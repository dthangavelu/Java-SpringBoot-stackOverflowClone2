package com.spring.stackOverflowClone.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Question {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	@Size(min = 3)
	@Type(type="text")
	private String question;

	@Column(updatable=false)
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Date createdAt;
    
    @Column
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Date updatedAt;
        
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "question", cascade=CascadeType.REMOVE)
    private List<Answer> answers = new ArrayList<>();
    
    @ManyToMany(fetch = FetchType.LAZY)    
    @JoinTable(
    		name="tags_questions",
    		joinColumns = @JoinColumn(name="question_id"),
    		inverseJoinColumns = @JoinColumn(name="tag_id")
    		)
    private List<Tag> tags;    
    
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
    public Question() {
    	
    }
    
    public Question(String q) {
    	question = q;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
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

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", question=" + question + ", answers=" + answers + ", tags=" + tags + "]";
	}

	/*
	@Override
	public String toString() {
		return "Question [question=" + question + ", tags=" + tags + "]";
	}
	*/
			
}
