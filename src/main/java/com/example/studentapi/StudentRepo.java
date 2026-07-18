package com.example.studentapi;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, String>{

}
