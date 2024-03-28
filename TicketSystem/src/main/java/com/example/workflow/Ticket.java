package com.example.workflow;

public class Ticket {

    private String ticketFName;
    private String ticketSurname;
    private String ticketEmail;
    private String ticketDepartment;
    private String ticketManager;
    private String ticketIssue;
    private String ticketEffect;
    private String ticketPriority;
    private String ticketDesc;
    private String ticketStatus;

    //First name getter and setter
    public String getTicketFName() {
        return ticketFName;
    }
    public void setTicketFName(String fName){
        this.ticketFName = fName;
    }

    //Surname getter and setter
    public String getTicketSurname(){
        return ticketSurname;
    }
    public void setTicketSurname(String surname){
        this.ticketSurname = surname;
    }

    //Combined name getter
    public String getFullName(){
        return this.ticketFName + " " + this.ticketSurname;
    }

    //Email getter and setter
    public String getTicketEmail(){
        return ticketEmail;
    }
    public void setTicketEmail(String email){
        this.ticketEmail = email;
    }

    //Department getter and setter
    public String getTicketDepartment(){
        return ticketDepartment;
    }
    public void setTicketDepartment(String department){
        this.ticketDepartment = department;
    }

    //Manager getter and setter
    public String getTicketManager(){
        return ticketManager;
    }
    public void setTicketManager(String manager){
        this.ticketManager = manager;
    }

    //Issue getter and setter
    public String getTicketIssue(){
        return ticketIssue;
    }
    public void setTicketIssue(String issue){
        this.ticketIssue = issue;
    }

    //Effect getter and setter
    public String getTicketEffect(){
        return ticketEffect;
    }
    public void setTicketEffect(String effect){
        this.ticketEffect = effect;
    }

    //Priority getter and setter
    public String getTicketPriority(){
        return ticketPriority;
    }
    public void setTicketPriority(String priority){
        this.ticketPriority = priority;
    }

    //Description getter and setter
    public String getTicketDesc(){
        return ticketDesc;
    }
    public void setTicketDesc(String desc){
        this.ticketDesc = desc;
    }

    //Status getter and setter
    public String getTicketStatus(){
        return ticketStatus;
    }
    public void setTicketStatus(String status){
        this.ticketStatus = status;
    }
}
