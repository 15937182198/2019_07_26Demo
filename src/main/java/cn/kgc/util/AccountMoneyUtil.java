package cn.kgc.util;

import cn.kgc.dao.AccountDao;
import cn.kgc.pojo.Account;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 账户积分的工具类
 */
@Component("accountMoneyUtil")
public class AccountMoneyUtil {

    @Resource(name = "accountDao")
    private AccountDao accountDao;
    /**
     * 判断账户冻结积分是否解冻的方法
     */
    public boolean WhetherToThaw(HttpServletRequest request){
        //拿到session作用域中的值
        Account account = (Account) request.getSession().getAttribute("account");
        //根据session中的account对象的id查询该account对象，防止有数据错误
        account = accountDao.findAccountById(account.getAccountId());
        //根据金字塔接口该用户的坐标及规律判断该用户下是否有10层用户
        //第1层
        int accountJNumber1=account.getAccountJNumber()*2;
        for (int i=0;i<2;i++){
            if (accountDao.findAccountByAccountJNumber(accountJNumber1+i)==null){
                return false;
            }
        }
        //第2层
        int accountJNumber2=accountJNumber1*2;
        for (int i=0;i<4;i++){
            if (accountDao.findAccountByAccountJNumber(accountJNumber1+i)==null){
                return false;
            }
        }
        //第3层
        int accountJNumber3=accountJNumber2*2;
        for (int i=0;i<8;i++){
            if (accountDao.findAccountByAccountJNumber(accountJNumber1+i)==null){
                return false;
            }
        }
        //第4层
        int accountJNumber4=accountJNumber3*2;
        for (int i=0;i<16;i++){
            if (accountDao.findAccountByAccountJNumber(accountJNumber1+i)==null){
                return false;
            }
        }
        //第5层
        int accountJNumber5=accountJNumber4*2;
        for (int i=0;i<32;i++){
            if (accountDao.findAccountByAccountJNumber(accountJNumber1+i)==null){
                return false;
            }
        }
        //第6层
        int accountJNumber6=accountJNumber5*2;
        for (int i=0;i<64;i++){
            if (accountDao.findAccountByAccountJNumber(accountJNumber1+i)==null){
                return false;
            }
        }
        //第7层
        int accountJNumber7=accountJNumber6*2;
        for (int i=0;i<128;i++){
            if (accountDao.findAccountByAccountJNumber(accountJNumber1+i)==null){
                return false;
            }
        }
        //第8层
        int accountJNumber8=accountJNumber7*2;
        for (int i=0;i<256;i++){
            if (accountDao.findAccountByAccountJNumber(accountJNumber1+i)==null){
                return false;
            }
        }
        //第9层
        int accountJNumber9=accountJNumber8*2;
        for (int i=0;i<512;i++){
            if (accountDao.findAccountByAccountJNumber(accountJNumber1+i)==null){
                return false;
            }
        }
        //第10层
        int accountJNumber10=accountJNumber9*2;
        for (int i=0;i<1024;i++){
            if (accountDao.findAccountByAccountJNumber(accountJNumber1+i)==null){
                return false;
            }
        }
        return true;
    }


    /**
     * 用户注册时用来计算他30层上的上级积分情况
     * @param accountLead 注册用户的上级
     * @return 修改后的用户集合
     */
    public List<Account> updateAccountLeadMoney(Integer accountLead, Integer accountMoney){
        List<Account> list=new ArrayList<Account>();
        for (int i=0;i<29;i++){
            Account accountById = accountDao.findAccountById(accountLead);
            if (accountById==null){
                return list;
            }
            double pow = Math.pow(0.8,i);
            accountById.setAccountMoney(accountById.getAccountMoney()+accountMoney*pow);

            list.add(accountById);
            accountLead=accountById.getAccountLead();
        }

        return list;
    }

    /**
     * 根据用户id判断该用户可以体现多少积分每日
     * @param accountId 需要查询的用户id
     * @return 每日体现金额
     */
    public Integer oneDayDeal(Integer accountId){
        List<Account> list = accountDao.findAccountByReferrer(accountId);
        if (list==null||list.size()==0){
            return 0;
        }else if (list.size()==1){
            return 200;
        }else if (list.size()==2){
            return 200;
        }else if (list.size()==3){
            return 200;
        }else if (list.size()==4){
            return 200;
        }else if (list.size()==5){
            return 200;
        }else if (list.size()==6){
            return 200;
        }else if (list.size()==7){
            return 200;
        }else if (list.size()==8){
            return 200;
        }else if (list.size()==9){
            return 200;
        }else if (list.size()==10){
            return 200;
        }else if (list.size()>10){
            return 100000000;
        }
        return 0;
    }

}
