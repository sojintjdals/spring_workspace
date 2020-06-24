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
				+ ", getPassword()=" + getPassword() + ", getName()=" + getName() + "]";
	}

}
