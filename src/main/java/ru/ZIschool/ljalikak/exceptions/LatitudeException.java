package ru.ZIschool.ljalikak.exceptions;

import java.util.Arrays;

public class LatitudeException extends RuntimeException {

    public LatitudeException(String[] message) {
        super("Incorrect latitude: " + message[3] + "; expected: 0..2147483647\nin line :" + Arrays.asList(message));
    }
}
