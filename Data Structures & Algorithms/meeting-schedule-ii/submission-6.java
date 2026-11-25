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
    public record Pair(int val, int flag) {};

    public int minMeetingRooms(List<Interval> intervals) {
        Pair[] sweep = new Pair[intervals.size() * 2];
        int max = 0, cnt = 0;

        for(Interval interval : intervals) {
            sweep[cnt++] = new Pair(interval.start, 1);
            sweep[cnt++] = new Pair(interval.end, -1);
        }

        Arrays.sort(sweep, (a, b) -> {
            if(a.val != b.val) return Integer.compare(a.val, b.val);
            return Integer.compare(a.flag, b.flag);
        });

        cnt = 0;
        for(Pair el : sweep) {
            cnt += el.flag;
            max = Math.max(max, cnt);
        }

        return max;
    }
}
