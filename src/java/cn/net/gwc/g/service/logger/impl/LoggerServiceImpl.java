package cn.net.gwc.g.service.logger.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.net.gwc.g.dao.logger.i.ILoggerDAO;
import cn.net.gwc.g.dto.logger.ClientLog;
import cn.net.gwc.g.service.logger.i.ILoggerService;

/**
 * <p>文件名称：TLoggerServiceImpl.java</p>
 * <p>文件描述：</p>
 * <p>版权所有： 版权所有(C)2007-2017</p>
 * <p>公    司： 与龙共舞独立工作室</p>
 * <p>内容摘要： </p>
 * <p>其他说明： </p>
 * <p>完成日期：2013-9-27</p>
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
public class LoggerServiceImpl implements ILoggerService
{
    protected Log logger = LogFactory.getLog(getClass());

    private ILoggerDAO dao;
    
   // @Override
    public String recordClientLog(ClientLog log)
    {    
        if(dao==null)
        {
            //需要在xml中配置bean
            logger.warn("dao is null");
            return "";
        }else
        {
            String s=dao.recordClientLog(log);
            return s;
        }        
       
    }

    public ILoggerDAO getDao()
    {
        return dao;
    }

    public void setDao(ILoggerDAO dao)
    {
        this.dao = dao;
    }

}
