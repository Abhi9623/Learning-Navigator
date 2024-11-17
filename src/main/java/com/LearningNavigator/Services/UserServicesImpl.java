package com.LearningNavigator.Services;

import com.LearningNavigator.Dto.RequestBoddyforSubject;
import com.LearningNavigator.Dto.RequestbodyExam;
import com.LearningNavigator.Entities.Exam;
import com.LearningNavigator.Entities.Student;
import com.LearningNavigator.Entities.Subject;
import com.LearningNavigator.Exceptions.ResourceNotFoundException;
import com.LearningNavigator.Repository.ExamRepository;
import com.LearningNavigator.Repository.StudentRepository;
import com.LearningNavigator.Repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserServicesImpl  implements  Userservics {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private ExamRepository examRepository;

    @Override
    public ResponseEntity<String> CreateUser(Student student) {
        Student student1 = Student.builder().name(student.getName()).
                examList(new ArrayList<>()).subjectList(new ArrayList<>()).build();
        studentRepository.save(student1);
        return ResponseEntity.status(HttpStatus.CREATED).body("User Created");


    }

    @Override
    public ResponseEntity<String> RegisterSubject(RequestBoddyforSubject requestBoddyforSubject) {

        Long studentIdLong = Long.parseLong(requestBoddyforSubject.getStudenId());  // Convert student ID to Long
        Long subjectIdLong = Long.parseLong(requestBoddyforSubject.getSubjectId()); // Convert subject ID to Long

        Optional<Student> studentOptional = studentRepository.findById(studentIdLong);
        Optional<Subject> subjectOptional = subjectRepository.findById(subjectIdLong);
        if (!studentOptional.isPresent()) {
            ResponseEntity.notFound();
        }
        if (!subjectOptional.isPresent()) {
            ResponseEntity.notFound();
        }

        Student student = studentOptional.get();
        Subject subject = subjectOptional.get();

        student.getSubjectList().add(subject);
        subject.getStudentList().add(student);

        studentRepository.save(student);
        subjectRepository.save(subject);

        return ResponseEntity.ok("Subject ADDED");
    }

    @Override
    public ResponseEntity<String> RegisterExam(RequestbodyExam requestbodyExam) {
        Long studentIdLong = Long.parseLong(requestbodyExam.getStudentId());
        Long examIdLong = Long.parseLong(requestbodyExam.getExamId());

        // Validate Student and Exam
        Optional<Student> studentOptional = studentRepository.findById(studentIdLong);
        Optional<Exam> examOptional = examRepository.findById(examIdLong);

        if (!studentOptional.isPresent()) {
            throw new ResourceNotFoundException("Resource not Fount");
        }
        if (!examOptional.isPresent()) {
            throw new ResourceNotFoundException("Resource not Fount");
        }

        Student student = studentOptional.get();
        Exam exam = examOptional.get();

        // Fetch the subject for the exam
        Subject subject = exam.getSubject();
        if (subject == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Exam does not have a valid subject");
        }

        // Check if the student is registered for the subject
        if (!subject.getStudentList().contains(student)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Student is not registered for the subject");
        }

        // Register the student for the exam if not already registered
        if (!exam.getStudentList().contains(student)) {
            exam.getStudentList().add(student);
            examRepository.save(exam);
        }

        return ResponseEntity.ok("Student registered for the exam successfully");
    }
}

