package Model;

public class FundRequest {
	
	int id;
	String reasercherID;
	String name;
	String email;
	String phone;
	String reaserchName;
	Double requestingAmount;
	
	
	public FundRequest() {
		
	}


	public FundRequest(int id, String reasercherID, String name, String email, String phone, String reaserchName,
			Double requestingAmount) {
		super();
		this.id = id;
		this.reasercherID = reasercherID;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.reaserchName = reaserchName;
		this.requestingAmount = requestingAmount;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getReasercherID() {
		return reasercherID;
	}


	public void setReasercherID(String reasercherID) {
		this.reasercherID = reasercherID;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getReaserchName() {
		return reaserchName;
	}


	public void setReaserchName(String reaserchName) {
		this.reaserchName = reaserchName;
	}


	public Double getRequestingAmount() {
		return requestingAmount;
	}


	public void setRequestingAmount(Double requestingAmount) {
		this.requestingAmount = requestingAmount;
	}

	
	

}
