package hans.memberBoard;

public class MemberBoardVO {
	/*
	 * CREATE TABLE member_metami ( id varchar(30) NOT NULL, password varchar(40)
	 * NOT NULL, name varchar(20) NOT NULL, CONSTRAINT member_metami_pk PRIMARY KEY
	 * (id) ) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
	 */
	private String id;
	private String password;
	private String name;
	private String phone1;
	private String phone2;
	private String phone3;
	private String email1;
	private String email2;
	private String email3;
	private String phone;
	private String email;
	private String fakeId;
	
	
	public String getFakeId() {
		return fakeId;
	}

	public void setFakeId(String fakeId) {
		this.fakeId = fakeId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getEmail3() {
		return email3;
	}

	public void setEmail3(String email3) {
		this.email3 = email3;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getPhone3() {
		return phone3;
	}

	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "MemberBoardVO [id=" + id + ", password=" + password + ", name=" + name + ", getId()=" + getId()
				+ ", getPassword()=" + getPassword() + ", getName()=" + getName() + ", getPhone1()=" + getPhone1()
				+ ", getPhone2()=" + getPhone2() + ", getPhone3()=" + getPhone3() + ", getEmail1()=" + getEmail1()
				+ ", getEmail2()=" + getEmail2() + ", getEmail3()=" + getEmail3() + "]";
	}

}
