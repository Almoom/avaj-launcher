package ru.ZIschool.ljalikak.models;

import ru.ZIschool.ljalikak.WeatherTower;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String currentWeather = weatherTower.getWeather(coordinates);

        switch (currentWeather) {
            case "SUN":
                coordinates = new Coordinates(
                        coordinates.getLongitude() + 2,
                        coordinates.getLatitude(),
                        coordinates.getHeight() + 4);
                System.out.println(toString() + ": Let's enjoy the good weather and take some pics.");
                break;
            case "RAIN":
                coordinates = new Coordinates(
                        coordinates.getLongitude(),
                        coordinates.getLatitude(),
                        coordinates.getHeight() - 5);
                System.out.println(toString() + ": Damn you rain! You messed up my baloon.");
                break;
            case "FOG":
                coordinates = new Coordinates(
                        coordinates.getLongitude(),
                        coordinates.getLatitude(),
                        coordinates.getHeight() - 3);
                System.out.println(toString() + ": It's fogging. I can't see anything.");
                break;
            case "SNOW":
                coordinates = new Coordinates(
                        coordinates.getLongitude(),
                        coordinates.getLatitude(),
                        coordinates.getHeight() - 15);
                System.out.println(toString() + ": It's snowing. We're gonna crash.");
                break;
        }

        if (this.coordinates.getHeight() <= 0) {
            weatherTower.unregister(this);
            System.out.println(toString() + " landing.");
            System.out.println("Tower says: " + toString() + " unregistered from weather tower.");
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        System.out.println("Tower says: " + toString() + " registered to weather tower.");
    }

}
