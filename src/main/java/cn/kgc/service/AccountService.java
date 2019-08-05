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

}
