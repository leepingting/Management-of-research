package srmsystem.dao;

import java.util.List;
import common.dao.BaseDao;
import srmsystem.domain.Auditor;

public interface AuditorDao extends BaseDao<Auditor>{
	/**
	 * 根据审核员编号AID查询审核员
	 * @param AID 审核员编号
	 * @return 符合指定AID的审核员集合
	 */
	List<Auditor> findByAIDList(String AID);
	/**
	 * 根据审核员编号AID查询审核员
	 * @param AID 审核员编号
	 * @return 符合指定AID的教师
	 */
	Auditor findByAID(String AID);
}
