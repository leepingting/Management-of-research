package srmsystem.vo;

import java.io.Serializable;

//用户

public class UserBean implements Serializable{
    private String UID;//用户编号
    private String password;//密码
    private String role;//角色
    //无参构造
    public void AppBean(){
	  
    }
	//带参构造
	public UserBean(String uID, String password, String role) {
		super();
		UID = uID;
		this.password = password;
		this.role = role;
	}
    //get set方法
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
    
}
