package cn.kgc.controller;

import cn.kgc.pojo.Account;
import cn.kgc.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 后台页面处理
 */
@Controller
@RequestMapping("/loginController")
public class loginController {

    @Resource(name = "accountService")
    private AccountService accountService;
    //首页
    @RequestMapping("/index")
    public ModelAndView login(HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView();
            modelAndView.setViewName("/admin/main");
        return modelAndView;
    }

    /**
     * 用户信息页面跳转
     * @return
     */
    @RequestMapping("/userInfor")
    public ModelAndView userInfor(){
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.setViewName("/admin/table");
        return modelAndView;
    }
    /**
     * 修改用户信息页面跳转
     * @return
     */
    @RequestMapping("/userInforUpdate")
    public ModelAndView userInforUpdate(Integer accountId){
        Account account=accountService.findAccountById(accountId);
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.addObject(account);
        modelAndView.setViewName("/admin/newsAdd");
        return modelAndView;
    }
    /**
     * 添加用户信息页面跳转
     * @return
     */
    @RequestMapping("/userInforAdd")
    public ModelAndView userInforAdd(){
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.setViewName("/admin/addUser");
        return modelAndView;
    }
    /**
     * 添加管理员信息页面跳转
     * @return
     */
    @RequestMapping("/userGuanLi")
    public ModelAndView userGuanLi(){
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.setViewName("/admin/addGuanLi");
        return modelAndView;
    }
    /**
     * 后台首页面跳转
     * @return
     */
    @RequestMapping("/userShouYe")
    public ModelAndView userShouYe(){
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.setViewName("/admin/main");
        return modelAndView;
    }
    /**
     * 后台店铺添加跳转
     * @return
     */
    @RequestMapping("/addShop")
    public ModelAndView addShop(){
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.setViewName("/admin/addShop");
        return modelAndView;
    }
    /**
     * 后台店铺跳转
     * @return
     */
    @RequestMapping("/shopInfo")
    public ModelAndView shopInfo(){
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.setViewName("/admin/shopInfo");
        return modelAndView;
    }
    /**
     * 后台管理员修改密码跳转
     * @return
     */
    @RequestMapping("/guanLiInfo")
    public ModelAndView guanLiInfo(){
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.setViewName("/admin/guanLiInfo");
        return modelAndView;
    }

    /**
     * 管理员跳转添加用户页面
     */
    @RequestMapping("/addUser")
    public String addUser(){
        return "/admin/addUser";
    }

    /**
     * 用户信息页面跳转
     * @return
     */
    @RequestMapping("/updateMoney")
    public ModelAndView updateMoney(Integer accountId){
        Account account=accountService.findAccountById(accountId);
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.addObject(account);
        modelAndView.setViewName("/admin/updaMoney");
        return modelAndView;
    }


    /**
     * 交易记录页面跳转
     * @return
     */
    @RequestMapping("/record")
    public ModelAndView record(){
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.setViewName("/admin/record");
        return modelAndView;
    }

    /**
     * 用户今天注册页面跳转
     * @return
     */
    @RequestMapping("/user_table")
    public ModelAndView user_table(){
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.setViewName("/admin/user_table");
        return modelAndView;
    }
    /**
     * 店铺今天注册页面跳转
     * @return
     */
    @RequestMapping("/shop_table")
    public ModelAndView shop_table(){
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.setViewName("/admin/shop_table");
        return modelAndView;
    }
    /**
     * yonghu今天tuijian页面跳转
     * @return
     */
    @RequestMapping("/user_TJ")
    public ModelAndView user_Tj(){
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.setViewName("/admin/user_Tj");
        return modelAndView;
    }
    /**
     * dianpu今天tuijian页面跳转
     * @return
     */
    @RequestMapping("/shop_TJ")
    public ModelAndView shop_Tj(){
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.setViewName("/admin/shop_TJ");
        return modelAndView;
    }
}
