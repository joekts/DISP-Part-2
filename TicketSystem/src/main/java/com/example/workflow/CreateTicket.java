package com.example.workflow;
import com.example.workflow.model.Ticket;
import jakarta.inject.Named;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

@Named
public class CreateTicket implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception{

        //Create ticket object
        Ticket ticket = new Ticket();

        //Assign ID

        //Assign values to ticket variables from form submission
        ticket.setTicketFName(execution.getVariable("ticketFName").toString());
        ticket.setTicketSurname(execution.getVariable("ticketSurname").toString());
        ticket.setTicketEmail(execution.getVariable("ticketEmail").toString());
        ticket.setTicketDepartment(execution.getVariable("ticketDepartment").toString());
        ticket.setTicketManager(execution.getVariable("ticketManager").toString());
        ticket.setTicketIssue(execution.getVariable("ticketIssue").toString());
        ticket.setTicketEffect(execution.getVariable("ticketEffect").toString());
        ticket.setTicketPriority(execution.getVariable("ticketPriority").toString());
        ticket.setTicketDesc(execution.getVariable("ticketDesc").toString());
        ticket.setTicketStatus("In Progress");

        System.out.println("Success");
    }
}
