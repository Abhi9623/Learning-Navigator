package com.LearningNavigator.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestbodyExam {
    private String studentId;
    private String examId;
}
