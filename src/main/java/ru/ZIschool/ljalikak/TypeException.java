package ru.ZIschool.ljalikak;

import java.util.Arrays;

public class TypeException extends RuntimeException {

    public TypeException(String[] message) {
        super("Incorrect type: " + message[0] + "\nin line :" + Arrays.asList(message));
    }
}
