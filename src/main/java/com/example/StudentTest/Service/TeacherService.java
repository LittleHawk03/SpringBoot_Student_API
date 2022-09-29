package com.example.StudentTest.Service;

import com.example.StudentTest.Entity.Teacher;
import com.example.StudentTest.Entity.Train;
import com.example.StudentTest.Repo.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public List<Teacher> list(){
        return teacherRepository.findAll();
    }

    public Teacher save(Teacher teacher){
        return teacherRepository.save(teacher);
    }

    public Teacher get(String id){
        return teacherRepository.findById(id).get();
    }

    public void delete(String id){
        teacherRepository.deleteById(id);
    }

}
