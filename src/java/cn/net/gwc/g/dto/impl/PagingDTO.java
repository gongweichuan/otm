package cn.net.gwc.g.dto.impl;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>文件名称：PagingDTO.java</p>
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
public class PagingDTO extends PaginationDTO
{
    @SuppressWarnings("rawtypes")
    private Map paramMap = new HashMap(); //查询条件

    public PagingDTO(int pageSize)
    {
        super(pageSize);
    }

    //计算分页
    public void setCountAndPaging(int count)
    {
        this.setCount(count);

        Map paramMap = this.getParamMap();
        paramMap.put("begin", Integer.valueOf(this.getStartIndex()));
        paramMap.put("end", Integer.valueOf(this.getEndIndex()));

    }

    public Map getParamMap()
    {
        return paramMap;
    }

    public void setParamMap(Map paramMap)
    {
        this.paramMap = paramMap;
    }
}
