package com.example.StudentTest.Controller;

import com.example.StudentTest.Entity.Course;
import com.example.StudentTest.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Course> list(){
        return courseService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> GetCourse(@PathVariable(value = "id") String id){
        try {
            Course course = courseService.get(id);
            if (course != null)
                return new ResponseEntity<Course>(course, HttpStatus.OK);
            else
                return new ResponseEntity<Course>(HttpStatus.NOT_FOUND);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Course>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<?> CreatCourse(@RequestBody Course course){
        try{
            return new ResponseEntity<Course>(courseService.Save(course),HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Course>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> UpdateCourse(@RequestBody Course course,@PathVariable(value = "id") String id){
        try{
            Course UpdateCourse = courseService.get(id);
            UpdateCourse.setId_Cource(course.getId_Cource());
            UpdateCourse.setNamecource(course.getNamecource());
            return new ResponseEntity<Course>(courseService.Save(UpdateCourse),HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Course>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable(value = "id") String id){
        try {
            courseService.delete(id);
            return ResponseEntity.ok().build();
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
