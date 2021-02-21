package ru.ZIschool.ljalikak;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Reader {

    public static Scenario readFileToScenario(String path) {
        String simNum = null;
        ArrayList<String> flyableLogList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            for (int i = 0; (line = br.readLine()) != null; ) {
                if (!line.trim().isEmpty()) {
                    if (i == 0) {
                        simNum = line.trim();
                    } else {
                        flyableLogList.add(line.trim());
                    }
                    i++;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Scenario(simNum, flyableLogList);
    }

    public static ArrayList<String> readFileToArrayIntByMD5(String path) {
        ArrayList<String> arrayIntByMD5 = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                arrayIntByMD5.add(line.trim());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return arrayIntByMD5;
    }
}