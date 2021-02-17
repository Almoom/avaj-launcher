package ru.ZIschool.ljalikak;

public class WeatherProvider {
    private static WeatherProvider weatherProvider;
    private static String[] weather;

    private WeatherProvider() {}

    public static WeatherProvider getProvider() {
        if (weatherProvider == null) {
            weatherProvider = new WeatherProvider();
        }
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        return null;
    }
}
