package srmsystem.action;

import java.util.ArrayList;
import java.util.List;
import com.opensymphony.xwork2.ActionContext;
import srmsystem.action.base.AudBaseAction;
import srmsystem.vo.*;

public class ViewAudAction extends AudBaseAction{
	private String TID;
	private String paName;
	private String prName;
	private List <PaperBean> papers=new ArrayList<>();
	private List <ProjectBean> projects=new ArrayList<>();
	private List <TeacherBean> teachers=new ArrayList<>();
	
	public List<TeacherBean> getTeachers() {
		return teachers;
	}
	public void setTeachers(List<TeacherBean> teachers) {
		this.teachers = teachers;
	}
	public String getTID() {
		return TID;
	}
	public void setTID(String tID) {
		TID = tID;
	}
	
	public String getPaName() {
		return paName;
	}
	public void setPaName(String paName) {
		this.paName = paName;
	}
	public String getPrName() {
		return prName;
	}
	public void setPrName(String prName) {
		this.prName = prName;
	}
	//papers的set、get方法
	public List<PaperBean> getPapers() {
		return papers;
	}
	public void setPapers(List<PaperBean> papers) {
		this.papers = papers;
	}

	
	
	
	//projects的set、get方法
	public List<ProjectBean> getProjects() {
		return projects;
	}
	public void setProjects(List<ProjectBean> projects) {
		this.projects = projects;
	}
	
	
	public String viewbypaStatus() throws Exception{
		// 创建ActionContext实例
		ActionContext ctx = ActionContext.getContext();
		// 调用业务逻辑方法处理用户请求
		List<PaperBean> papers=audManager.findbypaStatus(1);
		setPapers(papers);
		return SUCCESS;
	}
	
	public String viewbyprStatus() throws Exception{
		// 创建ActionContext实例
		ActionContext ctx = ActionContext.getContext();
		
		// 调用业务逻辑方法处理用户请求
		List<ProjectBean> projects=audManager.findbyprStatus(1); 
		setProjects(projects);
		return SUCCESS;
	}
	public String viewbytea() throws Exception
	{
		// 创建ActionContext实例
		ActionContext ctx = ActionContext.getContext();
		
		// 获取HttpSession中的user属性
		List<PaperBean> papers=audManager.findPaperbytea(TID);
		
		List<ProjectBean> projects=audManager.findProjectbytea(TID); 
		
		// 获取需要被当前经理处理的全部申请
	    setPapers(papers);
	    setProjects(projects);
	    
	    return SUCCESS;
	
	}
	
	
	public String viewbypaname() throws Exception{
		// 创建ActionContext实例
		ActionContext ctx = ActionContext.getContext();
			
		// 获取HttpSession中的user属性
		List<PaperBean> papers=audManager.findPaper(paName);
		setPapers(papers);
		
		return SUCCESS;
	}
	
	
	public String viewbyprname() throws Exception{
		// 创建ActionContext实例
		ActionContext ctx = ActionContext.getContext();
		// 获取HttpSession中的user属性
		List<ProjectBean> projects=audManager.findProject(prName); 
		setProjects(projects);	
		return SUCCESS;
	}
	
	public String viewScore() throws Exception{
		// 创建ActionContext实例
		ActionContext ctx = ActionContext.getContext();
		// 获取HttpSession中的user属性
		List<TeacherBean> teachers=audManager.sumTScore(); 
		
		setTeachers(teachers);	
		return SUCCESS;
	}
}
