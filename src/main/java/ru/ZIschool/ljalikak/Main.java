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
    public static void main(String[] args) {

        Checker.run(args);

        Scenario scenario = Reader.run(args[0]);
        scenario = DecoderMD5.run(scenario);

        Validator.run(scenario);

        WeatherTower tower = new WeatherTower();

        for (String s : scenario.getFlyableLogList()) {
            String[] params = s.split("\\s");

            AircraftFactory.newAircraft(
                    params[0],
                    params[1],
                    Integer.parseInt(params[2]),
                    Integer.parseInt(params[3]),
                    Integer.parseInt(params[4]))
                    .registerTower(tower);
        }

        for (int i = Integer.parseInt(scenario.getSimNum()); i > 0; i--) {
            tower.changeWeather();
        }
    }
}
