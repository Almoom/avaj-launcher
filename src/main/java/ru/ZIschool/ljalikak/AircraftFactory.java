package ru.ZIschool.ljalikak;

public abstract class AircraftFactory {

    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        Flyable flyable = null;

        System.out.println(FlyType.Baloon.getName());

//        switch (type) {
//            case "Helicopter" :
//                return new Helicopter(name, new Coordinates(longitude, latitude, height));
//            case FlyType.JetPlane.getName():
//                return new JetPlane(name, new Coordinates(longitude, latitude, height));
//            case FlyType.Baloon.getName() :
//                return new Baloon(name, new Coordinates(longitude, latitude, height));
//            default :
//                throw new RuntimeException("no such class");
//        }

        if (type.equals(FlyType.Helicopter.getName())) {
            flyable = new Helicopter(name, new Coordinates(longitude, latitude, height));
        } else if (type.equals(FlyType.JetPlane.getName())) {
            flyable = new JetPlane(name, new Coordinates(longitude, latitude, height));
        } else if (type.equals(FlyType.Baloon.getName())) {
            flyable = new Baloon(name, new Coordinates(longitude, latitude, height));
        }
        return flyable;
    }

}
