package com.tcloudata.controller;

import com.tcloudata.common.PageUtils;
import com.tcloudata.common.Query;
import com.tcloudata.domain.GoodDO;
import com.tcloudata.domain.StudentDO;
import com.tcloudata.service.impl.GoodServiceImpl;
import com.tcloudata.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {
    @Autowired
    private StudentServiceImpl studentService;

    @Autowired
    private GoodServiceImpl goodService;

    @GetMapping({"/",""})
    public String index()
    {
        return "index";
    }

    @GetMapping("/table")
    public String table(){
        return "show-table";
    }

    /*@GetMapping("/test/{name}")
    @ResponseBody
    public Map testMap(@PathVariable(name = "")){

    }*/

    @ResponseBody
    @GetMapping("/list")
    public PageUtils list(){
        return new PageUtils(new ArrayList<>(),0);
    }

    @ResponseBody
    @GetMapping("/student/list")
    public PageUtils studentList(@RequestParam Map<String, Object> params){
        Query query = new Query(params);
        List<StudentDO> studentList = studentService.list(query);
        int total = studentService.count();
        PageUtils pageUtils = new PageUtils(studentList, total);
        return pageUtils;
    }

    @ResponseBody
    @GetMapping("/goods/list")
    public PageUtils goodList(@RequestParam Map<String, Object> params){
        Query query = new Query(params);
        List<GoodDO> goodList = goodService.list(query);
        int total = goodService.count();
        PageUtils pageUtils = new PageUtils(goodList, total);
        return pageUtils;
    }
}
