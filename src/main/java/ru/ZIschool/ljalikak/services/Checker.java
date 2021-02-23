package ru.ZIschool.ljalikak.services;

import ru.ZIschool.ljalikak.exceptions.ArgsException;
import ru.ZIschool.ljalikak.exceptions.ArgsTypeException;
import ru.ZIschool.ljalikak.exceptions.FileContentException;

import java.io.File;

public abstract class Checker {

    public static void run(String[] args) {
        if (args.length != 1) {
            throw new ArgsException(args);
        }

        if (new File(args[0]).isDirectory()){
            throw new ArgsTypeException(args);
        }

        if (!(new File(args[0]).exists()) || Reader.readFileToString(args[0]).length() == 0){
            throw new FileContentException(args);
        }
    }
}
