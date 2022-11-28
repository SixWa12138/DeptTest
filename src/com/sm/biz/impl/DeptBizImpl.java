package com.sm.biz.impl;

import com.sm.biz.IDeptBiz;
import com.sm.dao.impl.DeptDaoImpl;
import com.sm.entry.Dept;

import java.util.List;

/**
 * @Auther:唐一涵
 * @Date:2022/11/28
 * @Description: com.sm.biz.com.sm.biz.impl
 * @version: 1.0
 */
public class DeptBizImpl implements IDeptBiz {
    DeptDaoImpl ddi = new DeptDaoImpl();

    @Override
    public boolean loginBiz(Dept dept) {
        return ddi.query(dept)!=null?true:false;
    }

    @Override
    public boolean registerBiz(Dept dept) {
        return ddi.insert(dept)==1?true:false;
    }

    @Override
    public List<Dept> queryBiz() {
        return ddi.queryDept();
    }

    @Override
    public Dept queryOneBiz(Dept dept) {
        return ddi.query(dept);
    }

    @Override
    public boolean removeBiz(Dept dept) {
        return ddi.delete(dept)==1?true:false;
    }

    @Override
    public boolean reviseBiz(Dept dept) {
        return ddi.update(dept)==1?true:false;
    }
}
