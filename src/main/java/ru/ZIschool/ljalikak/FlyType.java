package ru.ZIschool.ljalikak;

public enum FlyType {
    Baloon {
        @Override
        public Flyable create(String name, int longitude, int latitude, int height) {
            return new Baloon(name, new Coordinates(longitude, latitude, height));
        }
    },
    Helicopter {
        @Override
        public Flyable create(String name, int longitude, int latitude, int height) {
            return new Helicopter(name, new Coordinates(longitude, latitude, height));
        }
    },
    JetPlane {
        @Override
        public Flyable create(String name, int longitude, int latitude, int height) {
            return new JetPlane(name, new Coordinates(longitude, latitude, height));
        }
    };

    public abstract Flyable create(String name, int longitude, int latitude, int height);

}
