package ru.ZIschool.ljalikak.models;

public abstract class AircraftFactory {

    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        Flyable flyable;

        switch (type) {
            case "Helicopter":
                flyable = new Helicopter(name, new Coordinates(longitude, latitude, height));
                break;
            case "JetPlane":
                flyable = new JetPlane(name, new Coordinates(longitude, latitude, height));
                break;
            case "Baloon":
                flyable = new Baloon(name, new Coordinates(longitude, latitude, height));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
        return flyable;
    }
}
