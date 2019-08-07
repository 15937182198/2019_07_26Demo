package cn.kgc.service.impl;

import cn.kgc.dao.AccountDao;
import cn.kgc.dao.JurDao;
import cn.kgc.pojo.Account;
import cn.kgc.pojo.Jurisdiction;
import cn.kgc.pojo.PageInfo;
import cn.kgc.service.AccountService;
import cn.kgc.util.AccountLeadUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Resource(name = "accountDao")
    private AccountDao accountDao;

    @Resource(name = "jurDao")
    private JurDao jurDao;

    @Resource(name = "accountLeadUtil")
    private AccountLeadUtil accountLeadUtil;

    @Resource(name = "passwordEncoder")
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountDao.findAccountByName(username);
        //判断是否为空
        if (account!=null){
            //创建角色集合
            Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            List<Jurisdiction> all = jurDao.findAll();
            for (Jurisdiction jurisdiction : all) {
                SimpleGrantedAuthority role_user = new SimpleGrantedAuthority(jurisdiction.getJurName());
                authorities.add(role_user);
            }
            //创建临时角色
            return new User(account.getAccountName(),account.getAccountPassword(),authorities);
        }
        return null;
    }

    /**
     * 根据上级编号查询下级
     * @param accountLead 需要查询的上级编号
     * @return 查询到的下级集合
     */
    @Override
    public List<Account> findAccountByAccountLead(Integer accountLead) {
        return accountDao.findAccountByAccountLead(accountLead);
    }


    /**
     * 根据账户名查询账户
     * @param accountName 需要查询的账户名
     * @return 该账户名所对应的账户名
     */
    @Override
    public Account findAccountByName(String accountName) {
        return accountDao.findAccountByName(accountName);
    }

    /**
     * 保存账户需要的方法
     * @param referrer 推荐人id
     * @return 是否保存成功
     */
    @Override
    public boolean saveAccount(String accountName,String accountPassword, Integer referrer) {
        Account account=new Account();
        //初次设置密码
        account.setAccountPassword(accountPassword);
        //设置账户名
        account.setAccountName(accountName);
        //设置密码
        account.setJur(3);
        //设置基本积分
        account.setAccountMoney((double) 1000);
        //设置密码
        account.setAccountPassword(passwordEncoder.encode(account.getAccountPassword()));
        //后台给账户设定创建时间
        account.setAccountCreateDate(new Date());
        //给用户设定推荐人
        account.setReferrer(referrer);
        //给用户设定金字塔坐标
        account.setAccountLead(accountLeadUtil.getAccountLead(referrer));
        //保存账户
        System.out.println("开始保存");
        Integer integer = accountDao.saveAccount(account);
        if (integer!=0){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 保存管理员账户需要的方法
     * @param account 需要保存的账户
     * @return 是否保存成功
     */
    @Override
    public boolean saveAccount(Account account) {
        //设置权限
        account.setJur(2);
        //设置密码
        account.setAccountPassword(passwordEncoder.encode(account.getAccountPassword()));
        //后台给账户设定创建时间
        account.setAccountCreateDate(new Date());
        //保存账户
        Integer integer = accountDao.saveAccount(account);
        if (integer!=0){
            return true;
        }else {
            return false;
        }
    }


    @Override
    public List<Account> findAdmin() {
        return accountDao.findAdmin();
    }

    @Override
    public List<Account> findAccount() {
        return accountDao.findAccount();
    }

    /**
     * 根据时间查询注册用户
     * @param date 查询时间
     * @return 查询到的用户
     */
    @Override
    public List<Account> findAccountByDate(Date date) {
        return accountDao.findAccountByDate(date);
    }

    @Override
    public List<Account> findAccountByReferrer(Integer accountId) {
        return accountDao.findAccountByReferrer(accountId);
    }

    @Override
    public PageInfo findPage(int page, int pageSize) {
        PageHelper.startPage(page,pageSize);
        List<Account> list=accountDao.findAccount();
        PageInfo pageInfo = new PageInfo();
        pageInfo.setList(list);
        return pageInfo;
    }

    @Override
    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }
}
