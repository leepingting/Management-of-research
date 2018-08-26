package srmsystem.dao;

import java.util.List;

import common.dao.BaseDao;
import srmsystem.domain.*;

public interface RoleScoreDao extends BaseDao<RoleScore>{
	/**
	 * 根据编号查询
	 * @param RID 编号
	 * @return 符合指定RID的角色分数集合
	 */
	List<RoleScore> findByRIDList(int RID);
	/**
	 * 根据编号查询
	 * @param RID 编号
	 * @return 符合指定RID的角色分数
	 */
	RoleScore findByRID(int RID);
	/**
	 * 根据教师编号查询
	 * @param TID 教师编号
	 * @return 符合指定TID的角色分数集合
	 */
	//List<RoleScore> findByTID(String TID);
	List<RoleScore> findByTeacher(Teacher teacher);
	/**
	 * 根据教师编号、教师角色、教师分数查询
	 * @param TID 教师编号
	 * @param TRole 教师角色
	 * @param score 教师分数
	 * @return 符合指定TID的角色分数集合
	 */
	//List<RoleScore> findByTIDTRoleScore(String TID,int TRole,double score);
	List<RoleScore> find(Teacher teacher,int TRole,double score);
	/**
	 * 根据教师编号、教师角色、教师分数查询
	 * @param TID 教师编号
	 * @param TRole 教师角色
	 * @return 符合指定TID的角色分数集合
	 */
	List<RoleScore> findByTeacher(Teacher teacher,int TRole);
}
