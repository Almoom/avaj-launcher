package ru.ZIschool.ljalikak;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
        Scanner scan = new Scanner(new File(args[0]));

//        try(FileReader reader = new FileReader(new File(args[0])) {
//
//        }

//        System.out.println(AircraftFactory.newAircraft("Baloon", "ytt",1,1,1).toString());

        StringBuffer sb = new StringBuffer();
        for (FlyType a : FlyType.values()) {
            if (sb.length() != 0) {
                sb.append("|");
            }
            sb.append(a);
        }

        int counter = -1;
        List<String> lines = new ArrayList<>();
        while (scan.hasNext()) {
            String s = scan.nextLine().trim();
            if (!s.isEmpty() && counter == -1) {
                counter = parseFirstLine(s);
            } else if (!s.isEmpty() && isValidLine(s, sb.toString())) {
                lines.add(s);
                System.out.println(s);
            }
        }

        scan.close();

    }

    private static int parseFirstLine(String s) {
        if (s.matches("^\\d+"))
            return Integer.parseInt(s);
        throw new RuntimeException("");
    }

    private static boolean isValidLine(String s, String sb) {

        if (s.matches("^(" + sb + ")\\s+\\w+\\s+\\d+\\s+\\d+\\s+(\\d{1,2}|100)$")) {
            return true;
        } else {
            System.out.println("-=error line=-");
        }
        return false;
    }
}
