package ru.ZIschool.ljalikak;


import java.util.ArrayList;
import java.util.Arrays;

public class DecoderMD5 {

    public static final int ERROR_NUM = -1;
    public static final String ERROR_WORD = "error";

    public Scenario decode(Scenario scenario) {
        if (scenario.getSimNum().length() <= String.valueOf(Integer.MAX_VALUE).length()) {
            return scenario;
        }
        return decodeRun(scenario);
    }

    private Scenario decodeRun(Scenario scenario) {
        int simNum;
        ArrayList<String> flyableLogList = new ArrayList<>();

        if (HashMD5.integers.contains(scenario.getSimNum())) {
            simNum = HashMD5.integers.indexOf(scenario.getSimNum());
        } else {
            simNum = ERROR_NUM;
        }

        for (String line : scenario.getFlyableLogList()) {
            String[] words = line.split("\\s+");

            if (words.length != 5) {
                flyableLogList.add(ERROR_WORD);
            } else {
                StringBuffer decodedLine = new StringBuffer();
                String type = null;

                if (HashMD5.types.containsKey(words[0])) {
                    type = HashMD5.types.get(words[0]);
                    decodedLine.append(type).append(' ');
                } else {
                    decodedLine.append(ERROR_WORD);
                }

                switch (type) {
                    case "Helicopter":
                        if (HashMD5.namesH.contains(words[1])) {
                            decodedLine.append(HashMD5.namesH.indexOf(words[1])).append(' ');
                        } else {
                            decodedLine.append(words[1]).append(' ');
                        }
                        break;
                    case "JetPlane":
                        if (HashMD5.namesJ.contains(words[1])) {
                            decodedLine.append(HashMD5.namesJ.indexOf(words[1])).append(' ');
                        } else {
                            decodedLine.append(words[1]).append(' ');
                        }
                        break;
                    case "Baloon":
                        if (HashMD5.namesB.contains(words[1])) {
                            decodedLine.append(HashMD5.namesB.indexOf(words[1])).append(' ');
                        } else {
                            decodedLine.append(words[1]).append(' ');
                        }
                        break;
                    default:
                        decodedLine.append(ERROR_WORD).append(' ');
                }

                for (int i = 2; i < 5; i++) {
                    if (HashMD5.integers.contains(words[i])) {
                        decodedLine.append(HashMD5.integers.indexOf(words[i])).append(' ');
                    } else {
                        decodedLine.append(ERROR_NUM).append(' ');
                    }
                }

                flyableLogList.add(decodedLine.toString().trim());
            }
        }

        return new Scenario(String.valueOf(simNum), flyableLogList);
    }

}
