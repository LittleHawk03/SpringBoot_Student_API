package com.example.StudentTest.Controller;


import com.example.StudentTest.Entity.subject;
import com.example.StudentTest.Service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping
    public List<subject> list(){
        return subjectService.list();
    }

    @GetMapping("{id}")
    public ResponseEntity<subject> getDepart(@PathVariable(value = "id") String id){
        try{
            subject subject = subjectService.get(id);
            return new ResponseEntity<subject>(subject, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<subject>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<subject> CreSubject(subject subject){
        try {
            return new ResponseEntity<subject>(subjectService.save(subject),HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<subject>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<subject> UpdatePoint(@RequestBody subject subject, @PathVariable(value = "id") String id){
        try {
            subject UpdateSubject = subjectService.get(id);
            UpdateSubject.setId_Sub(subject.getId_Sub());
            UpdateSubject.setNameSubject(subject.getNameSubject());
            UpdateSubject.setSoTC(subject.getSoTC());
            return new ResponseEntity<subject>(subjectService.save(UpdateSubject),HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<subject>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> DeletePoint(@PathVariable(value = "id") String id){

        try {
            subjectService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
