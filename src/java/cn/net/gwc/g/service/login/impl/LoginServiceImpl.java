package cn.net.gwc.g.service.login.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.net.gwc.g.dao.login.i.ILoginDAO;
import cn.net.gwc.g.dto.login.LoginInDTO;
import cn.net.gwc.g.service.impl.BaseServiceImpl;
import cn.net.gwc.g.service.login.i.ILoginService;
/**
 * <p>文件名称：TLoginServiceImpl.java</p>
 * <p>文件描述：</p>
 * <p>版权所有： 版权所有(C)2007-2017</p>
 * <p>公    司： 与龙共舞独立工作室</p>
 * <p>内容摘要： </p>
 * <p>其他说明： </p>
 * <p>完成日期：2013-8-14</p>
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
public class LoginServiceImpl extends BaseServiceImpl implements ILoginService
{
    protected Log logger = LogFactory.getLog(getClass());
    
    /**
     * DAO
     */
    private ILoginDAO dao;

    //@Override
    public void addRegister(LoginInDTO inDTO)
    {
        if(dao==null)
        {
            dao=(ILoginDAO)context.getBean(ILoginDAO.BEANLOGINDAO);            
        }
        logger.info("addRegister");
        dao.save(inDTO);
    }

    //@Override
    public List listAllRegister()
    {
        if(dao==null)
        {
            dao=(ILoginDAO)context.getBean(ILoginDAO.BEANLOGINDAO);            
        }
        List list=dao.getList();
        logger.info("listAllRegister");
        return list;
    }

    public ILoginDAO getDao()
    {
        return dao;
    }

    public void setDao(ILoginDAO dao)
    {
        this.dao = dao;
    }

}
