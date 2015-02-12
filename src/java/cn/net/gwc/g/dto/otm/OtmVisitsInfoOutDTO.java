package cn.net.gwc.g.dto.otm;

import java.util.Date;

import cn.net.gwc.g.dto.impl.BaseDTO;



/**
 * <p>文件名称：OtmVisitsInfoOutDTO.java</p>
 * <p>文件描述：</p>
 * <p>版权所有： 版权所有(C)2007-2017</p>
 * <p>公    司： 与龙共舞独立工作室</p>
 * <p>内容摘要： </p>
 * <p>其他说明： </p>
 * <p>完成日期：2014-1-26</p>
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
public class OtmVisitsInfoOutDTO extends BaseDTO
{

    /**
     * 
     */
    private static final long serialVersionUID = 2390233677868955938L;
    
    /**
     * 是否第一次阅读
     */
    private int isFirstSuccess;
    
    /**
     * 回执附言
     */
    private String visitsReceipt;
    
    /**
     * 外键
     */
    private String fkMessageId;
    
    /**
     * 回话session
     */
    private String sessionId;
    
    /**
     * ip地址
     */
    private String ip;
    
    /**
     * 来源网址
     */
    private String refers;
    
    /**
     * 操作系统
     */
    private String osVersion;
    
    /**
     * 浏览器
     */
    private String browserVersion;

    public int getIsFirstSuccess()
    {
        return isFirstSuccess;
    }

    public void setIsFirstSuccess(int isFirstSuccess)
    {
        this.isFirstSuccess = isFirstSuccess;
    }

    public String getVisitsReceipt()
    {
        return visitsReceipt;
    }

    public void setVisitsReceipt(String visitsReceipt)
    {
        this.visitsReceipt = visitsReceipt;
    }

    public String getFkMessageId()
    {
        return fkMessageId;
    }

    public void setFkMessageId(String fkMessageId)
    {
        this.fkMessageId = fkMessageId;
    }

    public String getSessionId()
    {
        return sessionId;
    }

    public void setSessionId(String sessionId)
    {
        this.sessionId = sessionId;
    }

    public String getIp()
    {
        return ip;
    }

    public void setIp(String ip)
    {
        this.ip = ip;
    }

    public String getRefers()
    {
        return refers;
    }

    public void setRefers(String refers)
    {
        this.refers = refers;
    }

    public String getOsVersion()
    {
        return osVersion;
    }

    public void setOsVersion(String osVersion)
    {
        this.osVersion = osVersion;
    }

    public String getBrowserVersion()
    {
        return browserVersion;
    }

    public void setBrowserVersion(String browserVersion)
    {
        this.browserVersion = browserVersion;
    }
    
    
    /**
        `visits_id` int(11) not null auto_increment comment '访客id',
    `isFirstSuccess` int(0) not null default 0 comment '是否第一次阅读',
    `visits_receipt` char(32) comment '回执附言',
    `fk_message_id` int(11) not null comment '外键',
    `session_id`    char(64) not null comment '回话session',
    `ip` char(16) not null comment 'ip地址',
    `refers` text(1024) comment '来源网址',
    `os_version` char(128) comment '操作系统',
    `browser_version` char(128) comment '浏览器',
    `visits_date` TIMESTAMP  comment '访客访问时间',
    `update_date` TIMESTAMP comment '最后更新时间',
    
     */
    
    private String visitsId;

    private Date viditsDate;
    
    private Date updateDate;

    public String getVisitsId()
    {
        return visitsId;
    }

    public void setVisitsId(String visitsId)
    {
        this.visitsId = visitsId;
    }

    public Date getViditsDate()
    {
        return viditsDate;
    }

    public void setViditsDate(Date viditsDate)
    {
        this.viditsDate = viditsDate;
    }

    public Date getUpdateDate()
    {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate)
    {
        this.updateDate = updateDate;
    }
}
