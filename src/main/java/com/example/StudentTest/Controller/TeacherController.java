package com.example.StudentTest.Controller;


import com.example.StudentTest.Entity.Teacher;
import com.example.StudentTest.Entity.Train;
import com.example.StudentTest.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;


    @GetMapping
    public List<Teacher> list(){
        return teacherService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Teacher> GetTrain(@PathVariable(value = "id") String id){
        try{
            return new ResponseEntity<Teacher>(teacherService.get(id), HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Teacher>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Teacher> CreateTrain(@RequestBody Teacher teacher){
        try{
            return new ResponseEntity<Teacher>(teacherService.save(teacher),HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Teacher>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Teacher> UpdateTrain(@RequestBody Teacher teacher,@PathVariable(value = "id") String id){
        try{
            Teacher UpdateTeacher = teacherService.get(id);
            UpdateTeacher.setId_tea(teacher.getId_tea());
            UpdateTeacher.setBirthday(teacher.getBirthday());
            UpdateTeacher.setGender(teacher.getGender());
            UpdateTeacher.setFullname(teacher.getFullname());
            UpdateTeacher.setProvide(teacher.getProvide());
            UpdateTeacher.setDepart(teacher.getDepart());
            return new ResponseEntity<Teacher>(teacherService.save(UpdateTeacher),HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Teacher>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") String id){
        try{
            teacherService.delete(id);
            return ResponseEntity.ok().build();
        }catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
