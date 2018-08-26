package srmsystem.action;

import java.util.List;
import com.opensymphony.xwork2.ActionContext;
import srmsystem.action.base.AudBaseAction;
import srmsystem.vo.ProjectBean;

public class CheckProAction extends AudBaseAction{
	private int prID;	
	private String result;

	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public int getPrID() {
		return prID;
	}
	public void setPrID(int prID) {
		this.prID = prID;
	}
		
	public String check() throws Exception
	{
		// 创建ActionContext实例
		ActionContext ctx = ActionContext.getContext();
		
	    if (result.equals("pass"))
		{
			audManager.checkProject(prID, true);
		}
		// 拒绝申请
		else if (result.equals("deny"))
		{
			audManager.checkProject(prID, false);
		}
		else
		{
			throw new Exception("参数丢失");
		}	
	    return SUCCESS;
	}



	 
}
