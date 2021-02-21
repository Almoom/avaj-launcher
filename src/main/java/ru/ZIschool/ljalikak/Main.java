package ru.ZIschool.ljalikak;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//cd src/main/java
//find . -name "*.java" > sources.txt
//javac @sources.txt
//jar cmvf Manifest.mf myjar.jar ru/ZIschool/ljalikak/*
//java -jar myjar.jar scenario.txt

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {

        if (args.length != 1) {
            throw new RuntimeException("Incorrect numbers of arguments"); //todo
        }

        Reader reader = new Reader();
        Scenario scenario = reader.readFileToScenario(args[0]);

        DecoderMD5 decoderMD5 = new DecoderMD5();
        scenario = decoderMD5.decode(scenario);

        System.out.println(scenario.getSimNum());
        System.out.println(scenario.getFlyableLogList());
        System.out.println(HashMD5.integers.indexOf("cfcd208495d565ef66e7dff9f98764da"));

//        String outputFileName = "namesJ.txt";
//
//        try (BufferedWriter writter = new BufferedWriter(new FileWriter(outputFileName))) {
//            for (int i = 0; i < 100021; i++) {
//                MessageDigest m = MessageDigest.getInstance("MD5");
//                m.reset();
//                m.update(("J" + i).getBytes());
//                byte[] digest = m.digest();
//                BigInteger bigInt = new BigInteger(1, digest);
//                String hashtext = bigInt.toString(16);
//                while (hashtext.length() < 32) {
//                    hashtext = "0" + hashtext;
//                }
//
//                writter.write(hashtext + "\n");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        System.out.println(AircraftFactory.newAircraft("Baloon", "ytt",1,1,1).toString());

    }

    private static int parseFirstLine(String s) {
        if (s.matches("^\\d+"))
            return Integer.parseInt(s);
        throw new RuntimeException("");
    }

    private static boolean isValidLine(String s, String sb) {

        if (s.matches("^(Baloon|Helicopter|JetPlane)\\s+\\w+\\s+\\d+\\s+\\d+\\s+(\\d{1,2}|100)$")) {
            return true;
        } else {
            System.out.println("-=error line=-");
        }
        return false;
    }
}
