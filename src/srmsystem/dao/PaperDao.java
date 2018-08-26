package srmsystem.dao;

import java.util.List;

import common.dao.BaseDao;
import srmsystem.domain.*;

public interface PaperDao extends BaseDao<Paper>{
	/**
	 * 根据论文编号查询
	 * @param paID 论文编号
	 * @return 符合指定paID的论文集合
	 */
	List<Paper> findBypaIDList(int paID);
	/**
	 * 根据论文编号查询
	 * @param paID 论文编号
	 * @return 符合指定paID的论文
	 */
	Paper findBypaID(int paID);
	
	/**
	 * 根据申请人编号查询
	 * @param paApplicant 申请人编号
	 * @return 符合指定paApplicant的论文集合
	 */
	List<Paper> findBypaApplicant(String paApplicant);
	/**
	 * 根据状态查询
	 * @param paStatus 论文状态
	 * @return 符合指定paStatus的论文集合
	 */
	List<Paper> findBypaStatus(int paStatus);
	
	/**
	 * 根据论文编号查询
	 * @param paName 论文题目
	 * @return 符合指定paName的论文集合
	 */
	List<Paper> findBypaName(String paName);
	
}
