package com.LearningNavigator.Repository;

import com.LearningNavigator.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
