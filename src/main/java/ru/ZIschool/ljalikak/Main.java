package ru.ZIschool.ljalikak;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//cd src/main/java
//find . -name "*.java" > sources.txt
//javac @sources.txt
//jar cmvf Manifest.mf myjar.jar ru/ZIschool/ljalikak/*
//java -jar myjar.jar scenario.txt

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//        Scanner scan = new Scanner(new File(args[0]));

        StringBuffer sb = new StringBuffer();
        for (FlyType a : FlyType.values()) {
            if (sb.length() != 0) {
                sb.append("|");
            }
            sb.append(a);
        }

        System.out.println(sb.toString());


//        List<String> lines = new ArrayList<>();
//        for (int i = 0; scan.hasNext(); ) {
//            String s = scan.nextLine().trim();
//            if (!s.isEmpty() && isValidLine(i, s, sb.toString())) {
//                i++;
//                lines.add(s);
//                System.out.println(s);
//            }
//        }
//
//        scan.close();

    }

    private static boolean isValidLine(int i, String s, String sb) {

        if ((i == 0 && s.matches("^\\d+"))
                || s.matches("^(" + sb + ")\\s+\\w+\\s+\\d+\\s+\\d+\\s+\\d+$")) {
            return true;
        } else {
            System.out.println("-=error line=-");
        }
        return false;
    }
}
