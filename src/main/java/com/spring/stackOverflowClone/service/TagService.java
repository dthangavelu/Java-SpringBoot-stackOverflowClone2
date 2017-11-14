package com.spring.stackOverflowClone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.stackOverflowClone.model.Tag;
import com.spring.stackOverflowClone.repositories.TagRepository;

@Service
public class TagService {

	@Autowired
	private TagRepository tagRepository;
	
	public int findTagCountBySubject(String subject) {
		return tagRepository.findTagCountBySubject(subject);
	}
	
	public Tag findTagBySubject(String subject) {
		return tagRepository.findTagBySubject(subject);
	}
	
	public void saveTag(Tag tag) {
		tagRepository.save(tag);
	}
	
}
