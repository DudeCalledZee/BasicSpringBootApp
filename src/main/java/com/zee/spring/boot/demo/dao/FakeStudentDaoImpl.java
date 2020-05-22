package com.zee.spring.boot.demo.dao;

import com.zee.spring.boot.demo.Student.Student;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository("fakeDao")
public class FakeStudentDaoImpl implements StudentDAO {

  private final Map<UUID, Student> database;

  public FakeStudentDaoImpl() {
    database = new HashMap<>();
    UUID uuid = UUID.randomUUID();
    database.put(uuid, new Student(uuid,10,"bob","flowers","Maths"));
  }

  @Override
  public int insertNewStudent(UUID studentId, Student student) {
    database.put(studentId, student);
    return 1;
  }

  @Override
  public Student selectStudentById(UUID studentId) {
    return database.get(studentId);
  }

  @Override
  public List<Student> selectAllStudents() {
    return new ArrayList(database.values());
  }

  @Override
  public int updateStudentById(UUID student, Student studentUpdate) {
    database.put(student, studentUpdate);
    return 1;
  }

  @Override
  public int deleteStudentById(UUID studentId) {
    database.remove(studentId);
    return 1;
  }
}
