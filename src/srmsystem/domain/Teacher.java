package srmsystem.domain;

import javax.persistence.*;

@Entity
@Table
public class Teacher {
	@Id
	private String TID;
	private String TName;
	private double TScore;
	
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
