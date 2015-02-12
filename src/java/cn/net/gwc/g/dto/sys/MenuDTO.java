package cn.net.gwc.g.dto.sys;

import cn.net.gwc.g.dto.impl.BaseDTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MenuDTO extends BaseDTO
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Integer menuId;

    private String menuText;

    private String menuPath;

    private Integer menuSortValue;

    private Integer menuParentId;

    private Date menuCreateTime;

    private Date menuUpdateTime;

    private String menuCreator;

    private String menuUpdator;

    private MenuDTO parentMenuDTO;

    private List<MenuDTO> childNodes = new ArrayList<MenuDTO>();

    private String attr1;

    private String attr2;

    private String attr3;

    public Integer getMenuId()
    {
        return menuId;
    }

    public void setMenuId(Integer menuId)
    {
        this.menuId = menuId;
    }

    public String getMenuText()
    {
        return menuText;
    }

    public void setMenuText(String menuText)
    {
        this.menuText = menuText;
    }

    public String getMenuPath()
    {
        return menuPath;
    }

    public void setMenuPath(String menuPath)
    {
        this.menuPath = menuPath;
    }

    public Integer getMenuSortValue()
    {
        return menuSortValue;
    }

    public void setMenuSortValue(Integer menuSortValue)
    {
        this.menuSortValue = menuSortValue;
    }

    public Integer getMenuParentId()
    {
        return menuParentId;
    }

    public void setMenuParentId(Integer menuParentId)
    {
        this.menuParentId = menuParentId;
    }

    public Date getMenuCreateTime()
    {
        return menuCreateTime;
    }

    public void setMenuCreateTime(Date menuCreateTime)
    {
        this.menuCreateTime = menuCreateTime;
    }

    public Date getMenuUpdateTime()
    {
        return menuUpdateTime;
    }

    public void setMenuUpdateTime(Date menuUpdateTime)
    {
        this.menuUpdateTime = menuUpdateTime;
    }

    public String getMenuCreator()
    {
        return menuCreator;
    }

    public void setMenuCreator(String menuCreator)
    {
        this.menuCreator = menuCreator;
    }

    public String getMenuUpdator()
    {
        return menuUpdator;
    }

    public void setMenuUpdator(String menuUpdator)
    {
        this.menuUpdator = menuUpdator;
    }

    public List<MenuDTO> getChildNodes()
    {
        return childNodes;
    }

    public void setChildNodes(List<MenuDTO> chileNodes)
    {
        this.childNodes = chileNodes;
    }

    public MenuDTO getParentMenuDTO()
    {
        return parentMenuDTO;
    }

    public void setParentMenuDTO(MenuDTO parentMenuDTO)
    {
        this.parentMenuDTO = parentMenuDTO;
    }

    public String getAttr1()
    {
        return attr1;
    }

    public void setAttr1(String attr1)
    {
        this.attr1 = attr1;
    }

    public String getAttr2()
    {
        return attr2;
    }

    public void setAttr2(String attr2)
    {
        this.attr2 = attr2;
    }

    public String getAttr3()
    {
        return attr3;
    }

    public void setAttr3(String attr3)
    {
        this.attr3 = attr3;
    }
}
