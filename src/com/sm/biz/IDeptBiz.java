package com.sm.biz;

import com.sm.entry.Dept;

import java.util.List;

public interface IDeptBiz {

    //登录
    boolean loginBiz(Dept dept);

    //注册
    boolean registerBiz(Dept dept);

    //查询全部
    List<Dept> queryBiz();

    //删除
    boolean deleteBiz(Dept dept);

    //修改
    boolean updateBiz(Dept dept);


}
