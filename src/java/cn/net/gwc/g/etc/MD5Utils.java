package cn.net.gwc.g.etc;

import java.security.MessageDigest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * <p>文件名称：MD5Utils.java</p>
 * <p>文件描述：</p>
 * <p>版权所有： 版权所有(C)2007-2017</p>
 * <p>公    司： 与龙共舞独立工作室</p>
 * <p>内容摘要： </p>
 * <p>其他说明： </p>
 * <p>完成日期：2013-10-21</p>
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
public class MD5Utils
{
    static Log logger = LogFactory.getLog(MD5Utils.class);

    private final static String[] hexDigits = {"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    /**
     * 转换字节数组为16进制字串
     *
     * @param b
     *            字节数组
     * @return 16进制字串
     */

    public static String byteArrayToHexString(byte[] b)
    {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++)
        {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    private static String byteToHexString(byte b)
    {
        int n = b;
        if (n < 0)
            n = 256 + n;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    public static String MD5Encode(String origin)
    {
        String resultString = null;

        try
        {
            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            resultString = byteArrayToHexString(md.digest(resultString
                    .getBytes()));
        }
        catch (Exception e)
        {
            logger.debug("Exception :" + e.getMessage());
        }
        return resultString;
    }

    public static String bintoascii(byte[] bySourceByte)
    {
        int len, i;
        byte tb;
        char high, tmp, low;
        String result = new String();
        len = bySourceByte.length;
        for (i = 0; i < len; i++)
        {
            tb = bySourceByte[i];

            tmp = (char) ((tb >>> 4) & 0x000f);
            if (tmp >= 10)
                high = (char) ('a' + tmp - 10);
            else
                high = (char) ('0' + tmp);
            result += high;
            tmp = (char) (tb & 0x000f);
            if (tmp >= 10)
                low = (char) ('a' + tmp - 10);
            else
                low = (char) ('0' + tmp);

            result += low;
        }
        return result;
    }
}
