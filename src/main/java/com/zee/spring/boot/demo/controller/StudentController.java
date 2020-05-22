package com.zee.spring.boot.demo.controller;

import com.zee.spring.boot.demo.Student.Student;
import com.zee.spring.boot.demo.service.StudentService;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/students")
public class StudentController {

  private final StudentService studentService;

  @Autowired
  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping
  public List<Student> getAllStudents() {
    return studentService.getAllStudents();
  }

  @GetMapping(path = "{studentId}")
  public Student getStudentById(@PathVariable("studentId") UUID studentId) {
    return studentService.getStudentById(studentId);
  }

  @PostMapping
  public void addNewStudent(@RequestBody Student student) {
    studentService.persistNewStudent(UUID.randomUUID(), student);
  }

  @PutMapping(path = "{studentId}")
  public void updateStudent(@PathVariable("studentId") UUID studentId, @RequestBody Student student) {
    studentService.updateStudentById(studentId,student);
  }


  @DeleteMapping(path = "{studentId}")
  public void deleteStudentById(@PathVariable("studentId") UUID studentId) {
     studentService.deleteStudentById(studentId);
  }

}
