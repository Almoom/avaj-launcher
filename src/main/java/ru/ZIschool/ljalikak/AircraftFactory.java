package ru.ZIschool.ljalikak;

public abstract class AircraftFactory {

    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {

        return FlyType.valueOf(type).create(type + "#" + name, longitude, latitude, height);

//        switch (type) {
//            case "Helicopter" :
//                return new Helicopter(name, new Coordinates(longitude, latitude, height));
//            case FlyType.JetPlane.toString():
//                return new JetPlane(name, new Coordinates(longitude, latitude, height));
//            case FlyType.Baloon.toString() :
//                return new Baloon(name, new Coordinates(longitude, latitude, height));
//            default :
//                throw new RuntimeException("no such class");
//        }

//        if (type.equals(FlyType.HELICOPTER.toString())) {
//            flyable = new Helicopter(name, new Coordinates(longitude, latitude, height));
//        } else if (type.equals(FlyType.JETPLANE.toString())) {
//            flyable = new JetPlane(name, new Coordinates(longitude, latitude, height));
//        } else if (type.equals(FlyType.BALOON.toString())) {
//            flyable = new Baloon(name, new Coordinates(longitude, latitude, height));
//        }
//        return flyable;
    }

}
