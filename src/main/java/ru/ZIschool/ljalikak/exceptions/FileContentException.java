package ru.ZIschool.ljalikak.exceptions;

public class FileContentException extends RuntimeException {

    public FileContentException(String[] message) {
        super("File " + message[0] + " is empty!");
    }
}
