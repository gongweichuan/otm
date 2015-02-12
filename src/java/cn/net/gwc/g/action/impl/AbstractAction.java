package cn.net.gwc.g.action.impl;

import java.util.Map;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import cn.net.gwc.g.action.i.IAction;
import cn.net.gwc.g.dto.impl.BaseDTO;
import cn.net.gwc.g.service.logger.i.ILoggerService;

/**
 * <p>文件名称：AbstractAction.java</p>
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
public abstract class AbstractAction implements IAction,BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean 
{

    //@Override
    public abstract Map perform(BaseDTO request);
    
    protected BeanFactory context;
    protected String name;

    /**
     * 
     */
    public AbstractAction() {
        super();
    }

    /* (non-Javadoc)
     * @see com.paic.pafa.app.lwc.core.beans.factory.BeanNameAware#setBeanName(java.lang.String)
     */
    public void setBeanName(String name) {
        this.name = name;
    }

    /* (non-Javadoc)
     * @see com.paic.pafa.app.lwc.core.beans.factory.DisposableBean#destroy()
     */
    public void destroy(){
    }

    /**
     * Default implementation of InitializingBean
     */
    public void afterPropertiesSet() {

    }

    /* (non-Javadoc)
     * @see com.paic.pafa.app.lwc.core.beans.factory.BeanFactoryAware#setBeanFactory(com.paic.pafa.app.lwc.core.beans.factory.BeanFactory)
     */
    public void setBeanFactory(BeanFactory beanFactory){
        this.context = beanFactory;
    }
    
    /**
     * 
     * <p>功能描述：logger to DB</p>
     * <p>创建人：龚为川</p>
     * <p>创建日期：2013-9-27</p>
     * <p>修改记录1：</p>
     * <pre>
     *  修改人：
     *  修改日期：
    
     *  修改内容：
    
     * </pre>
     * <p>修改记录2：</p>
     *
     * @return
     */
    protected ILoggerService findDBLoggerService()
    {
        ILoggerService service=(ILoggerService)context.getBean(ILoggerService.BEANNAMEOFSERVICE);
        return service;
    }
}
