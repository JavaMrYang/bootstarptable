package com.tcloudata.dao;

import com.tcloudata.domain.GoodDO;
import com.tcloudata.provider.GoodDynSqlProvider;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

public interface GoodDao {
    @Insert("insert into tb_goods (good_name,size,price,desc) values(#{goodName},#{size},#{price},#{desc})")
    int insertStudent(GoodDO goodDO);

    @Delete("delete from tb_goods where id=#{id}")
    int deleteStudent(@Param(value = "id") Long id);

    @SelectProvider(type = GoodDynSqlProvider.class,method = "list")
    List<GoodDO> list(Map<String,Object> params);

    @SelectProvider(type = GoodDynSqlProvider.class,method = "count")
    int count();
}
