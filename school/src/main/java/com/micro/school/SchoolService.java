package com.micro.school;

import com.micro.school.client.StudentClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepo schoolRepo;
    private final StudentClient studentClient;

    public void saveSchool(School school){
        schoolRepo.save(school);
    }


    public List<School> findAllSchool(){
        return schoolRepo.findAll();
    }

    public FullSchoolResponseDao findSchoolsWithStudents(Integer schoolId) {
        var school = schoolRepo.findById(schoolId)
                .orElse(
                        School.builder()
                                .schoolName("NOT_FOUND")
                                .email("NOT_FOUND")
                                .build()
                );
        var students = studentClient.findAllStudentsBySchool(schoolId);
        return FullSchoolResponseDao.builder()
                .name(school.getSchoolName())
                .email(school.getEmail())
                .students(students)
                .build();
    }
}
