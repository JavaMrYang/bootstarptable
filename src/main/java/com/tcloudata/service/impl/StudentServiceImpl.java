package com.tcloudata.service.impl;

import com.tcloudata.dao.StudentDao;
import com.tcloudata.domain.StudentDO;
import com.tcloudata.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;
    @Override
    public int insertStudent(StudentDO studentDo) {
        return studentDao.insertStudent(studentDo);
    }

    @Override
    public int deleteStudent(Long id) {
        return studentDao.deleteStudent(id);
    }

    @Override
    public List<StudentDO> list(Map<String, Object> params) {
        return studentDao.list(params);
    }

    @Override
    public int count() {
        return studentDao.count();
    }
}
