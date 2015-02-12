/**
 * 
 */
package cn.net.gwc.g.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.common.util.PaginatedList;
import com.ibatis.sqlmap.client.SqlMapExecutor;

import cn.net.gwc.c.util.ObjectInfo;
import cn.net.gwc.g.dao.i.ICoreDAO;
import cn.net.gwc.g.dto.impl.PageListDTO;
import cn.net.gwc.g.dto.impl.PaginatedDTO;
import cn.net.gwc.g.etc.DataAccessorException;

/**
 * <p>文件名称：CoreDAOImpl.java</p>
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
public class CoreDAOIbatisImpl extends SqlMapClientDaoSupport implements ICoreDAO
{
    private Log logger = LogFactory.getLog(getClass());;

    public Map queryDispatchTemp(String sqlStmID,Map paramMap)throws DataAccessorException{

        getSqlMapClientTemplate().queryForObject(sqlStmID,
                paramMap);
        return paramMap;
    }
    
    /**
     * 查询对象列表 公共查询函数,所有select语句都可用此方法,返回LIST对象
     */
    @SuppressWarnings("unchecked")
    public List queryForList(String sqlStmID, Object param)
            throws DataAccessorException {
        try {
            
             logger.info(this.getClass().getName()+  "in queryForList()");

            List result = getSqlMapClientTemplate().queryForList(sqlStmID,
                    param);
            return result;
        } catch (DataAccessException dae) {
            throw new DataAccessorException(
                    "DataAccessException is thrown while executing the '"
                            + sqlStmID + "'-query for parameter: "
                            + param.toString()+this.getClass().getName()+
                    "READ_RECORD_ERROR "+ "queryForList()"
                            + dae.getMessage(), dae);
        } catch (Exception e) {
            throw new DataAccessorException( this.getClass().getName()+
                    "READ_RECORD_ERROR "+ "queryForList()"
                            + e.getMessage(), e);
        }
    }
    
    /**
     * 分页查询对象列表 公共查询函数,所有需要分页的select语句都可用此方法,返回分页对象
     */
    public PaginatedDTO queryForListByPagination(String sqlStmID,PageListDTO pageListDTO) throws DataAccessorException {
        try{
            logger.info(this.getClass().getName()+ "in queryForListByPagination()");

            
            PaginatedDTO result = null;
//            result = (PaginatedDTO) this.getSqlMapClientTemplate().queryFororaclePaginatedResult(sqlStmID, pageListDTO.getCollection(),
//                    pageListDTO.getTotalRecords(), pageListDTO.getGotoPage(), pageListDTO.getPageSize());
//TODO oracle分页 http://zhoualine.iteye.com/blog/1159787
            
            return result;
        } catch (DataAccessException dae) {
            throw new DataAccessorException(
                    "DataAccessException is thrown while executing the '"
                            + sqlStmID + "'-query for parameter: "
                            + pageListDTO.getCollection().toString()+this.getClass().getName()+
                    "READ_RECORD_ERROR,"+ "queryForListByPagination()"
                            + dae.getMessage(), dae);
        } catch (Exception e) {
            throw new DataAccessorException(this.getClass().getName()+
                    "READ_RECORD_ERROR, "+"queryForListByPagination()"
                            + e.getMessage(), e);
        }
        
    }

    /**
     * 取一个对象 公共查询函数,所有select语句都可用此方法,返回约定的对象
     */
    public Object queryForObject(String sqlStmID, Object param)
            throws DataAccessorException {

        try {
            logger.info(this.getClass().getName()+
                    "in queryForObject()");

            Object obj = getSqlMapClientTemplate().queryForObject(sqlStmID,
                    param);

            return obj;
        } catch (DataAccessException dae) {
            throw new DataAccessorException(
                    "DataAccessException is thrown while executing the '"
                            + sqlStmID + "'-query for parameter: "
                            + param.toString()+ this.getClass().getName()+
                    "READ_RECORD_ERROR, "+"queryForObject()"
                            + dae.getMessage(), dae);
        } catch (Exception e) {
            throw new DataAccessorException(this.getClass().getName()+
                    "READ_RECORD_ERROR, "+"queryForObject()"
                            + e.getMessage(), e);
        }
    }

    /**
     * 新增一个对象 公共INSERT函数,所有INSERT语句都可用此方法,返回对象
     */
    public Object insert(String sqlStmID, Object param)
            throws DataAccessorException {
        try {
            logger.info( this.getClass().getName()+ "in insert()");

            Object obj = getSqlMapClientTemplate().insert(sqlStmID, param);

            return obj;
        } catch(DataIntegrityViolationException ex){
            throw new DataAccessorException("RECORD_EXIST");     
        }catch (DataAccessException dae) {  
            throw new DataAccessorException(
                    "DataAccessException is thrown while executing the '"
                            + sqlStmID + "'-insert for parameter: "
                            + param.toString()+ this.getClass().getName()+
                    "INSERT_RECORD_ERROR, "+"insert()"
                            + dae.getMessage(), dae);
        } catch (Exception e) {
            throw new DataAccessorException( this.getClass().getName()+
                    "INSERT_RECORD_ERROR, "+"insert()"
                            + e.getMessage(), e);
        }
    }

    /**
     * 批量新增
     */

    @SuppressWarnings("unchecked")
    public void insert(final String sqlStmID, final List list)
            throws DataAccessorException {
        try {
            logger.info(this.getClass().getName()+ "in insert()");


            getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
                public Object doInSqlMapClient(SqlMapExecutor executor)
                        throws SQLException {
                    executor.startBatch();
                    for (int iter = 0, count = list.size(); iter < count; iter++) {
                        executor.insert(sqlStmID, list.get(iter));
                    }
                    executor.executeBatch();
                    return null;
                }
            });

        } catch (DataAccessException dae) {
            throw new DataAccessorException(
                    "DataAccessException is thrown while executing the '"
                            + sqlStmID + "'-insert for parameter: "
                            + ObjectInfo.toString(list)+ this.getClass()
                            .getName()+ "INSERT_RECORD_ERROR,"+
                    "insert()" + dae.getMessage(), dae);
        } catch (Exception e) {
            throw new DataAccessorException( this.getClass().getName()+
                    "INSERT_RECORD_ERROR,"+ "insert()"
                            + e.getMessage(), e);
        }
    }
    
    /**
     * 批量更新
     */

    @SuppressWarnings("unchecked")
    public void update(final String sqlStmID, final List list)
            throws DataAccessorException {
        try {
            logger.info(this.getClass().getName()+ "in insert()");

            getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
                public Object doInSqlMapClient(SqlMapExecutor executor)
                        throws SQLException {
                    executor.startBatch();
                    for (int iter = 0, count = list.size(); iter < count; iter++) {
                        executor.update(sqlStmID, list.get(iter));
                    }
                    executor.executeBatch();
                    return null;
                }
            });

        } catch (DataAccessException dae) {
            throw new DataAccessorException(
                    "DataAccessException is thrown while executing the '"
                            + sqlStmID + "'-update for parameter: "
                            + ObjectInfo.toString(list)+ this.getClass()
                            .getName()+ "INSERT_RECORD_ERROR,"+
                    "update()" + dae.getMessage(), dae);
        } catch (Exception e) {
            throw new DataAccessorException(this.getClass().getName()+
                    "INSERT_RECORD_ERROR, "+"update()"
                            + e.getMessage(), e);
        }
    }

    /**
     * 更新一个对象 公共UPDATE函数,所有UPDATE语句都可用此方法,返回修改记录数
     */
    public int update(String sqlStmID, Object param)
            throws DataAccessorException {
        try {
            logger.info(this.getClass().getName()+ "in update()");

            int ret = getSqlMapClientTemplate().update(sqlStmID, param);

            return ret;
        } catch (DataAccessException dae) {
            throw new DataAccessorException(
                    "DataAccessException is thrown while executing the '"
                            + sqlStmID + "'-update for parameter: "
                            + param.toString()+ this.getClass().getName()+
                    "INSERT_RECORD_ERROR, "+"update()"
                            + dae.getMessage(), dae);
        } catch (Exception e) {
            throw new DataAccessorException(this.getClass().getName()+
                    "INSERT_RECORD_ERROR, "+"update()"
                            + e.getMessage(), e);
        }
    }

    /**
     * 删除一个对象 公共DELETE函数,所有DELETE语句都可用此方法,返回删除记录数或大于零SQL执行正确小于零SQL执行出错
     */
    public int delete(String sqlStmID, Object param)
            throws DataAccessorException {
        try {
            logger.info( "in delete()");

            int ret = getSqlMapClientTemplate().delete(sqlStmID, param);

            return ret;
        } catch (DataAccessException dae) {
            throw new DataAccessorException(
                    "DataAccessException is thrown while executing the '"
                            + sqlStmID + "'-update for parameter: "
                            + param.toString()+ this.getClass().getName()+
                    "INSERT_RECORD_ERROR, delete()"
                            + dae.getMessage(), dae);
        } catch (Exception e) {
            throw new DataAccessorException(this.getClass().getName()+
                    "INSERT_RECORD_ERROR, delete()"
                            + e.getMessage(), e);
        }
    }

    /*
     * 调用存储过程
     */
    public int callProc(String sqlStmID, Object param)
            throws DataAccessorException {
        try {
            logger.info( "ExecuteSqlDAO"+ "in callProc()");

            int ret = getSqlMapClientTemplate().update(sqlStmID, param);

            return ret;
        } catch (DataAccessException dae) {
            throw new DataAccessorException(
                    "DataAccessException is thrown while executing the '"
                            + sqlStmID + "'-Call PL/SQL for parameter: "
                            + param.toString()+ "ExecuteSqlDAO"+
                    "UPDATE_RECORD_ERROR, callProc"
                            + dae.getMessage(), dae);
        } catch (Exception e) {
            throw new DataAccessorException( "ExecuteSqlDAO"+
                    "UPDATE_RECORD_ERROR,callProc"
                            + e.getMessage(), e);
        }
    }

    /*
     * 
     * 公共查询函数,所有要求分页的select语句都可用此方法,返回可进行分页操作的PaginatedList对象
     */
    public PaginatedList queryForPaginatedList(String sqlStmID, Object param,
            int pageSize) throws DataAccessorException {
        try {
            logger.debug( "ExecuteSqlDAO"+ "in queryForPaginatedList()");

            return getSqlMapClientTemplate().getSqlMapClient()
                    .queryForPaginatedList(sqlStmID, param, pageSize);
        } catch (DataAccessException dae) {
            throw new DataAccessorException(
                    "DataAccessException is thrown while executing the '"
                            + sqlStmID + "'-query for pagesize=" + pageSize
                            + ",parameter: " + param.toString()+
                    "ExecuteSqlDAO"+ "READ_RECORD_ERROR,"+
                    "queryForPaginatedList()" + dae.getMessage(), dae);
        } catch (Exception e) {
            throw new DataAccessorException( "ExecuteSqlDAO"+
                    "READ_RECORD_ERROR,"+
                    "queryForPaginatedList()" + e.getMessage(), e);
        }
    }

    /*
     * 
     * 公共查询函数,所有select语句都可用此方法,返回限制结果集的LIST对象
     */
    @SuppressWarnings("unchecked")
    public List queryPageForList(String sqlStmID, Object param, int skipNum,
            int maxNum) throws DataAccessorException {
        try {
            logger.info( "ExecuteSqlDAO"+"in queryForList() limited. ");

            List result = getSqlMapClientTemplate().queryForList(sqlStmID,
                    param, skipNum, maxNum);

            return result;
        } catch (DataAccessException dae) {
            throw new DataAccessorException(
                    "DataAccessException is thrown while executing the '"
                            + sqlStmID + "'-query for parameter: "
                            + param.toString()+ "ExecuteSqlDAO"+
                    "READ_RECORD_ERROR,"+
                    "queryForList() limited. " + dae.getMessage(), dae);
        } catch (Exception e) {
            throw new DataAccessorException( "ExecuteSqlDAO"+
                    "READ_RECORD_ERROR,"+
                    "queryForList() limited. " + e.getMessage(), e);
        }
    }
    
    
    /**
     * 批量更新(自定义)
     */

    @SuppressWarnings("unchecked")
    public void updateBatch(final String sqlStmID, final List list,final int count)
            throws DataAccessorException {
        try {
            logger.info( this.getClass().getName()+ "in insert()");

            getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
                public Object doInSqlMapClient(SqlMapExecutor executor)
                        throws SQLException {
                    executor.startBatch();
                    int tmp = 0;
                    try {
                    for (int iter = 0, count = list.size(); iter < count; iter++) {
                        executor.update(sqlStmID, list.get(iter));
                        tmp++;
                        if(tmp == count){
                            executor.executeBatch();
                        tmp = 0;

                        }
                      }
                    }
                     catch (Exception e) {
                         //DevLog.debug("exception incoming!");
                      } finally {
                          executor.executeBatch();
                      }
                      return null;
                }
            });

        } catch (DataAccessException dae) {
            throw new DataAccessorException(
                    "DataAccessException is thrown while executing the '"
                            + sqlStmID + "'-insert for parameter: "
                            + ObjectInfo.toString(list)+ this.getClass()
                            .getName()+"INSERT_RECORD_ERROR,"+
                    "insert()" + dae.getMessage(), dae);
        } catch (Exception e) {
            throw new DataAccessorException( this.getClass().getName()+
                    "INSERT_RECORD_ERROR, insert()"
                            + e.getMessage(), e);
        }
    }
    
    
    
    
    /**
     * 批量新增(自定义)
     */

    @SuppressWarnings("unchecked")
    public void insertBatch(final String sqlStmID, final List list,final int count)
            throws DataAccessorException {
        try {
            logger.info( this.getClass().getName()+ "in insert()");


            getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
                public Object doInSqlMapClient(SqlMapExecutor executor)
                        throws SQLException {
                    executor.startBatch();
                    int tmp = 0;
                    try {
                    for (int iter = 0, count = list.size(); iter < count; iter++) {
                        executor.insert(sqlStmID, list.get(iter));
                        tmp++;
                        if(tmp == count){
                            executor.executeBatch();
                        tmp = 0;

                        }
                      }
                    }
                     catch (Exception e) {
                         //DevLog.debug("exception incoming!");
                      } finally {
                          executor.executeBatch();
                      }
                      return null;
                }
            });

        } catch (DataAccessException dae) {
            throw new DataAccessorException(
                    "DataAccessException is thrown while executing the '"
                            + sqlStmID + "'-insert for parameter: "
                            + ObjectInfo.toString(list)+ this.getClass()
                            .getName()+ "INSERT_RECORD_ERROR,"+
                    "insert()" + dae.getMessage(), dae);
        } catch (Exception e) {
            throw new DataAccessorException(this.getClass().getName()+
                    "INSERT_RECORD_ERROR, insert()"
                            + e.getMessage(), e);
        }
    }
    

    /*
     * 
     * 提交并终止事务
     */
    public void commitTransaction() throws DataAccessorException {
        try {
            logger.info( "ExecuteSqlDAO"+ "commitTransaction...");
            getSqlMapClientTemplate().getSqlMapClient().commitTransaction();
        } catch (DataAccessException dae) {
            throw new DataAccessorException(
                    "DataAccessException is thrown while commitTransaction "+
                    "ExecuteSqlDAO"+ "SYSTEM_ERROR,"+
                    "commitTransaction..." + dae.getMessage(), dae);
        } catch (Exception e) {
            throw new DataAccessorException("ExecuteSqlDAO"+
                    "SYSTEM_ERROR,commitTransaction..."
                            + e.getMessage(), e);
        }

    }

    /*
     * 
     * ROLLBACK并终止事务
     */
    public void endTransaction() throws DataAccessorException {
        try {
            logger.info( "ExecuteSqlDAO"+ "endTransaction...");
            getSqlMapClientTemplate().getSqlMapClient().endTransaction();
        } catch (DataAccessException dae) {
            throw new DataAccessorException(
                    "DataAccessException is thrown while endTransaction "+
                    "ExecuteSqlDAO"+"SYSTEM_ERROR,"+
                    "endTransaction..." + dae.getMessage(), dae);
        } catch (Exception e) {
            throw new DataAccessorException( "ExecuteSqlDAO"+
                    "SYSTEM_ERROR, endTransaction..."
                            + e.getMessage(), e);
        }

    }

    /*
     * 
     * 启动事务
     */
    public void startTransaction() throws DataAccessorException {
        try {
            logger.info( "ExecuteSqlDAO"+ "startTransaction...");
            getSqlMapClientTemplate().getSqlMapClient().startTransaction();
        } catch (DataAccessException dae) {
            throw new DataAccessorException(
                    "DataAccessException is thrown while startTransaction "+
                    "ExecuteSqlDAO"+ "SYSTEM_ERROR,"+
                    "startTransaction..." + dae.getMessage(), dae);
        } catch (Exception e) {
            throw new DataAccessorException( "ExecuteSqlDAO"+
                    "SYSTEM_ERROR, startTransaction..."
                            + e.getMessage(), e);
        }
    }

    /*
     * 获取数据库连接
     */
    public Connection getConnection() throws DataAccessorException {
        try {
            logger.info( "ExecuteSqlDAO"+ "getConnection()");
            Connection conn = getSqlMapClientTemplate().getDataSource()
                    .getConnection();
            conn.setAutoCommit(false);
            return conn;
        } catch (DataAccessException dae) {
            throw new DataAccessorException(
                    "DataAccessException is thrown while getConnection() "+
                    "ExecuteSqlDAO"+ "SYSTEM_ERROR,"+
                    "getConnection()" + dae.getMessage(), dae);
        } catch (Exception e) {
            throw new DataAccessorException("ExecuteSqlDAO"+
                    "SYSTEM_ERROR,getConnection()"
                            + e.getMessage(), e);
        }
    }

    public Connection connectionClose() throws DataAccessorException {
        try {
            logger.info( "ExecuteSqlDAO"+ "getConnection()");
            Connection conn = getSqlMapClientTemplate().getDataSource()
                    .getConnection();

            conn.close();
            return conn;
        } catch (DataAccessException dae) {
            throw new DataAccessorException(
                    "DataAccessException is thrown while getConnection() "+
                    "ExecuteSqlDAO"+ "SYSTEM_ERROR,"+
                    "getConnection()" + dae.getMessage(), dae);
        } catch (Exception e) {
            throw new DataAccessorException( "ExecuteSqlDAO"+
                    "SYSTEM_ERROR, getConnection()"
                            + e.getMessage(), e);
        }
    }

}
