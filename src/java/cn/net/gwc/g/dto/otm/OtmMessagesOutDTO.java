package cn.net.gwc.g.dto.otm;

import java.util.Date;

import cn.net.gwc.g.dto.impl.BaseDTO;



/**
 * <p>文件名称：OtmMessagesOutDTO.java</p>
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
public class OtmMessagesOutDTO extends BaseDTO
{

    /**
     * 
     */
    private static final long serialVersionUID = 1263764670879151127L;

    /**
     * 内容
     */
    private String messageContext;
    
    /**
     * 阅读后多少秒销毁
     */
    private int readDelay;
    
    /**
     * 未读留言最长保留多少天
     */
    private int unreadDelay;
    
    /**
     * 访问密码
     */
    private String accessPassword;
    
    /**
     * 阅读次数
     */
    private int readCount;
    
    /**
     * 最大可阅读次数
     */
    private int maxReadCount;
    /*
     * 访问计数
     */
    private int visitCount;
    
    /**
     * 发送者的注册id
     */
    private String createUser;

    public String getMessageContext()
    {
        return messageContext;
    }

    public void setMessageContext(String messageContext)
    {
        this.messageContext = messageContext;
    }

    public int getReadDelay()
    {
        return readDelay;
    }

    public void setReadDelay(int readDelay)
    {
        this.readDelay = readDelay;
    }

    public int getUnreadDelay()
    {
        return unreadDelay;
    }

    public void setUnreadDelay(int unreadDelay)
    {
        this.unreadDelay = unreadDelay;
    }

    public String getAccessPassword()
    {
        return accessPassword;
    }

    public void setAccessPassword(String accessPassword)
    {
        this.accessPassword = accessPassword;
    }

    public int getReadCount()
    {
        return readCount;
    }

    public void setReadCount(int readCount)
    {
        this.readCount = readCount;
    }

    public int getMaxReadCount()
    {
        return maxReadCount;
    }

    public void setMaxReadCount(int maxReadCount)
    {
        this.maxReadCount = maxReadCount;
    }

    public int getVisitCount()
    {
        return visitCount;
    }

    public void setVisitCount(int visitCount)
    {
        this.visitCount = visitCount;
    }

    public String getCreateUser()
    {
        return createUser;
    }

    public void setCreateUser(String createUser)
    {
        this.createUser = createUser;
    }
    
    /**
     * 留言id
     */
    private String messageId;
    
    /**
     * 留言创建时间
     */
    private Date createDate;
    
    /**
     * 消息读取时间
     */
    private Date readDate;
    
    /**
     * 最后更新时间
     */
    private Date updateDate;
    /*
     *`message_id` int(11) not null auto_increment comment '留言id',
    `message_context` varchar(512) not null comment '内容',
    `read_delay` int(5) not null default 180 comment '阅读后多少秒销毁',
    `unread_delay` int(3) not null default 365 comment '未读留言最长保留多少天',
    `access_password` char(32) not null comment '访问密码',
    `read_count` int(3) not null default 0 comment '阅读次数',
    `max_read_count` int(3) not null default 1 comment '最大可阅读次数',
    `visit_count` int (5) not null default 0 comment '访问计数',
    `create_user` char(32) comment '发送者的注册id',
    `create_date` TIMESTAMP  comment '留言创建时间',
    `read_date` TIMESTAMP comment '消息读取时间',
    `update_date` TIMESTAMP comment '最后更新时间',
     */

    public String getMessageId()
    {
        return messageId;
    }

    public void setMessageId(String messageId)
    {
        this.messageId = messageId;
    }

    public Date getCreateDate()
    {
        return createDate;
    }

    public void setCreateDate(Date createDate)
    {
        this.createDate = createDate;
    }

    public Date getReadDate()
    {
        return readDate;
    }

    public void setReadDate(Date readDate)
    {
        this.readDate = readDate;
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
