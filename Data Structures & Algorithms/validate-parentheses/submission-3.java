class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>(Map.of(
            '(', ')',
            '[', ']',
            '{', '}'
        ));

        for(int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);

            if(map.containsKey(c)) stack.push(c);
            else {
                if(stack.isEmpty()) return false;

                if(map.get(stack.peek()) != c) return false;

                stack.pop();
            }
        }

        if(!stack.isEmpty()) return false;

        return true;
    }
}
