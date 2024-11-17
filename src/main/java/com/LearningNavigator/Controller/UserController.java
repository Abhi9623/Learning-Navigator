package com.LearningNavigator.Controller;

import com.LearningNavigator.Dto.RequestBoddyforSubject;
import com.LearningNavigator.Dto.RequestbodyExam;
import com.LearningNavigator.Entities.Student;
import com.LearningNavigator.Services.EasternEgg;
import com.LearningNavigator.Services.Userservics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private Userservics userservics;

    @Autowired
    private EasternEgg easternEgg;

    @PostMapping("/createuser")
    public ResponseEntity<String> CreateUser(@RequestBody Student student){
        return userservics.CreateUser(student);
    }

    @PostMapping("/register-subject")
    public ResponseEntity<String> RegisterForSubject(@RequestBody RequestBoddyforSubject requestBoddyforSubject){
          return userservics.RegisterSubject(requestBoddyforSubject);
    }
    @PostMapping("/register-exam")
    public  ResponseEntity<String> RegisteforExam(@RequestBody RequestbodyExam requestbodyExam){
        return userservics.RegisterExam(requestbodyExam);
    }
    @GetMapping("/hidden-feature/{num}")
    public String EasterEgg(@PathVariable String num) {
        return easternEgg.EasterEgg(num);
    }

}
