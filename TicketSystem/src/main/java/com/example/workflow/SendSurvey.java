package com.example.workflow;
import com.example.workflow.model.Survey;
import com.example.workflow.model.SurveyRepository;
import jakarta.inject.Named;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

@Named
public class SendSurvey implements JavaDelegate {
    @Autowired
    private SurveyRepository surveyRepository;

    @Override
    public void execute(DelegateExecution execution) throws Exception{
        //Create Survey object
        Survey Survey = new Survey();

        //Find size of database
        Iterable<Survey> SurveyDatabaseList = surveyRepository.findAll();
        int size = 0;
        for(Object survey: SurveyDatabaseList){
            size++;
        }

        //Establish SurveyID
        int generatedSurveyId = size + 1;

        //Set variable in camunda environment
        execution.setVariable("surveyID", generatedSurveyId);

        //Assign values to Survey variables from form submission
        Survey.setSurveyResponse(execution.getVariable("surveyResponse").toString());

        //Save Survey to database
        surveyRepository.save(Survey);
    }
}
