package com.example.workflow;

import jakarta.inject.Named;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

@Named
public class StoreAdditional implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        //Get additional info variable
        String assignee = execution.getVariable("additionalInfo").toString();

        //Using ticketID get ticket from database and update desc by adding additional
        execution.getVariable("ticketID");
    }
}
