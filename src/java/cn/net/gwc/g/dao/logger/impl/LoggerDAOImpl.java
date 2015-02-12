package cn.net.gwc.g.dao.logger.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import cn.net.gwc.g.dao.logger.i.ILoggerDAO;
import cn.net.gwc.g.dto.logger.ClientLog;
import cn.net.gwc.g.etc.Constants;
import cn.net.gwc.g.etc.DAOException;
import cn.net.gwc.g.etc.Messages;



/**
 * <p>文件名称：LoggerDAOImpl.java</p>
 * <p>文件描述：</p>
 * <p>版权所有： 版权所有(C)2007-2017</p>
 * <p>公    司： 与龙共舞独立工作室</p>
 * <p>内容摘要： </p>
 * <p>其他说明： </p>
 * <p>完成日期：2013-9-26</p>
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
public class LoggerDAOImpl extends SqlMapClientDaoSupport implements ILoggerDAO
{

    //@Override
    public String recordClientLog(ClientLog log)
    {
        Map condition = new HashMap();

        try {
            condition.put("IN_USER_ID", log.getUserId());
            
            condition.put("IN_USER_NAME", log.getUserName());
            condition.put("IN_CLIENT_IP", log.getClientIp());
            condition.put("IN_OPERATE_CODE", log.getOperateCode());
            condition.put("IN_OPERATE_TYPE", log.getOperateType());
            condition.put("IN_OPERATE_STATUS", log.getOperateStatus());
            
            condition.put("IN_OPERATE_SERIAL_NO", log.getOperateSerialNo());
            condition.put("IN_ERROR_CODE", log.getErrorCode());
            condition.put("IN_ERROR_DESCRIPTION", log.getErrorDescription());
            condition.put("IN_LOGON_WAY", log.getLogonWay());
            condition.put("IN_CHANNEL_TYPE", log.getChannelType());
            
           // getSqlMapClientTemplate().queryForObject("record-client-operation-log", condition);//插入数据的操作
            getSqlMapClientTemplate().insert("record-client-operation-log", condition);
            String retCode = (String)condition.get(Constants.DB_PROCEDRE_OUT_RETCODE);
            logger.info("OUT_RETCODE:"+retCode);
            
            if (Constants.DB_PROCEDURE_SYSTEM_EXCEPTION.equals(retCode)) 
            {
                logger.error("调用存储过程:G_CLIENT_LOG_PROC时发生异常: " + condition.get("OUT_MESSAGE"));
                throw new DAOException(Messages.MESSAGE_LOG_DB_OPERATION_EXCEPTION);
            }

            return retCode;

        }         
        catch (DataAccessException ex)
        {
            logger.error("调用存储过程:G_CLIENT_LOG_PROCC时发生异常", ex);
            return "";
        }
        catch (DAOException ex)
        {
            logger.error("调用存储过程:G_CLIENT_LOG_PROCC时发生异常", ex);
            return Constants.DB_PROCEDURE_SYSTEM_EXCEPTION;
        }
    }

}
