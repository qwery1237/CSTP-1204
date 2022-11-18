import java.util.Set;
import java.util.HashSet;

public class SortaSquare {

    /**
     * Return a subset of SortaSquares from the integers in set s.
     *
     * @param s
     *            the set from which we want to extract SortaSquares
     * @return a subset with all the SortaSquares in s
     */
    public static Set<Integer> getSortaSquares(Set<Integer> s) {
        // TODO: Implement this method
        HashSet<Integer> result = new HashSet<>();
        for (Integer i : s) {
            if (i < 0) continue;
            if (Math.sqrt(i) % 1 == 0) {
                result.add(i);
                continue;
            }
            for (int j = (int) Math.sqrt(i); j > 1; j--){
                for (int k = 2; k < j; k++){
                    if (i == j*j*k) result.add(i);
                }
            }
        }
        return result;
    }

}