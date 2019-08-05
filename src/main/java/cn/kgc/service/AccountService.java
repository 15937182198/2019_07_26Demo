package cn.kgc.service;

import cn.kgc.pojo.Account;
import org.springframework.security.core.userdetails.UserDetailsService;

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
     * @param account 需要保存的账户
     * @param referrer 推荐人id
     * @param jur 权限编号
     * @return 是否保存成功
     */
    boolean saveAccount(Account account,Integer referrer,Integer jur);

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

}
