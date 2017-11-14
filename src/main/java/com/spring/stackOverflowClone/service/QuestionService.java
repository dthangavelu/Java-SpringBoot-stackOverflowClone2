package com.spring.stackOverflowClone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.stackOverflowClone.model.Question;
import com.spring.stackOverflowClone.repositories.QuestionRepository;

@Service
public class QuestionService {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	public List<Question> getAllQuestions(){
		return (List<Question>) questionRepository.findAll();
	}
	
	public void saveQuestion(Question q) {
		questionRepository.save(q);
	}

	public Question getQuestionById(Long id) {
		return questionRepository.findOne(id);
	}
}
