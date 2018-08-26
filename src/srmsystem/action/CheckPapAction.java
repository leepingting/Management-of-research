package srmsystem.action;

import java.util.List;
import com.opensymphony.xwork2.ActionContext;
import srmsystem.action.base.AudBaseAction;
import srmsystem.vo.PaperBean;
import srmsystem.vo.ProjectBean;
import static srmsystem.service.AudManager.*;


public class CheckPapAction extends AudBaseAction{
	private int paID;
	private String result;
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public int getPaID() {
		return paID;
	}
	public void setPaID(int paID) {
		this.paID = paID;
	}
	public String check() throws Exception
	{	
		// 创建ActionContext实例
		ActionContext ctx = ActionContext.getContext();
			
		// 获取HttpSession中的user属性
		if (result.equals("pass"))
		{
			audManager.checkPaper(paID, true);
		}
		// 拒绝申请
		else if (result.equals("deny"))
		{
			audManager.checkPaper(paID, false);
		}
		else
		{
			throw new Exception("参数丢失");
		}	
	    return SUCCESS;
	}





}
	
	
	
	
	

