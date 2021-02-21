package ru.ZIschool.ljalikak;

import java.util.ArrayList;

public class Scenario {
    private int simNum;
    private ArrayList<String> flyableLogList;

    public Scenario(int simNum, ArrayList<String> flyableLogList) {
        this.simNum = simNum;
        this.flyableLogList = flyableLogList;
    }

    public int getSimNum() {
        return simNum;
    }

    public ArrayList<String> getFlyableLogList() {
        return flyableLogList;
    }
}
