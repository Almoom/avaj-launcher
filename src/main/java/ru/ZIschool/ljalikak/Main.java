package ru.ZIschool.ljalikak;

//cd src/main/java
//find . -name "*.java" > sources.txt
//javac @sources.txt
//jar cmvf Manifest.mf myjar.jar ru/ZIschool/ljalikak/*
//java -jar myjar.jar scenario.txt

public class Main {
    public static void main(String[] args) {

        Checker.run(args);

        Scenario scenario = Reader.run(args[0]);
        scenario = DecoderMD5.run(scenario);

        Validator.run(scenario);

        System.out.println((char)55);
        System.out.println(scenario.getSimNum());
        System.out.println(scenario.getFlyableLogList());

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

}
