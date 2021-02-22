package ru.ZIschool.ljalikak;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String currentWeather = WeatherProvider.getProvider().getCurrentWeather(coordinates);

        switch (currentWeather) {
            case "SUN":
                weatherTower.getWeather(new Coordinates(
                        coordinates.getLongitude(),
                        coordinates.getLatitude() + 10,
                        coordinates.getHeight() + 2 > 100 ? 100 : coordinates.getHeight() + 2));
                break;
            case "RAIN":
                weatherTower.getWeather(new Coordinates(
                        coordinates.getLongitude(),
                        coordinates.getLatitude() + 5,
                        coordinates.getHeight()));
                break;
            case "FOG":
                weatherTower.getWeather(new Coordinates(
                        coordinates.getLongitude(),
                        coordinates.getLatitude() + 1,
                        coordinates.getHeight()));
                break;
            case "SNOW":
                weatherTower.getWeather(new Coordinates(
                        coordinates.getLongitude(),
                        coordinates.getLatitude(),
                        coordinates.getHeight() - 7 < 0 ? 0 : coordinates.getHeight() - 7));
                break;
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
    }
}
