package cn.kgc.dao;

import cn.kgc.pojo.Account;
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


}
