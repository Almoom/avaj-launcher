package ru.ZIschool.ljalikak;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String currentWeather = WeatherProvider.getProvider().getCurrentWeather(coordinates);

        switch (currentWeather) {
            case "SUN":
                weatherTower.getWeather(new Coordinates(
                        coordinates.getLongitude() + 10,
                        coordinates.getLatitude(),
                        coordinates.getHeight() + 2 > 100 ? 100 : coordinates.getHeight() + 2));
                System.out.println(toString() + ": This is hot.");
                break;
            case "RAIN":
                weatherTower.getWeather(new Coordinates(
                        coordinates.getLongitude() + 5,
                        coordinates.getLatitude(),
                        coordinates.getHeight()));
                System.out.println(toString() + ": It's raining. Better watch out for lightings.");
                break;
            case "FOG":
                weatherTower.getWeather(new Coordinates(
                        coordinates.getLongitude() + 1,
                        coordinates.getLatitude(),
                        coordinates.getHeight()));
                System.out.println(toString() + ": It's fogging. I can't see anything.");
                break;
            case "SNOW":
                weatherTower.getWeather(new Coordinates(
                        coordinates.getLongitude(),
                        coordinates.getLatitude(),
                        coordinates.getHeight() - 12));
                System.out.println(toString() + ": My rotor is going to freeze!");
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
