package cn.kgc.service;

import cn.kgc.pojo.Account;
import cn.kgc.pojo.PageInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Date;
import java.util.List;

public interface AccountService extends UserDetailsService {

    /**
     * 根据用户上级编号查询下级
     * @param accountLead 需要查询的上级编号
     * @return 当前上级的直系下级
     */
    List<Account> findAccountByAccountLead(Integer accountLead);

    /**
     * 保存账户的方法
     * @param referrer 推荐人id
     * @return 是否保存成功
     */
    boolean saveAccount(String accountName,String accountPassword, Integer referrer,String userName,String userPhone,String site);

    /**
     * 根据账户名查询该用户
     * @param accountName 需要查询的账户名
     * @return 该账户名对应的账户
     */
    Account findAccountByName(String accountName);

    /**
     * 保存管理员账号的方法
     * @param account 需要保存的管理员账户
     * @return 是否保存成功
     */
    boolean saveAccount(Account account);

    /**
     * 查询所有管理员
     * @return 所有管理员账号
     */
    List<Account> findAdmin();

    /**
     * 查询所有用户
     * @return 所有用户
     */
    List<Account> findAccount();

    /**
     * 根据时间查询注册用户
     * @return 查询到的用户总数
     */
    PageInfo findAccountByDate(Integer currPage,Integer pageSizes);

    List<Account> findAccountByDateAll(String date);

    /**
     * 根据账户id查询推荐人数
     * @param accountId 查询的账户id
     * @return 该账户id推荐的人数
     */
    List<Account> findAccountByReferrer(Integer accountId);

    /**
     * 用户分页助手
     * @param page 当前页码
     * @param pageSize 页面容量
     * @return pageinfo对象
     */
    public PageInfo findPage(int page, int pageSize);

    /**
     * 店铺分页助手
     * @param page 当前页码
     * @param pageSize 页面容量
     * @return pageinfo对象
     */
    public PageInfo shopFindPage(int page, int pageSize);

    /**
     * 管理员分页助手
     * @param page 当前页码
     * @param pageSize 页面容量
     * @return pageinfo对象
     */
    public PageInfo adminFindPage(int page, int pageSize);

    /**
     * 根据账户id查询账户
     * @param accountId 需要查询的账户id
     * @return 该账户id对应的账户
     */
    Account findAccountById(Integer accountId);

    /**
     * 修改用户密码的方法
     * @param account 需要修改的用户
     * @return 是否修改成功
     */
    boolean updateAccountPassword(Account account);

    /**
     * 修改用户积分的方法
     * @param account 需要修改的用户
     * @return 是否修改成功
     */
    boolean updateAccountMoney(Account account);

    /**
     * 添加店铺需要的方法
     * @param accountName 用户名
     * @param accountPassword 密码
     * @param referrer 推荐人
     * @return 是否添加成功
     */
    boolean saveShop(String accountName, String accountPassword, Integer referrer,String userName,String userPhone,String site);

    /**
     * 查询所有店铺
     * @return 店铺集合
     */
    List<Account> findShop();

    /**
     * 查询当日注册的所有店铺
     * @param format 注册时间
     * @return 店铺集合
     */
    List<Account> findShopByDate(String format);

    PageInfo findShopByDate(int page, int pageSize);
    /**
     * 查询当前用户下级
     * @param accountId 需要查询的用户id
     * @return 直属的两个下级
     */
    public List<Account> findSubordinate(Integer accountId);

    /**
     * 转账所用的方法
     * @param accountId 转账人id
     * @param accountMoney 交易金额
     * @param accountName 收款人账户
     * @return 是否交易成功
     */
    boolean transfer(Integer accountId, double accountMoney, String accountName);

    /**
     * 修改可用积分的方法
     * @param account 需要修改的对象
     * @return 是否修改成功
     */
    boolean updateUsableMoney(Account account);

    /**
     * 修改用户信息的方法
     * @param accountId 用户id
     * @param accountName 用户名
     * @param userName 用户姓名
     * @param site 用户地址
     * @param userPhone 用户手机号
     * @param accountMoney 用户节点积分
     * @param usableMoney 用户可用积分
     * @param freezeMoney 用户冻结积分
     * @return 是否修改成功
     */
    boolean updateAccount(Integer accountId, String accountName, String userName, String site, String userPhone, double accountMoney, double usableMoney, double freezeMoney);
    /**
     * 昨日收益
     */
    double profit(int a, Double b, Date date);

    PageInfo findShopByReferrer(Integer currPage, Integer pageSizes);


    PageInfo findAccountByReferrer(Integer currPage, Integer pageSizes);


    Double findShopFreezeMoney();

    Double findShopAccountMoney();

    Double findShopUsableMoney();


    Double findAccountFreezeMoney();

    Double findAccountAccountMoney();

    Double findAccountUsableMoney();
}
