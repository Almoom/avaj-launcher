package ru.ZIschool.ljalikak;

import java.io.File;

public abstract class Checker {

    public static void run(String[] args) {
        if (args.length != 1) {
            throw new ArgsException(args);
        }

        if (new File(args[0]).isDirectory()){
            throw new ArgsTypeException(args);
        }

        if (new File(args[0]).exists() || Reader.readFileToString(args[0]).length() == 0){
            throw new FileContentException(args);
        }
    }
}
