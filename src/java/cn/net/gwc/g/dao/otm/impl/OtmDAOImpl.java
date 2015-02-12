package cn.net.gwc.g.dao.otm.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import cn.net.gwc.g.dao.otm.i.IOtmDAO;
import cn.net.gwc.g.dto.otm.OtmMessagesInDTO;
import cn.net.gwc.g.dto.otm.OtmVisitsInfoInDTO;
import cn.net.gwc.g.etc.Constants;

/**
 * <p>文件名称：OtmDAOImpl.java</p>
 * <p>文件描述：</p>
 * <p>版权所有： 版权所有(C)2007-2017</p>
 * <p>公    司： 与龙共舞独立工作室</p>
 * <p>内容摘要： </p>
 * <p>其他说明： </p>
 * <p>完成日期：2014-1-28</p>
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
public class OtmDAOImpl extends SqlMapClientDaoSupport implements IOtmDAO
{

    /**
     * 
     * 功能描述：创建消息
     * @see com.cvo.erp.pfl.gwc.net.cn.g.dao.otm.i.IOtmDAO#createMessages(com.cvo.erp.pfl.gwc.net.cn.g.dto.otm.OtmMessagesInDTO)
     */
    public String createMessages(OtmMessagesInDTO inDTO)
    {
        Map condition=new HashMap();
        condition.put("in_message_context",inDTO.getMessageContext() );
        condition.put("in_read_delay",Integer.valueOf(inDTO.getReadCount()) );
        condition.put("in_unread_delay", Integer.valueOf(inDTO.getUnreadDelay()));
        condition.put("in_access_password", inDTO.getAccessPassword());
        condition.put("in_read_count", Integer.valueOf(inDTO.getReadCount()));
        
        condition.put("in_max_read_count", Integer.valueOf(inDTO.getMaxReadCount()));
        condition.put("in_visit_count",Integer.valueOf(inDTO.getVisitCount()));
        condition.put("in_create_user",inDTO.getCreateUser() );        

        getSqlMapClientTemplate().insert("g-otm-insert-messages", condition);
        String retCode = (String) condition.get(Constants.DB_PROCEDRE_OUT_RETCODE);//
        String out_message_id=(String)condition.get("out_message_id");
        if(Constants.DB_PROCEDURE_SUCCESS.equalsIgnoreCase(retCode))
        {
            return out_message_id;
        }
        else
        {
            String retMessage=(String)condition.get(Constants.DB_PROCEDURE_OUT_MESSAGE);
            logger.warn("db out message:"+retMessage);
            return Constants.DB_PROCEDURE_SYSTEM_EXCEPTION;
        }        
        
    }

    /**
     * 
     * 功能描述：更新消息
     * @see com.cvo.erp.pfl.gwc.net.cn.g.dao.otm.i.IOtmDAO#updateMessages(com.cvo.erp.pfl.gwc.net.cn.g.dto.otm.OtmMessagesInDTO)
     */
    public void updateMessages(OtmMessagesInDTO inDTO)
    {
        Map condition=new HashMap();
        condition.put("in_message_id",inDTO.getMessageId()); 
        condition.put("in_read_count", Integer.valueOf(inDTO.getReadCount()));
        condition.put("in_visit_count",Integer.valueOf(inDTO.getVisitCount()));
        condition.put("in_case",Integer.valueOf(inDTO.getMessageCase()));        

        getSqlMapClientTemplate().insert("g-otm-update-messages", condition);
        String retCode = (String) condition.get(Constants.DB_PROCEDRE_OUT_RETCODE);//
      
        if(Constants.DB_PROCEDURE_SUCCESS.equalsIgnoreCase(retCode))
        {
            return ;
        }
        else
        {
            String retMessage=(String)condition.get(Constants.DB_PROCEDURE_OUT_MESSAGE);
            logger.warn("db out message:"+retMessage);
            return ;
        } 
        
    }

    /**
     * 
     * 功能描述：查询消息
     * @see com.cvo.erp.pfl.gwc.net.cn.g.dao.otm.i.IOtmDAO#selectMessages(com.cvo.erp.pfl.gwc.net.cn.g.dto.otm.OtmMessagesInDTO)
     */
    public List selectMessages(OtmMessagesInDTO inDTO)
    {

        Map condition =new HashMap();
        
        condition.put("in_message_id",inDTO.getMessageId());
        condition.put("in_from_date",inDTO.getFromDate());
        condition.put("in_to_date",inDTO.getToDate());
        condition.put("in_perpage",Integer.valueOf(inDTO.getPerpage()));
        condition.put("in_pagesize",Integer.valueOf(inDTO.getPagesize()));
        
        List list=getSqlMapClientTemplate().queryForList("g-otm-select-messages", condition);        
        String retCode = (String) condition.get(Constants.DB_PROCEDRE_OUT_RETCODE);//      
        if(Constants.DB_PROCEDURE_SUCCESS.equalsIgnoreCase(retCode))
        {
            String totalnum=(String)condition.get("out_totalnum");
            inDTO.setTotalnum(Integer.valueOf(totalnum).intValue());
            return list;
        }
        else
        {
            String retMessage=(String)condition.get(Constants.DB_PROCEDURE_OUT_MESSAGE);
            logger.warn("db out message:"+retMessage);
            
            list=new ArrayList();
            
            return list;
        }        
        
        
    }

    public String createVisits(OtmVisitsInfoInDTO inDTO)
    {

        Map condition=new HashMap();
        
        condition.put("in_isFirstSuccess",Integer.valueOf( inDTO.getIsFirstSuccess()));
        condition.put("in_visits_receipt", inDTO.getVisitsReceipt());
        condition.put("in_fk_message_id", inDTO.getFkMessageId());
        condition.put("in_session_id", inDTO.getSessionId());
        condition.put("in_ip", inDTO.getIp());
        
        condition.put("in_refers ", inDTO.getRefers());
        condition.put("in_os_version", inDTO.getOsVersion());
        condition.put("in_browser_version", inDTO.getBrowserVersion());
        
        getSqlMapClientTemplate().insert("g_otm_insert_visits_info_proc", condition);
        
        String retCode = (String) condition.get(Constants.DB_PROCEDRE_OUT_RETCODE);//
        String out_message_id=(String)condition.get("out_message_id");
        if(Constants.DB_PROCEDURE_SUCCESS.equalsIgnoreCase(retCode))
        {
            return out_message_id;
        }
        else
        {
            String retMessage=(String)condition.get(Constants.DB_PROCEDURE_OUT_MESSAGE);
            logger.warn("db out message:"+retMessage);
            return Constants.DB_PROCEDURE_SYSTEM_EXCEPTION;
        } 
        
        
    }

    public void updateVisits(OtmVisitsInfoInDTO inDTO)
    {   
        Map condition =new HashMap();
        
        condition.put("in_visits_id", inDTO.getVisitsId());
        condition.put("in_isFirstSuccess", Integer.valueOf(inDTO.getIsFirstSuccess()));
        condition.put("in_visits_receipt", inDTO.getVisitsReceipt());
        condition.put("in_fk_message_id", inDTO.getFkMessageId());
        condition.put("in_session_id", inDTO.getSessionId());
        
        condition.put("in_ip", inDTO.getIp());
        condition.put("in_refers", inDTO.getRefers());
        condition.put("in_os_version", inDTO.getOsVersion());
        condition.put("in_browser_version", inDTO.getBrowserVersion());
        
        getSqlMapClientTemplate().insert("g_otm_update_visits_info_proc", condition);
        
        String retCode = (String) condition.get(Constants.DB_PROCEDRE_OUT_RETCODE);//
        
        if(Constants.DB_PROCEDURE_SUCCESS.equalsIgnoreCase(retCode))
        {
            return ;
        }
        else
        {
            String retMessage=(String)condition.get(Constants.DB_PROCEDURE_OUT_MESSAGE);
            logger.warn("db out message:"+retMessage);
            return ;
        } 
    }

    public List selectVisits(OtmVisitsInfoInDTO inDTO)
    {
        Map condition=new HashMap();
        
        condition.put("in_fk_message_id", inDTO.getFkMessageId());
        condition.put("in_perpage",Integer.valueOf( inDTO.getPerpage()));
        condition.put("in_pagesize",Integer.valueOf( inDTO.getPagesize()));
        
        List list=getSqlMapClientTemplate().queryForList("g_otm_select_visits_info_proc", condition);        
        String retCode = (String) condition.get(Constants.DB_PROCEDRE_OUT_RETCODE);//      
        if(Constants.DB_PROCEDURE_SUCCESS.equalsIgnoreCase(retCode))
        {
            String totalnum=(String)condition.get("out_totalnum");
            inDTO.setTotalnum(Integer.valueOf(totalnum).intValue());
            return list;
        }
        else
        {
            String retMessage=(String)condition.get(Constants.DB_PROCEDURE_OUT_MESSAGE);
            logger.warn("db out message:"+retMessage);
            
            list=new ArrayList();
            
            return list;
        }
    }

}
