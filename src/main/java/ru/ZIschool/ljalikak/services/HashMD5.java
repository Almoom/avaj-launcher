package ru.ZIschool.ljalikak.services;

import ru.ZIschool.ljalikak.services.Reader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class HashMD5 {

    final static public Map<String, String> types = new HashMap<String, String>() {{
        put("994736b4f0aec72f6e5ae580051d012f", "Baloon");
        put("2ab8b43468e8b92b0fc5c81e70e35a2d", "Helicopter");
        put("554cd647d6b135f7e36ab1214c5e816a", "JetPlane");
    }};
    final static public ArrayList<String> integers = Reader.readFileToArrayIntByMD5("src/main/resources/intMD5.txt");
    final static public ArrayList<String> namesB = Reader.readFileToArrayIntByMD5("src/main/resources/namesB.txt");
    final static public ArrayList<String> namesH = Reader.readFileToArrayIntByMD5("src/main/resources/namesH.txt");
    final static public ArrayList<String> namesJ = Reader.readFileToArrayIntByMD5("src/main/resources/namesJ.txt");

}
