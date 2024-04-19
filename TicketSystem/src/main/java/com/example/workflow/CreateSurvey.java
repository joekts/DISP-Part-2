package com.example.workflow;
import com.example.workflow.model.Survey;
import com.example.workflow.model.SurveyRepository;
import jakarta.inject.Named;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

@Named
public class CreateSurvey implements JavaDelegate {
    @Autowired
    private SurveyRepository surveyRepository;

    @Override
    public void execute(DelegateExecution execution) throws Exception{
        //Create survey object
        Survey survey = new Survey();

        //Find size of database
        Iterable<Survey> databaseList = surveyRepository.findAll();

        int size = 0;
        for(Object counter: databaseList){
            size++;
        }

        //Establish surveyID
        int id = size + 1;

        //Set variable in camunda environment
        execution.setVariable("surveyID", id);

        //Assign values to survey variables from form submission
        survey.setSurveyResponse(execution.getVariable("surveyResponse").toString());

        //Save survey to database
        surveyRepository.save(survey);
    }
}
