package com.tcloudata.service.impl;

import com.tcloudata.dao.GoodDao;
import com.tcloudata.domain.GoodDO;
import com.tcloudata.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GoodServiceImpl implements GoodService {
    @Autowired
    private GoodDao goodDao;
    @Override
    public int insertStudent(GoodDO goodDO) {
        return goodDao.insertStudent(goodDO);
    }

    @Override
    public int deleteStudent(Long id) {
        return goodDao.deleteStudent(id);
    }

    @Override
    public List<GoodDO> list(Map<String, Object> params) {
        return goodDao.list(params);
    }

    @Override
    public int count() {
        return goodDao.count();
    }
}
