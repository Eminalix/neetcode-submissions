class Solution {
    record Pair(int value, int index) {}

    public int[] maxSlidingWindow(int[] nums, int k) {
        int max = 0, i, n = 0;
        int[] res = new int[nums.length - k + 1];
        PriorityQueue<Pair> heap = new PriorityQueue<>(
            (a, b) -> Integer.compare(b.value(), a.value())
        );

        for(i = 0; i < k; ++i) heap.offer(new Pair(nums[i], i));
        res[n++] = heap.peek().value();

        while(i < nums.length) {
            heap.add(new Pair(nums[i], i));

            while(heap.peek().index() <= i - k) heap.poll();

            res[n++] = heap.peek().value();
            ++i;
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