package srmsystem.dao.impl;

import java.util.List;

import common.dao.impl.BaseDaoHibernate4;
import srmsystem.dao.*;
import srmsystem.domain.*;

public class UserDaoHibernate4 extends BaseDaoHibernate4<User>
implements UserDao{

	@Override
	public List<User> findByUID(String TID, String password, int role) {
		// TODO Auto-generated method stub
		return find("select u from User u where u.UID = ?0 "
				+ "and u.password = ?1 and u.role = ?2",TID,password,role);
	}

	@Override
	public List<User> findByUser(User user) {
		// TODO Auto-generated method stub
		return find("select u from User u where u.UID = ?0 "
				+ "and u.password = ?1 and u.role = ?2",
				user.getUID(),user.getPassword(),user.getRole());
	}

}
