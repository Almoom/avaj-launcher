package ru.ZIschool.ljalikak.exceptions;

import java.util.Arrays;

public class ParametersException extends RuntimeException {

    public ParametersException(String[] message) {
        super("Incorrect number of parameters: " + message.length + "; expected: 5\nin line :" + Arrays.asList(message));
    }
}
