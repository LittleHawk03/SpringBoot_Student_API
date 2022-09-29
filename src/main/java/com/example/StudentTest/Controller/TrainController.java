package com.example.StudentTest.Controller;

import com.example.StudentTest.Entity.Train;
import com.example.StudentTest.Service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/train")
public class TrainController {

    @Autowired
    private TrainService trainService;

    @GetMapping
    public List<Train> list(){
        return trainService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Train> GetTrain(@PathVariable(value = "id") String id){
        try{
            return new ResponseEntity<Train>(trainService.get(id), HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Train>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Train> CreateTrain(@RequestBody Train train){
        try{
            return new ResponseEntity<Train>(trainService.save(train),HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Train>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Train> UpdateTrain(@RequestBody Train train,@PathVariable(value = "id") String id){
        try{
            Train UpdateTrain = trainService.get(id);
            UpdateTrain.setId_Type(train.getId_Type());
            UpdateTrain.setNametype(train.getNametype());
            return new ResponseEntity<Train>(trainService.save(UpdateTrain),HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Train>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") String id){
        try{
            trainService.delete(id);
            return ResponseEntity.ok().build();
        }catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
