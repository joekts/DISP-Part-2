package com.example.workflow.model;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    //Method to save ticket
    Ticket save(Ticket ticket);

    //Method to retrieve all tickets
    List<Ticket> findAll();
}
