package com.yweiai.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface TestMapper {
    @Select("select * from log_login")
    public List<Map<String,Object>> getLoginLog();

    @Select("select * from log_login where id=#{id}")
    public Map<String,Object> getLoginLogById(@Param("id") String id);

}
