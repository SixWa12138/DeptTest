package com.sm.server;

import com.sm.biz.impl.DeptBizImpl;
import com.sm.entry.Dept;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ts")
public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        int i = Integer.parseInt(request.getParameter("i"));
        if (i==1){
            register(request,response);
        }else if (i==2){
            login(request,response);
        }else if (i==3){
            query(request,response);
        }else if (i==4){
            delete(request,response);
        }else if (i==5){
            revise(request,response);
        }else if (i==6){
            queryOne(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        int i = Integer.parseInt(request.getParameter("i"));
        if (i==1){
            register(request,response);
        }else if (i==2){
            login(request,response);
        }else if (i==3){
            query(request,response);
        }else if (i==4){
            delete(request,response);
        }else if (i==5){
            revise(request,response);
        }else if (i==6){
            queryOne(request,response);
        }
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.service(request, response);
    }

    public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        int deptno = Integer.parseInt(request.getParameter("deptno"));
        String dname = request.getParameter("dname");
        String loc = request.getParameter("loc");
        DeptBizImpl dbi = new DeptBizImpl();
        Dept dept = new Dept(deptno,dname,loc);
        boolean boo = dbi.registerBiz(dept);
        if (boo){
            System.out.println("????????????");
            response.sendRedirect("login.jsp");
        }else {
            response.getWriter().println("????????????");
            response.getWriter().println("<a href='register.jsp'>????????????</a>");
        }
    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        int deptno = Integer.parseInt(request.getParameter("deptno"));
        String dname = request.getParameter("dname");
        DeptBizImpl dbi = new DeptBizImpl();
        Dept dept = new Dept();
        dept.setDeptno(deptno);
        dept.setDname(dname);
        boolean boo = dbi.loginBiz(dept);
        if (boo){
            System.out.println("????????????");
            response.sendRedirect("ts?i=3");
        }else {
            System.out.println("????????????");
            response.getWriter().println("?????????????????????????????????");
            response.sendRedirect("ts?i=2");
        }
    }

    public void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        DeptBizImpl dbi = new DeptBizImpl();
        List<Dept> list = dbi.queryBiz();
        HttpSession session = request.getSession();
        session.setAttribute("queryAllList",list);
        response.sendRedirect("query.jsp");
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Dept dept = new Dept();
        DeptBizImpl dbi = new DeptBizImpl();
        int deptno = Integer.parseInt(request.getParameter("deptno"));
        dept.setDeptno(deptno);
        boolean boo = dbi.removeBiz(dept);
        if (boo) {
            System.out.println("????????????");
            response.sendRedirect("ts?i=3");
        } else {
            System.out.println("????????????");
            response.sendRedirect("ts?i=3");
        }
    }

    public void revise(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("textcml;charset=utf-8");
        int deotno = Integer.parseInt(request.getParameter("deptno"));
        String dname = request.getParameter("dname");
        String loc = request.getParameter("loc");
        DeptBizImpl dbi = new DeptBizImpl();
        Dept dept = new Dept();
        dept.setDeptno(deotno);
        dept.setDname(dname);
        dept.setLoc(loc);
        boolean boo = dbi.reviseBiz(dept);
        if (boo){
            System.out.println("????????????");
            response.sendRedirect("ts?i=3");
        }else {
            System.out.println("????????????");
            response.sendRedirect("revise.jsp");
        }
    }

    public void queryOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        int deptno = Integer.parseInt(request.getParameter("deptno"));
        String dname = request.getParameter("dname");
        Dept d = new Dept(deptno,dname,null);
        DeptBizImpl dbi = new DeptBizImpl();
        Dept dept = dbi.queryOneBiz(d);
        List<Dept> list = new ArrayList<>();
        list.add(dept);
        HttpSession session = request.getSession();
        session.setAttribute("queryOneList",list);
        response.sendRedirect("revise.jsp");
    }
}
