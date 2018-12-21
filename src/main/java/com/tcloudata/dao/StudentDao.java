package com.tcloudata.dao;

import com.tcloudata.domain.StudentDO;
import com.tcloudata.provider.StudentDynSqlProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentDao {
    @Insert("insert into tb_student (name,age,birth,major,hobby) values(#{name},#{age},#{birth},#{major},#{hobby})")
    int insertStudent(StudentDO studentDao);

    @Delete("delete from tb_student where id=#{id}")
    int deleteStudent(@Param(value = "id") Long id);

    @SelectProvider(type = StudentDynSqlProvider.class,method = "list")
    List<StudentDO> list(Map<String,Object> params);

    @SelectProvider(type = StudentDynSqlProvider.class,method = "count")
    int count();


}
