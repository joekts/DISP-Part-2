package com.example.workflow;

import jakarta.inject.Named;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

@Named
public class StoreAssignment implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception{

        //Get assignee variable
        String assignee = execution.getVariable("assignee").toString();

        //Using ticketID get ticket from database and update assignee
        execution.getVariable("ticketID");
    }

}
