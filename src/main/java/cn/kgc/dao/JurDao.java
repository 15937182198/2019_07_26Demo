package cn.kgc.dao;

import cn.kgc.pojo.Jurisdiction;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 权限dao层
 */
@Repository
public interface JurDao {


    @Select("select * from jurisdiction")
    List<Jurisdiction> findAll();

    /**
     * 根据权限id查询权限名
     * @param jurId 需要查询的权限id
     * @return 权限实体类
     */
    @Select("select * from jurisdiction where jurId=#{jurId}")
    Jurisdiction findJurByJurId(Integer jurId);
}
