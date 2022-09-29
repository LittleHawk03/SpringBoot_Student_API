package com.example.StudentTest.Service;

import com.example.StudentTest.Entity.Course;
import com.example.StudentTest.Repo.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courceRepository;


    public List<Course> list(){
        return courceRepository.findAll();
    }

    public Course get(String id){
        return courceRepository.findById(id).get();
    }

    public Course Save(Course cource){
        return courceRepository.save(cource);
    }

    public void delete(String id){
        courceRepository.deleteById(id);
    }
}
