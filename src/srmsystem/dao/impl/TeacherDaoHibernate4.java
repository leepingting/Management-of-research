package srmsystem.dao.impl;

import java.util.List;
import common.dao.impl.BaseDaoHibernate4;
import srmsystem.dao.*;
import srmsystem.domain.*;

public class TeacherDaoHibernate4 extends BaseDaoHibernate4<Teacher>
implements TeacherDao{
	
	@Override
	public List<Teacher> findByTIDList(String TID) {
		// TODO Auto-generated method stub
		return find("select t from Teacher t where t.TID = ?0", TID);
	}
	
	@Override
	public Teacher findByTID(String TID) {
		// TODO Auto-generated method stub
		List<Teacher> teacher = find("select t from Teacher t where t.TID = ?0", TID);
		if (teacher!= null && teacher.size() >= 1)
		{
			return teacher.get(0);
		}
		return null;
	}

	@Override
	public List<Teacher> findByNameList(String TName) {
		// TODO Auto-generated method stub
		return find("select t from Teacher t where t.TName = ?0", TName);
	}

	@Override
	public Teacher findByName(String TName) {
		// TODO Auto-generated method stub
		List<Teacher> teacher = find("select t from Teacher t where t.TName = ?0", TName);
		if (teacher!= null && teacher.size() >= 1)
		{
			return teacher.get(0);
		}
		return null;
	}

	@Override
	public List<Teacher> find() {
		// TODO Auto-generated method stub
		return find("select t from Teacher t");
	}
}
