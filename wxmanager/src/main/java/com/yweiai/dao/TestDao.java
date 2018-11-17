package com.yweiai.dao;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TestDao {

    @Autowired
    private BasicDataSource dataSource;

    public List<Map<String,Object>> getLoginLog(){
        List<Map<String,Object>> result=new ArrayList<>();
        Connection conn=null;
        try {
            conn=dataSource.getConnection();
            String sql="select * from log_login";
            PreparedStatement statement=conn.prepareStatement(sql);
            ResultSet resultSet=statement.executeQuery();
            ResultSetMetaData metaData=resultSet.getMetaData();
            while (resultSet.next()){
                Map<String,Object> t=new HashMap<>();
                for(int i=0;i<metaData.getColumnCount();i++){
                    String name=metaData.getColumnName(i+1);
                    Object value=resultSet.getObject(i+1);
                    t.put(name,value);
                }
                result.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
