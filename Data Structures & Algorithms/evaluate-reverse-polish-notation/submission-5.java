class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        Set<String> map = new HashSet<>(
            Set.of("+", "-", "*", "/")
        );

        for(int i = 0; i < tokens.length; ++i) {
            String c = tokens[i];

            if(!map.contains(c)) stack.push(c);
            else {
                int b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());

                if(c.equals("+")) stack.push(Integer.toString(a + b));
                if(c.equals("-")) stack.push(Integer.toString(a - b));
                if(c.equals("*")) stack.push(Integer.toString(a * b));
                if(c.equals("/")) stack.push(Integer.toString(a / b));
            }
        }

        return Integer.parseInt(stack.pop());
    }
}
/*
    reverse polish notation = post order = SDR
*/