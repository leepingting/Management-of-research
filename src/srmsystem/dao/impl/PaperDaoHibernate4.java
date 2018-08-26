package srmsystem.dao.impl;

import java.util.List;

import common.dao.impl.BaseDaoHibernate4;
import srmsystem.dao.*;
import srmsystem.domain.*;

public class PaperDaoHibernate4 extends BaseDaoHibernate4<Paper>
implements PaperDao{

	@Override
	public List<Paper> findBypaIDList(int paID) {
		// TODO Auto-generated method stub
		return find("select p from Paper p where p.paID = ?0", paID);
	}

	@Override
	public Paper findBypaID(int paID) {
		// TODO Auto-generated method stub
		List<Paper> paper = find("select p from Paper p where p.paID = ?0", paID);
		if (paper!= null && paper.size() >= 1)
		{
			return paper.get(0);
		}
		return null;
	}


	@Override
	public List<Paper> findBypaApplicant(String paApplicant) {
		// TODO Auto-generated method stub
		return find("select p from Paper p where p.paApplicant = ?0", paApplicant);
	}

	@Override
	public List<Paper> findBypaStatus(int paStatus) {
		// TODO Auto-generated method stub
		return find("select p from Paper p where p.paStatus = ?0", paStatus);
	}

	@Override
	public List<Paper> findBypaName(String paName) {
		// TODO Auto-generated method stub
		return find("select p from Paper p where p.paName = ?0", paName);
	}

}
