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
        Q.offer(intervals.get(0).end);

        for(int i = 1; i < intervals.size(); ++i) {
            if(Q.peek() > intervals.get(i).start) {
                Q.offer(intervals.get(i).end);
            }
            else {
                Q.poll();
                Q.offer(intervals.get(i).end);
            }
        }

        return Q.size();
    }
}
