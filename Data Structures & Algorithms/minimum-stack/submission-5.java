class MinStack {
    Stack<Long> stack;
    int min;

    public MinStack() {
        stack = new Stack<>();
        min = 0;
    }
    
    public void push(int val) {
        if(stack.isEmpty()) {
            stack.push(0L);
            min = val;
        }
        else {
            long dif = (long) val - min;
            stack.push(dif);
            if(dif < 0) min = val;
        }
    }
    
    public void pop() {
        if(stack.isEmpty()) return ;
        long dif = stack.peek();
        if(dif < 0) min -= dif;
        stack.pop();
    }
    
    public int top() {
        long dif = stack.peek();
        if(dif < 0) return min;
        return (int) (min + dif);
    }
    
    public int getMin() {
        return min;
    }
}
