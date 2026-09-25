class Solution {
    public void swap(int arr[], int a, int b) {
        int aux = arr[a];
        arr[a] = arr[b];
        arr[b] = aux;
    }

    public void pivot(int[] arr, int st, int dr) {
        Random rand = new Random();
        int range = dr - st + 1;

        int pivot = st + rand.nextInt(range);
        swap(arr, dr, pivot);        
    }

    public void quickSelect(int[] arr, Map<Integer, Integer> map, int st, int dr, int k) {
        if(st < dr) {
            pivot(arr, st, dr);

            int ls = st;
            int ld = dr - 1;

            while(ls <= ld) {
                while(ls <= ld && map.get(arr[ls]) < map.get(arr[dr])) ls++;
                while(ls <= ld && map.get(arr[ld]) > map.get(arr[dr])) ld--;

                if(ls <= ld) {
                    swap(arr, ls, ld);
                    ++ls;
                    --ld;
                }
            }

            swap(arr, ls, dr);

            if(ls == k) return ;
            if(ls > k) quickSelect(arr, map, st, ls - 1, k);
            else quickSelect(arr, map, ls + 1, dr, k);
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[k];
        int cnt = 0;

        for(int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int[] arr = new int[map.size()];

        for(int i : map.keySet()) {
            arr[cnt++] = i;
        }

        quickSelect(arr, map, 0, arr.length - 1, arr.length - k);

        return Arrays.copyOfRange(arr, arr.length - k, arr.length);
    }
}
