package ru.ZIschool.ljalikak;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String currentWeather = WeatherProvider.getProvider().getCurrentWeather(coordinates);

        switch (currentWeather) {
            case "SUN":
                weatherTower.getWeather(new Coordinates(
                        coordinates.getLongitude() + 2,
                        coordinates.getLatitude(),
                        coordinates.getHeight() + 4 > 100 ? 100 : coordinates.getHeight() + 4));
                break;
            case "RAIN":
                weatherTower.getWeather(new Coordinates(
                        coordinates.getLongitude(),
                        coordinates.getLatitude(),
                        coordinates.getHeight() - 5 < 0 ? 0 : coordinates.getHeight() - 5));
                break;
            case "FOG":
                weatherTower.getWeather(new Coordinates(
                        coordinates.getLongitude(),
                        coordinates.getLatitude(),
                        coordinates.getHeight() - 3 < 0 ? 0 : coordinates.getHeight() - 3));
                break;
            case "SNOW":
                weatherTower.getWeather(new Coordinates(
                        coordinates.getLongitude(),
                        coordinates.getLatitude(),
                        coordinates.getHeight() - 15 < 0 ? 0 : coordinates.getHeight() - 15));
                break;
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
    }
}
