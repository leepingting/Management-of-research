package srmsystem.dao.impl;

import java.util.List;

import common.dao.impl.BaseDaoHibernate4;
import srmsystem.dao.*;
import srmsystem.domain.*;

public class AuditorDaoHibernate4 extends BaseDaoHibernate4<Auditor>
implements AuditorDao{
	
	@Override
	public List<Auditor> findByAIDList(String AID) {
		// TODO Auto-generated method stub
		return  find("select a from Auditor a where a.AID = ?0", AID);
	}

	@Override
	public Auditor findByAID(String AID) {
		// TODO Auto-generated method stub
		List<Auditor> auditor = find("select a from Auditor a where a.AID = ?0", AID);
		if (auditor!= null && auditor.size() >= 1)
		{
			return auditor.get(0);
		}
		return null;
	}

}
