package srmsystem.action;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import com.opensymphony.xwork2.ActionContext;
import srmsystem.action.base.TeaBaseAction;
import srmsystem.domain.RoleScore;
import srmsystem.domain.Teacher;

public class ApplyProAction  extends TeaBaseAction{

	private String[] name;
	private String[] TRole;
	private double[] score;
	
	
	public String[] getName() {
		return name;
	}
	public void setName(String[] name) {
		this.name = name;
	}
	//set、get 
//	public String[] getTID() {
//			return TID;
//	}
//	public void setTID(String[] tID) {
//			TID = tID;
//	}
	
	public double[] getScore() {
			return score;
	}
	public String[] getTRole() {
		return TRole;
	}
	public void setTRole(String[] tRole) {
		TRole = tRole;
	}
	public void setScore(double[] score) {
			this.score = score;
	}
	
	private List<RoleScore> roleScore=new ArrayList<>();;
	private String prName;
	private int prLevel;
	private double prScore;
	private String prApplicant;
	private double prFunding;
	
	public void init() 
	{
		for(int i=0;i<name.length;i++){
			RoleScore r=new RoleScore();
			Teacher t=new Teacher();
			t.setTName(name[i]);
			r.setTeacher(t);
			int role=1;
			if(TRole[i].equals("负责人")){
				role=0;
			}
			r.setTRole(role);
			r.setScore(score[i]);
			roleScore.add(r);
		}
		ActionContext ctx = ActionContext.getContext();
		prName=(String) ctx.getSession().get("prName");
		prLevel=(int) ctx.getSession().get("prLevel");
	    prScore=(double) ctx.getSession().get("prScore");
		prApplicant=teaManager.findTID((String) ctx.getSession().get("user"));
		prFunding=(double) ctx.getSession().get("prFunding");
	}
	
    public String save() throws Exception
   {
	    init();
		int prStatus=0;
		int result=teaManager.saveProject(prName, prLevel,prFunding, prScore,prApplicant,prStatus,roleScore);
		if(result==0){
			JOptionPane.showMessageDialog(null, "保存失败！", "错误", JOptionPane.ERROR_MESSAGE);
			return ERROR;
		}
		JOptionPane.showMessageDialog(null, "保存成功！");
		return SUCCESS;
	}
	

			
	
	public String apply() throws Exception
	{
		init();
		int prStatus=1;
		int result=teaManager.applyProject(prName, prLevel, prFunding,prScore,prApplicant,prStatus,roleScore);
		if(result==0){
			JOptionPane.showMessageDialog(null, "保存失败！", "错误", JOptionPane.ERROR_MESSAGE);
			return ERROR;
		}
		JOptionPane.showMessageDialog(null, "保存成功！");
		return SUCCESS;

	}
		
	public String cancel() throws Exception
	{   
		return SUCCESS;
    }
	
}
