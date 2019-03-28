package com.example.cep.proj2;

public class MensajeError {
    private String Message;
    public MensajeError() {

    }
    public MensajeError(String message) {
        Message = message;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
