class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int[] bucket = new int[nums.length];
        List<Integer>[] buckets = new List[nums.length + 1];

        for(int x : map.keySet()) {
            int freq = map.get(x);

            if(buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }

            buckets[freq].add(x);
        }

        int[] res = new int[k];
        int cnt = 0;

        for(int i = buckets.length - 1; i >= 1 && cnt != k; i--) {
            if(buckets[i] != null) {
                for(int num : buckets[i]) {
                    res[cnt++] = num;
                }
            }
        }

        return res;
    }
}
