class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for(int i = 0; i < heights.length; ++i) {
            if(stack.isEmpty()) stack.push(i);
            else {
                if(heights[i] < heights[stack.peek()]) {
                    int rightBoundary = i;

                    while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                        int val = heights[stack.pop()];
                        int leftBoundary = (stack.isEmpty()) ? -1 : stack.peek();

                        maxArea = Math.max(maxArea, val * (rightBoundary - leftBoundary - 1));
                    }
                }

                stack.push(i);
            }
        }

        if(stack.isEmpty()) return maxArea;

        int rightBoundary = heights.length;
        while(!stack.isEmpty()) {
            int val = heights[stack.pop()];
            int leftBoundary = (stack.isEmpty()) ? -1 : stack.peek();

            maxArea = Math.max(maxArea, val * (rightBoundary - leftBoundary - 1));
        }

        return maxArea;
    }
}
/*
    on the stack we need the index of the curr el
    pop from the stack whenever u encounter a height smaller
    than the top one
    whenever i pop something, the right boundary is the smaller element 
    that triggered the pop, and the left boundary is the top element
    on the stack after the pop, and then i can compare the local max
    area stored with the area cause whithin the left and right boundary
    rightBoundary - leftBoundary - 1
    for every element still on the stack when the main loop finishes, the right     
    boundary is uniformly arr.length
*/