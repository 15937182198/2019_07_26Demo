package cn.kgc.util;

import cn.kgc.dao.AccountDao;
import cn.kgc.pojo.Account;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 用于给用户随机找上级的工具类
 */
@Component("accountLeadUtil")
public class AccountLeadUtil {

    @Resource(name = "accountDao")
    private AccountDao accountDao;
    /**
     * 根据推荐人给被推荐人随机安排上级
     * @param accountId 推荐人id
     * @return 上级编号
     */
    public List<Integer> getAccountLead(Integer accountId){
        //根据用户编号查询用户
        Account accountByAccountId = accountDao.findAccountByAccountId(accountId);
        //因为用户的第一个直系下属的金字塔编号是该用户金字塔编号的2倍，所以该用户编号的2倍后的所有用户都在改用户的金字塔下
        int num=2;
        for (int i=accountByAccountId.getAccountJNumber()*2;;i=i*2){
            for (int j=0;j<num;j++){
                //根据该用户金字塔编号查询该用户
                Account accountByAccountJNumber = accountDao.findAccountByAccountJNumber(i+j);
                //如果该用户等于空，并且该用户的编号是双数，那么返回该用户的编号，如果不是则-1返回该用户的编号
                if (accountByAccountJNumber==null){
                    List<Integer> list=new ArrayList<Integer>();
                    list.add(i+j);
                    if ((i+j)%2==0){
                        list.add(accountDao.findAccountByAccountJNumber((i+j)/2).getAccountId());
                        return list;
                    }else {
                        list.add(accountDao.findAccountByAccountJNumber((i+j-1)/2).getAccountId());
                        return list;
                    }
                }
            }
            num=num*2;
        }
    }//end getAccountLead
}//end AccountLeadUtil
