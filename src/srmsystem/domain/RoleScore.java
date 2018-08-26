package srmsystem.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table
public class RoleScore {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int RID;
	//private String TID;//教师编号
	@ManyToOne(targetEntity=Teacher.class)
	@JoinColumn(name = "TID", nullable=false)
	private Teacher teacher;
	private int TRole;//教师角色，0：负责人，1：参与者
	private double score;//教师分数
	@ManyToMany(targetEntity=Paper.class)
	@JoinTable(name="paper_score",
			joinColumns=@JoinColumn(name="RID",referencedColumnName="RID"),
			inverseJoinColumns=@JoinColumn(name="paID",referencedColumnName="paID"))
	private Set<Paper> paper=new HashSet<>();
	@ManyToMany(targetEntity=Project.class)
	@JoinTable(name="project_score",
			joinColumns=@JoinColumn(name="RID",referencedColumnName="RID"),
			inverseJoinColumns=@JoinColumn(name="prID",referencedColumnName="prID"))
	private Set<Project> project=new HashSet<>();
	
	public int getRID() {
		return RID;
	}
	public void setRID(int rID) {
		RID = rID;
	}
//	public String getTID() {
//		return TID;
//	}
//	public void setTID(String tID) {
//		TID = tID;
//	}

	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public int getTRole() {
		return TRole;
	}
	public void setTRole(int tRole) {
		TRole = tRole;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public Set<Paper> getPaper() {
		return paper;
	}
	public void setPaper(Set<Paper> paper) {
		this.paper = paper;
	}
	public Set<Project> getProject() {
		return project;
	}
	public void setProject(Set<Project> project) {
		this.project = project;
	}
	
}
