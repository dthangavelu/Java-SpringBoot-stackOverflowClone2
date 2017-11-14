package com.spring.stackOverflowClone.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.spring.stackOverflowClone.model.Tag;

public interface TagRepository extends CrudRepository<Tag, Long> {

	//@Query("SELECT COUNT(*) FROM Tag t WHERE t.subject = ?1")
	@Query(value="SELECT COUNT(*) FROM tag t WHERE t.subject = ?1", nativeQuery=true)
	int findTagCountBySubject(String subject);

	@Query(value="SELECT * FROM tag t WHERE t.subject = ?1", nativeQuery=true)
	Tag findTagBySubject(String subject);

}
