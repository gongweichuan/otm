package cn.net.gwc.g.dto.impl;

/**
 * <p>文件名称：PageInfoDTO.java</p>
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
 *  修改内容：   分页信息基础类

 * </pre>
 * <p>修改记录2：</p>
 *
 * @version 1.0
 * @author 龚为川

 * @email  gongweichuan(AT)gmail.com
 */
public class PageInfoDTO extends BaseDTO
{
    private static final long serialVersionUID = 1L;
    /**
     * 每页显示条数
     */
    public  static  final  int  PAGE_SIZE = 15; 
    /**
     * 每页显示条数
     */
    public  static  final  int  GOTO_PAGE = 1;
    /**
     * 总记录数
     */
    private long totalRecords;
    /**
     * 跳转页面
     */
    private int gotoPage;
    /**
     * 每页显示条数
     */
    private int pageSize;
    /**
     * 是否有记录
     */
    private boolean hasRecord;
    /**
     * 查询语句开始的记录
     */
    private long  startRow;
    /**
     * 查询结束的记录
     */
    private long  endRow;    

    public PageInfoDTO()
    {
        gotoPage = GOTO_PAGE;
        pageSize = PAGE_SIZE;
        hasRecord = false;
    }

    public long getStartRow()
    {
        startRow = (gotoPage - 1) * pageSize + 1;
        return startRow;
    }

    public long getEndRow()
    {
        endRow = getStartRow() + pageSize;
        return endRow;
    }

    public long getTotalRecords()
    {
        return totalRecords;
    }

    public long getTotalPages()
    {
        if(totalRecords % pageSize > 0)
            return totalRecords / pageSize + 1;
        else
            return totalRecords / pageSize;
    }

    public void setTotalRecords(long aTotalRecords)
    {
        totalRecords = aTotalRecords;
    }

    public int getPageSize()
    {
        return pageSize;
    }

    public void setPageSize(int pageSize)
    {
        this.pageSize = pageSize;
    }

    public boolean isHasRecord()
    {
        return hasRecord;
    }

    public void setHasRecord(boolean hasRecord)
    {
        this.hasRecord = hasRecord;
    }

    public int getGotoPage()
    {
        if(gotoPage == 0)
            return 1;
        else
            return gotoPage;
    }

    public void setGotoPage(int gotoPage)
    {
        this.gotoPage = gotoPage;
    }

    public void setStartRow(long startRow) {
        this.startRow = startRow;
    }

    public void setEndRow(long endRow) {
        this.endRow = endRow;
    }
}
