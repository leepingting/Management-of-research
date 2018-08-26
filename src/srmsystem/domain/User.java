package srmsystem.domain;

import javax.persistence.*;

@Entity
@Table
public class User {
	@Id
	private String UID;
	private String password;
	private int role;//1:…Û∫À‘±,2:ΩÃ ¶
	
	public String getUID() {
		return UID;
	}
	public void setUID(String uID) {
		UID = uID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	
}
