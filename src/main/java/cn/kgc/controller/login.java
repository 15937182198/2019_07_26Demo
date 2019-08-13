package cn.kgc.controller;

import cn.kgc.pojo.Account;
import cn.kgc.pojo.NewAccount;
import cn.kgc.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author LZY
 * @date 2019/8/13 19:02
 * 登录页面转发
 */
@Controller
@RequestMapping("/login")
public class login {
    @Resource(name = "accountService")
    private AccountService accountService;
    /**
     * 登录页面转发
     */
    @RequestMapping("/login")
    public String login(HttpServletRequest request){
        //获得在session中的用户名
        String accountName= (String) request.getSession().getAttribute("username");
        //根据用户名查找该用户信息
        Account account = accountService.findAccountByName(accountName);
        //将查询到的对象放入包装类中
        NewAccount newAccount=new NewAccount();
        newAccount.setAccountId(account.getAccountId());
        newAccount.setAccountMoney(account.getAccountMoney());
        if (accountService.findAccountById(account.getReferrer())!=null){
            newAccount.setReferrer(accountService.findAccountById(account.getReferrer()).getAccountName());
        }
        newAccount.setAccountCreateDate(account.getAccountCreateDate());
        newAccount.setAccountName(account.getAccountName());
        if (accountService.findAccountById(account.getAccountLead())!=null){
            newAccount.setAccountLead(accountService.findAccountById(account.getAccountLead()).getAccountName());

        }
        List<Account> subordinate=null;
        if (account.getAccountJNumber()!=null){
            subordinate = accountService.findSubordinate(account.getAccountJNumber());
            if (subordinate.get(0)!=null){
                newAccount.setJunior1(subordinate.get(0).getAccountName());
            }
            if (subordinate.get(1)!=null){
                newAccount.setJunior2(subordinate.get(1).getAccountName());
            }
        }
        newAccount.setFreezeMoney(account.getFreezeMoney());
        if (account.getUsableMoney()!=null){
            newAccount.setUsableMoney(account.getUsableMoney());
        }
        request.getSession().setAttribute("account",newAccount);
        //根据用户权限跳转不同页面
        if (account.getJur()!=3){
            return "redirect:/loginController/index";
        }else {
            return "redirect:/Home/index";
        }

    }
}
