class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null || popped == null || pushed.length != popped.length)
            return false;
        
        Deque<Integer> stack = new LinkedList<Integer>();
        int j = 0;
        for (int i : pushed) {
            stack.push(i);
            
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}