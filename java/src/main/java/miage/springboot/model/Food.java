package miage.springboot.model;

public class Food {
	
	private Integer idFood;
	private String nameFood;
	private Float price;
	
	public Food() {	}
	
	public Food(Integer idFood, String nameFood, Float price) {
		this.idFood = idFood;
		this.nameFood = nameFood;
		this.price = price;
	}

	public Integer getIdFood() {
		return idFood;
	}

	public void setIdFood(Integer idFood) {
		this.idFood = idFood;
	}

	public String getNameFood() {
		return nameFood;
	}

	public void setNameFood(String nameFood) {
		this.nameFood = nameFood;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}
	
	

}
