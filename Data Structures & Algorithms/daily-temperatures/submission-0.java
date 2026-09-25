class Solution {
    public record Pair(int value, int index) {}

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Pair> stack = new Stack<>();
        int[] res = new int[temperatures.length];

        for(int i = temperatures.length - 1; i >= 0; i--) {
            while(!stack.isEmpty() && stack.peek().value() <= temperatures[i]) {
                stack.pop();
            }

            if(stack.isEmpty()) res[i] = 0;
            else res[i] = stack.peek().index() - i;

            stack.push(new Pair(temperatures[i], i));
        }

        return res;
    }
}
