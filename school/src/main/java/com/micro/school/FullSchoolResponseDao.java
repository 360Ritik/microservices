package com.micro.school;

import java.util.List;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FullSchoolResponseDao {
   private String name;
   private String email;
   List<Student> students;
}
