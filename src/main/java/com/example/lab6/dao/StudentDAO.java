package com.example.lab6.dao;

import com.example.lab6.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentDAO {

    List<Student> getAllStudents();

    Student getStudent(int id);

    Student saveStudent(Student student);

    void deleteStudent(int id);
}
