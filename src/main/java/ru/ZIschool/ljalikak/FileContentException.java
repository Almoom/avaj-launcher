package ru.ZIschool.ljalikak;

public class FileContentException extends RuntimeException {

    public FileContentException(String[] message) {
        super("File " + message[0] + " is empty!");
    }
}
