package com.question.services.impl;

import com.question.entities.Question;
import com.question.services.QuestionService;
import java.util.List;
import com.question.repositories.QuestionRepository;

import org.springframework.stereotype.Service;


@Service

public class QuestionServiceImpl implements QuestionService{
 

private final QuestionRepository questionRepository;
public QuestionServiceImpl(QuestionRepository questionRepository) {
    this.questionRepository = questionRepository;
}

@Override
public Question create(Question question) {
    
    return questionRepository.save(question); 
}
@Override
public List<Question> get() {
    return questionRepository.findAll(); 
}       
@Override
public Question getOne(Long id) {
    return questionRepository.findById(id).orElseThrow(()-> new RuntimeException("Question not found with id: " + id)); 
}



@Override 
public List<Question> getQuestionsQuiz(Long quizId) {
    return questionRepository.findByQuizId(quizId);
}
}