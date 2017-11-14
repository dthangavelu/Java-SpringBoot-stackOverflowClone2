package com.spring.stackOverflowClone.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Tag {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(unique=true)
	@Size(min = 1, max=255)	
	private String subject;

	@Column(updatable=false)
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Date createdAt;
    
    @Column
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Date updatedAt;
  
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    		name="tags_questions",
    		joinColumns = @JoinColumn(name="tag_id"),
    		inverseJoinColumns = @JoinColumn(name="question_id")
    		)
    private List<Question> questions;
    
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
    public Tag() {
    	
    }
    
    public Tag(String sub) {
    	subject = sub;
    }
    
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	/*
	@Override
	public String toString() {
		return "Tag [id=" + id + ", subject=" + subject + ", questions=" + questions + "]";
	}
	*/

	
	@Override
	public String toString() {
		return "Tag [subject=" + subject +"]";
	}

	
}
