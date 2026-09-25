class Solution {

    public String encode(List<String> strs) {
        StringBuilder str = new StringBuilder();

        for(String s : strs) {
            str.append(s.length() + "#" + s);
        }

        String res = str.toString();
        return res;
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;

        while(i < str.length()) {
            int j = i;

            while(str.charAt(j) != '#') {
                j++;
            }

            int nr = Integer.parseInt(str.substring(i, j));
            String s = str.substring(j + 1, j + nr + 1);
            res.add(s);
            i = j + nr + 1;
        }

        return res;
    }
}
