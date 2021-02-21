package ru.ZIschool.ljalikak;

import java.util.ArrayList;

public abstract class DecoderMD5 {

    public static final int ERROR_NUM = -1;
    public static final String ERROR_WORD = "error";

    public static Scenario run(Scenario scenario) {
        if (scenario.getSimNum().length() <= String.valueOf(Integer.MAX_VALUE).length()) {
            return scenario;
        }
        return decode(scenario);
    }

    private static Scenario decode(Scenario scenario) {
        int simNum;
        ArrayList<String> flyableLogList = new ArrayList<>();

        if (HashMD5.integers.contains(scenario.getSimNum())) {
            simNum = HashMD5.integers.indexOf(scenario.getSimNum());
        } else {
            simNum = ERROR_NUM;
        }

        for (String line : scenario.getFlyableLogList()) {
            String[] params = line.split("\\s+");

            if (params.length != 5) {
                throw new ParametersException(params);
            } else {
                StringBuffer decodedLine = new StringBuffer();
                String type;

                if (HashMD5.types.containsKey(params[0])) {
                    type = HashMD5.types.get(params[0]);
                    decodedLine.append(type).append(' ');

                    switch (type) {
                        case "Helicopter":
                            if (HashMD5.namesH.contains(params[1])) {
                                decodedLine.append('H').append(HashMD5.namesH.indexOf(params[1]) + 1).append(' ');
                            } else {
                                decodedLine.append(params[1]).append(' ');
                            }
                            break;
                        case "JetPlane":
                            if (HashMD5.namesJ.contains(params[1])) {
                                decodedLine.append('J').append(HashMD5.namesJ.indexOf(params[1]) + 1).append(' ');
                            } else {
                                decodedLine.append(params[1]).append(' ');
                            }
                            break;
                        case "Baloon":
                            if (HashMD5.namesB.contains(params[1])) {
                                decodedLine.append('B').append(HashMD5.namesB.indexOf(params[1]) + 1).append(' ');
                            } else {
                                decodedLine.append(params[1]).append(' ');
                            }
                            break;
                        default:
                            decodedLine.append(ERROR_WORD).append(' ');
                    }
                } else {
                    decodedLine.append(ERROR_WORD).append(' ');
                }

                for (int i = 2; i < 5; i++) {
                    if (HashMD5.integers.contains(params[i])) {
                        decodedLine.append(HashMD5.integers.indexOf(params[i])).append(' ');
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
