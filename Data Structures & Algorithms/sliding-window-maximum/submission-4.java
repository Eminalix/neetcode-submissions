class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int max = 0, n = 0;
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deck = new ArrayDeque<>();

        for(int i = 0; i < nums.length; ++i) {
            // pop all invalid numbers outside the window
            while(deck.size() > 0 && deck.peekFirst() <= i - k) deck.pollFirst();

            // add element such that it is the highest on top
            while(deck.size() > 0 && nums[deck.peekLast()] < nums[i]) deck.pollLast();
            deck.addLast(i);

            if(i - k + 1 >= 0) res[n++] = nums[deck.peekFirst()];
        }

        return res;
    }
}
/*
first push k elements from the array in the heap, in the form of value - index; then i put the max in an array without popping, as i move the window, i check whether the index is within the window using i - k and if its not i pop it and check again and do so until the end
- push k
- record max
- start while:
    - push element
    - pop every top i - k
    - record max
*/

/*
    Approach 2:
    Monotonic Deque Approach
    - using a deque of size k
    - add the first k elements
    - while the add element is bigger than the current top element, remove the elements   
    - as i move along the window, pop one element from the left of the queue if its index is not whithin the window
    => store index in the deque (I can easily access values through it)
*/