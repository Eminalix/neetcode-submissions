class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()) return false;

        int[] m = new int[26];
        int l = s1.length() - 1;

        for(int i = 0; i < s1.length(); ++i) {
            m[s1.charAt(i) - 'a']--;
            m[s2.charAt(i) - 'a']++;
        }

        int cnt = 0;
        for(int i = 0; i < 26; ++i) {
            if(m[i] == 0) cnt++;
        }

        if(cnt == 26) return true;

        int i = l + 1;
        while(i < s2.length()) {
            int c = s2.charAt(i) - 'a';

            int sw = 0;
            if(m[c] != 0) sw = 1;
            m[c]++;
            if(sw == 1 && m[c] == 0) cnt++;
            if(sw == 0 && m[c] != 0) cnt--;

            sw = 0;
            if(m[s2.charAt(i - l - 1) - 'a'] == 0) sw = 1;
            m[s2.charAt(i - l - 1) - 'a']--;
            if(m[s2.charAt(i - l - 1) - 'a'] != 0 && sw == 1) cnt--;
            if(m[s2.charAt(i - l - 1) - 'a'] == 0 && sw == 0) cnt++;

            if(cnt == 26) return true;

            ++i;
        }

        return false;
        
    }
}
