package ru.ZIschool.ljalikak.models;

import ru.ZIschool.ljalikak.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String currentWeather = weatherTower.getWeather(coordinates);

        switch (currentWeather) {
            case "SUN":
                coordinates = new Coordinates(
                        coordinates.getLongitude(),
                        coordinates.getLatitude() + 10,
                        coordinates.getHeight() + 2);
                System.out.println(toString() + ": This is hot.");
                break;
            case "RAIN":
                coordinates = new Coordinates(
                        coordinates.getLongitude(),
                        coordinates.getLatitude() + 5,
                        coordinates.getHeight());
                System.out.println(toString() + ": It's raining. Better watch out for lightings.");
                break;
            case "FOG":
                coordinates = new Coordinates(
                        coordinates.getLongitude(),
                        coordinates.getLatitude() + 1,
                        coordinates.getHeight());
                System.out.println(toString() + ": It's fogging. I can't see anything.");
                break;
            case "SNOW":
                coordinates = new Coordinates(
                        coordinates.getLongitude(),
                        coordinates.getLatitude(),
                        coordinates.getHeight() - 7);
                System.out.println(toString() + ": OMG! Winter is coming!");
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
        System.out.println("Tower says: " + this.toString() + " registered to weather tower.");
    }
}
