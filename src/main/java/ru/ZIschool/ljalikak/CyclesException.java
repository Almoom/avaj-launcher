package ru.ZIschool.ljalikak;

public class CyclesException extends RuntimeException {

    public CyclesException(String message) {
        super("Incorrect number of cycles: " + message + "; expected: 0..2147483647");
    }
}
