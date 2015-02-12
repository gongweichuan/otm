package cn.net.gwc.g.etc;

/**
 * <p>文件名称：DataAccessorException.java</p>
 * <p>文件描述：</p>
 * <p>版权所有： 版权所有(C)2007-2017</p>
 * <p>公    司： 与龙共舞独立工作室</p>
 * <p>内容摘要： </p>
 * <p>其他说明： </p>
 * <p>完成日期：2015-1-8</p>
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
public class DataAccessorException extends DAOException
{

    public DataAccessorException()
    {
        super();
        // TODO Auto-generated constructor stub
    }

    public DataAccessorException(String message, Throwable cause)
    {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    public DataAccessorException(Throwable cause)
    {
        super(cause);
        // TODO Auto-generated constructor stub
    }

    public DataAccessorException(String msg)
    {
        super(msg);
        // 与DAOException相同
    }

    /**
     * 
     */
    private static final long serialVersionUID = 7195648015916030019L;

}
