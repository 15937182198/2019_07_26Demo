package cn.kgc.controller;

import cn.kgc.pojo.Account;
import cn.kgc.pojo.PageInfo;
import cn.kgc.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @RequestMapping("/findAccountByAccountName")
    public ModelAndView findAccountByAccountName(String accountName){
        ModelAndView modelAndView=new ModelAndView();
        Account account = accountService.findAccountByName(accountName);
        PageInfo pageInfo=new PageInfo();
        ArrayList<Account> arrayList = new ArrayList<Account>();
        arrayList.add(account);
        pageInfo.setList(arrayList);
        modelAndView.setViewName("/admin/table");
        modelAndView.addObject(pageInfo);
        return modelAndView;
    }



    /**
     * 管理员添加用户的方法
     * @param accountName 用户名
     * @param accountPassword 用户密码
     * @param referrer 推荐人
     * @return 保存成功返回true，保存失败返回false
     */
    @RequestMapping("/saveAccount")
    public @ResponseBody String saveAccount(String  accountName,String accountPassword,Integer referrer){
        boolean b=false;
        //根据用户名查询用户
        Account accountByName = accountService.findAccountByName(accountName);
        //如果有该用户返回false
        if (accountByName!=null){
            return b+"";
        }
        b= accountService.saveAccount(accountName, accountPassword, referrer);
        return b+"";
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

    /**
     * 查询所有用户总数
     * @return 用户总数
     */
    @RequestMapping("/findAccountNumber")
    public @ResponseBody String findAccountNumber(){
        return  accountService.findAccount().size()+"";
    }
    /**
     * 查询一天用户注册的总数
     * @return 当日用户注册总数
     */
    @RequestMapping("/findAccountByDate")
    public @ResponseBody String findAccountByDate(){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        return accountService.findAccountByDate(simpleDateFormat.format(new Date())).size()+"";
    }

    @RequestMapping("/findAccountByReferrer")
    public @ResponseBody String findAccountByReferrer(){
        //查询所有所有用户
        List<Account> account = accountService.findAccount();
        //推荐人数大于等于6的总人数
        int i=0;
        for (Account account1 : account) {
            //根据用户id查询推荐人
            List<Account> list=accountService.findAccountByReferrer(account1.getAccountId());
            //如果推荐人大于等于6
            if (list.size()>=6){
                i++;
            }
        }
        return i+"";
    }


    /**
     * 分页
     * @param currPage
     * @param pageSizes
     * @return
     */
    @RequestMapping("/pageInfo")
    public ModelAndView pageInfo(
            @RequestParam(required = false,defaultValue = "1",value = "currPage")Integer currPage,
            @RequestParam(required = false,defaultValue = "5",value = "pageSizes")Integer pageSizes
    ){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(accountService.findPage(currPage,pageSizes));
        modelAndView.setViewName("/admin/table");
        return modelAndView;
    }

    /**
     * 修改密码的方法
     * @return 修改成功返回true 失败返回false
     */
    @RequestMapping("/updateAccountPassword")
    public @ResponseBody String updateAccountPassword(Integer accountId,String accountPassword){
        Account account = accountService.findAccountById(accountId);
        account.setAccountPassword(accountPassword);
        boolean bo=accountService.updateAccountPassword(account);
        return bo+"";
    }

    /**
     * 修改积分的方法
     * @return 修改成功返回true 失败返回false
     */
    @RequestMapping("/updateAccountMoney")
    public @ResponseBody String updateAccountMoney(Integer accountId,double accountMoney){
        Account account = accountService.findAccountById(accountId);
        account.setAccountMoney(accountMoney);
        boolean bo=accountService.updateAccountMoney(account);
        return bo+"";
    }


}
