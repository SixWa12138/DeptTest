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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        int i = Integer.parseInt(request.getParameter("i"));
        if (i==1){

        }else if (i==4){
            delete(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

    }
    public void delete(HttpServletRequest request, HttpServletResponse response) {
        Dept dept = new Dept();
        DeptBizImpl dbi = new DeptBizImpl();
        int deptno = Integer.parseInt(request.getParameter("deptno"));
        dept.setDeptno(deptno);
        boolean boo = dbi.removeBiz(dept);
        if (boo) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.service(request, response);
    }

    public void register(){

    }

    public void login(){

    }

    public void query(){

    }

    public void update(){

    }

    public void queryOne(){

    }
}
