package ru.ZIschool.ljalikak;

import java.util.ArrayList;

public class ArgsException extends RuntimeException {

    public ArgsException(String[] message) {
        super("Incorrect number of arguments: " + message.length + "; expected: 1");
    }
}
