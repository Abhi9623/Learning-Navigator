package com.LearningNavigator.Repository;

import com.LearningNavigator.Entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository  extends JpaRepository<Subject,Long> {
}
