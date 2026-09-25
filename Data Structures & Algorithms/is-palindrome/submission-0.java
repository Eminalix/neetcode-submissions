class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder str = new StringBuilder();
        s = s.toLowerCase();

        for(int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);

            if(Character.isLetterOrDigit(c)) str.append(c);
        }

        StringBuilder s1 = new StringBuilder(str.substring(0, str.length() / 2));
        StringBuilder s2 = new StringBuilder(str.substring(str.length() - str.length() / 2, str.length()));

        if(s1.compareTo(s2.reverse()) == 0) return true;
        
        return false;
    }
}
