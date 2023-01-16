package com.example.student.controller;

import com.example.student.entity.Student;
import com.example.student.repository.StudentRepository;
import com.example.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/student")
    public @ResponseBody String addStudent(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, @RequestParam String course) {
        return studentService.addStudent(firstName, lastName, email, course);
    }

    @GetMapping(path = "/students")
    public @ResponseBody Iterable<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("student_id")
    public ResponseEntity<List<Student>> getByid(@RequestParam int id){
        return studentService.getByid(id);

    }

}

