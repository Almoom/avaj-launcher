package ru.ZIschool.ljalikak.services;

import ru.ZIschool.ljalikak.exceptions.*;
import ru.ZIschool.ljalikak.models.Scenario;

public abstract class Validator {

    public static void run(Scenario scenario) {
        String cycles = scenario.getSimNum();

        if (!cycles.matches("^\\d{0,10}$") || Long.parseLong(cycles) > Integer.MAX_VALUE) {
            throw new CyclesException(scenario.getSimNum());
        }

        for (String line : scenario.getFlyableLogList()) {
            String[] params = line.split("\\s+");
            if (params.length != 5) {
                throw new ParametersException(params);
            } else {
                if (!params[0].matches("^(Baloon|Helicopter|JetPlane)$")) {
                    throw new TypeException(params);
                }
                if (!params[2].matches("^\\d{0,10}$") || Long.parseLong(params[2]) > Integer.MAX_VALUE) {
                    throw new LongitudeException(params);
                }
                if (!params[3].matches("^\\d{0,10}$") || Long.parseLong(params[3]) > Integer.MAX_VALUE) {
                    throw new LatitudeException(params);
                }
                if (!params[4].matches("^\\d{1,2}|100$")) {
                    throw new HeightException(params);
                }
            }
        }
    }
}
