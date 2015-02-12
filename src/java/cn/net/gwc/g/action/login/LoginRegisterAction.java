package cn.net.gwc.g.action.login;

import java.util.HashMap;
import java.util.Map;

import cn.net.gwc.g.action.impl.AbstractAction;
import cn.net.gwc.g.dto.impl.BaseDTO;
import cn.net.gwc.g.dto.logger.ClientLog;
import cn.net.gwc.g.dto.login.LoginInDTO;
import cn.net.gwc.g.etc.Constants;
import cn.net.gwc.g.service.logger.i.ILoggerService;
import cn.net.gwc.g.service.login.i.ILoginService;



/**
 * <p>文件名称：LoginAction.java</p>
 * <p>文件描述：</p>
 * <p>版权所有： 版权所有(C)2007-2017</p>
 * <p>公    司： 与龙共舞独立工作室</p>
 * <p>内容摘要： </p>
 * <p>其他说明： </p>
 * <p>完成日期：2013-8-15</p>
 * <p>修改记录1：</p>
 * <pre>
 *  修改日期：

 *  版本号：
 *  修改人：
 *  修改内容：

 * </pre>
 * <p>修改记录2：</p>
 *
 * @version 1.0
 * @author 龚为川

 * @email  gongweichuan(AT)gmail.com
 */
public class LoginRegisterAction extends AbstractAction
{

    /**
     * sevice
     */
    private ILoginService service;
    
   // @Override
    public Map perform(BaseDTO request)
    {
        // DTO 转换
        LoginInDTO inDTO=(LoginInDTO)request;
        
        //记录日志
        //TODO 调用存储过程
        
        //获得service
        if(service==null)
        {
            service=(ILoginService)context.getBean(ILoginService.BEANLOGINSERVICE);
        }
        
        //调用service
        Map map=new HashMap();
        
            service.addRegister(inDTO);
            
        //设置返回值
        map.put(Constants.SUCCESS_ACTION_KEY, Constants.SUCCESS_ACTION_VALUE);
        
        //记录到db
        ClientLog cLog=new ClientLog();
        cLog.setUserId(inDTO.getId());
        cLog.setUserName(inDTO.getName());
        cLog.setClientIp(inDTO.getClientIp());
        cLog.setChannelType(Constants.CHANNEL_TYPE_JSP);        
        ILoggerService dbLogger=this.findDBLoggerService();
        dbLogger.recordClientLog(cLog);
        
        return map;
    }

    public ILoginService getService()
    {
        return service;
    }

    public void setService(ILoginService service)
    {
        this.service = service;
    }

}
