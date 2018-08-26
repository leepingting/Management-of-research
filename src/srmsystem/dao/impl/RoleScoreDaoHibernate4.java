package srmsystem.dao.impl;

import java.util.List;

import common.dao.impl.BaseDaoHibernate4;
import srmsystem.dao.*;
import srmsystem.domain.*;

public class RoleScoreDaoHibernate4 extends BaseDaoHibernate4<RoleScore>
implements RoleScoreDao{

	@Override
	public List<RoleScore> findByRIDList(int RID) {
		// TODO Auto-generated method stub
		return find("select r from RoleScore r where r.RID = ?0", RID);
	}

	@Override
	public RoleScore findByRID(int RID) {
		// TODO Auto-generated method stub
		List<RoleScore> roleScore = find("select r from RoleScore r where r.RID = ?0", RID);
		if (roleScore!= null && roleScore.size() >= 1)
		{
			return roleScore.get(0);
		}
		return null;
	}
/*
	@Override
	public List<RoleScore> findByTID(String TID) {
		// TODO Auto-generated method stub
		return find("select r from RoleScore r where r.TID = ?0", TID);
	}

	@Override
	public List<RoleScore> findByTIDTRoleScore(String TID, int TRole, double score) {
		// TODO Auto-generated method stub
		return find("select r from RoleScore r where r.TID = ?0 and r.TRole=?1 "
				+ "and r.score", TID,TRole,score);
	}*/

	@Override
	public List<RoleScore> findByTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		return find("select r from RoleScore r where r.teacher = ?0", teacher);
	}

	@Override
	public List<RoleScore> find(Teacher teacher, int TRole, double score) {
		// TODO Auto-generated method stub
		return find("select r from RoleScore r where r.teacher = ?0 and r.TRole=?1 "
				+ "and r.score=?2", teacher,TRole,score);
	}

	@Override
	public List<RoleScore> findByTeacher(Teacher teacher, int TRole) {
		// TODO Auto-generated method stub
		return find("select r from RoleScore r where r.teacher = ?0 and r.TRole=?1 "
				, teacher,TRole);
	}


}
