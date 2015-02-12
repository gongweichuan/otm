package cn.net.gwc.g.service.otm.impl;

import java.util.List;
import java.util.Random;

import cn.net.gwc.g.dao.otm.i.IOtmDAO;
import cn.net.gwc.g.dto.otm.OtmMessagesInDTO;
import cn.net.gwc.g.dto.otm.OtmVisitsInfoInDTO;
import cn.net.gwc.g.service.otm.i.IOtmService;

/**
 * <p>文件名称：OtmServiceImpl.java</p>
 * <p>文件描述：</p>
 * <p>版权所有： 版权所有(C)2007-2017</p>
 * <p>公    司： 与龙共舞独立工作室</p>
 * <p>内容摘要： </p>
 * <p>其他说明： </p>
 * <p>完成日期：2014-2-10</p>
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
public class OtmServiceImpl implements IOtmService
{
    private IOtmDAO dao;

    /**
     * 
     * 功能描述：生成一个随机的4到8位的数字密码
     * @see com.cvo.erp.pfl.gwc.net.cn.g.service.otm.i.IOtmService#generatePassword(int)
     */
    public String generatePassword(int length)
    {
        //long mTime=System.currentTimeMillis();
        //Random rand=new Random(mTime);
        Random rand=new Random();
        int rInt=rand.nextInt(length);

        return Integer.toString(Math.abs(rInt));    
    }

    public String createMessages(OtmMessagesInDTO inDTO)
    {
        
        return dao.createMessages(inDTO);
    }

    public void updateMessages(OtmMessagesInDTO inDTO)
    {
        dao.updateMessages(inDTO);
        
    }

    public List selectMessages(OtmMessagesInDTO inDTO)
    {
       
        return dao.selectMessages(inDTO);
    }

    public String createVisits(OtmVisitsInfoInDTO inDTO)
    {

        return dao.createVisits(inDTO);
    }

    public void updateVisits(OtmVisitsInfoInDTO inDTO)
    {
        dao.updateVisits(inDTO);
        
    }

    public List selectVisits(OtmVisitsInfoInDTO inDTO)
    {
       
        return dao.selectVisits(inDTO);
    }

    public IOtmDAO getDao()
    {
        return dao;
    }

    public void setDao(IOtmDAO dao)
    {
        this.dao = dao;
    }

}
