class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];

        for(int i = temperatures.length - 2; i >= 0; i--) {
            int j = i + 1;

            while(j < temperatures.length && temperatures[j] <= temperatures[i]) {
                if(res[j] == 0) {
                    j = temperatures.length;
                    break;
                }

                j += res[j];
            }

            if(j < temperatures.length) res[i] = j - i;
        }

        return res;
    }
}

/*
Because 71 <= 75, day j is not warm enough. You need to find a day warmer than 75.The Naive Way vs. The JumpNaive ($j++$): You check $j + 1$, then $j + 2$, then $j + 3$... one by one. If there are thousands of colder days in between, you waste time scanning every single one.Smart (j += res[j]): You ask: “Could any day between $j$ and the day that beat $j$ possibly beat 75?”No! By definition, every day between $j$ and $j + res[j]$ was colder than or equal to 71.If a temperature couldn't even beat 71, it has zero chance of beating 75.
*/