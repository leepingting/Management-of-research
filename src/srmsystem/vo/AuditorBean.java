package srmsystem.vo;

import java.io.Serializable;

//审核员

public class AuditorBean implements Serializable {
	private String AID;// 编号
	private String AName;// 姓名
	// 无参数的构造器

	public void auditorBean() {

	}

	// 初始化全部成员变量的构造器
	public AuditorBean(String aID, String aName) {
		super();
		AID = aID;
		AName = aName;
	}

	// setter和getter方法
	public String getAID() {
		return AID;
	}

	public void setAID(String aID) {
		AID = aID;
	}

	public String getAName() {
		return AName;
	}

	public void setAName(String aName) {
		AName = aName;
	}

}
