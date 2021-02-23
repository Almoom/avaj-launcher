package ru.ZIschool.ljalikak.exceptions;

import java.util.Arrays;

public class HeightException extends RuntimeException {

    public HeightException(String[] message) {
        super("Incorrect height: " + message[4] + "; expected: 0..100\nin line :" + Arrays.asList(message));
    }
}
