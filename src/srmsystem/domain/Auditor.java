package srmsystem.domain;

import javax.persistence.*;

@Entity
@Table
public class Auditor {
	@Id
	private String AID;
	private String AName;
	
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
