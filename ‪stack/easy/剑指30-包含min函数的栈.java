class MinStack {
    private Deque<Integer> stack;
    private Deque<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        stack  = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
    }
    
    public void push(int x) {
       stack.push(x);
       if (minStack.isEmpty() || x < minStack.peek())
           minStack.push(x);
        else 
            minStack.push(minStack.peek());
    }
    
    public void pop() {
        if (stack.isEmpty())
            return;

        stack.pop();
        minStack.pop();
    }
    
    public int top() {
       return stack.peek();
    }
    
    public int min() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */