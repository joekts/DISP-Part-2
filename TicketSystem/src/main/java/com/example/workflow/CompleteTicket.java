package com.example.workflow;

import jakarta.inject.Named;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

@Named
public class CompleteTicket implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        //Using ticketID get ticket from database and update ticket status to completed
        execution.getVariable("ticketID");
    }
}
