package arq.dto;

import java.util.Date;

import javax.persistence.Temporal;

public class PriceDTO {
	
	private String product_id;
	private double price;
	@Temporal(javax.persistence.TemporalType.DATE)
    private Date datetime;
    private long shop_id;
    
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
	public long getShop_id() {
		return shop_id;
	}
	public void setShop_id(long shop_id) {
		this.shop_id = shop_id;
	}
	
    
}
