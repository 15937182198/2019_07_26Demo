package cn.kgc.dao;

import cn.kgc.pojo.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

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
    @Select("select * from where referrer=#{accountId}")
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
    @Select("select * from where accountJNumber=#{accountJNumber}")
    Account findAccountByAccountJNumber(Integer accountJNumber);

    /**
     * 保存账户的方法
     * @param account 需要保存的账户
     * @return 保存受影响的行数
     */
    @Insert("insert into account values (null,#{accountName},#{accountPassword},null,#{accountCreateDate},#{referrer},#{accountLead},#{jur},accountJNumber);")
    Integer saveAccount(Account account);
}
