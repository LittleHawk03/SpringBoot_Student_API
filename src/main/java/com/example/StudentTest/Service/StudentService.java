package com.example.StudentTest.Service;

import com.example.StudentTest.Entity.Student;
import com.example.StudentTest.Repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> list(){
        return studentRepository.findAll();
    }

    public Student save(Student student){
        return studentRepository.save(student);
    }

    public Student get(String id){
        return studentRepository.findById(id).get();
    }

    public void delete(String id){
        studentRepository.deleteById(id);
    }
}
