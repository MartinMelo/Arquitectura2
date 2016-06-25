package arq.domain;

import org.springframework.data.annotation.Id;

import java.util.Date;


public class Price{

	//Variables
	@Id
    private String id;
	private String product;
	private double price;
    private Date datetime;
    private Shop shop;

	//Constructor
	public Price() {
	}

	//Getters & Setters

    public void setId(String id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getId(){
        return this.id;
    }
	public String getProduct_id() {
		return product;
	}
	public void setProduct_id(String product_id) {
		this.product = product_id;
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
