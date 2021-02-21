package ru.ZIschool.ljalikak;

public abstract class Validator {

    public static void run(Scenario scenario) {
        if (!scenario.getSimNum().matches("^\\d{0,2147483647}$"))
            throw new RuntimeException("Incorrect number of cycles"); //todo

        for (String line : scenario.getFlyableLogList()) {
            String[] params = line.split("\\s+");
            if (params.length != 5) {
                throw new RuntimeException("Incorrect number of parameters"); //todo
            } else {
                if (!params[0].matches("^(Baloon|Helicopter|JetPlane)$")) {
                    throw new RuntimeException("Incorrect type"); //todo
                }
                if (!params[2].matches("^\\d{0,10}$") || Long.parseLong(params[2]) > Integer.MAX_VALUE) {
                    throw new RuntimeException("Incorrect longitude"); //todo
                }
                if (!params[3].matches("^\\d{0,10}$") || Long.parseLong(params[3]) > Integer.MAX_VALUE) {
                    throw new RuntimeException("Incorrect latitude"); //todo
                }
                if (!params[4].matches("^\\d{1,2}|100$")) {
                    throw new RuntimeException("Incorrect height"); //todo
                }
            }
        }

    }
}
