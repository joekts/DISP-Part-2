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
        //Create ticket object
        Survey survey = new Survey();

        //Find size of database
        Iterable<Survey> databaseList = surveyRepository.findAll();

        int size = 0;
        for(Object counter: databaseList){
            size++;
        }

        //Establish ticketID
        int id = size + 1;

        //Set variable in camunda environment
        execution.setVariable("surveyID", id);

        //Assign values to ticket variables from form submission
        survey.setSurveyResponse(execution.getVariable("surveyResponse").toString());

        //Save ticket to database
        surveyRepository.save(survey);
    }
}
