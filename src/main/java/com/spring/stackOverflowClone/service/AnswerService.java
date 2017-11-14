package com.spring.stackOverflowClone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.stackOverflowClone.model.Answer;
import com.spring.stackOverflowClone.repositories.AnswerRepository;

@Service
public class AnswerService {
	
	@Autowired
	private AnswerRepository answerRepository;
	
	public void saveAnswer(Answer ans) {
		answerRepository.save(ans);
	}

}
