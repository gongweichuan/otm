/**
 * 
 */
package cn.net.gwc.g.service.sys.impl;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import cn.net.gwc.g.dao.i.ICoreDAO;
import cn.net.gwc.g.dto.sys.MenuDTO;
import cn.net.gwc.g.etc.BusinessServiceException;
import cn.net.gwc.g.etc.DataAccessorException;
import cn.net.gwc.g.etc.ServiceException;
import cn.net.gwc.g.service.impl.BaseService;
import cn.net.gwc.g.service.sys.i.MenuManageService;

/**
 * <p>文件名称：MenuManageServiceImpl.java</p>
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
public class MenuManageServiceImpl extends BaseService implements MenuManageService
{


    @Override
    public MenuDTO queryMenu(List<String> roleNameList) throws BusinessServiceException {
        List<MenuDTO> dbMenuSourceList=queryAllMenuByRole(roleNameList);
    
        MenuDTO root=buildMenuTree(dbMenuSourceList);
        
        return root;
    }
    
    /**
     * 构建菜单树
     * @param dbMenuSourceList
     * @return
     */
    private MenuDTO buildMenuTree(List<MenuDTO> menuSourceList)throws BusinessServiceException {
        for(MenuDTO menu1:menuSourceList){
            for(MenuDTO menu2:menuSourceList){
                addRelation(menu1, menu2);
            }
        }
        return getRoot(menuSourceList);
    }
    /**
     * 建立级联关系
     * @param menu1 菜单1
     * @param menu2 菜单2
     */
    private void addRelation(MenuDTO menu1, MenuDTO menu2) {
        if(menu2.getMenuParentId()==null)return;
        if(menu2.getMenuParentId().equals(menu1.getMenuId())){
            if(!menu1.getChildNodes().contains(menu2)){
                menu1.getChildNodes().add(menu2);
                menu2.setParentMenuDTO(menu1);
            }
        }
    }
    /**
     * 获取菜单根节点
     * @param dbMenuSourceList
     * @return
     */
    private MenuDTO getRoot(List<MenuDTO> menuSourceList) throws BusinessServiceException{
        for(MenuDTO menu:menuSourceList){
            if(menu.getMenuParentId()==null
               ||menu.getMenuParentId()==-1
               ){
                return menu;
            }
        }
        throw new BusinessServiceException("无菜单权限!");
    }

    
    
    
    public void exploreMenu(MenuDTO root,StringBuffer context) throws BusinessServiceException{
        
        MenuDTO temp=root.getParentMenuDTO();
        do{
         if(temp!=null){
             context.append("--");
             temp=temp.getParentMenuDTO();
         }
        
        }while(temp!=null);
    
        context.append(root.getMenuId()+"("+root.getMenuText()+")\n");
        
        for(MenuDTO men:root.getChildNodes()){
            exploreMenu(men, context);
        }
    }
    
    
    @SuppressWarnings("unchecked")
    public List<MenuDTO> queryAllMenuByRole(List<String> roleNameList) throws BusinessServiceException {
        ICoreDAO coreDAO =null;
        List<MenuDTO> menuList=null;
        if(roleNameList==null||roleNameList.size()==0)throw new BusinessServiceException("当前登录账号无本系统使用权限。");
        try {
            coreDAO = (ICoreDAO) context.getBean("coreDAO");
            Map condition = new HashMap();
            condition.put("roleNameList", roleNameList);
            menuList=coreDAO.queryForList("select_menu_by_role", condition);
            
        } catch (DataAccessorException e) {
            throw new BusinessServiceException(e.getMessage());
        }
        return menuList;
    }
    
    
    @Override
    public String getMenuString(List<String> roleNameList) throws BusinessServiceException {
        StringBuffer context=new StringBuffer();
        MenuDTO mdto=queryMenu(roleNameList);
        exploreMenu(mdto, context);
        return context.toString();
    }
    

}
