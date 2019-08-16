package cn.kgc.service.impl;

import cn.kgc.dao.DealDao;
import cn.kgc.pojo.Deal;
import cn.kgc.service.DealService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service("dealService")
public class DealServiceImpl implements DealService {

    @Resource(name = "dealDao")
    private DealDao dealDao;
    @Override
    public List<Deal> findDealByAccountId(Integer accountId) {
        dealDao.deleteDeal();
        List<Deal> dealByAccountId = dealDao.findDealByAccountId(accountId);
        for (Deal deal : dealByAccountId) {
            String dealDate = deal.getDealDate();
            char[] chars = dealDate.toCharArray();
            StringBuffer stringBuffer=new StringBuffer();
            for (int i=0;i<chars.length;i++){
                if (i<chars.length-2){
                    stringBuffer.append(chars[i]);
                }
            }
            deal.setDealDate(stringBuffer.toString());
        }
        return  dealByAccountId;
    }

    @Override
    public int saveDeal(double dealIncome,int accountId) {
        Deal deal=new Deal();
        deal.setDealIncome(dealIncome);
        deal.setDealDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        deal.setAccountId(accountId);
        dealDao.deleteDeal();
        return dealDao.saveDeal(deal);
    }
}
