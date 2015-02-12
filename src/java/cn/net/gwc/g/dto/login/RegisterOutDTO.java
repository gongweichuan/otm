package cn.net.gwc.g.dto.login;

import java.math.BigInteger;
import java.util.Date;

import cn.net.gwc.g.dto.impl.BaseDTO;





/**
 * <p>文件名称：RegisterOutDTO.java</p>
 * <p>文件描述：</p>
 * <p>版权所有： 版权所有(C)2007-2017</p>
 * <p>公    司： 与龙共舞独立工作室</p>
 * <p>内容摘要： </p>
 * <p>其他说明： </p>
 * <p>完成日期：2013-10-15</p>
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
public class RegisterOutDTO extends BaseDTO
{

    /**
     * 
     */
    private static final long serialVersionUID = -1369455777094547591L;

    //`username` varchar(100) not null comment '用户名',
    private String username;
    
    //`email` varchar(100) default null comment '电子邮箱',
    private String email;
    
    //`password` char(32) not null comment '密码',
    private String password;
    
    //`encrypt_type` tinyint(1) not null default '0' comment '密码加密方式',
    private int encryptType;
    
    //`register_time` datetime not null comment '注册时间',
    private Date registerTime;
    
    //`register_ip` varchar(50) not null default '127.0.0.1' comment '注册IP',
    private String registerIp;
    
    //`last_login_time` datetime not null comment '最后登录时间',
    private Date lastLoginTime;
    
    //`last_login_ip` varchar(50) not null default '127.0.0.1' comment '最后登录IP',
    private String lastLoginIp;
    
    //`login_count` int(11) not null default '0' comment '登录次数',
    private BigInteger loginCount;
    
   // `reset_key` char(32) default null comment '重置密码问题',
    private String resetKey;
    
    //`reset_pwd` varchar(10) default null comment '重置密码答案',
    private String resetPwd;
    
    //`activation` tinyint(1) not null default 0 comment '激活状态',
    private String activation;
    
    //`activation_code` char(32) default null comment '激活码',
    private String activationCode;

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public int getEncryptType()
    {
        return encryptType;
    }

    public void setEncryptType(int encryptType)
    {
        this.encryptType = encryptType;
    }

    public Date getRegisterTime()
    {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime)
    {
        this.registerTime = registerTime;
    }

    public String getRegisterIp()
    {
        return registerIp;
    }

    public void setRegisterIp(String registerIp)
    {
        this.registerIp = registerIp;
    }

    public Date getLastLoginTime()
    {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime)
    {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLastLoginIp()
    {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp)
    {
        this.lastLoginIp = lastLoginIp;
    }

    public BigInteger getLoginCount()
    {
        return loginCount;
    }

    public void setLoginCount(BigInteger loginCount)
    {
        this.loginCount = loginCount;
    }

    public String getResetKey()
    {
        return resetKey;
    }

    public void setResetKey(String resetKey)
    {
        this.resetKey = resetKey;
    }

    public String getResetPwd()
    {
        return resetPwd;
    }

    public void setResetPwd(String resetPwd)
    {
        this.resetPwd = resetPwd;
    }

    public String getActivation()
    {
        return activation;
    }

    public void setActivation(String activation)
    {
        this.activation = activation;
    }

    public String getActivationCode()
    {
        return activationCode;
    }

    public void setActivationCode(String activationCode)
    {
        this.activationCode = activationCode;
    }
    
    
    
    
    

}
