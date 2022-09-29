package com.example.StudentTest.Controller;


import com.example.StudentTest.Entity.Student;
import com.example.StudentTest.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping
    public List<Student> list(){
        return service.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> GetStudentByID(@PathVariable(value = "id") String id){
        try{
            Student student = service.get(id);
            return new ResponseEntity<Student>(student,HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping
    public ResponseEntity<Student> CreStudent(@RequestBody Student student){

        try {
            return new ResponseEntity<Student>(service.save(student),HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }



    @PutMapping("/{id}")
    public ResponseEntity<?> UpdateStudent(@RequestBody Student student
            ,@PathVariable(value = "id") String id){

            try {
                Student UpdateStudent = service.get(id);
                UpdateStudent.setId_Stu(student.getId_Stu());
                UpdateStudent.setFullName(student.getFullName());
                UpdateStudent.setGender(student.getGender());
                UpdateStudent.setBirthDay(student.getBirthDay());
                UpdateStudent.setProvide(student.getProvide());
                service.save(UpdateStudent);
                return new ResponseEntity<>(HttpStatus.OK);
            }catch (NoSuchElementException e){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

    }

    @PatchMapping ("/{id}/{field}")
    public ResponseEntity<Student> UpdateStudentByField(@RequestBody String StringN
            ,@PathVariable(value = "id") String id
            ,@PathVariable(value = "field") String field){

        try {
            Student UpdateStudent = service.get(id);
                if (field == "Id_Stu"){
                    UpdateStudent.setId_Stu(StringN);
                } else if (field == "FullName") {
                    UpdateStudent.setFullName(StringN);
                } else if (field == "Gender") {
                    UpdateStudent.setGender(StringN);
                }else if (field == "provide") {
                    UpdateStudent.setProvide(StringN);
                }
            service.save(UpdateStudent);
            return new ResponseEntity<Student>(UpdateStudent,HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> DeleteStudent(@PathVariable(value = "id") String id){
        try {
            service.delete(id);
            return ResponseEntity.ok().build();
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }







}
