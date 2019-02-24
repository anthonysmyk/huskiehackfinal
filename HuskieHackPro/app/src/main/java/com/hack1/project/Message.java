package com.hack1.project;

public class Message {
    private String message;
    private String time;
    public Message(String message,String time){
        this.message=message;
        this.time =time;
    }
    public String getTime(){return this.time;}
    public String getMessage(){return this.message;}
}
