class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        if(s.length() % 2 != 0) return false;

        for(int i = 0; i < s.length(); ++i) {
            if(stack.isEmpty()) stack.push(s.charAt(i));
            else {
                if(s.charAt(i) == ')' && stack.peek() != '(') return false;
                if(s.charAt(i) == ']' && stack.peek() != '[') return false;
                if(s.charAt(i) == '}' && stack.peek() != '{') return false;

                if(s.charAt(i) == ')' ||
                s.charAt(i) == ']' ||
                s.charAt(i) == '}') stack.pop();
                else stack.push(s.charAt(i));
            }
        }

        if(!stack.isEmpty()) return false;
        
        return true;
    }
}
