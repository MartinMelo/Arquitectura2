package arq.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity
public class Price extends AbstractEntity {
	
	private String pruduct_id;
	
	private double price;
	
	@Temporal(javax.persistence.TemporalType.DATE)
    private Date datetime;
	
	@ManyToOne
    private Shop shop;

	public String getPruduct_id() {
		return pruduct_id;
	}

	public void setPruduct_id(String pruduct_id) {
		this.pruduct_id = pruduct_id;
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
