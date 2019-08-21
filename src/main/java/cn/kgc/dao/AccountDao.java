package cn.kgc.dao;

import cn.kgc.pojo.Account;
import cn.kgc.pojo.Profit;
import cn.kgc.pojo.Record;
import cn.kgc.pojo.picture;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * 用户dao层
 */
@Repository
public interface AccountDao {

    /**
     * 查询所有
     * @return 所有账户集合
     */
    @Select("select * from account")
    List<Account> findAll();

    /**
     * 根据账户名查询账户
     * @param accountName 需要查询的账户名
     * @return 账户实体类
     */
    @Select("select * from account where accountName=#{accountName}")
    Account findAccountByName(String accountName);

    /**
     * 根据用户上级编号查询下级
     * @param accountLead 需要查询的上级编号
     * @return 当前上级的直系下级
     */
    @Select("select * from account where accountLead=#{accountLead}")
    List<Account> findAccountByAccountLead(Integer accountLead);

    /**
     * 根据id查询他推荐的所有人
     * @return 当前id下的所有推荐人
     */
    @Select("select * from account where referrer=#{accountId}")
    List<Account> findAccountByReferrer(Integer accountId);




    /**
     * 根据用户id查询用户
     * @return 该id所对应的用户
     */
    @Select("select * from account where accountId=#{accountId}")
    Account findAccountByAccountId(Integer accountId);

    /**
     * 根据用户金字塔编号查询用户
     * @param accountJNumber 需要查询的用户金字塔编号
     * @return 该编号所对应的金字塔编号
     */
    @Select("select * from account where accountJNumber=#{accountJNumber}")
    Account findAccountByAccountJNumber(Integer accountJNumber);

    /**
     * 保存账户的方法
     * @param account 需要保存的账户
     * @return 保存受影响的行数
     */
    @Insert("insert into account values (null,#{accountName},#{accountPassword},#{accountMoney},#{accountCreateDate},#{referrer},#{accountLead},#{jur},#{accountJNumber},#{freezeMoney},#{usableMoney},#{userName},#{userPhone},#{site})")
    Integer saveAccount(Account account);

    /**
     * 查询所有管理员
     * @return 所有管理员
     */
    @Select("select * from account where jur=1 or jur=2")
    List<Account> findAdmin();

    /**
     * 查询所有用户
     * @return 所有用户
     */
    @Select("select * from account where jur=3 ")
    List<Account> findAccount();

    /**
     * 查询所有店铺
     * @return 所有用户
     */
    @Select("select * from account where jur=4 ")
    List<Account> findAccountShop();
    /**
     * 根据时间查询用户
     * @param date 当前时间
     * @return 查询到的用户
     */
    @Select("select * from account where accountCreateDate=#{date} and jur=3")
    List<Account> findAccountByDate(String date);

    /**
     * 根据时间查询店铺
     * @param date 当前时间
     * @return 查询到的用户
     */
    @Select("select * from account where accountCreateDate=#{date} and jur=4")
    List<Account> findAccountShopByDate(String date);
    /**
     * 根据账户id查询账户
     * @param accountId 需要查询的账户id
     * @return 该账户id对应的账户
     */
    @Select("select * from account where accountId=#{accountId}")
    Account findAccountById(Integer accountId);

    /**
     * 修改密码的方法
     * @param account 需要修改的用户
     * @return 修改受影响的行数
     */
    @Update("update account set accountPassword=#{accountPassword} where accountId=#{accountId}")
    int updateAccountPassword(Account account);

    /**
     * 修改节点积分余额的方法
     * @param account 需要修改的用户
     * @return 受影响的行数
     */
    @Update("update account set accountMoney=#{accountMoney} where accountId=#{accountId}")
    int updateAccountMoney(Account account);


    /**
     * 修改用户冻结积分的方法
     * @param account 需要修改用户
     * @return 受影响行数
     */
    @Update("update account set freezeMoney=#{freezeMoney} where accountId=#{accountId}")
    int updateFreezeMoney(Account account);

    /**
     * 修改用户冻结积分的方法
     * @param account 需要修改用户
     * @return 受影响行数
     */
    @Update("update account set usableMoney=#{usableMoney} where accountId=#{accountId}")
    int updateUsableMoney(Account account);

    @Update("update account set accountName=#{accountName},userName=#{userName},userPhone=#{userPhone},site=#{site},accountMoney=#{accountMoney},usableMoney=#{usableMoney},freezeMoney=#{freezeMoney} where accountId=#{accountId}")
    void updateAccount(Account account);

    @Select("select *from Profit where accountId=#{param1}")
    Profit querybyId(int a);

    @Insert("insert into Profit values(#{accountId},#{Yesterday},#{YesterdayTime},#{Today})")
     int insetProfit(Profit profit);

    @Update("update Profit set Yesterday=#{Yesterday},YesterdayTime=#{YesterdayTime},Today=#{Today} where accountId=#{accountId}")
    int updateProfit(Profit profit);


    @Select("SELECT * FROM account where accountId in (SELECT referrer FROM (select distinct referrer,count(1) from account where (jur=4 or jur=3)and referrer!=1  group by referrer HAVING count(1)>6) a where referrer =a.referrer) and jur=3")
    List<Account> selectAccountByReferrer();

    @Select("SELECT * FROM account where accountId in (SELECT referrer FROM (select distinct referrer,count(1) from account where (jur=4 or jur=3)and referrer!=1  group by referrer HAVING count(1)>6) a where referrer =a.referrer) and jur=4")
    List<Account> findShopByReferrer();

    @Select("select sum(freezeMoney) from account where jur=4")
    Double findShopFreezeMoney();

    @Select("select sum(accountMoney) from account where jur=4")
    Double findShopAccountMoney();

    @Select("select sum(usableMoney) from account where jur=4")
    Double findShopUsableMoney();

    @Select("select sum(freezeMoney) from account where jur=3")
    Double findAccountFreezeMoney();

    @Select("select sum(accountMoney) from account where jur=3")
    Double findAccountAccountMoney();

    @Select("select sum(usableMoney) from account where jur=3")
    Double findAccountUsableMoney();

    @Select("select *from picture where pictureId>=7")
    List<picture> queryPicture();
    @Select("select *from picture where pictureId<7")
    List<picture> queryTopPicture();
    @Delete("delete from account where accountId=#{param1}")
    int deleteUser(int accountId);
}
