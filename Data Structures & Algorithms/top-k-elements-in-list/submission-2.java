class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

        int[] arr = new int[k];
        int cnt = 0;

        for(int i : map.keySet()) {
            heap.add(i);
            if(heap.size() > k) {
                heap.poll();
            } 
        }

        for(int i = 0; i < k; ++i) {
            arr[cnt++] = heap.poll();
        }

        return arr;
    }
}
