package com.application.error;

public enum Error {
    NO_ERROR(""), ERROR_TITLE("There is no title"), ERROR_CONTENT("There is no content");

    private String text;

    Error(String text){
        this.text = text;
    }

    public String getText(){
        return text;
    }
}
