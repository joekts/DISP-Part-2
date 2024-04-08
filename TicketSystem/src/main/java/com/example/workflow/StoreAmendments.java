package com.example.workflow;

import jakarta.inject.Named;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

@Named
public class StoreAmendments implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {

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

                // Check to see if ticket effect has been amended by desk manager
                if (execution.getVariable("amendEffect").toString() != "null"){
                    // Create SQL query for updating ticket effect
                    String sql = "UPDATE TICKET SET ticket_effect = \'" + execution.getVariable("amendEffect").toString() + "\' WHERE ticketid = " + execution.getVariable("ticketID") + ";";

                    //Try statement for database connection
                    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

                        // Execute the update
                        pstmt.executeUpdate();

                    }
                }

                // Check to see if ticket priority has been amended by desk manager
                if (execution.getVariable("amendPriority").toString() != "null"){
                    // Create SQL query for updating ticket priority
                    String sql = "UPDATE TICKET SET ticket_priority = \'" + execution.getVariable("amendPriority").toString() + "\' WHERE ticketid = " + execution.getVariable("ticketID") + ";";

                    //Try statement for database connection
                    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

                        // Execute the update
                        pstmt.executeUpdate();

                    }
                }

                // Check to see if ticket description has been amended by desk manager
                if (execution.getVariable("amendDesc").toString() != ""){

                    // Update camunda environment ticketDesc variable to have desk manager amend desc
                    execution.setVariable("ticketDesc", execution.getVariable("ticketDesc").toString() + "\n\nDesk Manager additional information:\n" + execution.getVariable("amendDesc").toString());

                    String updatedDesc = execution.getVariable("ticketDesc").toString();

                    // Create SQL query for updating ticket description
                    String sql = "UPDATE TICKET SET ticket_desc = \'" + updatedDesc + "\' WHERE ticketid = " + execution.getVariable("ticketID") + ";";

                    //Try statement for database connection
                    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

                        // Execute the update
                        pstmt.executeUpdate();

                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
