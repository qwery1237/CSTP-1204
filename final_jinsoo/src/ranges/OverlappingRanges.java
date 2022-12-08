package ranges;

import java.util.*;

public class OverlappingRanges {
	public static boolean isValidPoints(int sp, int ep) {
		return sp > 0 && sp < ep;
	}
	/**
	 * Returns the smallest integer that is present in the maximum number of
	 * input ranges
	 * 
	 * @param startPoints
	 *            the list of starting points for the ranges
	 * @param endPoints
	 *            the list of end points for the ranges
	 * @return the smallest integer that is present in the maximum number of
	 *         ranges
	 * @throws NoOverlapException
	 *             when there is no overlap between any of the ranges
	 */
	public static Integer maxOverlapInt(ArrayList<Integer> startPoints, ArrayList<Integer> endPoints) throws NoOverlapException {

		List<Integer> overaps = new ArrayList<>();
		if (startPoints.size() != endPoints.size()) return -1;
		for (int i = 0; i < startPoints.size(); i++) {
			int sp = startPoints.get(i);
			int ep = endPoints.get(i);

			if (!isValidPoints(sp,ep)) continue;

			for (int j = sp; j <=ep;j++) overaps.add(j);
		}

		Collections.sort(overaps);

		Set<Integer> times = new HashSet<>();
		times.addAll(overaps);

		int maxOverlapInt = 0;
		int max = 0;
		for (int time : times)  {
			int overlap = overaps.lastIndexOf(time)-overaps.indexOf(time);

			if ( overlap > max) {
				max = overlap;
				maxOverlapInt = time;
			}
		}

		if (max == 0) throw new NoOverlapException();
		return maxOverlapInt;
	}


}
