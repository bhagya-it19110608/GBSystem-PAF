package Model;

public class Product {

	int id;
	String name;
	String category;
	String description;
	Double price;
			
	public Product() {
	}

	public Product(int id, String name, String category, String description, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.description = description;
		this.price = price;
	}

	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}
	
	public String getcategory() {
		return category;
	}

	public void setcategory(String category) {
		this.category = category;
	}

	public String getdescription() {
		return description;
	}

	public void setdescription(String description) {
		this.description = description;
	}
	public Double getprice() {
		return price;
	}

	public void setprice(Double price) {
		this.price = price;
	}
	
}
