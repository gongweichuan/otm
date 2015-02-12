package cn.net.gwc.g.action.otm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import cn.net.gwc.g.action.impl.AbstractAction;
import cn.net.gwc.g.dto.impl.BaseDTO;
import cn.net.gwc.g.dto.otm.OtmMessagesInDTO;
import cn.net.gwc.g.etc.Constants;
import cn.net.gwc.g.service.otm.i.IOtmService;



/**
 * <p>文件名称：OtmListAllMessagesAction.java</p>
 * <p>文件描述：列出多条消息</p>
 * <p>版权所有： 版权所有(C)2007-2017</p>
 * <p>公    司： 与龙共舞独立工作室</p>
 * <p>内容摘要： </p>
 * <p>其他说明： </p>
 * <p>完成日期：2014-2-10</p>
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
public class OtmListAllMessagesAction extends AbstractAction
{

 Logger log=Logger.getLogger(OtmListAllMessagesAction.class);
    
    /**
     * OTM Service
     */
    private IOtmService service;
    
    public Map perform(BaseDTO request)
    {
        OtmMessagesInDTO inDTO=(OtmMessagesInDTO)request;
        Map map=new HashMap();
        //List
        List list=new ArrayList();
        
        if(service!=null)
        {
            list=service.selectMessages(inDTO);
        }
        else
        {
            log.warn("service is null");
            return null;
        }
        
        map.put(Constants.SUCCESS_ACTION_KEY, Constants.SUCCESS_ACTION_VALUE);
        map.put(Constants.SUCCESS_RETURN_DTO_KEY, list);    
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
