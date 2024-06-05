package modalclasses;

public class RegisterModal {
	
	private String fname;
	private String lname;
	private String mobile;
	private String email;
	private String pwd;
	
	public RegisterModal() {
		
	}
	
	public RegisterModal(String fname,String lname,String mobile,String email,String pwd) {
		this.fname=fname;
		this.lname=lname;
		this.mobile=mobile;
		this.email=email;
		this.pwd=pwd;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	

	public String toString() {
		return "Model Class layer:"+ fname+" "+lname+" "+mobile+" "+email+" "+pwd;
	}
	

}
