package com;

import com.DomObj.Student;
import com.dao.StudentDao;
import com.dao.StudentDaoImpl;
import com.utils.ConnectionToPostgres;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String gender = req.getParameter("gender");
        StudentDao studentDao = new StudentDaoImpl();
        ArrayList<Student> students = studentDao.selectAllStudent();
        ArrayList<Student> studentByGender = studentDao.selectStudentByGender(gender);
        req.setAttribute("studList",students);
        req.setAttribute("studentByGender",studentByGender);
        req.getRequestDispatcher("student.jsp").forward(req,resp);
    }
}
