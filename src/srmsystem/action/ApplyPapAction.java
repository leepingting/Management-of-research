package srmsystem.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

import com.opensymphony.xwork2.ActionContext;
import srmsystem.action.base.TeaBaseAction;
import srmsystem.domain.*;


public class ApplyPapAction extends TeaBaseAction{
	private String[] name;
	private String[] TRole;
	private double[] score;
	
	private List<RoleScore> roleScore=new ArrayList<>();;
	private String paName;
	private int paLevel;
	private double paScore;
	private String paApplicant;
	
	public String[] getName() {
		return name;
	}
	public void setName(String[] name) {
		this.name = name;
	}
	public double[] getScore() {
		return score;
	}
	public void setScore(double[] score) {
		this.score = score;
	}
	public String[] getTRole() {
		return TRole;
	}
	public void setTRole(String[] tRole) {
		TRole = tRole;
	}
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
		paName=(String) ctx.getSession().get("paName");
		paLevel=(int) ctx.getSession().get("paLevel");
	    paScore=(double) ctx.getSession().get("paScore");
		paApplicant=teaManager.findTID((String) ctx.getSession().get("user"));
	}
	
	public String save() throws Exception
	{
        this.init();
        
		int paStatus=0;
		int result=teaManager.savePaper(paName, paLevel, paScore,paApplicant,paStatus,roleScore);
		if(result==0){
			JOptionPane.showMessageDialog(null, "保存失败！", "错误", JOptionPane.ERROR_MESSAGE);
			return ERROR;
		}
		JOptionPane.showMessageDialog(null, "保存成功！");
		return SUCCESS;
	}
	
	
	
	public String apply() throws Exception
	{   
		this.init();
		
		int paStatus=1;
		int result=teaManager.applyPaper(paName, paLevel, paScore,paApplicant,paStatus,roleScore);
		if(result==0){
			JOptionPane.showMessageDialog(null, "提交失败！", "错误", JOptionPane.ERROR_MESSAGE);
			return ERROR;
		}
		JOptionPane.showMessageDialog(null, "提交成功！");
		return SUCCESS;
   }	
		
	public String cancel() throws Exception
	{   
		return SUCCESS;
   }	
}
