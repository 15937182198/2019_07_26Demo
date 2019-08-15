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
import org.springframework.security.core.authority.AuthorityUtils;
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
            String jurName = jurDao.findJurByJurId(account.getJur()).getJurName();
            if (jurName.equals("ROLE_USER")){
                jurName+=",ROLE_SSR,ROLE_SSO";
            }
            if (jurName.equals("ROLE_ADMIN")){
                jurName+=",ROLE_SSR,ROLE_SSO,ROLE_USER";
            }
            if(jurName.equals("ROLE_ROOT")){
                jurName+=",ROLE_SSR,ROLE_SSO,ROLE_USER,ROLE_ADMIN";
            }

            //创建临时角色
            return new User(account.getAccountName(),account.getAccountPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList(jurName));
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
            //设置用户姓名
            newAccount.setUserName(account.getUserName());
            //设置用户手机号
            newAccount.setUserPhone(account.getUserPhone());
            //设置用户收货地址
            newAccount.setSite(account.getSite());
            //设置用户id
            newAccount.setAccountId(account.getAccountId());
            //这只用户账号
            newAccount.setAccountName(account.getAccountName());
            //设置用户创建时间
            newAccount.setAccountCreateDate(account.getAccountCreateDate());
            //设置用户推荐人
            newAccount.setReferrer(accountDao.findAccountById(account.getReferrer()).getAccountName());
            //设置节点积分
            newAccount.setAccountMoney(account.getAccountMoney());
            //设置用户冻结积分
            newAccount.setFreezeMoney(account.getFreezeMoney());
            //设置用户可用积分
            newAccount.setUsableMoney(account.getUsableMoney());
            //设置用户上级
            newAccount.setAccountLead(accountDao.findAccountById(account.getAccountLead()).getAccountName());
            //设置用户下级
            List<Account> subordinate = findSubordinate(account.getAccountJNumber());
            if (subordinate.get(0)!=null){
                newAccount.setJunior1(subordinate.get(0).getAccountName());
            }
            if (subordinate.get(1)!=null){
                newAccount.setJunior2(subordinate.get(1).getAccountName());
            }
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
            //设置用户姓名
            newAccount.setUserName(account.getUserName());
            //设置用户手机号
            newAccount.setUserPhone(account.getUserPhone());
            //设置用户收货地址
            newAccount.setSite(account.getSite());
            //设置用户id
            newAccount.setAccountId(account.getAccountId());
            //这只用户账号
            newAccount.setAccountName(account.getAccountName());
            //设置用户创建时间
            newAccount.setAccountCreateDate(account.getAccountCreateDate());
            //设置用户推荐人
            newAccount.setReferrer(accountDao.findAccountById(account.getReferrer()).getAccountName());
            //设置节点积分
            newAccount.setAccountMoney(account.getAccountMoney());
            //设置用户冻结积分
            newAccount.setFreezeMoney(account.getFreezeMoney());
            //设置用户可用积分
            newAccount.setUsableMoney(account.getUsableMoney());
            //设置用户上级
            newAccount.setAccountLead(accountDao.findAccountById(account.getAccountLead()).getAccountName());
            //设置用户下级
            List<Account> subordinate = findSubordinate(account.getAccountJNumber());
            if (subordinate.get(0)!=null){
                newAccount.setJunior1(subordinate.get(0).getAccountName());
            }
            if (subordinate.get(1)!=null){
                newAccount.setJunior2(subordinate.get(1).getAccountName());
            }
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
     * 修改节点积分
     * @param account 需要修改的用户
     * @return
     */
    @Override
    public boolean updateAccountMoney(Account account) {
        int i=accountDao.updateAccountMoney(account);
        if (i!=0){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateUsableMoney(Account account) {
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
        //根据当金字塔编号查询该用户
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

    @Override
    public boolean updateAccount(Integer accountId, String accountName, String userName, String site, String userPhone, double accountMoney, double usableMoney, double freezeMoney) {
        Account account=new Account();
        account.setAccountName(accountName);
        account.setAccountId(accountId);
        account.setUserName(userName);
        account.setSite(site);
        account.setUserPhone(userPhone);
        account.setAccountMoney(accountMoney);
        account.setUsableMoney(usableMoney);
        account.setFreezeMoney(freezeMoney);
        accountDao.updateAccount(account);
        return false;
    }
}
