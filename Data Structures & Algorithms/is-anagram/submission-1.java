class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for(int i = 0; i < s.length(); ++i) {
            if(!map1.containsKey(s.charAt(i))) {
                map1.put(s.charAt(i), 1);
            }
            else {
                int cnt = map1.get(s.charAt(i));
                map1.put(s.charAt(i), cnt + 1);
            }
        }

        for(int i = 0; i < t.length(); ++i) {
            if(!map2.containsKey(t.charAt(i))) {
                map2.put(t.charAt(i), 1);
            }
            else {
                int cnt = map2.get(t.charAt(i));
                map2.put(t.charAt(i), cnt + 1);
            }
        }

        if(map1.size() != map2.size()) return false;

        return map1.equals(map2);
    }
}
