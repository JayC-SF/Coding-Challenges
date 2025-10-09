import java.util.*;

public class Solution {
    static class Call {
        int start;
        int end;
        int duration;
        int volume;

        public Call(int start, int duration, int volume) {
            this.start = start;
            this.duration = duration;
            this.volume = volume;
            this.end = start + duration;
        }
    }

    public static int maximumOrderVolume(int start[], int duration[], int volume[]) {
        // convert to call objects
        Call[] calls = new Call[start.length];

        // create call object for each index
        for (var i = 0; i < calls.length; i++) {
            calls[i] = new Call(start[i], duration[i], volume[i]);
        }

        // sort them by their end time
        Arrays.sort(calls, (c1, c2) -> c1.end - c2.end);

        // find last ending call
        var maxEnd = calls[calls.length - 1].end;

        // create a memoization of calls for rows and time for columns
        //
        int[][] dp = new int[start.length][maxEnd];
        for (var i = 0; i < dp[0].length; i++) {

        }
        // dummy return
        return 0;
    }
}
