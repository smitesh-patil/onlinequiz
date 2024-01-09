package com.quiz.home.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.quiz.home.dtos.AddQuestion;
import com.quiz.home.dtos.GetByIDResponse;
import com.quiz.home.dtos.GetQuestionResponse;
import com.quiz.home.dtos.UpdateQuestionReq;
import com.quiz.home.pojos.Question;
import com.quiz.home.repositories.QuestionRepositories;

import jakarta.transaction.Transactional;

@Service
@Transactional
//@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepositories qrepo;
	
	@Autowired
	private ModelMapper mapper;
	
	
	@Override
	public Question createQuestion(Question ques) {
		// TODO Auto-generated method stub
//		return qrepo.save(mapper.map(ques, Question.class));
		return qrepo.save(ques);
	}

	@Override
	public List<GetQuestionResponse> getAllQuestions() {
		// TODO Auto-generated method stub
		List<Question> q=qrepo.findAll();
		List<GetQuestionResponse> gq=new ArrayList<GetQuestionResponse>();
		for(Question qs:q)
		{
			GetQuestionResponse gt=new GetQuestionResponse(qs.getQuestion(),qs.getQuestionType(),qs.getSubject());
			gq.add(gt);
		}
		return gq;
	}

	@Override
	public Optional<GetByIDResponse> getQuestionById(Long id) {
		// TODO Auto-generated method stub
		Optional<Question> q=qrepo.findById(id);
		GetByIDResponse g=new GetByIDResponse();
		g.setQuestion(q.get().getQuestion());
		g.setQuestionType(q.get().getQuestionType());
		g.setSubject(q.get().getSubject());
		return Optional.of(g);
	}

	@Override
	public List<String> getAllSubjects() {
		// TODO Auto-generated method stub
		return qrepo.findDistinctSubject();
	}

	@Override
	public Question updateQuestion(Long id, UpdateQuestionReq question) throws ChangeSetPersister.NotFoundException {
		// TODO Auto-generated method stub
		 Optional<Question> theQuestion = this.getQuestionByIid(id);
		 if (theQuestion.isPresent()){
	            Question updatedQuestion = theQuestion.get();
	            updatedQuestion.setQuestion(question.getQuestion());
	            updatedQuestion.setChoices(question.getChoices());
	            updatedQuestion.setCorrectAnswers(question.getCorrectAnswers());
	            return qrepo.save(updatedQuestion);
	        }
		 else
		 {
			 throw new ChangeSetPersister.NotFoundException();
		 }
		
	}

	@Override
	public void deleteQuestion(Long id) {
		// TODO Auto-generated method 
		qrepo.deleteById(id);

	}

	@Override
	public List<Question> getQuestionsForUser(Integer numOfQuestions, String subject) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(0, numOfQuestions);
        return qrepo.findBySubject(subject, pageable).getContent();
		//return null;
	}

	@Override
	public Optional<Question> getQuestionByIid(Long id) {
		// TODO Auto-generated method stub
	return qrepo.findById(id);
	}

}