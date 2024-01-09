package com.quiz.home.dtos;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddQuestion {
	@NotBlank
    private String question;
    @NotBlank
    private String subject;
    @NotBlank
    private String questionType;
}
