package srmsystem.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import srmsystem.domain.RoleScore;

//项目

public class ProjectBean implements Serializable{
	private int prID;//项目编号
	private String prName;//项目题目
	private int prLevel;//项目级别
	private double prFunding;//项目经费
	private double prScore;//项目分数
	private String prApplicant;//申报人编号
	private int prStatus;//审核状态
	private List<RoleScore> roleScore=new ArrayList<>();//教师角色-分数
	// 无参数的构造器
	public void projectBean(){
		
	}
	// 初始化全部成员变量的构造器
	public ProjectBean(int prID, String prName, int prLevel, double prFunding, double prScore, String prApplicant,
			int prStatus) {
		super();
		this.prID = prID;
		this.prName = prName;
		this.prLevel = prLevel;
		this.prFunding = prFunding;
		this.prScore = prScore;
		this.prApplicant = prApplicant;
		this.prStatus = prStatus;
	}
	
	public ProjectBean(int prID, String prName, int prLevel, double prFunding, double prScore, String prApplicant,
			int prStatus, List<RoleScore> roleScore) {
		super();
		this.prID = prID;
		this.prName = prName;
		this.prLevel = prLevel;
		this.prFunding = prFunding;
		this.prScore = prScore;
		this.prApplicant = prApplicant;
		this.prStatus = prStatus;
		this.roleScore = roleScore;
	}
	//setter和getter方法
	public int getPrID() {
		return prID;
	}

	public void setPrID(int prID) {
		this.prID = prID;
	}

	public String getPrName() {
		return prName;
	}

	public void setPrName(String prName) {
		this.prName = prName;
	}

	public int getPrLevel() {
		return prLevel;
	}

	public void setPrLevel(int prLevel) {
		this.prLevel = prLevel;
	}

	public double getPrFunding() {
		return prFunding;
	}

	public void setPrFunding(double prFunding) {
		this.prFunding = prFunding;
	}

	public double getPrScore() {
		return prScore;
	}

	public void setPrScore(double prScore) {
		this.prScore = prScore;
	}

	public String getPrApplicant() {
		return prApplicant;
	}

	public void setPrApplicant(String prApplicant) {
		this.prApplicant = prApplicant;
	}

	public int getPrStatus() {
		return prStatus;
	}

	public void setPrStatus(int prStatus) {
		this.prStatus = prStatus;
	}
	public List<RoleScore> getRoleScore() {
		return roleScore;
	}
	public void setRoleScore(List<RoleScore> roleScore) {
		this.roleScore = roleScore;
	}
	
}
