package cn.net.gwc.g.dto.impl;

import cn.net.gwc.g.dto.i.IPaginated;
import java.util.List;
/**
 * <p>文件名称：PaginatedDTO.java</p>
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
public class PaginatedDTO extends BaseDTO implements IPaginated
{
    /**
     * 
     */
    private static final long serialVersionUID = -7870528536926518905L;
    
    private long fullListSize = -1L;
    private List PageList = null;
    private int objectsPerPage = -1;
    private int PageNumber = -1;
    private int startRowNum = -1;
    private int endRowNum = -1;
    
    public int getEndRowNum()
    {
      return this.objectsPerPage * this.PageNumber;
    }
    
    public void setEndRowNum(int endRowNum)
    {
      this.endRowNum = endRowNum;
    }
    
    public int getStartRowNum()
    {
      int tmp = this.objectsPerPage * (this.PageNumber - 1);
      
      return tmp;
    }
    
    public void setStartRowNum(int startRowNum)
    {
      this.startRowNum = startRowNum;
    }
    
    public long getFullListSize()
    {
      return this.fullListSize;
    }
    
    public List getList()
    {
      return this.PageList;
    }
    
    public int getObjectsPerPage()
    {
      return this.objectsPerPage;
    }
    
    public int getPageNumber()
    {
      return this.PageNumber;
    }
    
    public String getSearchId()
    {
      return null;
    }
    
    public void setObjectsPerPage(int objectsPerPage)
    {
      this.objectsPerPage = objectsPerPage;
    }
    
    public void setFullListSize(long fullListSize)
    {
      this.fullListSize = fullListSize;
    }
    
    public void setPageList(List pageList)
    {
      this.PageList = pageList;
    }
    
    public void setPageNumber(int pageNumber)
    {
      this.PageNumber = pageNumber;
    }
    
    public boolean equals(PaginatedDTO arg0)
    {
      return (arg0.getEndRowNum() == getEndRowNum()) && (arg0.getFullListSize() == getFullListSize()) && (arg0.getList() == getList()) && (arg0.getObjectsPerPage() == getObjectsPerPage()) && (arg0.getPageNumber() == getPageNumber()) && (arg0.getStartRowNum() == getStartRowNum());
    }
}
