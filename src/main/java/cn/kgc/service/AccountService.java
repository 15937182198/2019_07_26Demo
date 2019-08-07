package cn.kgc.service;

import cn.kgc.pojo.Account;
import cn.kgc.pojo.PageInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.xml.crypto.Data;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public interface AccountService extends UserDetailsService {

    /**
     * 根据用户上级编号查询下级
     * @param accountLead 需要查询的上级编号
     * @return 当前上级的直系下级
     */
    List<Account> findAccountByAccountLead(Integer accountLead);

    /**
     * 保存账户的方法
     * @param referrer 推荐人id
     * @return 是否保存成功
     */
    boolean saveAccount(String accountName,String accountPassword, Integer referrer);

    /**
     * 根据账户名查询该用户
     * @param accountName 需要查询的账户名
     * @return 该账户名对应的账户
     */
    Account findAccountByName(String accountName);

    /**
     * 保存管理员账号的方法
     * @param account 需要保存的管理员账户
     * @return 是否保存成功
     */
    boolean saveAccount(Account account);

    /**
     * 查询所有管理员
     * @return 所有管理员账号
     */
    List<Account> findAdmin();

    /**
     * 查询所有用户
     * @return 所有用户
     */
    List<Account> findAccount();

    /**
     * 根据时间查询注册用户
     * @param date 查询时间
     * @return 查询到的用户总数
     */
    List<Account> findAccountByDate(Date date);

    /**
     * 根据账户id查询推荐人数
     * @param accountId 查询的账户id
     * @return 该账户id推荐的人数
     */
    List<Account> findAccountByReferrer(Integer accountId);

    /**
     * 分页助手
     * @param page 当前页码
     * @param pageSize 页面容量
     * @return pageinfo对象
     */
    public PageInfo findPage(int page, int pageSize);

    /**
     * 根据账户id查询账户
     * @param accountId 需要查询的账户id
     * @return 该账户id对应的账户
     */
    Account findAccountById(Integer accountId);
}
