package ru.ZIschool.ljalikak.models;

import ru.ZIschool.ljalikak.WeatherTower;

public interface Flyable {

    public void updateConditions();

    public void registerTower(WeatherTower weatherTower);

}
