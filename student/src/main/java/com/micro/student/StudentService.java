package com.micro.student;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ProblemDetail;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepo studentRepo;


    public void saveStudent(Student student){
        studentRepo.save(student);
    }


    public List<Student> findAllStudent(){
        return studentRepo.findAll();
    }

    public List<Student> findAllStudentsBySchool(Integer schoolId) {
        return studentRepo.findAllBySchoolId(schoolId);
    }
}
