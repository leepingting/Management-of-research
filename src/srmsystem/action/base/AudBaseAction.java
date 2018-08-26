package srmsystem.action.base;

import com.opensymphony.xwork2.ActionSupport;
import srmsystem.service.AudManager;

/**
 * Description:
 * <br/>网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
 * <br/>Copyright (C), 2001-2016, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
public class AudBaseAction extends ActionSupport
{
	// 依赖的业务逻辑组件
	protected AudManager audManager;
	// 依赖注入业务逻辑组件所必须的setter方法

	public AudManager getAudManager() {
		return audManager;
	}

	public void setAudManager(AudManager audManager) {
		this.audManager = audManager;
	}
	
	
}