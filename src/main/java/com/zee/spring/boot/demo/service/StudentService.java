package com.zee.spring.boot.demo.service;

import com.zee.spring.boot.demo.Student.Student;
import com.zee.spring.boot.demo.dao.StudentDAO;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

  private final StudentDAO studentDAO;

  @Autowired
  public StudentService(@Qualifier("mongoDb") StudentDAO studentDAO) {
    this.studentDAO = studentDAO;
  }

  public int persistNewStudent(UUID studentId, Student student) {
    UUID newStudentUUID = studentId == null ? UUID.randomUUID() : studentId;
    student.setId(newStudentUUID);
    return studentDAO.insertNewStudent(newStudentUUID, student);
  }

  public Student getStudentById(UUID studentId) {
    return studentDAO.selectStudentById(studentId);
  }

  public List<Student> getAllStudents() {
    return studentDAO.selectAllStudents();
  }

  public int updateStudentById(UUID studentId, Student studentUpdate) {
    return studentDAO.updateStudentById(studentId, studentUpdate);
  }

  public int deleteStudentById(UUID studentId) {
    Student student = getStudentById(studentId);
    return studentDAO.deleteStudentById(studentId);
  }
}
