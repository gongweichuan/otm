package cn.net.gwc.w.login;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import cn.net.gwc.g.action.i.IAction;
import cn.net.gwc.g.dto.login.LoginInDTO;
import cn.net.gwc.g.etc.Constants;

/**
 * <p>文件名称：LoginAddRegisterController.java</p>
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
BaseCommandController和AbstractCommandController 
abstractFormController SimpleFormController
 * @email  gongweichuan(AT)gmail.com
 */
public class LoginAddRegisterController extends AbstractController
{
    private String resultView;


    private IAction action;
    private Logger log=Logger.getLogger(LoginController.class);
    
    
    
    //@Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {
        Map map=new HashMap();        
        
        String regID=request.getParameter("regID");
        String regName=request.getParameter("regName");
        String regCode=request.getParameter("regCode");
        
        logger.debug("regID regName regName"+regID+" "+regName+" "+regCode);
        LoginInDTO inDTO=new LoginInDTO();
        inDTO.setId(regID);
        inDTO.setName(regName);
        
        
        if(action!=null)
        {
            map=action.perform(inDTO);
        }
        else
        {
            logger.warn("action is null");
        }
        
        if(Constants.SUCCESS_ACTION_VALUE.equalsIgnoreCase((String)map.get(Constants.SUCCESS_ACTION_VALUE)))
        {
            ModelAndView mv=new ModelAndView(resultView,map);
            
            log.info("End LoginAddRegisterController..."+mv);
            return mv;
        }else
        {
            log.info("unknow error...");
            return null;
        }
        
        
    }

    public IAction getAction()
    {
        return action;
    }

    public void setAction(IAction action)
    {
        this.action = action;
    }
    
    
    public String getResultView()
    {
        return resultView;
    }

    public void setResultView(String resultView)
    {
        this.resultView = resultView;
    }

}
