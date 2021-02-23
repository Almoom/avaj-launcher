package ru.ZIschool.ljalikak.exceptions;

public class CyclesException extends RuntimeException {

    public CyclesException(String message) {
        super("Incorrect number of cycles: " + message + "; expected: 0..2147483647");
    }
}
