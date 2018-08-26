package srmsystem.dao;

import java.util.List;
import common.dao.BaseDao;
import srmsystem.domain.*;

public interface ProjectDao extends BaseDao<Project>{
	/**
	 * 根据项目编号查询
	 * @param prID 项目编号
	 * @return 符合指定prID的项目集合
	 */
	List<Project> findByprIDList(int prID);
	/**
	 * 根据项目编号查询
	 * @param prID 项目编号
	 * @return 符合指定prID的项目
	 */
	Project findByprID(int prID);
	/**
	 * 根据申请人编号查询
	 * @param prApplicant 申请人编号
	 * @return 符合指定prApplicant的项目集合
	 */
	List<Project> findByprApplicant(String prApplicant);
	/**
	 * 根据状态查询
	 * @param prStatus 论文状态
	 * @return 符合指定prStatus的论文集合
	 */
	List<Project> findByprStatus(int prStatus);
	/**
	 * 根据项目编号查询
	 * @param prName 项目题目
	 * @return 符合指定prName的项目集合
	 */
	List<Project> findByprName(String prName);
}
