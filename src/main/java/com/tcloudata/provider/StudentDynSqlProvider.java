package com.tcloudata.provider;

import org.apache.commons.lang3.StringUtils;


import java.util.Map;

public class StudentDynSqlProvider {
    public String list(Map<String,Object> param){
        StringBuilder sql=new StringBuilder("select id,name,age,birth,major,hobby from " +
                "tb_student where 1=1 ");
        if(param.get("sort")!=null&&StringUtils.isNotBlank(param.get("sort").toString())){
            sql.append("order by ${sort} ${order}");
        }else{
            sql.append("order by id ");
        }
        if(param.get("limit")!=null&&param.get("offset")!=null){
            sql.append("limit #{offset}, #{limit}");
        }
        return sql.toString();
    }

    public String count(){
        StringBuilder sql=new StringBuilder("select count(*) from tb_student");
        return sql.toString();
    }
}
