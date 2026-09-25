class MinStack {
    Deque<Integer> stack;
    Deque<Integer> mini;

    public MinStack() {
        stack = new ArrayDeque<>();
        mini = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.addLast(val);
        if(mini.isEmpty()) mini.addLast(val);
        else {
            if(mini.peekLast() < val) mini.addLast(mini.peekLast());
            else mini.addLast(val);
        }
    }
    
    public void pop() {
        if(stack.isEmpty()) return ;
        mini.removeLast();
        stack.removeLast();
    }
    
    public int top() {
        return stack.peekLast();
    }
    
    public int getMin() {
        return mini.peekLast();
    }
}
