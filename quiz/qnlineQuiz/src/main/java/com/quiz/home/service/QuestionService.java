package com.quiz.home.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.crossstore.ChangeSetPersister;

import com.quiz.home.dtos.AddQuestion;
import com.quiz.home.dtos.GetByIDResponse;
import com.quiz.home.dtos.GetQuestionResponse;
import com.quiz.home.dtos.UpdateQuestionReq;
import com.quiz.home.pojos.Question;

public interface QuestionService {
	Question createQuestion(Question ques);

	List<GetQuestionResponse> getAllQuestions();

	Optional<GetByIDResponse> getQuestionById(Long id);
	Optional<Question> getQuestionByIid(Long id);

	List<String> getAllSubjects();

	Question updateQuestion(Long id, UpdateQuestionReq question) throws ChangeSetPersister.NotFoundException ;

	void deleteQuestion(Long id);

	List<Question> getQuestionsForUser(Integer numOfQuestions, String subject);

}