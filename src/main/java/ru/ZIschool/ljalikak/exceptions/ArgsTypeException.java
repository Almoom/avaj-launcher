package ru.ZIschool.ljalikak.exceptions;

public class ArgsTypeException extends RuntimeException {

    public ArgsTypeException(String[] message) {
        super("It's directory: " + message[0] + "; expected: file");
    }
}
