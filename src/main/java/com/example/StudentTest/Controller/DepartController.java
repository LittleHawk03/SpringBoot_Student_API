package com.example.StudentTest.Controller;

import com.example.StudentTest.Entity.Depart;
import com.example.StudentTest.Entity.Point;
import com.example.StudentTest.Entity.Student;
import com.example.StudentTest.Service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/depart")
public class DepartController {

    @Autowired
    private DepartService departService;

    @GetMapping
    public List<Depart> list(){
        return departService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Depart> getDepart(@PathVariable(value = "id") String id){
        try{
            Depart depart = departService.get(id);
            return new ResponseEntity<Depart>(depart, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Depart>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Depart> CreDepart(Depart depart){
        try {
            return new ResponseEntity<Depart>(departService.save(depart),HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Depart>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Depart> UpdatePoint(@RequestBody Depart depart,@PathVariable(value = "id") String id){
        try {
            Depart UpdateDepart = departService.get(id);
            UpdateDepart.setId_depart(depart.getId_depart());
            UpdateDepart.setNamedepart(depart.getNamedepart());
            UpdateDepart.setAddress(depart.getAddress());
            UpdateDepart.setPhone(depart.getPhone());
            return new ResponseEntity<Depart>(departService.save(UpdateDepart),HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Depart>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> DeletePoint(@PathVariable(value = "id") String id){

        try {
            departService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
