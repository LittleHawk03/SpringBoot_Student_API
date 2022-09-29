package com.example.StudentTest.Service;

import com.example.StudentTest.Entity.Train;
import com.example.StudentTest.Repo.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainService {

    @Autowired
    private TrainRepository trainRepository;

    public List<Train> list(){
        return trainRepository.findAll();
    }

    public Train save(Train train){
        return trainRepository.save(train);
    }

    public Train get(String id){
        return trainRepository.findById(id).get();
    }

    public void delete(String id){
        trainRepository.deleteById(id);
    }
}
