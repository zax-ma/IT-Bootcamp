package org.example.service.exceptions.errors;

public class EmailAlreadyRegisteredException extends RuntimeException{

    private String message;

    public EmailAlreadyRegisteredException(String message) {
        super(message);
        this.message = message;
    }

    public String getCode() {return "01";}

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
