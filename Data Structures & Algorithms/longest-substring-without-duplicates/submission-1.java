class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> map = new HashSet<>();
        int cnt = 0, max = 0, ind = 0;
        int i = 0;

        while(i < s.length()) {
            if(!map.contains(s.charAt(i))) {
                map.add(s.charAt(i));
                if(cnt == 0) ind = i;
                ++cnt;
                ++i;
            }
            else {
                if(cnt > max) max = cnt;
                cnt = 0;
                i = ind + 1;
                map = new HashSet<>();
            }
        }

        if(cnt > max) max = cnt;

        return max;
    }
}
