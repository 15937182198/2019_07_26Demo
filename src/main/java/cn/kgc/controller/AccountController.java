package cn.kgc.controller;

import cn.kgc.pojo.Account;
import cn.kgc.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 账户相关的controller
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Resource(name = "accountService")
    private AccountService accountService;

    /**
     * 根据用户名查询是否有该用户
     * @param accountName 需要查询的用户名
     * @return 如果没有改用户返回true，有返回false
     */
    @RequestMapping("/findAccountByName")
    public @ResponseBody Boolean findAccountByName(String accountName){
        Account accountByName = accountService.findAccountByName(accountName);
        if (accountByName!=null){
            return false;
        }
        return true;
    }

    /**
     * 保存普通账户的方法
     * @param account 需要保存的账户
     * @param referrer 推荐人id
     * @return 是否保存成功
     */
    @RequestMapping("/saveAccount")
    public @ResponseBody Boolean saveAccount(Account account,Integer referrer){
        return accountService.saveAccount(account,referrer,3);
    }

    /**
     * 保存管理员账户的方法
     * @param account 需要保存的管理员账户
     * @return 是否保存成功
     */
    @RequestMapping("/saveAdmin")
    public @ResponseBody Boolean saveAccount(Account account){
        return accountService.saveAccount(account);
    }

}
