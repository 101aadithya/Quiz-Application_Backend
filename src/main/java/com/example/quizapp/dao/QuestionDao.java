package com.example.quizapp.dao;

import com.example.quizapp.model.Question;
import com.example.quizapp.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {
    //JpaRepository fetches data from database
    List<Question> findByCategory(String category);

    //JPA is smart enough to know that user is trying to get data with a particular category
    //because findBy'Category'() this category is a field of the table

    @Query(value = "SELECT * FROM question q Where q.category=:category ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category,int numQ);


}
