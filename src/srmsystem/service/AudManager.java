package srmsystem.service;

import java.util.List;

import srmsystem.domain.Paper;
import srmsystem.domain.Project;
import srmsystem.domain.User;
import srmsystem.vo.PaperBean;
import srmsystem.vo.ProjectBean;
import srmsystem.vo.TeacherBean;

	//审核员管理
public interface AudManager {
	// 登录失败
	public static final int LOGIN_FAIL = 0;
	// 以审核员身份登录
	public static final int LOGIN_AUD = 1;
	// 以教师身份登录
	public static final int LOGIN_TEA = 2;
	
	String findTID(String UID);
	String findAName(String UID);
	String findTName(String UID);
	/**
	 * 验证登录
	 * @param user 
	 * @return 登录后的身份确认:0为登录失败，1为登录审核员 2为登录教师
	 */
	int validLogin(User user);
	
	/**
	 * 
	 * @return 获取全部论文信息
	 */
	List<Paper> getAllPaper();
	
	/**
	 * 
	 * @return 获取全部项目信息
	 */
	List<Project> getAllProject();
	

	/** 
	 * 通过论文编号返回论文信息
	 * paID:论文编号
	 */
	List<PaperBean> getPaperBypaID(int paID);
	
	/** 
	 * 通过项目编号返回项目信息
	 * prID:项目编号
	 */
	List<ProjectBean> getProjectByprID(int prID);
	/** 
	 * 通过教师编号返回教师信息
	 * TID:教师编号
	 */
	List<TeacherBean> getTeaScore(String TID);
	
	//审核论文,返回数值为0则不通过，1则通过
	void checkPaper(int paID,boolean result);
	//审核项目,返回数值为0则不通过，1则通过
	void checkProject(int prID,boolean result);
	//更改教师分数
	void changeScore();
	/**
	 *根据教师编号查询论文信息
	 */
	List<PaperBean> findPaperbytea(String TID);
	/**
	 *根据教师编号查询论文信息
	 */
	List<ProjectBean> findProjectbytea(String TID);
	/**
	 *根据论文题目查询论文信息
	 */
	List<PaperBean> findPaper(String paName);
	/**
	 *根据项目题目查询论文信息
	 */
	List<ProjectBean> findProject(String prName);
	/**
	 *根据论文状态查询论文信息
	 */
	List<PaperBean> findbypaStatus(int paStatus);
	/**
	 *根据项目状态查询论文信息
	 */
	List<ProjectBean> findbyprStatus(int prStatus);
	/**
	 *汇总教师分数
	 */
	List<TeacherBean> sumTScore();
}
