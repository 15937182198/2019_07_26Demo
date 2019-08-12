package cn.kgc.controller;

import cn.kgc.pojo.Account;
import cn.kgc.pojo.NewAccount;
import cn.kgc.pojo.PageInfo;
import cn.kgc.service.AccountService;
import cn.kgc.util.AccountMoneyUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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

    @Resource(name = "accountMoneyUtil")
    private AccountMoneyUtil accountMoneyUtil;

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
        NewAccount newAccount=new NewAccount();
        newAccount.setAccountId(account.getAccountId());
        newAccount.setAccountName(account.getAccountName());
        newAccount.setAccountCreateDate(account.getAccountCreateDate());
        if (account.getReferrer()!=null){
            newAccount.setReferrer(accountService.findAccountById(account.getReferrer()).getAccountName());
        }
        newAccount.setAccountMoney(account.getAccountMoney());
        PageInfo pageInfo=new PageInfo();
        ArrayList<NewAccount> arrayList = new ArrayList<NewAccount>();
        arrayList.add(newAccount);
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
    @RequestMapping("/saveAccount.admin")
    public @ResponseBody String saveAccount(String  accountName,String accountPassword,Integer referrer,Integer param,String userName,String userPhone,String site){
        boolean b=false;
        //根据用户名查询用户
        Account accountByName = accountService.findAccountByName(accountName);
        //如果有该用户返回false
        if (accountByName!=null){
            return "1";
        }
        b= accountService.saveAccount(accountName, accountPassword, referrer,userName,userPhone,site);
        if (param==1){
            //查询新增用户
            Account accountByName1 = accountService.findAccountByName(accountName);
            //给该用户上30层的所有上级增加相应积分
            List<Account> accounts =accountMoneyUtil.updateAccountLeadMoney(accountByName1.getAccountLead(),30);
            System.out.println(accounts.size());
            System.out.println(accounts.size());
            System.out.println(accounts.size());
            System.out.println(accounts.size());
            System.out.println(accounts.size());
            System.out.println(accounts.size());
            System.out.println(accounts.size());
            for (Account account : accounts) {
                System.out.println(account);
                System.out.println(account);
                System.out.println(account);
                System.out.println(account);
                System.out.println(account);
                accountService.updateAccountMoney(account);
            }
        }
        return b+"";
    }

    /**
     * 保存管理员账户的方法
     * @param account 需要保存的管理员账户
     * @return 是否保存成功
     */
    @RequestMapping("/saveAdmin")
    public @ResponseBody String saveAccount(Account account){
        if (accountService.findAccountByName(account.getAccountName())!=null){
            return "1";
        }
        return accountService.saveAccount(account)+"";
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

    /**
     * 查询推荐人大于6的方法
     * @return 推荐人数大于6的总人数
     */
    @RequestMapping("/findAccountByReferrer")
    public @ResponseBody String findAccountByReferrer(){
        List<Account> account = accountService.findAccount();
        //查询所有所有用户
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
     * 用户分页
     * @param currPage 当前页面
     * @param pageSizes 页面容量
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
     * 店铺分页
     * @param currPage 当前页面
     * @param pageSizes 页面容量
     */
    @RequestMapping("/ShopPageInfo")
    public ModelAndView ShoppageInfo(
            @RequestParam(required = false,defaultValue = "1",value = "currPage")Integer currPage,
            @RequestParam(required = false,defaultValue = "5",value = "pageSizes")Integer pageSizes
    ){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(accountService.shopFindPage(currPage,pageSizes));
        modelAndView.setViewName("/admin/shopInfo");
        return modelAndView;
    }

    /**
     * 管理员分页
     * @param currPage 当前页面
     * @param pageSizes 页面容量
     */
    @RequestMapping("/adminPageInfo")
    public ModelAndView adminPageInfo(
            @RequestParam(required = false,defaultValue = "1",value = "currPage")Integer currPage,
            @RequestParam(required = false,defaultValue = "5",value = "pageSizes")Integer pageSizes
    ){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(accountService.adminFindPage(currPage,pageSizes));
        modelAndView.setViewName("/admin/guanLiInfo");
        return modelAndView;
    }

    /**
     * 修改密码的方法
     * @return 修改成功返回true 失败返回false
     */
    @RequestMapping("/updateAccountPassword")
    public @ResponseBody String updateAccountPassword(Integer accountId,String accountPassword,String accountName){
        Account account = accountService.findAccountById(accountId);
        account.setAccountName(accountName);
        account.setAccountPassword(accountPassword);
        boolean bo=accountService.updateAccountPassword(account);
        return bo+"";
    }

    /**
     * 修改可用积分的方法
     * @return 修改成功返回true 失败返回false
     */
    @RequestMapping("/updateAccountMoney")
    public @ResponseBody String updateAccountMoney(Integer accountId,double accountMoney){
        Account account = accountService.findAccountById(accountId);
        account.setUsableMoney(accountMoney);
        boolean bo=accountService.updateUsableMoney(account);
        return bo+"";
    }

    /**
     * 用户新增账号的方法
     * @param referrer 推荐人id
     * @param accountName 用户名
     * @param accountPassword 用户密码
     */
    @RequestMapping("/userSaveAccount")
    public @ResponseBody String userSaveAccount(HttpServletRequest request,Integer referrer, String accountName, String accountPassword, String userName, String userPhone, String site){
        //判断该用户名是否可用
        Account accountByName = accountService.findAccountByName(accountName);
        if (accountByName!=null){
            return "1";
        }
        //查看推荐人积分是否在2000积分以上
        Account accountById = accountService.findAccountById(referrer);
        if (accountById.getUsableMoney()<2000){
            return "2";
        }
        //保存该用户
        boolean b = accountService.saveAccount(accountName, accountPassword,referrer,userName,userPhone,site);
        if (b){
            //给推荐人增加180积分,并保存
            accountById.setUsableMoney(accountById.getUsableMoney()-999);
            accountById.setAccountMoney(accountById.getAccountMoney()+180);
            accountService.updateAccountMoney(accountById);
            //查询新增用户
            Account accountByName1 = accountService.findAccountByName(accountName);
            //给该用户上30层的所有上级增加相应积分
            List<Account> accounts =accountMoneyUtil.updateAccountLeadMoney(accountByName1.getAccountLead(),30);
            for (Account account : accounts) {
                accountService.updateAccountMoney(account);
            }
        }
        NewAccount account = (NewAccount) request.getSession().getAttribute("account");
        account.setAccountMoney(accountById.getAccountMoney());
        account.setFreezeMoney(accountById.getFreezeMoney());
        account.setUsableMoney(accountById.getUsableMoney());
        request.getSession().setAttribute("account",account);
        return b+"";
    }

    /**
     * 根据用户名判断该用户名是否可用
     * @param accountName 需要查询的用户名
     */
    @RequestMapping("/userFindAccountByAccountName")
    public @ResponseBody String userFindAccountByAccountName(String accountName){
        Account accountByName = accountService.findAccountByName(accountName);
        if (accountByName==null){
            return "1";
        }else {
            return "2";
        }
    }

    /**
     * 管理员添加店铺的方法
     * @param accountName 用户名
     * @param accountPassword 用户密码
     * @param referrer 推荐人
     * @return 保存成功返回true，保存失败返回false
     */
    @RequestMapping("/saveShop.admin")
    public @ResponseBody String saveShop(String  accountName,String accountPassword,Integer referrer,Integer param,String userName,String userPhone,String site){
        boolean b=false;
        //根据用户名查询用户
        Account accountByName = accountService.findAccountByName(accountName);
        //如果有该用户返回false
        if (accountByName!=null){
            return "1";
        }
        b= accountService.saveShop(accountName, accountPassword, referrer, userName, userPhone, site);
        if (param==1){
            Account accountByName1 = accountService.findAccountByName(accountName);
            List<Account> accounts =accountMoneyUtil.updateAccountLeadMoney(accountByName1.getAccountLead(),30);
            for (Account account : accounts) {
                accountService.updateAccountMoney(account);
            }
        }
        return b+"";
    }

    /**
     * 用户新增店铺账号的方法
     * @param referrer 推荐人id
     * @param accountName 用户名
     * @param accountPassword 用户密码
     */
    @RequestMapping("/userSaveShop")
    public @ResponseBody String userSaveShop(Integer referrer,String accountName,String accountPassword,String userName,String userPhone,String site){
        //判断该用户名是否可用
        Account accountByName = accountService.findAccountByName(accountName);
        if (accountByName!=null){
            return "1";
        }
        //查看推荐人积分是否在10000积分以上
        Account accountById = accountService.findAccountById(referrer);
        if (accountById.getUsableMoney()<10000){
            return "2";
        }
        //保存该用户
        boolean b = accountService.saveShop(accountName, accountPassword, referrer,userName, userPhone, site);
        if (b){
            //给推荐人增加380积分,并保存
            accountById.setUsableMoney(accountById.getUsableMoney()-10000);
            accountById.setAccountMoney(accountById.getAccountMoney()+380);
            accountService.updateAccountMoney(accountById);
            //查询新增用户
            Account accountByName1 = accountService.findAccountByName(accountName);
            System.out.println(accountByName1);
            //给该用户上30层的所有上级增加相应积分    //店铺节点分数不清楚
            List<Account> accounts =accountMoneyUtil.updateAccountLeadMoney(accountByName1.getAccountLead(),30);
            for (Account account : accounts) {
                accountService.updateAccountMoney(account);
            }
        }
        return b+"";
    }

    /**
     * 查询所有用户总数
     * @return 用户总数
     */
    @RequestMapping("/findShopNumber")
    public @ResponseBody String findShopNumber(){
        return  accountService.findShop().size()+"";
    }
    /**
     * 查询一天用户注册的总数
     * @return 当日用户注册总数
     */
    @RequestMapping("/findShopByDate")
    public @ResponseBody String findShopByDate(){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        return accountService.findShopByDate(simpleDateFormat.format(new Date())).size()+"";
    }

    /**
     * 查询推荐人大于6的方法
     * @return 推荐人数大于6的总人数
     */
    @RequestMapping("/findShopByReferrer")
    public @ResponseBody String findShopByReferrer(){
        //查询所有所有用户
        List<Account> account = accountService.findShop();
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
     * 用户积分交易所用方法
     * @param accountId 转账人的账户id
     * @param accountMoney 转账金额
     * @param accountName 收款人
     * @return 成功返回true，余额不足返回1，失败返回2
     */
    @RequestMapping("/transfer")
    public @ResponseBody String transfer(Integer accountId,Integer accountMoney,String accountName){
        Account accountById = accountService.findAccountById(accountId);
        if (accountById.getUsableMoney()<accountMoney){
            return "1";
        }
        boolean bo=accountService.transfer(accountId,accountMoney,accountName);

        return bo+"";
    }
}
