package com.tcloudata.service;

import com.tcloudata.domain.GoodDO;
import com.tcloudata.provider.GoodDynSqlProvider;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

public interface GoodService {
    int insertStudent(GoodDO goodDO);

    int deleteStudent(@Param(value = "id") Long id);

    List<GoodDO> list(Map<String,Object> params);

    int count();
}
