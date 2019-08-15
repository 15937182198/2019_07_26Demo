package cn.kgc.controller;

import cn.kgc.pojo.Account;
import cn.kgc.pojo.Deal;
import cn.kgc.pojo.NewDeal;
import cn.kgc.pojo.PageInfo;
import cn.kgc.service.AccountService;
import cn.kgc.service.DealService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LZY
 * @date 2019/8/13 19:09
 * 用户页面处理
 */
@Controller
@RequestMapping("/Home")
public class userController {

    @Resource(name = "dealService")
    private DealService dealService;

    @Resource(name = "accountService")
    private AccountService accountService;

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
    public ModelAndView userRecord(Integer accountId, @RequestParam(required = false,defaultValue = "1",value = "currPage")Integer currPage,
                                   @RequestParam(required = false,defaultValue = "5",value = "pageSizes")Integer pageSizes){
        ModelAndView modelAndView =new ModelAndView();
        int number=dealService.findDealByAccountId(accountId).size();
        PageHelper.startPage(currPage,pageSizes);
        PageInfo pageInfo=new PageInfo();
        List<Deal> list1 = dealService.findDealByAccountId(accountId);
        if (number%pageSizes!=0){
            pageInfo.setPages(number/pageSizes+1);
        }else {
            pageInfo.setPages(number/pageSizes);
        }
        List<NewDeal> list=new ArrayList<NewDeal>();
        for (Deal deal : list1) {
            NewDeal deal1=new NewDeal();
            deal1.setDeal(deal);
            Account accountById = accountService.findAccountById(accountId);
            deal1.setAccountName(accountById.getAccountName());
            list.add(deal1);
        }
        pageInfo.setList(list);
        modelAndView.addObject(pageInfo);
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
