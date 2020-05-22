package com.zee.spring.boot.demo.dao;

import com.zee.spring.boot.demo.Student.Student;
import java.util.List;
import java.util.UUID;

public interface StudentDAO {

  int insertNewStudent(UUID studentId, Student student);

  Student selectStudentById(UUID studentId);

  List<Student> selectAllStudents();

  int updateStudentById(UUID student, Student studentUpdate);

  int deleteStudentById(UUID studentId);
}
