package com.example.workflow;

import jakarta.inject.Named;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

@Named
public class StoreAssignment implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception{

        //Get assignee variable
        String assignee = execution.getVariable("assignee").toString();
        //Get ticketID variable
        int id = (int) execution.getVariable("ticketID");

        //Database configuration variables
        String url = "jdbc:h2:file:./camunda-h2-database";
        String user = "";
        String password = "";

        try {
            // Load the H2 JDBC Driver
            Class.forName("org.h2.Driver");

            // Establish connection to the database
            try (Connection conn = DriverManager.getConnection(url, user, password);
                 Statement stmt = conn.createStatement()) {

                // Create SQL query for updating ticket assignee
                String sql = "UPDATE TICKET SET ticket_assignee = \'" + assignee + "\' WHERE ticketid = " + id + ";";

                //Try statement for database connection
                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

                    // Execute the update
                    pstmt.executeUpdate();

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
