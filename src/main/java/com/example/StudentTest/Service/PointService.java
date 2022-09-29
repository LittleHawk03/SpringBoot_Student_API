package com.example.StudentTest.Service;

import com.example.StudentTest.Entity.Point;
import com.example.StudentTest.Entity.PointID;
import com.example.StudentTest.Entity.Student;
import com.example.StudentTest.Repo.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PointService {

    @Autowired
    PointRepository pointRepository;


    public List<Point> list(){
        return pointRepository.findAll();
    }

    public List<Point> listAllByIdStu(String id){
        return pointRepository.findAllId(id);
    }

    public Point get(String id){
        return pointRepository.findById(id).get();
    }

    public Point save(Point point){
        return pointRepository.save(point);
    }

    public void deletePoint(String id){
        pointRepository.deleteById(id);
    }
}
