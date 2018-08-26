package srmsystem.service;

import java.util.List;
import srmsystem.domain.*;
import srmsystem.vo.*;

//教师管理
public interface TeaManager {
	// 登录失败
	public static final int LOGIN_FAIL = 2;
	// 以教师身份登录
	public static final int LOGIN_TEA = 1;
	
	String findTID(String TName);
	/**
	 * 以经理身份来验证登录
	 * @param user 登录的经理身份
	 * @return 登录后的身份确认:0为登录失败，1为登录审核员 2为登录教师
	 */
	int validLogin(User user);
	/** 
	 * 通过教师编号返回教师信息
	 * TID:教师编号
	 */
	List<TeacherBean> GetTeaScore(String TID);
	/**
	 * 计算论文分数
	 * @param mem论文成员
	 * @param paLevel论文级别
	 * @param mem论文成员
	 * @return
	 */
	double markPaper(List<String> mem,int paLevel,String applicant);
	/**
	 * 计算项目分数
	 * @param prLevel项目级别
	 * @param prFunding项目资金
	 * @return
	 */
	double markProject(List<String> mem,int prLevel,double prFunding,String applicant);
	/**
	 * 判断教师分配分数是否符合规则
	 * @param roleScore每个成员对应分数,第一个对应负责人分数，后面对应参与者分数
	 * @param Score项目总分
	 * @return 符合规则返回true，否则 false
	 */
	boolean judgeAssignProject(List<RoleScore> roleScore,double Score);
	/**
	 * 判断教师分配分数是否符合规则
	 * @param roleScore每个成员对应分数，第一个对应一作分数，后面对应二作分数
	 * @return 符合规则返回true，否则 false
	 */
	boolean judgeAssignPaper(List<RoleScore> roleScore,double paperScore);
	/**
	 * @param paName 论文名称
	 * @param paLevel 论文级别
	 * @param paperScore 论文分数
	 * @param paApplicant 申报人编号
	 * @param paStatus 论文状态
	 * @param roleScore 角色-分数表
	 * @param PaScore 每个成员对应分数
	 * @return 1添加成功，0添加失败
	 */
	int savePaper(String paName,int paLevel,double paperScore,String paApplicant,
			int paStatus,List<RoleScore> roleScore);
	/**
	 * 
	 * @param prName 项目名称
	 * @param prLevel 项目级别
	 * @param prFunding 项目资金
	 * @param projectScore 项目分数
	 * @param prApplicant 申报人编号
	 * @param prStatus 项目状态
	 * @param roleScore 项目角色-分数表
	 * @param PrScore 每个成员对应分数
	 * @return 1添加成功，0添加失败
	 */
	int saveProject(String prName,int prLevel,double prFunding,double projectScore,
			String prApplicant,int prStatus,List<RoleScore> roleScore);
	/** 
	 * @param paName 论文名称
	 * @param paLevel 论文级别
	 * @param paperScore 论文分数
	 * @param paApplicant 申报人编号
	 * @param paStatus 论文状态
	 * @param roleScore 角色-分数表
	 */
	int applyPaper(String paName,int paLevel,double paperScore,String paApplicant,
			int paStatus,List<RoleScore> roleScore);
	/**
	 *@param prName 项目名称
	 * @param prLevel 项目级别
	 * @param prFunding 项目资金
	 * @param projectScore 项目分数
	 * @param prApplicant 申报人编号
	 * @param prStatus 项目状态
	 * @param roleScore 项目角色-分数表
	 */
	int applyProject(String prName,int prLevel,double prFunding,double projectScore,
			String prApplicant,int prStatus,List<RoleScore> roleScore);
	/**
	 *根据申请人查询论文信息
	 *@param paApplicant 论文申请人
	 */
	List<PaperBean> findPaper(String paApplicant);
	/**
	 *根据申请人查询论文信息
	 *@param prApplicant 项目申请人
	 */
	List<ProjectBean> findProject(String prApplicant);
	/**
	 *根据教师编号查询论文信息
	 */
	List<PaperBean> findPaperScore(String TID);
	/**
	 *根据教师编号查询论文信息
	 */
	List<ProjectBean> findProjectScore(String TID);
}
