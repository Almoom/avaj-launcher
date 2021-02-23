package ru.ZIschool.ljalikak.services;

import ru.ZIschool.ljalikak.models.Scenario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Reader {
    private static final int LENGTH_MD5_LINE_PARAMETERS = 165;

    public static Scenario run(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = br.readLine()) != null) {
                if (line.trim().length() != 0) {
                    if (Reader.readFileToString(path).matches("^\\d+(Baloon|Helicopter|JetPlane).+")) {
                        return readFileToScenario(path);
                    } else {
                        return readMD5FileToScenario(path);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Scenario(null, null);
    }

    private static Scenario readMD5FileToScenario(String path) {
        String content = readFileToString(path);
        String simNum = null;
        ArrayList<String> flyableLogList = new ArrayList<>();
        StringBuffer sb = new StringBuffer();

        for (String s : content.split("(?<=\\G.{32})")) {
            if (simNum == null) {
                simNum = s;
            } else {
                sb.append(s).append(" ");
                if (sb.length() == LENGTH_MD5_LINE_PARAMETERS) {
                    flyableLogList.add(sb.toString().trim());
                    sb.delete(0, sb.length());
                }
            }
        }
        if (sb.toString().length() != 0 && !flyableLogList.contains(sb.toString())) {
            flyableLogList.add(sb.toString().trim());
        }
        return new Scenario(simNum, flyableLogList);
    }

    public static Scenario readFileToScenario(String path) {
        String simNum = null;
        ArrayList<String> flyableLogList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    if (simNum == null) {
                        simNum = line.trim();
                    } else {
                        flyableLogList.add(line.trim());
                    }
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

    public static String readFileToString(String path) {
        StringBuffer content = new StringBuffer();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = br.readLine()) != null) {
                content.append(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString().replaceAll("\\s+", "");
    }
}