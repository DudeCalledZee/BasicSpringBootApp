package com.zee.spring.boot.demo.dao;

import com.zee.spring.boot.demo.Student.Student;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository("mongoDb")
public class MongoDBStudentDaoImpl implements StudentDAO {

 // private final MongoDBStudentDaoImpl mongoDBStudentDao;

  @Override
  public int insertNewStudent(UUID studentId, Student student) {
    return 0;
  }

  @Override
  public Student selectStudentById(UUID studentId) {
    return null;
  }

  @Override
  public List<Student> selectAllStudents() {
    List<Student> students = new ArrayList<>();
    students.add(new Student(UUID.randomUUID(),10,"Mongo", "Database","Data base fundimentals"));
    return students;
  }

  @Override
  public int updateStudentById(UUID student, Student studentUpdate) {
    return 0;
  }

  @Override
  public int deleteStudentById(UUID studentId) {
    return 0;
  }
}
