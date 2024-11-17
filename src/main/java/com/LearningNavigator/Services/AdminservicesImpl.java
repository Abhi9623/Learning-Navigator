package com.LearningNavigator.Services;

import com.LearningNavigator.Entities.Exam;
import com.LearningNavigator.Entities.Subject;
import com.LearningNavigator.Repository.ExamRepository;
import com.LearningNavigator.Repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class AdminservicesImpl  implements  AdminServices{

    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private ExamRepository examRepository;
    @Override
    public String createSubject(Subject subject) {
        // Create a new subject with the name from the request and initialize the studentList as empty
        Subject subject1 = Subject.builder()
                .name(subject.getName())
                .studentList(Collections.emptyList()) // Initialize studentList as empty
                .build();

        // Save the new subject to the repository
        subjectRepository.save(subject1);

        return "Subject Saved Successfully";
    }


    @Override
    public String createExam(Exam exam) {
        // Get the Subject object from the subject ID
        Subject subject = subjectRepository.findById(exam.getSubject().getId())
                .orElseThrow(() -> new RuntimeException("Subject not found"));

        // Set the subject for the exam
        exam.setSubject(subject);

        // Save the exam with an empty student list (if no students are added yet)
        examRepository.save(exam);

        return "Exam created successfully";
    }

}
