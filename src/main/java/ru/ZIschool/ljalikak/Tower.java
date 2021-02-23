package ru.ZIschool.ljalikak;

import ru.ZIschool.ljalikak.models.Flyable;

import java.util.ArrayList;
import java.util.List;

public abstract class Tower {
    private List<Flyable> observers = new ArrayList<>();

    public void register(Flyable flyable) {
        observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        observers.remove(flyable);
    }

    protected void conditionsChanged() {
        List<Flyable> list = new ArrayList<>(observers);
        for (Flyable f : list) {
            f.updateConditions();
        }
    }
}
