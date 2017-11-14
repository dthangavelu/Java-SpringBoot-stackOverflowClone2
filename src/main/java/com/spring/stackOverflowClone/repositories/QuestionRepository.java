package com.spring.stackOverflowClone.repositories;

import org.springframework.data.repository.CrudRepository;

import com.spring.stackOverflowClone.model.Question;

public interface QuestionRepository extends CrudRepository<Question, Long>{
	
}
