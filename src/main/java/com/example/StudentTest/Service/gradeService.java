package com.example.StudentTest.Service;

import com.example.StudentTest.Entity.Grade;
import com.example.StudentTest.Repo.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class gradeService {

    @Autowired
    GradeRepository gradeRepository;

    public List<Grade> list(){
        return gradeRepository.findAll();
    }

    public Grade save(Grade grade){
        return gradeRepository.save(grade);
    }

    public Grade get(String id){
        return gradeRepository.findById(id).get();
    }

    public void delete(String id){
        gradeRepository.deleteById(id);
    }


}
