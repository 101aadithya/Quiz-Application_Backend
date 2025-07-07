package com.example.quizapp.service;

import com.example.quizapp.model.Question;
import com.example.quizapp.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<List<Question>>getAllQuestions(){
       try {
           //creating an object of response entity
           return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
           // with response entity were sending the data and the status code
       }catch (Exception e)
       {
           e.printStackTrace();
       }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
       //if something goes wrong ,were returning an empty array with status code bad request

    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        try {
            return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        //if something goes wrong ,were returning an empty array with status code bad request


    }


    public ResponseEntity<String> addQuestion(Question question) {
        questionDao.save(question); //add question to DB
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
        //Since were adding data on the server status is CREATED
        //It shows 201 Created in the postman when we add a question
    }
}
