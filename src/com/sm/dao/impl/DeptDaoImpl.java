package com.sm.dao.impl;

import com.sm.dao.IDeptDao;
import com.sm.entry.Dept;
import com.sm.util.DBHelper;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther:唐一涵
 * @Date:2022/11/28
 * @Description: com.sm.util.dao.impl
 * @version: 1.0
 */
public class DeptDaoImpl implements IDeptDao {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public Dept query(Dept dept) {
        Dept d=null;
        try {
            String sql = "select * from dept where deptno=? and dname=?";
            rs = queryMethod(sql,dept.getDeptno(),dept.getDname());
            while (rs.next()){
                d = new Dept();
                d.setDeptno(rs.getInt(1));
                d.setDname(rs.getString(2));
                d.setLoc(rs.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelper.closeAll(con,ps,rs);
        }
        return d;
    }

    @Override
    public List<Dept> queryDept() {

        List<Dept> list = new ArrayList<>();
        Dept d = null;
        try {
            String sql = "select * from dept";
            rs = queryMethod(sql);
            while (rs.next()) {
                d = new Dept();
                d.setDeptno(rs.getInt(1));
                d.setDname(rs.getString(2));
                d.setLoc(rs.getString(3));
                list.add(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelper.closeAll(con, ps, rs);
        }
        return list;
    }

    @Override
    public int insert(Dept dept) {
        String sql = "insert into dept values(?,?,?)";
        int num = uniMethod(sql,dept.getDeptno(),dept.getDname(),dept.getLoc());
        return num;
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
        String sql = "update dept set dname=?,loc=? where deptno=?";
        int i = uniMethod(sql,dept.getDname(),dept.getLoc(),dept.getDeptno());
        return i;
    }

    @Override
    public int uniMethod(String sql, Object... objs) {
        int num = 0;
        try {
            con = DBHelper.getCollection();
            ps = con.prepareStatement(sql);
            for (int i=0;i<objs.length;i++){
                ps.setObject(i+1,objs[i]);
            }
            num = ps.executeUpdate();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBHelper.closeAll(con,ps,null);
        }
        return num;
    }

    @Override
    public ResultSet queryMethod(String sql, Object... objs) {
        try {
            con = DBHelper.getCollection();
            ps = con.prepareStatement(sql);
            for (int i=0;i<objs.length;i++){
                ps.setObject(i+1,objs[i]);
            }
            rs = ps.executeQuery();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
