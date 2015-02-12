package cn.net.gwc.g.dao.login.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import cn.net.gwc.g.dao.login.i.ILoginDAO;
import cn.net.gwc.g.dto.login.LoginInDTO;
import cn.net.gwc.g.dto.login.LoginOutDTO;

import com.ibatis.common.xml.NodeletException;

/**
 * <p>文件名称：LoginDAOImpl.java</p>
 * <p>文件描述：</p>
 * <p>版权所有： 版权所有(C)2007-2017</p>
 * <p>公    司： 与龙共舞独立工作室</p>
 * <p>内容摘要： </p>
 * <p>其他说明： </p>
 * <p>完成日期：2013-8-13</p>
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
public class LoginDAOImpl extends SqlMapClientDaoSupport implements ILoginDAO
{

   // @Override
    public List getList()
    {
        NodeletException e =null;
        return getSqlMapClientTemplate().queryForList("getAllUsers",null);
    }

    //@Override
    public LoginOutDTO getByName(String name)
    {
        return (LoginOutDTO)getSqlMapClientTemplate().queryForObject("getUsersByName",name);
    }

    //@Override
    public LoginOutDTO getById(String id)
    {
        return (LoginOutDTO)getSqlMapClientTemplate().queryForObject("getUsersById",id);
    }

   // @Override
    public void save(LoginInDTO inDTO)
    {
        getSqlMapClientTemplate().insert("insertUsers",inDTO);

    }

    //@Override
    public void delete(String id)
    {
        getSqlMapClientTemplate().delete("deleteUsers", id);

    }

    //@Override
    public void update(LoginInDTO inDTO)
    {
        getSqlMapClientTemplate().update("updateUsers", inDTO);

    }
    
}
