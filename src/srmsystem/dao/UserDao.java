package srmsystem.dao;

import java.util.List;
import common.dao.BaseDao;
import srmsystem.domain.Teacher;
import srmsystem.domain.User;

public interface UserDao extends BaseDao<User>{
	/**
	 * 根据用户编号UID、密码password、角色role查询教师
	 * @param UID 用户编号
	 * @param password 密码
	 * @param role 角色
	 * @return 符合指定用户编号UID、密码password、角色role的用户
	 */
	List<User> findByUID(String UID,String password,int role);
	/**
	 * 根据用户编号UID、密码password、角色role查询教师
	 * @param UID 用户编号
	 * @param password 密码
	 * @param role 角色
	 * @return 符合指定用户编号UID、密码password、角色role的用户
	 */
	List<User> findByUser(User user);
}
