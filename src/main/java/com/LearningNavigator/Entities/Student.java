package com.LearningNavigator.Entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "studentList")
    private List<Subject> subjectList;

    @ManyToMany(mappedBy = "studentList")
    private List<Exam> examList;
}
