package com.sm.dao;

import com.sm.entry.Dept;

import java.sql.ResultSet;
import java.util.List;

public interface IDeptDao {

    //登录查询
    Dept query(Dept dept);

    //查询全部
    List<Dept> queryDept();

    //注册添加
    int insert(Dept dept);

    //注销删除
    int delete(Dept dept);

    //修改
    int update(Dept dept);

    //增删改通用方法
    int uniMethod(String sql,Object...objs);

    //查通用方法
    ResultSet queryMethod(String sql,Object...objs);
}
