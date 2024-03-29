package com.quiz.home.dtos;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateQuestionReq {
	
	    private String question;
	   
	    private String subject;
	
	    private String questionType;
	    
	   
	    private List<String> choices;
	  
	    private List<String> correctAnswers;
}
