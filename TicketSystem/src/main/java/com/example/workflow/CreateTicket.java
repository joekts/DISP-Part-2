package com.example.workflow;
import com.example.workflow.model.Ticket;
import com.example.workflow.model.TicketRepository;
import jakarta.inject.Named;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

@Named
public class CreateTicket implements JavaDelegate {
    @Autowired
    private TicketRepository ticketRepository;

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

        //Find size of database
        Iterable<Ticket> databaseList = ticketRepository.findAll();
        long size = 0;
        for(Object counter: databaseList){
            size++;
        }

        //Establish ticketID
        long id = size + 1;

        //Set ticketID
        ticket.setID(id);

        //Set variable in camunda environment
        execution.setVariable("ticketID", id);

        //Save ticket to database
        ticketRepository.save(ticket);
    }
}
