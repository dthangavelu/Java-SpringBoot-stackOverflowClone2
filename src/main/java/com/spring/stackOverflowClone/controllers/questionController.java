package com.spring.stackOverflowClone.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.stackOverflowClone.model.Answer;
import com.spring.stackOverflowClone.model.Question;
import com.spring.stackOverflowClone.model.Tag;
import com.spring.stackOverflowClone.service.AnswerService;
import com.spring.stackOverflowClone.service.QuestionService;
import com.spring.stackOverflowClone.service.TagService;

@Controller
public class questionController {

	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private TagService tagService;
	
	@Autowired
	private AnswerService answerService;
	
	@GetMapping("/questions")
	public String questions(Model model) {
		List<Question> allQuestions = questionService.getAllQuestions();
		model.addAttribute("allQuestions", allQuestions);
		return "questions";
	}
	
	@GetMapping("/questions/new")
	public String newQuestion(Model model) {		
		model.addAttribute("questionVal", "");
		return "newQuestion";
	}
	
	@PostMapping("/questions/new")
	public String createNewQuestion(@RequestParam(value="question") String question, @RequestParam(value="tags") String tags, Model model) {
		String[] tagsArr = tags.split(",");
		int count = 0;
		List<Tag> tagsForQuestion = new ArrayList<>();
		Question newQuestion = new Question(question);
		String tagStr = "";
		
		if(tagsArr.length > 3) {
			model.addAttribute("tags_err", "Please enter 3 or less tags, all comma separated");
			model.addAttribute("questionVal", question);
			return "newQuestion";
		}
		
		for(int i = 0; i < tagsArr.length; i++) {
			//System.out.println("tagsarr: " + tagsArr[i]);
			tagStr = tagsArr[i].toLowerCase().trim();
			count = tagService.findTagCountBySubject(tagStr);
			//System.out.println("count: " + count);
			Tag tag = new Tag(tagStr);			
			
			if(count == 0) {
				tagService.saveTag(tag);
				tagsForQuestion.add(tag);
			}else {
				tag = tagService.findTagBySubject(tagStr);
				tagsForQuestion.add(tag);
			}
		}
		newQuestion.setTags(tagsForQuestion);
		questionService.saveQuestion(newQuestion);
		return "redirect:/questions";
	}
	
	@GetMapping("/questions/{questionId}")
	public String questionDetails(@PathVariable String questionId, Model model) {		
		Question oneQuestion = questionService.getQuestionById(Long.parseLong(questionId));
		//System.out.println("quesion by id: " + oneQuestion);
		model.addAttribute("oneQuestion", oneQuestion);
		return "questionDetails";
	}
	
	@PostMapping("/questions/{questionId}")
	public String createNewAnswer(@PathVariable String questionId, @RequestParam(value="answer") String answer) {
		//System.out.println("question id in create new ans: " + questionId);
		//System.out.println("answer: " + answer);
		Question question = questionService.getQuestionById(Long.parseLong(questionId));
		Answer newAnswer = new Answer(answer);
		newAnswer.setQuestion(question);
		List<Answer> answersOfQuestion = question.getAnswers();
		//System.out.println("answser of question:  " + answersOfQuestion);
		
		answersOfQuestion.add(newAnswer);
		question.setAnswers(answersOfQuestion);
		questionService.saveQuestion(question);
		answerService.saveAnswer(newAnswer);
		return "redirect:/questions";
	}
}
