package org.example.service.exceptions.errors;

public class RoleNotFoundException extends RuntimeException{

    private String message;

    public RoleNotFoundException(String message) {
        super(message);
        this.message = message;
    }

    public String getCode() {return "02";}

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
