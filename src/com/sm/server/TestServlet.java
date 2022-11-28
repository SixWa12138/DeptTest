package com.sm.server;

import com.sm.biz.impl.DeptBizImpl;
import com.sm.entry.Dept;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/ts")
public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        delete(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        delete(req, resp);
    }
    public void delete(HttpServletRequest req, HttpServletResponse resp){
        Dept dept=new Dept();
        DeptBizImpl dbi=new DeptBizImpl();
        int deptno=Integer.parseInt(req.getParameter("deptno"));
        dept.setDeptno(deptno);
        boolean boo=dbi.deleteBiz(dept);
        if (boo){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }

    }
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }
}
