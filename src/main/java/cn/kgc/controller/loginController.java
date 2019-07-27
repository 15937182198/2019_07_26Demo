package cn.kgc.controller;

import cn.kgc.dao.AccountDao;
import cn.kgc.pojo.Account;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping("/loginController")
public class loginController {

    @Resource(name = "accountDao")
    private AccountDao accountDao;


    @RequestMapping("/login")
    public ModelAndView login(String accountName){
        System.out.println(accountName);
        Account account = accountDao.findAccountByName(accountName);
        System.out.println(account.getJur());
        ModelAndView modelAndView=new ModelAndView();
        if (account.getJur()!=3){
            modelAndView.setViewName("/admin/index");
        }else {
            modelAndView.setViewName("/user/index");
        }
        return modelAndView;
    }
}
