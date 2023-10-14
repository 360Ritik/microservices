package com.micro.student;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {



    private final StudentService studentService;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public  void save(@RequestBody Student student){
        studentService.saveStudent(student);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Student>> findAllStudents(){
        return ResponseEntity.ok(studentService.findAllStudent());
    }


    @GetMapping("/school/{school-id}")
    public ResponseEntity<List<Student>> findAllStudents(
            @PathVariable("school-id") Integer schoolId) {
        return ResponseEntity.ok(studentService.findAllStudentsBySchool(schoolId));
    }


}
