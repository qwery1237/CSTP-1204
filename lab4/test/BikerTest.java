import org.junit.Test;

import java.awt.*;
import java.util.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class BikerTest {
    @Test
    public void getBestGain(){
        SortedMap<Integer,Double> averageSpeeds;
        averageSpeeds = new TreeMap<Integer,Double>();
        averageSpeeds.put(2005,33.2);
        averageSpeeds.put(2006,33.2);
        averageSpeeds.put(2007,33.2);
        averageSpeeds.put(2008,33.2);
        //averageSpeeds.put(2009,35.2);
        //averageSpeeds.put(2010,45.2);
        //averageSpeeds.put(2011,47.2);

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
        assertEquals(false,gains.get(gains.size() - 1) > Double.MIN_VALUE);
        //assertEquals(2,gains.get(gains.size() - 1));
    }
    @Test
    public void getMedianSpeed() {
        SortedMap<Integer,Double> averageSpeeds;
        averageSpeeds = new TreeMap<Integer,Double>();
        averageSpeeds.put(2005,33.2);
        averageSpeeds.put(2006,34.2);
        averageSpeeds.put(2007,35.2);
        //averageSpeeds.put(2008,36.2);
        List<Double> speedEntries = new ArrayList<>();
        Double avg = 0.0;
        for(int y : averageSpeeds.keySet())
            speedEntries.add(averageSpeeds.get(y));

        Collections.sort(speedEntries);

        if(speedEntries.size() % 2 == 1) {
            avg = speedEntries.get(speedEntries.size()/2);
        }else {
            avg =  (
                    speedEntries.get(speedEntries.size()/2) +
                            speedEntries.get(speedEntries.size()/2 -1)
            )/2;
        }

        assertEquals(34.2,avg);
        //assertEquals(34.7,avg);
    }
}
