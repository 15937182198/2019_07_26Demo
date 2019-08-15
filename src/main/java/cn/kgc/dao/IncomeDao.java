package cn.kgc.dao;


import cn.kgc.pojo.Income;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncomeDao {

    @Select("select * from income where accountId=#{accountId}")
    List<Income> findIncomeByAccountId(Integer accountId);

    @Update("update income set oldIncome=#{oldIncome},income=#{income} where accountId=#{accountId}")
    int updateIncome(Income income);

    @Insert("insert into income values(null,null,null,accountId=#{accountId})")
    int saveIncome(Income income);
}
