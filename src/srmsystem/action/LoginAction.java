package srmsystem.action;

import com.opensymphony.xwork2.ActionContext;
import srmsystem.action.base.AudBaseAction;
import srmsystem.domain.User;
import srmsystem.service.AudManager;
import static srmsystem.service.AudManager.*;

public class LoginAction extends AudBaseAction{
	// 定义一个常量作为审核员登录成功的Result名
	private final String AUD_RESULT = "aud";
	// 定义一个常量作为教师登录成功的Result名
	private final String TEA_RESULT = "tea";
	// 封装请求参数
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	// 处理用户请求
	public String execute()
		throws Exception
	{
		// 创建ActionContext实例
		ActionContext ctx = ActionContext.getContext();
		// 调用业务逻辑方法来处理登录请求			
		int result = audManager.validLogin(getUser());
		//int result = LOGIN_TEA;
		// 登录结果为审核员
		if (result == LOGIN_AUD)
		{
			ctx.getSession().put(WebConstant.USER
				, audManager.findAName(user.getUID()));
			ctx.getSession().put(WebConstant.LEVEL
				, WebConstant.AUD_LEVEL);
			addActionMessage("您已经成功登录系统");
			return AUD_RESULT;
		}
		// 登录结果为教师
		else if (result == LOGIN_TEA)
		{
			ctx.getSession().put(WebConstant.USER
				, audManager.findTName(user.getUID()));
			ctx.getSession().put(WebConstant.LEVEL
				, WebConstant.TEA_LEVEL);
			addActionMessage("您已经成功登录系统");
			return TEA_RESULT;
		}
		// 用户名和密码不匹配
		else
		{
			addActionMessage("用户名/密码不匹配");
			return ERROR;
		}
	}

}
