package Model;

public class User {

	int uId;
	String firstName;
	String lastName;
	String email;
	String gender;
	String occupation;
	int phone;
	String username;
	String password;
		
	public User() {
	}

	public User(int uId, String firstName, String lastName, String email, String gender, String occupation, int phone, String username, String password ) {
		super();
		this.uId = uId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.occupation = occupation;
		this.phone = phone;
		this.username = username;
		this.password = password;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public String getfirstName() {
		return firstName;
	}

	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getlastName() {
		return lastName;
	}

	public void setlastName(String lastName) {
		this.lastName = lastName;
	}

	public String getemail() {
		return email;
	}

	public void setemail(String email) {
		this.email = email;
	}
	public String getgender() {
		return gender;
	}

	public void setgender(String gender) {
		this.gender = gender;
	}
	public String getoccupation() {
		return occupation;
	}

	public void setoccupation(String occupation) {
		this.occupation = occupation;
	}
	
	public int getphone() {
		return phone;
	}

	public void setphone(int phone) {
		this.phone = phone;
	}
	
	public String getusername() {
		return username;
	}

	public void setusername(String username) {
		this.username = username;
	}
	
	public String getpassword() {
		return password;
	}

	public void setpassword(String password) {
		this.password = password;
	}
}
