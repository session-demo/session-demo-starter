package com.session.springbootstarterdemo;

public class SessionDemoService {

    private String comments;

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void printComments() {
        System.out.printf("comments:" + comments);
    }
}
