package cn.net.gwc.g.action.i;

import java.util.Map;

import cn.net.gwc.g.dto.impl.BaseDTO;

/**
 * <p>文件名称：IAction.java</p>
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
public interface IAction
{
 /**
  * 
  * <p>功能描述：</p>
  * <p>创建人：龚为川</p>
  * <p>创建日期：2013-8-14</p>
  * <p>修改记录1：</p>
  * <pre>
  *  修改人：
  *  修改日期：
 
  *  修改内容：
 
  * </pre>
  * <p>修改记录2：</p>
  *
  * @param request
  * @return
  */
    public Map perform(BaseDTO request);
}
