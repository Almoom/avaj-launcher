package ru.ZIschool.ljalikak.exceptions;

import java.util.Arrays;

public class LongitudeException extends RuntimeException {

    public LongitudeException(String[] message) {
        super("Incorrect longitude: " + message[2] + "; expected: 0..2147483647\nin line :" + Arrays.asList(message));
    }
}
