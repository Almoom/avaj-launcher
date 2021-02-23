package ru.ZIschool.ljalikak.models;

import java.util.ArrayList;

public class Scenario {
    private String simNum;
    private ArrayList<String> flyableLogList;

    public Scenario(String simNum, ArrayList<String> flyableLogList) {
        this.simNum = simNum;
        this.flyableLogList = flyableLogList;
    }

    public String getSimNum() {
        return simNum;
    }

    public ArrayList<String> getFlyableLogList() {
        return flyableLogList;
    }
}
