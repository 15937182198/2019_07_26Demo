package cn.kgc.controller;

import cn.kgc.dao.AccountDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/loginController")
public class loginController {

    @Resource(name = "accountDao")
    private AccountDao accountDao;


    @RequestMapping("/login")
    public ModelAndView login(HttpServletRequest request){
        //获得在session中的用户名
        String accountName= (String) request.getSession().getAttribute("username");
        System.out.println(accountName);
        //根据用户名查找该用户信息
        Account account = accountDao.findAccountByName(accountName);
        request.getSession().setAttribute("account",account);
        //根据用户权限跳转不同页面
        ModelAndView modelAndView=new ModelAndView();
        if (account.getJur()!=3){
            modelAndView.setViewName("/admin/main");
        }else {
            modelAndView.setViewName("/user/index");
        }
        return modelAndView;
    }
}
