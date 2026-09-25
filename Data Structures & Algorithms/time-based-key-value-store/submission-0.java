class TimeMap {
    public record Pair(int timestamp, String value) {}
    Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<Pair> list = map.getOrDefault(key, new ArrayList<>());
        list.add(new Pair(timestamp, value));
        map.put(key, list);
    }
    
    public String get(String key, int timestamp) {
        List<Pair> list = map.get(key);
        if (list == null || list.isEmpty()) return "";

        String res = "";
        int ls = 0;
        int ld = list.size() - 1;

        while(ls <= ld) {
            int mij = (ls + ld) / 2;

            if(list.get(mij).timestamp() == timestamp) return list.get(mij).value();

            if(list.get(mij).timestamp() < timestamp) {
                res = list.get(mij).value();
                ls = mij + 1;
            }
            else ld = mij - 1;
        }

        return res;
    }
}
