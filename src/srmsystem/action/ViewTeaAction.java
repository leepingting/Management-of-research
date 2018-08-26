package srmsystem.action;

import java.util.List;
import com.opensymphony.xwork2.ActionContext;
import srmsystem.action.base.TeaBaseAction;
import srmsystem.vo.*;

public class ViewTeaAction extends TeaBaseAction{
	private List<PaperBean> papers;
	private List<ProjectBean> projects;
	private List<TeacherBean> teachers;
	
	public List<TeacherBean> getTeachers() {
		return teachers;
	}
	public void setTeachers(List<TeacherBean> teachers) {
		this.teachers = teachers;
	}
	public List<ProjectBean> getProjects() {
		return projects;
	}
	public void setProjects(List<ProjectBean> projects) {
		this.projects = projects;
	}
	public List<PaperBean> getPapers() {
		return papers;
	}
	public void setPapers(List<PaperBean> papers) {
		this.papers = papers;
	}


	public String viewStatus() throws Exception{
		// 创建ActionContext实例
		ActionContext ctx = ActionContext.getContext();
		
		// 调用业务逻辑方法处理用户请求
		String paApplicant=teaManager.findTID((String) ctx.getSession().get("user"));
		List<PaperBean> papers=teaManager.findPaper(paApplicant);
		List<ProjectBean> projects=teaManager.findProject(paApplicant);
		setPapers(papers);
		setProjects(projects);
		return SUCCESS;
	}

	public String view() throws Exception{
		// 创建ActionContext实例
		ActionContext ctx = ActionContext.getContext();
		
		// 调用业务逻辑方法处理用户请求
		String TID=teaManager.findTID((String) ctx.getSession().get("user"));
		List<PaperBean> paperscore=teaManager.findPaperScore(TID);
		List<ProjectBean> projectscore=teaManager.findProjectScore(TID);
		setPapers(paperscore);
		setProjects(projectscore);
		return SUCCESS;
	}
	public String viewScore()throws Exception{
		ActionContext ctx = ActionContext.getContext();
		String TID=teaManager.findTID((String) ctx.getSession().get("user"));
		List<TeacherBean> teacherScore=teaManager.GetTeaScore(TID);
		setTeachers(teacherScore);
		return SUCCESS;
		
	}

}
