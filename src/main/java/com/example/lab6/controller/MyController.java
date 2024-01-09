package com.example.lab6.controller;

import com.example.lab6.entity.Student;
import com.example.lab6.exception.TestLab6Exception;
import com.example.lab6.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Student> showAllStudents() {

        List<Student> allStudents = studentService.getAllStudents();
        return allStudents;
    }

    @GetMapping("/students/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Student getStudent(@PathVariable("id") int id) {

        return studentService.getStudent(id);
    }

    @PostMapping("/students")
    @ResponseStatus(value = HttpStatus.CREATED, reason = "Student save")
    public Student saveStudent(@RequestBody Student student) throws TestLab6Exception {

            studentService.saveStudent(student);
            return student;
    }

    @PutMapping("/students")
    @ResponseStatus(value = HttpStatus.OK)
    public String updateStudent(@RequestBody Student student) {
        try {


            if (student.getId() == studentService.getStudent(student.getId()).getId()) {
                studentService.saveStudent(student);
                return "s";
            }
        } catch (NullPointerException e) {

            return "Error net studenta";
        } finally {
            studentService.saveStudent(student);
        }
        studentService.saveStudent(student);
        return "student";
    }

    @DeleteMapping("/students/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public String deleteStudent(@PathVariable("id") int id) {
        try {
            if (id == studentService.getStudent(id).getId()) {
                studentService.deleteStudent(id);
                return "done";
            } else {

                return "nope";
            }
        } catch (NullPointerException e) {

            return "error";
        }
    }
}
