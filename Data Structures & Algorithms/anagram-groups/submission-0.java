class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs) {
            int[] temp = new int[26];

            for(char c : s.toCharArray()) {
                temp[c - 'a']++;
            }

            StringBuilder key = new StringBuilder();

            for(int i : temp) {
                key.append(i + "#");
            }

            String keyf = key.toString();

            map.computeIfAbsent(keyf, k -> new ArrayList<String>()).add(s);
        }

        for(String key : map.keySet()) {
            List<String> words = new ArrayList<>(map.get(key));
            result.add(words);
        }    

        return result;
    }
}