package cn.net.gwc.g.dto.impl;

import cn.net.gwc.g.dto.i.IBaseDTO;

/**
 * <p>文件名称：BaseDTO.java</p>
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
public class BaseDTO implements IBaseDTO
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    //客户ip地址信息
    private String ClientIp;

    public String getClientIp()
    {
        return ClientIp;
    }

    public void setClientIp(String clientIp)
    {
        ClientIp = clientIp;
    }
}
