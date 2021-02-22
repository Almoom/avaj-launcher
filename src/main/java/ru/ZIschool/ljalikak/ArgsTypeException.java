package ru.ZIschool.ljalikak;

public class ArgsTypeException extends RuntimeException {

    public ArgsTypeException(String[] message) {
        super("It's directory: " + message[0] + "; expected: file");
    }
}
