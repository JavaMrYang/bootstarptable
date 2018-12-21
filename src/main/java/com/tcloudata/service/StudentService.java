package com.tcloudata.service;


import com.tcloudata.domain.StudentDO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public interface StudentService {
    int insertStudent(StudentDO studentDo);

    int deleteStudent(Long id);

    List<StudentDO> list(Map<String,Object> params);

    int count();
}
