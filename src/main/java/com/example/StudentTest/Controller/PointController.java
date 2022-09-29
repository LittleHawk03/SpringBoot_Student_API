package com.example.StudentTest.Controller;


import com.example.StudentTest.Entity.Point;
import com.example.StudentTest.Entity.PointID;
import com.example.StudentTest.Service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/point")
public class PointController {

    @Autowired
    private PointService pointService;


    @GetMapping
    public List<Point> list(){
        return pointService.list();
    }



    @GetMapping("/{id}")
    public ResponseEntity<List<Point>> GetPoint(@PathVariable(value = "id") String id){
        try {
            return new ResponseEntity<List<Point>>(pointService.listAllByIdStu(id), HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<List<Point>>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Point> CrePoint(Point point){
        try {
            return new ResponseEntity<Point>(pointService.save(point),HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Point>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Point> UpdatePoint(@RequestBody Point point,@PathVariable(value = "id") String id){
        try {
            Point UpdatePoint = pointService.get(id);
            UpdatePoint.setIdStu(point.getStuId());
            UpdatePoint.setIdSub(point.getSubID());
            UpdatePoint.setPoint(point.getPoint());
            UpdatePoint.setTerm(point.getTerm());
            return new ResponseEntity<Point>(pointService.save(UpdatePoint),HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Point>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> DeletePoint(@PathVariable(value = "id") String id){

        try {
            pointService.deletePoint(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
