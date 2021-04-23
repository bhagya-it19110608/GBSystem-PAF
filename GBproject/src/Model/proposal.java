package Model;

public class proposal {
	int pid;
	String rname;
	String pname;
	String catagory;
	String duration;
	String email;
	String phone;
	Double budget;
	String userid;
	String summery;
	String status;
	
	public proposal() {
	}
	
	public proposal(int pid, String rname, String pname, String catagory, String duration, String email, String phone,
			Double budget,String userid, String summery,String status) {
		super();
		this.pid = pid;
		this.rname = rname;
		this.pname = pname;
		this.catagory = catagory;
		this.duration = duration;
		this.email = email;
		this.phone = phone;
		this.budget = budget;
		this.userid = userid;
		this.summery = summery;
		this.status = status;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getCatagory() {
		return catagory;
	}

	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
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

	public Double getBudget() {
		return budget;
	}

	public void setBudget(Double budget) {
		this.budget = budget;
	}
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getSummery() {
		return summery;
	}

	public void setSummery(String summery) {
		this.summery = summery;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	

}
