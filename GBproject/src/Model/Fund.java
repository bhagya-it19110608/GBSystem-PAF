package Model;

public class Fund {

	int idfund;
	String projectID;
	String reasercherID;
	String clientID;
	Double fundAmount;
	String status;
	
	public Fund() {
	}

	public Fund(int idfund, String projectID, String reasercherID, String clientID, Double fundAmount, String status) {
		super();
		this.idfund = idfund;
		this.projectID = projectID;
		this.reasercherID = reasercherID;
		this.clientID = clientID;
		this.fundAmount = fundAmount;
		this.status = status;
	}

	public int getIdfund() {
		return idfund;
	}

	public void setIdfund(int idfund) {
		this.idfund = idfund;
	}

	public String getProjectID() {
		return projectID;
	}

	public void setProjectID(String projectID) {
		this.projectID = projectID;
	}

	public String getReasercherID() {
		return reasercherID;
	}

	public void setReasercherID(String reasercherID) {
		this.reasercherID = reasercherID;
	}

	public String getClientID() {
		return clientID;
	}

	public void setClientID(String clientID) {
		this.clientID = clientID;
	}

	public Double getFundAmount() {
		return fundAmount;
	}

	public void setFundAmount(Double fundAmount) {
		this.fundAmount = fundAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
