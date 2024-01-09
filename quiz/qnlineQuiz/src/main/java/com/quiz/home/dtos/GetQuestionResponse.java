package com.quiz.home.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetQuestionResponse {
private String question;
    
    private String subject;
    
    private String questionType;

}
