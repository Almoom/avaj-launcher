package ru.ZIschool.ljalikak;

import ru.ZIschool.ljalikak.models.Coordinates;

public class WeatherTower extends Tower {

    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    void changeWeather() {
        conditionsChanged();
    }
}
