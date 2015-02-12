package cn.net.gwc.g.dto.impl;

import java.util.List;

/**
 * <p>文件名称：PaginationDTO.java</p>
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
public class PaginationDTO extends BaseDTO
{
    /**
     * 查询
     */
    public static final String QUERY = "QUERY";

    /**
     * 首页
     */
    public static final String FIRST_PAGE = "FIRST_PAGE";

    /**
     * 前一页
     */
    public static final String PRE_PAGE = "PRE_PAGE";

    /**
     * 下一页
     */
    public static final String NEXT_PAGE = "NEXT_PAGE";

    /**
     * 尾页
     */
    public static final String LAST_PAGE = "LAST_PAGE";

    /**
     * 当前页
     */
    public static final String CURRENT_PAGE = "CURRENT_PAGE";
    /**
     * 开始索引
     */
    public static final String START_INDEX = "startIndex";

    /**
     * 结束索引
     */
    public static final String END_INDEX = "endIndex";

    // ---------------- 查询动作常量 --------------------//

    /**
     * 总页数
     */
    private int pageNum = 0;

    /**
     * 当前页
     */
    private int curPageNum = 0;

    /**
     * 页大小(一页包含记录数)
     */
    private int pageSize = 0;

    /**
     * 总记录数
     */
    private int count = 0;

    /**
     * 是否首页
     */
    private boolean firstPage = true;

    /**
     * 是否存在上一页
     */
    private boolean prePage = false;

    /**
     * 是否存在下一页
     */
    private boolean nextPage = false;

    /**
     * 是否尾页
     */
    private boolean lastPage = true;

    /**
     * 结果集合
     */
    private List list = null;

    /**
     * 构造函数
     * 
     * @param pageSize
     *            页大小(一页包含记录数)
     */
    public PaginationDTO(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 
     * 
     * @Description：上翻页
     * 
     * @author：WULEI017
     * 
     * @return
     * 
     * @throws：
     * 
     * @Create Time：2009-1-16
     */
    public boolean previouPage() {
        if (this.curPageNum <= 1) {
            return false;
        }

        this.curPageNum--;
        this.setPageProperties();

        return true;
    }

    /**
     * 
     * 
     * @Description：下翻页
     * 
     * @author：WULEI017
     * 
     * @return
     * 
     * @throws：
     * 
     * @Create Time：2009-1-16
     */
    public boolean nextPage() {
        if (this.curPageNum >= this.pageNum) {
            return false;
        }

        this.curPageNum++;
        this.setPageProperties();

        return true;
    }

    /**
     * 
     * 
     * @Description：首翻页
     * 
     * @author：WULEI017
     * 
     * @return
     * 
     * @throws：
     * 
     * @Create Time：2009-1-16
     */
    public boolean firstPage() {
        if (this.curPageNum <= 1) {
            return false;
        }

        this.curPageNum = 1;
        this.setPageProperties();

        return true;
    }

    /**
     * 
     * 
     * @Description：当前页
     * 
     * @author：ex-ganwei001
     * 
     * @return
     * 
     * @throws：
     * 
     * @Create Time：2011-8-9
     */
    public boolean currentPage() {
        if (this.curPageNum <= 0 || this.curPageNum > this.pageNum) {
            return false;
        }
        this.setPageProperties();
        return true;
    }

    /**
     * 
     * 
     * @Description：尾翻页
     * 
     * @author：WULEI017
     * 
     * @return
     * 
     * @throws：
     * 
     * @Create Time：2009-1-16
     */
    public boolean lastPage() {
        if (this.curPageNum >= this.pageNum) {
            return false;
        }

        this.curPageNum = this.pageNum;
        this.setPageProperties();

        return true;
    }

    /**
     * 
     * 
     * @Description：跳转至第page页
     * 
     * @author：WULEI017
     * 
     * @param page
     *            页索引
     * @return
     * 
     * @throws：
     * 
     * @Create Time：2009-1-16
     */
    public boolean toPage(int page) {
        if (page <= 0 || page > this.pageNum) {
            return false;
        }

        this.curPageNum = page;
        this.setPageProperties();

        return true;
    }

    /**
     * 
     * 
     * @Description：得到开始索引
     * 
     * @author：WULEI017
     * 
     * @return
     * 
     * @throws：
     * 
     * @Create Time：2009-1-16
     */
    public int getStartIndex() {
        int startIndex = (this.curPageNum - 1) * this.pageSize;
        return startIndex <= 0 ? 0 : startIndex;
    }

    /**
     * 
     * 
     * @Description：得到结束索引
     * 
     * @author：WULEI017
     * 
     * @return
     * 
     * @throws：
     * 
     * @Create Time：2009-1-16
     */
    public int getEndIndex() {
        int endIndex = this.curPageNum * this.pageSize;
        return endIndex >= this.count ? this.count : endIndex;
    }

    /**
     * 
     * 
     * @Description：设置页属性
     * 
     * @author：WULEI017
     * 
     * 
     * @throws：
     * 
     * @Create Time：2009-1-16
     */
    private void setPageProperties() {
        if (this.pageNum <= 0) {// 查询无结果
            this.firstPage = false;
            this.prePage = false;
            this.nextPage = false;
            this.lastPage = false;
            return;
        }

        if (this.pageNum <= 1) {// 只有一页,首页即尾页
            this.firstPage = true;
            this.lastPage = true;
            this.prePage = false;
            this.nextPage = false;
            return;
        }

        // 多页情况
        if (this.curPageNum <= 1) {// 首页
            this.firstPage = true;
            this.prePage = false;
            this.nextPage = true;
            this.lastPage = false;
        } else if (this.curPageNum >= this.pageNum) {// 最后页
            this.lastPage = true;
            this.nextPage = false;
            this.prePage = true;
            this.firstPage = false;
        } else {// 中间页
            this.firstPage = false;
            this.lastPage = false;
            this.prePage = true;
            this.nextPage = true;
        }
    }

    /**
     * 
     * 
     * @Description：计算页数
     * 
     * @author：WULEI017
     * 
     * 
     * @throws：
     * 
     * @Create Time：2009-1-16
     */
    private void countPageNum() {
        if ((this.count % this.pageSize) == 0) {
            this.pageNum = this.count / this.pageSize;
        } else {
            this.pageNum = (this.count / this.pageSize) + 1;
        }
    }

    // ----------------- getter&setter ----------------------//
    public int getPageNum() {
        return pageNum;
    }

    public int getCurPageNum() {
        return curPageNum;
    }

    public void setCurPageNum(int curPageNum) {
        this.curPageNum = curPageNum;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
        this.countPageNum();
    }

    public boolean isFirstPage() {
        return firstPage;
    }

    public boolean isPrePage() {
        return prePage;
    }

    public boolean isNextPage() {
        return nextPage;
    }

    public boolean isLastPage() {
        return lastPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
}
