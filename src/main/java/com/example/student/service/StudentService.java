package com.example.student.service;

import com.example.student.entity.Student;
import com.example.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    public String addStudent(String firstName, String lastName, String email, String course) {

        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setEmail(email);
        student.setCourse(course);
        studentRepository.save(student);
        return "Saved!";

    }

    public Iterable<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public ResponseEntity<List<Student>> getByid(int id){
        return new ResponseEntity<>(studentRepository.findByid(id), HttpStatus.OK);
    }




}
