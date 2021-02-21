package ru.ZIschool.ljalikak;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Reader {

    public Scenario readFileToScenario(String path) {
        int simNum = -1;
        ArrayList<String> flyableLogList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    if (simNum == -1) {
                        simNum = Integer.parseInt(line);
                        if (simNum < 0) {
                            throw new RuntimeException("Incorrect number of simulation's cycles"); //todo
                        }
                    } else {
                        flyableLogList.add(line);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Scenario(simNum, flyableLogList);
    }
}