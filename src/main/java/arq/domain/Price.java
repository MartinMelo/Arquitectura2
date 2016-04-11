package arq.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity
public class Price extends AbstractEntity {

	//Variables
	private String product_id;
	private double price;
	@Temporal(javax.persistence.TemporalType.DATE)
    private Date datetime;
	@ManyToOne
    private Shop shop;

	//Constructor
	public Price() {
	}

	//Getters & Setters
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
}
