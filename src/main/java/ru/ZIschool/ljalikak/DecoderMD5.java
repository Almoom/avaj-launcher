package ru.ZIschool.ljalikak;



public class DecoderMD5 {

    public static final int MD5_LENGTH = 32;

    public Scenario decode(Scenario scenario) {
        if (scenario.getSimNum().length() <= String.valueOf(Integer.MAX_VALUE).length()) {
            return scenario;
        }
        return decodeRun(scenario);
    }

    private Scenario decodeRun(Scenario scenario) {

        if (HashMD5.types.containsKey(scenario.getSimNum())) {
            return null;
        }
        return scenario;
    }
}
