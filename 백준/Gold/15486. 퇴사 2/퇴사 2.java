import java.io.*;

public class Main {
    public static class Day {
        int t, p;
        Day(int t, int p) {
            this.t = t;
            this.p = p;
        }
        @Override
        public String toString() {
            return "["+t+", "+p+"]";
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Day[] days = new Day[N];
        for (int i=0; i<N; i++) {
            String[] strArr = br.readLine().split(" ");
            days[i] = new Day(Integer.parseInt(strArr[0]), Integer.parseInt(strArr[1]));
        }

        int[] dp = new int[N+1];
        for (int i=0; i<N; i++) {
            if (i + days[i].t <= N) {
                dp[i+days[i].t] = Math.max(dp[i+days[i].t], dp[i]+days[i].p);
            }
            dp[i+1] = Math.max(dp[i+1], dp[i]);
        }

        System.out.println(dp[N]);
    }
}