package com.example.StudentTest.Controller;

import com.example.StudentTest.Entity.Grade;
import com.example.StudentTest.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.StudentTest.Service.gradeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/grade")
public class GradeController {

    @Autowired
    private gradeService gradeService;

    @GetMapping
    public List<Grade> gradeList(){
        return gradeService.list();
    }

    @GetMapping("{id}")
    public ResponseEntity<Grade> getGradeByID(@PathVariable(value = "id") String id){
        try {
            Grade grade = gradeService.get(id);
            return new ResponseEntity<Grade>(grade,HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Grade>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Grade> CreStudent(@RequestBody Grade grade){
        try {
            return new ResponseEntity<Grade>(gradeService.save(grade),HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Grade>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Grade> UpdateGrade(@RequestBody Grade grade,
                                         @PathVariable(value = "id") String id){
        try{
            Grade UpadteGrade = gradeService.get(id);
            UpadteGrade.setId_Grade(grade.getId_Grade());
            UpadteGrade.setNameclass(grade.getNameclass());
            UpadteGrade.setCource(grade.getCource());
            UpadteGrade.setDepart(grade.getDepart());
            UpadteGrade.setTrain(grade.getTrain());
            return new ResponseEntity<>(gradeService.save(UpadteGrade),HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> DeleteGrade(@PathVariable(value = "id") String id){
        try{
            gradeService.delete(id);
            return ResponseEntity.ok().build();
        }catch (NoSuchElementException e){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    



}
