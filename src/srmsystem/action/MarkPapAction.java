package srmsystem.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.opensymphony.xwork2.ActionContext;
import srmsystem.action.base.TeaBaseAction;

public class MarkPapAction extends TeaBaseAction{
	
	// 封装处理结果的count成员变量
	private String paName;
	private int paLevel;
	private String member;
	
	
	// paname setter和getter方法
	public String getPaName() {
		return paName;
	}
	public void setPaName(String paName) {
		this.paName = paName;
	}


	
	
	//palevel setter和getter方法
	public int getPaLevel() {
		return paLevel;
	}
	public void setPaLevel(int paLevel) {
		this.paLevel = paLevel;
	}

	
	

	//member setter和getter方法
	public String getMember() {
		return member;
	}
	public void setMember(String member) {
		this.member = member;
	}
	
	

	public String execute() throws Exception{
		// 创建ActionContext实例
		ActionContext ctx = ActionContext.getContext();
		
		List<String> mem=new ArrayList<>();
		if(member!=null){
			String[] m=member.split("、");
			mem=Arrays.asList(m);
		}
		String applicant=(String) ctx.getSession().get("user");
		// 调用业务逻辑方法处理用户请求
		double result =teaManager.markPaper(mem,paLevel,applicant);
		if(result>0){
			ctx.getSession().put("paMember",mem);
			ctx.getSession().put("paScore",result);
			ctx.getSession().put("paName",paName);
			ctx.getSession().put("paLevel",paLevel);
			return SUCCESS;
		}else{
			return ERROR;
		}
	}


	
}
