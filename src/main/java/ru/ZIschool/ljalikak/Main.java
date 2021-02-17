package ru.ZIschool.ljalikak;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("target/classes/sources/scenario.txt"));

        List<String> lines = new ArrayList<>();
        for (int i = 0; scan.hasNext();) {
            String s = scan.nextLine().trim();
            if (!s.isEmpty() && isValidLine(i, s)) {
                i++;
                lines.add(s);
                System.out.println(s);
            }
        }

        scan.close();

        int cycle = Integer.parseInt(lines.get(0));
        System.out.println(cycle);

    }

    private static boolean isValidLine(int i, String s) {
        if ((i == 0 && s.matches("^\\d+"))
                || s.matches("^\\w+\\s\\w+\\s\\d+\\s\\d+\\s\\d+$")) {
            return true;
        } else {
//            throw new IOException("ALERT");
            System.out.println("чокаво");
        }
        return false;
    }
}
