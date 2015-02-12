package cn.net.gwc.g.action.otm;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import cn.net.gwc.g.action.impl.AbstractAction;
import cn.net.gwc.g.dto.impl.BaseDTO;
import cn.net.gwc.g.dto.otm.OtmVisitsInfoInDTO;
import cn.net.gwc.g.etc.Constants;
import cn.net.gwc.g.service.otm.i.IOtmService;



/**
 * <p>文件名称：OtmUpdateVisitAction.java</p>
 * <p>文件描述：</p>
 * <p>版权所有： 版权所有(C)2007-2017</p>
 * <p>公    司： 与龙共舞独立工作室</p>
 * <p>内容摘要： </p>
 * <p>其他说明： </p>
 * <p>完成日期：2014-2-11</p>
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
public class OtmUpdateVisitAction extends AbstractAction
{

Logger log=Logger.getLogger(OtmUpdateVisitAction.class);
    
    /**
     * OTM Service
     */
    private IOtmService service;
    
    public Map perform(BaseDTO request)
    {
        OtmVisitsInfoInDTO inDTO=(OtmVisitsInfoInDTO)request;
        Map map=new HashMap();
        //List
      //List list=new ArrayList();
      // String visitId=null;
        
        if(service!=null)
        {
            service.updateVisits(inDTO);
        }
        else
        {
            log.warn("service is null");
            return null;
        }
        
        map.put(Constants.SUCCESS_ACTION_KEY, Constants.SUCCESS_ACTION_VALUE);
        map.put(Constants.SUCCESS_RETURN_DTO_KEY, "0");    
        return map;        
    }

    public IOtmService getService()
    {
        return service;
    }

    public void setService(IOtmService service)
    {
        this.service = service;
    }

}
