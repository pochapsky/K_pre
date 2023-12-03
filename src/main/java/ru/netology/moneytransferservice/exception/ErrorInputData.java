package ru.netology.moneytransferservice.exception;

public class ErrorInputData extends Exception {
    public ErrorInputData(String message) {
        super(message);
    }
}