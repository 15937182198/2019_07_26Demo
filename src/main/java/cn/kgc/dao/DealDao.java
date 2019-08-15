package cn.kgc.dao;

import cn.kgc.pojo.Deal;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 交易记录
 */
@Repository
public interface DealDao {

    @Select("select * from deal where accountId=#{accountId}")
    List<Deal> findDealByAccountId(Integer accountId);

    @Insert("insert into deal values(null,#{dealIncome},#{dealDate},#{accountId})")
    int saveDeal(Deal deal);

    @Delete("delete from deal where dealDate<SUBDATE(now(),interval 7 day)")
    int deleteDeal();
}
