package cn.net.gwc.g.etc;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;

import java.util.Locale;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * <p>文件名称：PropertiesConfiger.java</p>
 * <p>文件描述：</p>
 * <p>版权所有： 版权所有(C)2007-2017</p>
 * <p>公    司： 与龙共舞独立工作室</p>
 * <p>内容摘要： </p>
 * <p>其他说明： </p>
 * <p>完成日期：2013-10-17</p>
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
public class PropertiesConfiger implements InitializingBean
{
    static Log log = LogFactory.getLog(PropertiesConfiger.class);

    private static Properties configProperties;

    public void setConfigProperties(Properties configProperties)
    {
        PropertiesConfiger.configProperties = configProperties;
    }

    private static MessageSource messageSource;

    public void setMessageSource(MessageSource messageSource)
    {
        PropertiesConfiger.messageSource = messageSource;
    }

    /**
     * 读取配置文件中的值：context-ibp.properties
     * @param key
     * @return
     */
    public static String get(String key)
    {
        String value = configProperties.getProperty(key);
        if (StringUtils.isBlank(value))
        {
            log.warn("找不到相关的配置项：" + key);
        }
        return value;
    }

    public static String get(String key, String defaultValue)
    {
        return configProperties.getProperty(key, defaultValue);
    }

    public void afterPropertiesSet() throws Exception
    {
        if (configProperties == null)
        {
            throw new IllegalArgumentException("请设置 configProperties 属性");
        }
        if (messageSource == null)
        {
            throw new IllegalArgumentException("请设置 messageSource 属性");
        }
    }

    /**读取信息文件：message-info.properties，message-error.properties等
     * @param code
     * @param args
     * @param defaultMessage
     * @param locale
     * @return
     */
    public static String getMessage(String code, Object[] args,
            String defaultMessage, Locale locale)
    {
        return messageSource.getMessage(code, args, defaultMessage, locale);
    }

    /**读取信息文件：message-info.properties，message-error.properties等
     * @param code
     * @param args
     * @param locale
     * @return
     * @throws NoSuchMessageException
     */
    public static String getMessage(String code, Object[] args, Locale locale)
            throws NoSuchMessageException
    {
        return messageSource.getMessage(code, args, locale);
    }
}
