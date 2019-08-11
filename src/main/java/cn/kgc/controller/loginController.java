package cn.kgc.controller;

import cn.kgc.dao.AccountDao;
import cn.kgc.pojo.Account;
import cn.kgc.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/loginController")
public class loginController {

    @Resource(name = "accountService")
    private AccountService accountService;

    //登陆跳转
    @RequestMapping("/login")
    public ModelAndView login(HttpServletRequest request){
        //获得在session中的用户名
        String accountName= (String) request.getSession().getAttribute("username");
        System.out.println(accountName);
        //根据用户名查找该用户信息
        Account account = accountService.findAccountByName(accountName);
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
     * 普通用户购买账号页面跳转
     * @return
     */
    @RequestMapping("/userAdd")
    public ModelAndView userAdd(HttpServletRequest request){
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.setViewName("/user/userAdd");
        return modelAndView;
    }
    /**
     * 普通用户修改账号页面跳转
     * @return
     */
    @RequestMapping("/UpdateUser")
    public ModelAndView updateUser(){
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.setViewName("/user/updatPwd");
        return modelAndView;
    }
    /**
     * 普通用户积分交易账号页面跳转
     * @return
     */
    @RequestMapping("/userjiaoyi")
    public ModelAndView userjiaoyi(){
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.setViewName("/user/jiaoyi");
        return modelAndView;
    }
    /**
     * 普通用户积分交易账号页面跳转
     * @return
     */
    @RequestMapping("/usershouye")
    public ModelAndView usershouye(){
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.setViewName("/user/index");
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
     * 普通用户购买店铺账号页面跳转
     * @return
     */
    @RequestMapping("/shopAdd")
    public ModelAndView shopAdd(){
//        Account account=accountService.findAccountById(accountId);
        ModelAndView modelAndView =new ModelAndView();
//        modelAndView.addObject(account);
        modelAndView.setViewName("/user/shopAdd");
        return modelAndView;
    }
    /**
     * 我的推荐页面跳转
     * @return
     */
    @RequestMapping("/recommender")
    public ModelAndView recommender(){
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.setViewName("/user/recommender");
        return modelAndView;
    }
}
