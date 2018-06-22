package com.dao;

import com.DomObj.Student;

import java.util.ArrayList;

public interface StudentDao {
     ArrayList<Student> selectAllStudent();
     ArrayList<Student> selectStudentByGender(String gender);

}
