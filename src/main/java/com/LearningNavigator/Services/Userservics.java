package com.LearningNavigator.Services;

import com.LearningNavigator.Dto.RequestBoddyforSubject;
import com.LearningNavigator.Dto.RequestbodyExam;
import com.LearningNavigator.Entities.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface Userservics {
    public ResponseEntity<String> CreateUser(Student student);
    public ResponseEntity<String> RegisterSubject(RequestBoddyforSubject requestBoddyforSubject);
    public ResponseEntity<String> RegisterExam(RequestbodyExam requestbodyExam);
}
