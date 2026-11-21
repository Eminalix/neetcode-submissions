/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals.size() == 0) return 0;

        intervals.sort((a, b) -> Integer.compare(a.start, b.start));
        PriorityQueue<Integer> Q = new PriorityQueue<>();

        for (Interval in : intervals) {
            if (!Q.isEmpty() && Q.peek() <= in.start) Q.poll();
            Q.offer(in.end);
        }

        return Q.size();
    }
}
