package com.example.studentapi;

import java.util.List;

public interface StudentService {
    Student save(Student student);

    List<Student> getAll();

    Student getById(String id);

    Student update(String id, Student student);

    void delete(String id);

}
