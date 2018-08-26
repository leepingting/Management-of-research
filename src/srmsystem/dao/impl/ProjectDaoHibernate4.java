package srmsystem.dao.impl;

import java.util.List;

import common.dao.impl.BaseDaoHibernate4;
import srmsystem.dao.*;
import srmsystem.domain.*;

public class ProjectDaoHibernate4 extends BaseDaoHibernate4<Project>
implements ProjectDao{

	@Override
	public List<Project> findByprIDList(int prID) {
		// TODO Auto-generated method stub
		return find("select p from Project p where p.prID = ?0", prID);
	}

	@Override
	public Project findByprID(int prID) {
		// TODO Auto-generated method stub
		List<Project> project = find("select p from Project p where p.prID = ?0", prID);
		if (project!= null && project.size() >= 1)
		{
			return project.get(0);
		}
		return null;
	}


	@Override
	public List<Project> findByprApplicant(String prApplicant) {
		// TODO Auto-generated method stub
		return find("select p from Project p where p.prApplicant = ?0", prApplicant);
	}

	@Override
	public List<Project> findByprStatus(int prStatus) {
		// TODO Auto-generated method stub
		return find("select p from Project p where p.prStatus = ?0", prStatus);
	}

	@Override
	public List<Project> findByprName(String prName) {
		// TODO Auto-generated method stub
		return find("select p from Project p where p.prName = ?0", prName);
	}

}
