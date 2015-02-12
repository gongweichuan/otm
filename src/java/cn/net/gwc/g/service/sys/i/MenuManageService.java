/**
 * 
 */
package cn.net.gwc.g.service.sys.i;

/**
 * <p>文件名称：MenuManageService.java</p>
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

import java.util.List;
import cn.net.gwc.g.dto.sys.MenuDTO;
import cn.net.gwc.g.etc.BusinessServiceException;

public interface MenuManageService
{
    /**
     * 根据角色列表获取菜单树
     * 
     * @param roleNameList 角色列表
     * 
     * @return 菜单树
     * @throws BusinessServiceException TODO
     */
    public MenuDTO queryMenu(List<String> roleNameList) throws BusinessServiceException ;
    /**
     * 根据角色查询菜单
     * @param roleNameList
     * @return
     * @throws BusinessServiceException TODO
     */
    public List<MenuDTO> queryAllMenuByRole(List<String> roleNameList) throws BusinessServiceException;
    /**
     * 遍历菜单树
     * @param root
     * @param context
     * @throws BusinessServiceException TODO
     */
    public void exploreMenu(MenuDTO root,StringBuffer context) throws BusinessServiceException;
    
    
    /**
     * 根据角色查询菜单字符串
     * @param root
     * @param context
     * @throws BusinessServiceException TODO
     */
    public String getMenuString(List<String> roleNameList) throws BusinessServiceException;
}
