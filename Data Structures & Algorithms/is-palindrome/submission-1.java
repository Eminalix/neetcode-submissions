class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder str = new StringBuilder();
        s = s.toLowerCase();

        for(int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);

            if(Character.isLetterOrDigit(c)) str.append(c);
        }

        return str.toString().equals(str.reverse().toString());
    }
}
