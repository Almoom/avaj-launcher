package ru.ZIschool.ljalikak;

public class AircraftFactory {

    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        Flyable flyable = null;

        if (type.equals("Helicopter")) {
            flyable = new Helicopter(name, new Coordinates(longitude, latitude, height));
        } else if (type.equals("JetPlane")) {
            flyable = new JetPlane(name, new Coordinates(longitude, latitude, height));
        } else if (type.equals("Baloon")) {
            flyable = new Baloon(name, new Coordinates(longitude, latitude, height));
        }
        return flyable;
    }

}
