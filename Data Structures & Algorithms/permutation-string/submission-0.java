class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()) return false;

        char[] m1 = new char[26];
        char[] m2 = new char[26];
        int l = s1.length() - 1;

        for(int i = 0; i < s1.length(); ++i) {
            m1[s1.charAt(i) - 'a']++;
            m2[s2.charAt(i) - 'a']++;
        }

        if(Arrays.equals(m1, m2)) return true;

        int i = l + 1;
        while(i < s2.length()) {
            m2[s2.charAt(i) - 'a']++;
            m2[s2.charAt(i - l - 1) - 'a']--;

            if(Arrays.equals(m1, m2)) return true;
            ++i;
        }

        return false;
        
    }
}
