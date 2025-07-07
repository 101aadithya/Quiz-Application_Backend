package com.example.quizapp.controller;

import com.example.quizapp.model.Question;
import com.example.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  //because we want to accept request
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){

        return questionService.getAllQuestions(); //controller tells the user to get all the questions

    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
        //Path variable to assign the keyword in the URL
        return questionService.getQuestionsByCategory(category);

    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
    //RequestBody because were sending data from client side to server side
        return questionService.addQuestion(question);
    }
}
