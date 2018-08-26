package srmsystem.action.base;

import com.opensymphony.xwork2.ActionSupport;
import srmsystem.service.TeaManager;

public class TeaBaseAction extends ActionSupport{
	protected TeaManager teaManager;

	public TeaManager getTeaManager() {
		return teaManager;
	}

	public void setTeaManager(TeaManager teaManager) {
		this.teaManager = teaManager;
	}
	
}
