package com.LearningNavigator.Controller;

import com.LearningNavigator.Entities.Exam;
import com.LearningNavigator.Entities.Subject;
import com.LearningNavigator.Services.AdminServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminServices adminService;

    // POST endpoint to create a subject
    @PostMapping("/subjects")
    public String createSubject(@RequestBody Subject subject) {
        return adminService.createSubject(subject);
    }

    // POST endpoint to create an exam
    @PostMapping("/exams")
    public String createExam(@RequestBody Exam exam) {

        return adminService.createExam(exam);
    }
}
