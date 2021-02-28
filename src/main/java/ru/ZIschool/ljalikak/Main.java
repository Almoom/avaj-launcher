package ru.ZIschool.ljalikak;

//cd src/main/java
//find . -name "*.java" > sources.txt
//javac @sources.txt
//jar cmvf Manifest.mf myJar.jar ru/ZIschool/ljalikak/*
//java -jar myJar.jar ~/Desktop/scenario.txt

import ru.ZIschool.ljalikak.models.AircraftFactory;
import ru.ZIschool.ljalikak.models.Scenario;
import ru.ZIschool.ljalikak.services.*;

public class Main {

    public static final int TYPE = 0;
    public static final int NAME = 1;
    public static final int LONGITUDE = 2;
    public static final int LATITUDE = 3;
    public static final int HEIGHT = 4;

    public static void main(String[] args) {

        Checker.run(args);

        Scenario scenario = Reader.run(args[0]);
        scenario = DecoderMD5.run(scenario);

        Validator.run(scenario);

        WeatherTower tower = new WeatherTower();

        for (String s : scenario.getFlyableLogList()) {
            String[] params = s.split("\\s");

            AircraftFactory.newAircraft(
                    params[TYPE],
                    params[NAME],
                    Integer.parseInt(params[LONGITUDE]),
                    Integer.parseInt(params[LATITUDE]),
                    Integer.parseInt(params[HEIGHT]))
                    .registerTower(tower);
        }

        for (int i = Integer.parseInt(scenario.getSimNum()); i > 0; i--) {
            tower.changeWeather();
        }
    }
}
