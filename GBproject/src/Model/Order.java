package Model;

public class Order {

	int orderID;
	String orderName;
	String orderCategory;
	String paymentMethod;
	Double orderPayment;
	
	public Order() {
	}

	public Order(int orderID, String orderName, String orderCategory, String paymentMethod, Double orderPayment) {
		super();
		this.orderID = orderID;
		this.orderName = orderName;
		this.orderCategory = orderCategory;
		this.paymentMethod = paymentMethod;
		this.orderPayment = orderPayment;
	}

	
	public int getOrderId() {
		return orderID;
	}

	public void setOrderId(int orderID) {
		this.orderID = orderID;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public String getOrderCategory() {
		return orderCategory;
	}

	public void setOrderategory(String orderCategory) {
		this.orderCategory = orderCategory;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Double getOrderPayment() {
		return orderPayment;
	}

	public void setOrderPayment(Double orderPayment) {
		this.orderPayment = orderPayment;
	}



}
