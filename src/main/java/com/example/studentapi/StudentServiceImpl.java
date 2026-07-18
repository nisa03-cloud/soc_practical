package com.example.studentapi;

import com.example.studentapi.Student;
import com.example.studentapi.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepository;

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student getById(String id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }

    @Override
    public Student update(String id, Student student) {
        Student existing = getById(id);
        existing.setName(student.getName());
        existing.setEmail(student.getEmail());
        existing.setAge(student.getAge());
        return studentRepository.save(existing);
    }

    @Override
    public void delete(String id) {
        studentRepository.deleteById(id);
    }
}