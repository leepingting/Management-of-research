package srmsystem.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table
public class Project {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int prID;
	private String prName;
	private int prLevel;//1:校,2:省,3:国家
	private double prFunding;
	private double prScore;
	private String prApplicant;
	private int prStatus;//0：未提交，1：待审核，2：审核通过，3：审核未通过
	@ManyToMany(targetEntity=RoleScore.class)
	@JoinTable(name="project_score",
			joinColumns=@JoinColumn(name="prID",referencedColumnName="prID"),
			inverseJoinColumns=@JoinColumn(name="RID",referencedColumnName="RID"))
	private Set<RoleScore> roleScore=new HashSet<>();
	
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
	public Set<RoleScore> getRoleScore() {
		return roleScore;
	}
	public void setRoleScore(Set<RoleScore> roleScore) {
		this.roleScore = roleScore;
	}
	
}
