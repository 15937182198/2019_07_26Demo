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
        return dealDao.findDealByAccountId(accountId);
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
