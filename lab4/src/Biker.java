import java.util.*;
public class Biker {
    private String lastName;
    private String firstName;
    private SortedMap<Integer, Double> averageSpeeds;
    private int numEvents;

    public Biker(String lastName, String firstName, int year, double avgSpeed){
        this.lastName = lastName;
        this.firstName = firstName;

        numEvents = 1;
        averageSpeeds = new TreeMap<Integer, Double>();
        averageSpeeds.put(year, avgSpeed);

    }

    public void addPerformanceStats(int year, double avgSpeed) {
        if (!averageSpeeds.containsKey(year)) {
            averageSpeeds.put(year, avgSpeed);
            numEvents++;
        }
    }

    public String getName() {
        return new String(firstName + " " +lastName);
    }

    public double getBestGain() {
        if (averageSpeeds.keySet().size() <= 1)
            return 0.0;
        List<Double> gains = new ArrayList<>();
        Double gainFromPreviousYear = -1.0;
        for(int y : averageSpeeds.keySet()) {
            if (gainFromPreviousYear != -1) {
                Double aGain = averageSpeeds.get(y) - gainFromPreviousYear;
                    gains.add(aGain);
            }
            gainFromPreviousYear = averageSpeeds.get(y);
        }
        Collections.sort(gains);
        if (gains.get(gains.size() - 1) > Double.MIN_VALUE)
            return gains.get(gains.size() - 1);
        return 0.0;
    }

    public double getMedianSpeed() {
        List<Double> speedEntries = new ArrayList<>();
        for(int y : averageSpeeds.keySet())
            speedEntries.add(averageSpeeds.get(y));

        Collections.sort(speedEntries);

        if(speedEntries.size() % 2 == 1)
            return speedEntries.get(speedEntries.size()/2);

        return (
                speedEntries.get(speedEntries.size()/2) +
                speedEntries.get(speedEntries.size()/2 -1)
        )/2;
    }

    public double getSpeedForYear(int year) {
        if (year < 0) return 0.0;
        if (averageSpeeds.containsKey(year)) {
            return averageSpeeds.get(year);
        } else return 0.0;
    }
}