package com.LearningNavigator.Services;

import com.LearningNavigator.Entities.Exam;
import com.LearningNavigator.Entities.Subject;
import org.springframework.stereotype.Service;

@Service
public interface AdminServices {
    public  String createSubject(Subject subject);
    public  String createExam(Exam subject);
}
