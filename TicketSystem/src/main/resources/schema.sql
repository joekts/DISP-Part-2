-- Create TICKET table
CREATE TABLE IF NOT EXISTS TICKET (
    ticketid BIGINT AUTO_INCREMENT PRIMARY KEY,
    ticket_assignee VARCHAR(255),
    ticket_department VARCHAR(255),
    ticket_desc TEXT,
    ticket_effect VARCHAR(255),
    ticket_email VARCHAR(255),
    ticketfname VARCHAR(255),
    ticket_issue TEXT,
    ticket_manager VARCHAR(255),
    ticket_priority VARCHAR(50),
    ticket_status VARCHAR(50),
    ticket_surname VARCHAR(255)
);
-- Create SURVEY Table
CREATE TABLE IF NOT EXISTS SURVEY (
    surveyID BIGINT AUTO_INCREMENT PRIMARY KEY,
    survey_response TEXT,
    survey_ticketid BIGINT,
    FOREIGN KEY (survey_ticketid) REFERENCES TICKET (ticketid)
);