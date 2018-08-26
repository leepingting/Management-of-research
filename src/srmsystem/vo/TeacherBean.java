package srmsystem.vo;

import java.io.Serializable;

//教师

public class TeacherBean implements Serializable{
	private String TID;//教师编号
	private String TName;//姓名
	private double TScore;//分数
	// 无参数的构造器
	public TeacherBean() {
			super();
	}
	// 初始化全部成员变量的构造器
	public TeacherBean(String tID, String tName, double tScore) {
		super();
		TID = tID;
		TName = tName;
		TScore = tScore;
	}
   
	//setter和getter方法
	public String getTID() {
		return TID;
	}

	public void setTID(String tID) {
		TID = tID;
	}

	public String getTName() {
		return TName;
	}

	public void setTName(String tName) {
		TName = tName;
	}

	public double getTScore() {
		return TScore;
	}

	public void setTScore(double tScore) {
		TScore = tScore;
	}
	
	
}
