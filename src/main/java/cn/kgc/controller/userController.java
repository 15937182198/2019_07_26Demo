package cn.kgc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author LZY
 * @date 2019/8/13 19:09
 * 用户页面处理
 */
@Controller
@RequestMapping("/Home")
public class userController {
    //首页页面跳转
    @RequestMapping("/index")
    public ModelAndView login(HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView();
            modelAndView.setViewName("/user/index");
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
     * 我的推荐页面跳转
     * @return
     */
    @RequestMapping("/recommender")
    public ModelAndView recommender(){
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.setViewName("/user/recommender");
        return modelAndView;
    }
    /**
     * 用户交易记录页面跳转
     * @return
     */
    @RequestMapping("/userRecord")
    public ModelAndView userRecord(){
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.setViewName("/user/userRecord");
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
}
