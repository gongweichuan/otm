package cn.net.gwc.w.login;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import cn.net.gwc.g.action.i.IAction;
import cn.net.gwc.g.etc.Constants;



/**
 * <p>文件名称：LoginController.java</p>
 * <p>文件描述：</p>
 * <p>版权所有： 版权所有(C)2007-2017</p>
 * <p>公    司： 与龙共舞独立工作室</p>
 * <p>内容摘要： </p>
 * <p>其他说明： </p>
 * <p>完成日期：2013-6-6</p>
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
public class LoginController extends AbstractController
{
    private String resultView;
    
    private Object dispatchService;
  
    private Logger log=Logger.getLogger(LoginController.class);
    
    
    /**
     * action
     */
    private IAction action;
    
   //@Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request,
            HttpServletResponse reponse) throws Exception
    {
        log.info("start LoginController...");        
        //String jspView="login_jsp";
        
        ModelAndView mv;
       
        Map map=new HashMap();
       // map.put("a", "a");
        if(action!=null)
        {
            map=action.perform(null);
        }
        
        if(Constants.SUCCESS_ACTION_VALUE.equalsIgnoreCase((String)map.get(Constants.SUCCESS_ACTION_VALUE)))
        {
            List list=(List)map.get(Constants.SUCCESS_RETURN_DTO_KEY);
            mv=new ModelAndView(resultView,Constants.SUCCESS_RETURN_VIEW_MODEL_NAME,list);
                      
        }else
        {
            mv=new ModelAndView(resultView,map);
        }
        
        log.info("End LoginController..."+mv);
        return mv;
    }

    public String getResultView()
    {
        return resultView;
    }

    public void setResultView(String resultView)
    {
        this.resultView = resultView;
    }

    public Object getDispatchService()
    {
        return dispatchService;
    }

    public void setDispatchService(Object dispatchService)
    {
        this.dispatchService = dispatchService;
    }

    public IAction getAction()
    {
        return action;
    }

    public void setAction(IAction action)
    {
        this.action = action;
    }

}
