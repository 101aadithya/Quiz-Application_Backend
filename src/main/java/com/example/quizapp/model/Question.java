package com.example.quizapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data           // to avoid writing getter and setter codes
@Entity        //This table to be mapped with the class
public class Question {

    @Id         // to set id as primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto generated
    private Integer id;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String rightAnswer;
    private String difficultyLevel;
    private String category;
}
