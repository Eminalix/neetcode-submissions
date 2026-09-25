class Solution {
    public int characterReplacement(String s, int k) {
        // LENGTH - UNI CHAR <= k
        int l = 0, freq = 0, maxl = 0, i = 0, cnt = k;
        Map<Character, Integer> map = new HashMap<>();

        int ls = 0;

        for(i = 0; i < s.length(); ++i) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

            freq = Math.max(freq, map.get(s.charAt(i)));

            while((i - ls + 1) - freq > k) {
                map.put(s.charAt(ls), map.get(s.charAt(ls)) - 1);
                ls++;
            }

            maxl = Math.max(maxl, i - ls + 1);
        }
        
        return maxl;
    }
}
