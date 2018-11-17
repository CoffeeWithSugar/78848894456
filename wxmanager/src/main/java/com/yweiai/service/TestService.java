package com.yweiai.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yweiai.dao.TestDao;
import com.yweiai.mapper.TestMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TestService {

    private static final Logger log=Logger.getLogger(TestService.class);

    @Autowired
    private TestDao dao;

    @Autowired
    private TestMapper mapper;

    public List<Map<String,Object>> getLoginLog(){
        return dao.getLoginLog();
    }

    public List<Map<String,Object>> getLoginLogFromMapper(){
        return mapper.getLoginLog();
    }

    public Map<String,Object> getLoginLogByIdFromMapper(String id){
        return mapper.getLoginLogById(id);
    }

    public PageInfo<Map<String,Object>> getLoginLogPage(int pageIndex){
        PageHelper.startPage(pageIndex,5);
        List<Map<String,Object>> result=mapper.getLoginLog();
        PageInfo<Map<String,Object>> pageInfo=new PageInfo<>(result);
        return pageInfo;
    }
}
