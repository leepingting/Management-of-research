package srmsystem.dao;

import java.util.List;
import common.dao.BaseDao;
import srmsystem.domain.*;

public interface TeacherDao extends BaseDao<Teacher>{
	/**
	 * 根据教师编号查询教师
	 * @param TID 教师编号
	 * @return 符合指定TID的教师集合
	 */
	List<Teacher> findByTIDList(String TID);
	/**
	 * 根据教师编号查询教师
	 * @param TID 教师编号
	 * @return 符合指定TID的教师
	 */
	Teacher findByTID(String TID);
	/**
	 * 根据教师编号查询教师
	 * @param TID 教师编号
	 * @return 符合指定TID的教师集合
	 */
	List<Teacher> findByNameList(String TName);
	/**
	 * 根据教师编号查询教师
	 * @param TID 教师编号
	 * @return 符合指定TID的教师
	 */
	Teacher findByName(String TName);
	/**
	 * 查询所有教师
	 */
	List<Teacher> find();
}
