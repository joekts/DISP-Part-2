package com.example.workflow;

import jakarta.inject.Named;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

@Named
public class StoreEvaluate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        //Database configuration variables
        String url = "jdbc:h2:file:./camunda-h2-database";
        String user = "";
        String password = "";

        // Update camunda environment ticketDesc variable to have user evaluate desc
        execution.setVariable("ticketDesc", execution.getVariable("ticketDesc").toString() + "\n\nEnd user unsatisfied with resolution information:\n" + execution.getVariable("evaluateDesc").toString());

        // Create variable for new ticket desc
        String updatedDesc = execution.getVariable("ticketDesc").toString();

        try {
            // Load the H2 JDBC Driver
            Class.forName("org.h2.Driver");

            // Establish connection to the database
            try (Connection conn = DriverManager.getConnection(url, user, password);
                 Statement stmt = conn.createStatement()) {

                // Create SQL query for updating ticket description
                String sql = "UPDATE TICKET SET ticket_desc = \'" + updatedDesc + "\' WHERE ticketid = " + execution.getVariable("ticketID") + ";";

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
