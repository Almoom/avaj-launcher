package ru.ZIschool.ljalikak.exceptions;

public class ArgsException extends RuntimeException {

    public ArgsException(String[] message) {
        super("Incorrect number of arguments: " + message.length + "; expected: 1");
    }
}
