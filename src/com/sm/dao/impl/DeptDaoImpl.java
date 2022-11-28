package com.sm.dao.impl;

import com.sm.dao.IDeptDao;
import com.sm.entry.Dept;
import com.sm.util.DBHelper;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @Auther:唐一涵
 * @Date:2022/11/28
 * @Description: com.sm.util.dao.impl
 * @version: 1.0
 */
public class DeptDaoImpl implements IDeptDao {
    @Override
    public Dept query(Dept dept) {
        return null;
    }

    @Override
    public List<Dept> queryDept() {
        return null;
    }

    @Override
    public int add(Dept dept) {
        return 0;
    }

    @Override
    public int delete(Dept dept) {
        Connection con=null;
        int i=0;
        try {
            con=DBHelper.getCollection();
            String sql="delete from dept where deptno=?";
            i=uniMethod(sql,dept.getDeptno());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            DBHelper.closeAll(con,null,null);
        }
        return i;
    }

    @Override
    public int update(Dept dept) {
        return 0;
    }

    @Override
    public int uniMethod(String sql, Object... objs) {
        return 0;
    }
}
