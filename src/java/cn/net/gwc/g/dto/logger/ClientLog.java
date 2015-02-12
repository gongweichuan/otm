package cn.net.gwc.g.dto.logger;

import cn.net.gwc.g.dto.impl.BaseDTO;

/**
 * <p>文件名称：ClientLog.java</p>
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
public class ClientLog extends BaseDTO
{
    /**
     * 
     */
    private static final long serialVersionUID = 2380141905386588880L;
    
    private String userId;          
    private String userName;        
    private String clientIp;        
    private String operateCode;     
    private String operateType;      
    private String operateStatus;    
    private String operateSerialNo;
    private String errorCode;       
    private String errorDescription;
    public String getUserId()
    {
        return userId;
    }
    public void setUserId(String userId)
    {
        this.userId = userId;
    }
    public String getUserName()
    {
        return userName;
    }
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    public String getClientIp()
    {
        return clientIp;
    }
    public void setClientIp(String clientIp)
    {
        this.clientIp = clientIp;
    }
    public String getOperateCode()
    {
        return operateCode;
    }
    public void setOperateCode(String operateCode)
    {
        this.operateCode = operateCode;
    }
    public String getOperateType()
    {
        return operateType;
    }
    public void setOperateType(String operateType)
    {
        this.operateType = operateType;
    }
    public String getOperateStatus()
    {
        return operateStatus;
    }
    public void setOperateStatus(String operateStatus)
    {
        this.operateStatus = operateStatus;
    }
    public String getOperateSerialNo()
    {
        return operateSerialNo;
    }
    public void setOperateSerialNo(String operateSerialNo)
    {
        this.operateSerialNo = operateSerialNo;
    }
    public String getErrorCode()
    {
        return errorCode;
    }
    public void setErrorCode(String errorCode)
    {
        this.errorCode = errorCode;
    }
    public String getErrorDescription()
    {
        return errorDescription;
    }
    public void setErrorDescription(String errorDescription)
    {
        this.errorDescription = errorDescription;
    }
    public String getLogonWay()
    {
        return logonWay;
    }
    public void setLogonWay(String logonWay)
    {
        this.logonWay = logonWay;
    }
    public String getChannelType()
    {
        return channelType;
    }
    public void setChannelType(String channelType)
    {
        this.channelType = channelType;
    }
    public String getOperateTime()
    {
        return operateTime;
    }
    public void setOperateTime(String operateTime)
    {
        this.operateTime = operateTime;
    }
    private String logonWay;        
    private String channelType;     
    private String operateTime;     
}
