package cn.net.gwc.g.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import cn.net.gwc.g.service.i.IService;



/**
 * <p>文件名称：BaseService.java</p>
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
public class BaseServiceImpl implements IService, BeanNameAware,
        DisposableBean, InitializingBean, BeanFactoryAware
{

    protected Log logger = LogFactory.getLog(getClass());

    protected BeanFactory context;

    protected String name;

    protected Logger tracer;

    public BaseServiceImpl()
    {
    }

    public void setBeanName(String name)
    {
        this.name = name;
    }

    public String getBeanName()
    {
        return name;
    }

    public void destroy()
    {
    }

    public void afterPropertiesSet()
    {
    }

    public void setBeanFactory(BeanFactory beanFactory)
    {
        context = beanFactory;
    }

}
