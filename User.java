package supplierManagement.project;

public class User {
	
	private String userid, password;
//	private int privilege;
	
/*	public int getPrivilege() {
		return privilege;
	}
	public void setPrivilege(int privilege) {
		this.privilege = privilege;
	}*/
	public final String getPassword() {
		return password;
	}
	public final void setPassword(String password) {
		this.password = password;
	}
	public final String getUserid() {
		return userid;
	}
	public final void setUserid(String userid) {
		this.userid = userid;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(String userid, String password) {
		this.userid = userid;
		this.password = password;
	}
	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + ((userid == null) ? 0 : userid.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final User other = (User) obj;
		if (userid == null) {
			if (other.userid != null)
				return false;
		} else if (!userid.equals(other.userid))
			return false;
		return true;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "userid is " + userid;
	}
	
	

}
