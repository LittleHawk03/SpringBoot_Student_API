package com.example.StudentTest.Service;


import com.example.StudentTest.Entity.Depart;
import com.example.StudentTest.Repo.DepartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartService {

    @Autowired
    DepartRepository departRepository;

    public List<Depart> list(){
        return departRepository.findAll();
    }

    public Depart save(Depart depart){
        return departRepository.save(depart);
    }

    public Depart get(String id){
        return departRepository.findById(id).get();
    }

    public void delete(String id){
        departRepository.deleteById(id);
    }
}
