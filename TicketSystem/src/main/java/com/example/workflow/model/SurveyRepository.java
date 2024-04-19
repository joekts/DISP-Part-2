package com.example.workflow.model;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long> {

    //Method to save ticket
    Survey save(Survey survey);

    //Method to retrieve all tickets
    List<Survey> findAll();
}
