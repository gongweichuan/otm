package cn.net.gwc.g.dao.i;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.ibatis.common.util.PaginatedList;

import cn.net.gwc.g.dto.impl.PageListDTO;
import cn.net.gwc.g.dto.impl.PaginatedDTO;
import cn.net.gwc.g.etc.DataAccessorException;

/**
 * <p>文件名称：ICoreDAO.java</p>
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

public interface ICoreDAO
{
    /**
     * 调用存储过程，手动派工Excel上传，校验
     * @param sqlStmID
     * @param paramMap
     * @return
     * @throws DataAccessorException
     */
    public Map queryDispatchTemp(String sqlStmID, Map paramMap)
            throws DataAccessorException;

    /**
     * 查询对象列表 公共查询函数,所有select语句都可用此方法,返回LIST对象
     */
    @SuppressWarnings("unchecked")
    public List queryForList(String sqlStmID, Object param)
            throws DataAccessorException;

    /**
     * 分页查询对象列表 公共查询函数,所有需要分页的select语句都可用此方法,返回分页对象
     */
    public PaginatedDTO queryForListByPagination(String sqlStmID,
            PageListDTO pageListDTO) throws DataAccessorException;

    /**
     * 取一个对象 公共查询函数,所有select语句都可用此方法,返回约定的对象
     */
    public Object queryForObject(String sqlStmID, Object param)
            throws DataAccessorException;

    /**
     * 新增一个对象 公共INSERT函数,所有INSERT语句都可用此方法,返回对象
     */
    public Object insert(String sqlStmID, Object param)
            throws DataAccessorException;

    /**
     * 批量新增
     */
    @SuppressWarnings("unchecked")
    public void insert(final String sqlStmID, final List list)
            throws DataAccessorException;

    /**
     * 批量更新
     */
    @SuppressWarnings("unchecked")
    public void update(final String sqlStmID, final List list)
            throws DataAccessorException;

    /**
     * 更新一个对象 公共UPDATE函数,所有UPDATE语句都可用此方法,返回修改记录数
     */
    public int update(String sqlStmID, Object param)
            throws DataAccessorException;

    /**
     * 删除一个对象 公共DELETE函数,所有DELETE语句都可用此方法,返回删除记录数或大于零SQL执行正确小于零SQL执行出错
     */
    public int delete(String sqlStmID, Object param)
            throws DataAccessorException;

    public int callProc(String sqlStmID, Object param)
            throws DataAccessorException;

    public PaginatedList queryForPaginatedList(String sqlStmID, Object param,
            int pageSize) throws DataAccessorException;

    @SuppressWarnings("unchecked")
    public List queryPageForList(String sqlStmID, Object param, int skipNum,
            int maxNum) throws DataAccessorException;

    public void commitTransaction() throws DataAccessorException;

    public void endTransaction() throws DataAccessorException;

    public void startTransaction() throws DataAccessorException;

    public Connection getConnection() throws DataAccessorException;

    public Connection connectionClose() throws DataAccessorException;

    @SuppressWarnings("unchecked")
    public void insertBatch(String string, List dtoList, int i)
            throws DataAccessorException;

    @SuppressWarnings("unchecked")
    public void updateBatch(String string, List dtoList, int i)
            throws DataAccessorException;
}
