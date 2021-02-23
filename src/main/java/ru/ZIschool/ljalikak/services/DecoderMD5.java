package ru.ZIschool.ljalikak.services;

import ru.ZIschool.ljalikak.exceptions.ParametersException;
import ru.ZIschool.ljalikak.models.Scenario;

import java.util.ArrayList;

public abstract class DecoderMD5 {

    public static Scenario run(Scenario scenario) {
        if (scenario.getSimNum().length() <= String.valueOf(Integer.MAX_VALUE).length()) {
            return scenario;
        }
        return decode(scenario);
    }

    private static Scenario decode(Scenario scenario) {
        String simNum;
        ArrayList<String> flyableLogList = new ArrayList<>();

        if (HashMD5.integers.contains(scenario.getSimNum())) {
            simNum = String.valueOf(HashMD5.integers.indexOf(scenario.getSimNum()));
        } else {
            simNum = scenario.getSimNum();
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
                            decodedLine.append(params[0]).append(' ');
                    }
                } else {
                    decodedLine.append(params[0]).append(' ');
                    decodedLine.append(params[1]).append(' ');
                }

                for (int i = 2; i < 5; i++) {
                    if (HashMD5.integers.contains(params[i])) {
                        decodedLine.append(HashMD5.integers.indexOf(params[i])).append(' ');
                    } else {
                        decodedLine.append(params[i]).append(' ');
                    }
                }

                flyableLogList.add(decodedLine.toString().trim());
            }
        }

        return new Scenario(simNum, flyableLogList);
    }

}
