import java.io.*;
import java.util.*;
public class TdFMain {

    public static void main(String[] args) {

        FileInputStream tdfStream;

        Map<String, Biker> allBikers = new TreeMap<String, Biker>();

        try {
            // couldn't access the file by just the file name
            tdfStream = new FileInputStream("/Users/sonjinsu/Desktop/school-prjects/CSTP-1204/lab4/tdf.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            BufferedReader tdfReader = new BufferedReader(
                    new InputStreamReader(tdfStream));

            String line;

            while ((line = tdfReader.readLine()) != null) {
                String[] columns = line.split(",");
                String column0 = "";
                String column1 = "";
                String column2 = "";
                String column3 = "";

                // I can not access to the list by index if it is outside of for loop
                // Whenever I try to access to columns[1] or 2,  console says
                //java.lang.ArrayIndexOutOfBoundsException: Index 1 out of bounds for length 1
                //at TdFMain.main(TdFMain.java:52)
                // but inside of for loop I can access...
                // even columns.length is greater than 1 or 2.

                for (int i = 0; i < columns.length; i++) {
                    if (i == 0) {
                        column0 = columns[i];
                    }
                    if (i == 1) {
                        column1 = columns[i];
                    }
                    if (i == 2) {
                        column2 = columns[i];
                    }
                    if (i == 3) {
                        column3 = columns[i];
                    }
                }
                String key = column3 + column2;

                if (allBikers.containsKey(key)) {
                    allBikers.get(key).addPerformanceStats(
                            Integer.parseInt(column0),
                            Double.parseDouble(column1));
                } else {
                    Biker newBiker = new Biker(column2, column3,
                            Integer.parseInt(column0),
                            Double.parseDouble(column1));
                    allBikers.put(key, newBiker);
                }
            }
            tdfReader.close();
            tdfStream.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        for (Map.Entry<String, Biker> currentEntry : allBikers.entrySet()) {
            Biker currentBiker = currentEntry.getValue();
            System.out.println(String.format("%-30s: %s %s",
                    currentBiker.getName(), currentBiker.getBestGain(), currentBiker.getMedianSpeed()));
        }

        double medianSpeed = 0;

        List<Double> allSpeeds = new ArrayList<>();
        for (String bikerName : allBikers.keySet()) {
            for ( int i = 2005 ; i <= 2012; i++){
                if(allBikers.get(bikerName).getSpeedForYear(i) != 0)
                    allSpeeds.add(allBikers.get(bikerName).getSpeedForYear(i));
            }

        }

        // You didn't sort the array.
        Collections.sort(allSpeeds);

        if(allSpeeds.size() % 2 == 1){
            medianSpeed = allSpeeds.get(allSpeeds.size()/2);
        }else{
            medianSpeed = (
                    allSpeeds.get(allSpeeds.size()/2  ) +
                            allSpeeds.get(allSpeeds.size()/2 -1 )
            ) /2;
        }

        System.out.println("\nThe median speed at the Tour de France is "
                + medianSpeed);

        double medianOfMedians = 0;
        List<Double> allMedianSpeeds = new ArrayList<>();
        for (String bikerName : allBikers.keySet()){
            allMedianSpeeds.add(allBikers.get(bikerName).getMedianSpeed());
        }
        Collections.sort(allMedianSpeeds);
        if(allMedianSpeeds.size() % 2 == 1){
            medianOfMedians = allMedianSpeeds.get(allMedianSpeeds.size()/2);
        }else{
            medianOfMedians = (
                    allMedianSpeeds.get(allMedianSpeeds.size()/2  ) +
                            allMedianSpeeds.get(allMedianSpeeds.size()/2 -1 )
            ) /2;
        }

        System.out.println("\nThe median of medians at the Tour de France is "
                + medianOfMedians);

    }
}