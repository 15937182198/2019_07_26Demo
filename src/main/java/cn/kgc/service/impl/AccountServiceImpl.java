package cn.kgc.service.impl;

import cn.kgc.dao.AccountDao;
import cn.kgc.dao.JurDao;
import cn.kgc.pojo.Account;
import cn.kgc.pojo.Deal;
import cn.kgc.pojo.Jurisdiction;
import cn.kgc.service.AccountService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Resource(name = "accountDao")
    private AccountDao accountDao;

    @Resource(name = "jurDao")
    private JurDao jurDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Account account = accountDao.findAccountByName(username);
        System.out.println(account);
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
}
