package cn.net.gwc.g.dto.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>文件名称：PageListDTO.java</p>
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
 
  * 定义页面显示数据对象
  * 用户在实现类时，要对该类的泛型进行实际对象值确定

 * </pre>
 * <p>修改记录2：</p>
 *
 * @version 1.0
 * @author 龚为川

 * @email  gongweichuan(AT)gmail.com
 */
public class PageListDTO<T> extends PageInfoDTO
{
private static final String  QUERY = "query";
    
    private static final String  GOTOPAGE = "gotoPage";
    
    private static final String  PAGESIZE = "pageSize";
    
    private  List<T> list;
    
    private  Map collection = new HashMap();
    
    //增加对特殊情况下的使用，如查询条件出现集合
    private  Map<String,Object> collObjMap = new HashMap<String,Object>();
    private int recordCount;

    public int getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
    
    public Map getCollection() {
        return collection;
    }

    public void setCollection(Map collection) {
        this.collection = collection;
    }

    public Map<String, Object> getCollObjMap() {
        return collObjMap;
    }

    public void setCollObjMap(Map<String, Object> collObjMap) {
        this.collObjMap = collObjMap;
    }

    @SuppressWarnings("unchecked")
    public void  switchPaginatedDTO(PaginatedDTO paginatedDTO){     
        if(paginatedDTO == null)
            return ;
        setList(paginatedDTO.getList());
        setTotalRecords(paginatedDTO.getFullListSize());
        setGotoPage(paginatedDTO.getPageNumber());
        setPageSize(paginatedDTO.getObjectsPerPage());
    }
    
    /**
     * 对页面请求的参数，进行处理
     * @param request
     * @return
     */
    @SuppressWarnings("unchecked")
    public  static  PageListDTO  bindingPageListDTO(HttpServletRequest request){
        String query = (String)request.getParameter(QUERY);
        PageListDTO pl = new PageListDTO();
        
        //判断是点击查询按钮还是点击分页按钮
        if(query == null){
            pl.setPageSize(PAGE_SIZE);
            pl.setGotoPage(GOTO_PAGE);  
            pl.setTotalRecords(0);
        }else{
            String  gotoPage = (String)request.getParameter(GOTOPAGE);
            String  pageSize = (String)request.getParameter(PAGESIZE);
            
            if(pageSize == null || pageSize.trim().equals("")){
                pageSize = PAGE_SIZE +"";           
            }
            pl.setPageSize(Integer.parseInt(pageSize));
            
            if(gotoPage == null || gotoPage.trim().equals("")){
                gotoPage = GOTO_PAGE +"";
            }
            pl.setGotoPage(Integer.parseInt(gotoPage));
        }   
        return pl;
    }   
}
