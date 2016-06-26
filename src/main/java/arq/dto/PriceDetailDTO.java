package arq.dto;

public class PriceDetailDTO {
	
    private String brand;
	private String type_of_capability;
	private String type_of_container;
	private Double amount;
	private Long id;
    
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getType_of_capability() {
		return type_of_capability;
	}
	public void setType_of_capability(String type_of_capability) {
		this.type_of_capability = type_of_capability;
	}
	public String getType_of_container() {
		return type_of_container;
	}
	public void setType_of_container(String type_of_container) {
		this.type_of_container = type_of_container;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
    
}
