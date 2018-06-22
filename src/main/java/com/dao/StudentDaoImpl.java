package com.dao;

import com.DomObj.Student;
import com.utils.ConnectionToPostgres;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public final class StudentDaoImpl implements StudentDao {

    Connection connection = ConnectionToPostgres.createConnection();
    ArrayList<Student> students = new ArrayList<>();
    ArrayList<Student> studentbygender = new ArrayList<>();
    @Override
    public ArrayList<Student> selectAllStudent() {
        PreparedStatement pr = null;
        try {
            pr = connection.prepareStatement("SELECT * FROM student2");
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                Student student = new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                students.add(student);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public ArrayList<Student> selectStudentByGender(String gender) {
        PreparedStatement pr = null;
        try {
            pr = connection.prepareStatement("SELECT * FROM student2 WHERE gender LIKE ?");
            pr.setString(1,gender);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                Student student = new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                studentbygender.add(student);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return studentbygender;
    }
}
