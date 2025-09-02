package com.question.controllers;


import com.question.entities.Question;
import java.util.List;

import com.question.services.QuestionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/questions")
public class QuestionController {

    private QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }




    //create

    @PostMapping
    public Question create( @RequestBody Question question) {
        return questionService.create(question);
    }



    //get all
    @GetMapping
    public List <Question> getAll() {
        return questionService.get();    
}


//get all
@GetMapping("/{questionId}")
    public Question getAll(@PathVariable Long questionId) {
        return questionService.getOne(questionId);    
}


//get all questions of a quiz
    @GetMapping("/quiz/{quizId}")
    public List<Question> getQuestionsQuiz(@PathVariable Long quizId) {
        return questionService.getQuestionsQuiz(quizId);
    }
}