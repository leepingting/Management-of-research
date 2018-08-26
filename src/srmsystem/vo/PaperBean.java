package srmsystem.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import srmsystem.domain.RoleScore;

//论文

public class PaperBean implements Serializable{
	private int paID;//论文编号
	private String paName;//论文题目
	private int paLevel;//论文级别
	private double paScore;//论文分数
	private String paApplicant;//申报人编号
	private int paStatus;//审核状态
	private List<RoleScore> roleScore=new ArrayList<>();//教师角色-分数
	// 无参数的构造器
	public PaperBean() {
		super();
	}
	// 初始化全部成员变量的构造器
	public PaperBean(int paID, String paName, int paLevel, double paScore, String paApplicant, int paStatus) {
		super();
		this.paID = paID;
		this.paName = paName;
		this.paLevel = paLevel;
		this.paScore = paScore;
		this.paApplicant = paApplicant;
		this.paStatus = paStatus;
	}
	
	public PaperBean(int paID, String paName, int paLevel, double paScore, String paApplicant, int paStatus,
			List<RoleScore> roleScore) {
		super();
		this.paID = paID;
		this.paName = paName;
		this.paLevel = paLevel;
		this.paScore = paScore;
		this.paApplicant = paApplicant;
		this.paStatus = paStatus;
		this.roleScore = roleScore;
	}
	//setter和getter方法
	public int getPaID() {
		return paID;
	}

	public void setPaID(int paID) {
		this.paID = paID;
	}

	public String getPaName() {
		return paName;
	}

	public void setPaName(String paName) {
		this.paName = paName;
	}

	public int getPaLevel() {
		return paLevel;
	}

	public void setPaLevel(int paLevel) {
		this.paLevel = paLevel;
	}

	public double getPaScore() {
		return paScore;
	}

	public void setPaScore(double paScore) {
		this.paScore = paScore;
	}

	public String getPaApplicant() {
		return paApplicant;
	}

	public void setPaApplicant(String paApplicant) {
		this.paApplicant = paApplicant;
	}

	public int getPaStatus() {
		return paStatus;
	}

	public void setPaStatus(int paStatus) {
		this.paStatus = paStatus;
	}
	public List<RoleScore> getRoleScore() {
		return roleScore;
	}
	public void setRoleScore(List<RoleScore> roleScore) {
		this.roleScore = roleScore;
	}
	
}
