package com.example.StudentTest.Service;

import com.example.StudentTest.Entity.Train;
import com.example.StudentTest.Entity.subject;
import com.example.StudentTest.Repo.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public List<subject> list(){
        return subjectRepository.findAll();
    }

    public subject save(subject subjecta){
        return subjectRepository.save(subjecta);
    }

    public subject get(String id){
        return subjectRepository.findById(id).get();
    }

    public void delete(String id){
        subjectRepository.deleteById(id);
    }
}
