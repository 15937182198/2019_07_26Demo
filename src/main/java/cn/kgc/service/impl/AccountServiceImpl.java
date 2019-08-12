package cn.kgc.service.impl;

import cn.kgc.dao.AccountDao;
import cn.kgc.dao.JurDao;
import cn.kgc.pojo.Account;
import cn.kgc.pojo.Jurisdiction;
import cn.kgc.pojo.NewAccount;
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
import java.text.SimpleDateFormat;
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
    public boolean saveAccount(String accountName,String accountPassword, Integer referrer,String userName,String userPhone,String site) {
        Account account=new Account();
        //初次设置密码
        account.setAccountPassword(accountPassword);
        //设置账户名
        account.setAccountName(accountName);
        //设置权限
        account.setJur(3);
        //设置冻结积分
        account.setFreezeMoney((double) 1000);
        //设置密码
        account.setAccountPassword(passwordEncoder.encode(account.getAccountPassword()));
        //设置用户姓名
        account.setUserName(userName);
        //设置用户手机号
        account.setUserPhone(userPhone);
        //设置用户收货地址
        account.setSite(site);
        //后台给账户设定创建时间
        account.setAccountCreateDate(new SimpleDateFormat("yyy-MM-dd").format(new Date()));
        //给用户设定推荐人
        account.setReferrer(referrer);
        //给用户设定金字塔坐标
        List<Integer> list = accountLeadUtil.getAccountLead(referrer);
        account.setAccountJNumber(list.get(0));
        //给用户设定上级
        account.setAccountLead(list.get(1));
        //保存账户
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
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        account.setAccountCreateDate(simpleDateFormat.format(new Date()));
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
    public List<Account> findAccountByDate(String date) {
        return accountDao.findAccountByDate(date);
    }

    @Override
    public List<Account> findAccountByReferrer(Integer accountId) {
        return accountDao.findAccountByReferrer(accountId);
    }

    /**
     * 用户分页
     * @param page 当前页码
     * @param pageSize 页面容量
     * @return
     */
    @Override
    public PageInfo findPage(int page, int pageSize) {
        int number=accountDao.findAccount().size();
        PageHelper.startPage(page,pageSize);
        List<Account> list=accountDao.findAccount();
        PageInfo pageInfo = new PageInfo();
        if (number%pageSize!=0){
            pageInfo.setPages(number/pageSize+1);
        }else {
            pageInfo.setPages(number/pageSize);
        }
        List<NewAccount> newList=new ArrayList<NewAccount>();
        for (Account account : list) {
            NewAccount newAccount=new NewAccount();
            newAccount.setAccountId(account.getAccountId());
            newAccount.setAccountName(account.getAccountName());
            newAccount.setAccountCreateDate(account.getAccountCreateDate());
            newAccount.setReferrer(accountDao.findAccountById(account.getReferrer()).getAccountName());
            newAccount.setAccountMoney(account.getAccountMoney());
            newList.add(newAccount);
        }

        pageInfo.setAccountNum(number);
        pageInfo.setPageSize(pageSize);
        pageInfo.setPageNum(page);
        pageInfo.setList(newList);
        return pageInfo;
    }

    /**
     * 店铺分页
     * @param page 当前页码
     * @param pageSize 页面容量
     * @return
     */
    @Override
    public PageInfo shopFindPage(int page, int pageSize) {
        int number=accountDao.findAccountShop().size();
        PageHelper.startPage(page,pageSize);
        List<Account> list=accountDao.findAccountShop();
        PageInfo pageInfo = new PageInfo();
        if (number%pageSize!=0){
            pageInfo.setPages(number/pageSize+1);
        }else {
            pageInfo.setPages(number/pageSize);
        }
        List<NewAccount> newList=new ArrayList<NewAccount>();
        for (Account account : list) {
            NewAccount newAccount=new NewAccount();
            newAccount.setAccountId(account.getAccountId());
            newAccount.setAccountName(account.getAccountName());
            newAccount.setAccountCreateDate(account.getAccountCreateDate());
            newAccount.setReferrer(accountDao.findAccountById(account.getReferrer()).getAccountName());
            newAccount.setAccountMoney(account.getAccountMoney());
            newList.add(newAccount);
        }

        pageInfo.setAccountNum(number);
        pageInfo.setPageSize(pageSize);
        pageInfo.setPageNum(page);
        pageInfo.setList(newList);
        return pageInfo;
    }

    /**
     * 管理员分页
     * @param page 当前页码
     * @param pageSize 页面容量
     * @return
     */
    @Override
    public PageInfo adminFindPage(int page, int pageSize) {
        int number=accountDao.findAdmin().size();
        PageHelper.startPage(page,pageSize);
        List<Account> list=accountDao.findAdmin();
        PageInfo pageInfo = new PageInfo();
        if (number%pageSize!=0){
            pageInfo.setPages(number/pageSize+1);
        }else {
            pageInfo.setPages(number/pageSize);
        }
        pageInfo.setAccountNum(number);
        pageInfo.setPageSize(pageSize);
        pageInfo.setPageNum(page);
        pageInfo.setList(list);
        return pageInfo;
    }

    @Override
    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    @Override
    public boolean updateAccountPassword(Account account) {
        account.setAccountPassword(passwordEncoder.encode(account.getAccountPassword()));
        int i=accountDao.updateAccountPassword(account);
        if (i!=0){
            return true;
        }
        return false;
    }

    /**
     * 修改可用积分
     * @param account 需要修改的用户
     * @return
     */
    @Override
    public boolean updateAccountMoney(Account account) {
        int i=accountDao.updateUsableMoney(account);
        if (i!=0){
            return true;
        }
        return false;
    }

    /**
     * 保存店铺的方法
     * @param accountName 用户名
     * @param accountPassword 密码
     * @param referrer 推荐人
     * @return 保存成功返回true。失败返回false
     */
    @Override
    public boolean saveShop(String accountName, String accountPassword, Integer referrer,String userName,String userPhone,String site) {
        Account account=new Account();
        //设置用户名
        account.setAccountName(accountName);
        //设置用户密码
        account.setAccountPassword(passwordEncoder.encode(accountPassword));
        //设置用户权限
        account.setJur(4);
        //设置冻结积分
        account.setFreezeMoney(10000d);
        //设置用户姓名
        account.setUserName(userName);
        //设置用户手机号
        account.setUserPhone(userPhone);
        //设置用户收货地址
        account.setSite(site);
        //设置推荐人
        account.setReferrer(referrer);
        //给用户设定金字塔坐标
        List<Integer> list = accountLeadUtil.getAccountLead(referrer);
        account.setAccountJNumber(list.get(0));
        //设置创建时间
        account.setAccountCreateDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        //给用户设定上级
        account.setAccountLead(list.get(1));
        //保存账户
        Integer integer = accountDao.saveAccount(account);
        if (integer>0){
            return true;
        }
        return false;
    }

    /**
     * 查询所有店铺
     * @return 店铺集合
     */
    @Override
    public List<Account> findShop() {
        return accountDao.findAccountShop();
    }

    /**
     * 查询当日注册的所有店铺
     * @param format 注册时间
     * @return 店铺集合
     */
    @Override
    public List<Account> findShopByDate(String format) {
        return accountDao.findAccountShopByDate(format);
    }

    /**
     * 查询当前用户下级
     * @param accountId 需要查询的用户id
     * @return 直属的两个下级
     */
    public List<Account> findSubordinate(Integer accountId){
        //根据当前id查询该用户
        Account accountById = accountDao.findAccountByAccountJNumber(accountId);
        //根据用户金字塔编号查询该用户所有下属
        Account accountByAccountJNumber = accountDao.findAccountByAccountJNumber(accountById.getAccountJNumber()*2);
        Account accountByAccountJNumber1 = accountDao.findAccountByAccountJNumber(accountById.getAccountJNumber()*2+1);
        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(accountByAccountJNumber);
        accounts.add(accountByAccountJNumber1);
        return accounts;
    }

    @Override
    public boolean transfer(Integer accountId, double accountMoney, String accountName) {
        Account accountById = accountDao.findAccountById(accountId);
        accountById.setUsableMoney(accountById.getUsableMoney()-accountMoney);
        Account accountByName = accountDao.findAccountByName(accountName);
        accountByName.setUsableMoney(accountByName.getUsableMoney()+accountMoney);
        accountDao.updateAccountMoney(accountById);
        accountDao.updateAccountMoney(accountByName);
        return true;
    }
}
