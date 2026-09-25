class MinStack {
    Stack<Integer> stack;
    Stack<Integer> mini;

    public MinStack() {
        stack = new Stack<>();
        mini = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(mini.isEmpty()) mini.push(val);
        else {
            if(mini.peek() < val) mini.push(mini.peek());
            else mini.push(val);
        }
    }
    
    public void pop() {
        if(stack.isEmpty()) return ;
        mini.pop();
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return mini.peek();
    }
}
