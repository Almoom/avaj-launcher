package ru.ZIschool.ljalikak;

public enum FlyType {
    Baloon("Baloon"),
    Helicopter("Helicopter"),
    JetPlane("JetPlane");

    private String name;

    FlyType(String name){
        this.name = name;
    }

    final public String getName() {
        return name;
    }
}
