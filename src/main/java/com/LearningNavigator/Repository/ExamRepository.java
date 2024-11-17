package com.LearningNavigator.Repository;

import com.LearningNavigator.Entities.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<Exam,Long> {
}
