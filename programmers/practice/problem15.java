class Solution {
    public static Integer [] dp;


    public static int solve(int n, int y) {
        if (dp[n] == null) {
            if (n % 6 == 0) {
                if (n - y >= 0) {
                    dp[n] = Math.min(solve(n - y, y), Math.min(solve(n/3, y), solve(n/2, y))) + 1;
                } else {
                    dp[n] = Math.min(solve(n/3, y), solve(n/2, y)) + 1;
                }
            } else if (n % 3 == 0) {
                if (n - y >= 0) {
                    dp[n] = Math.min(solve(n/3, y), solve(n - y, y)) + 1;
                } else {
                    dp[n] = solve(n/3, y);
                }
            } else if (n % 2 == 0) {
                if (n - y >= 0) {
                    dp[n] = Math.min(solve(n/2, y), solve(n - y, y)) + 1;
                } else {
                    dp[n] = solve(n/2, y);
                }
            } else {
                if (n - y >= 0) {
                    dp[n] = solve(n - y, y) + 1;
                }
            }
        }
        return dp[n];

    }

    public int solution(int x, int y, int n) {
        dp = new Integer [y + 1];
        dp[0] = dp[1] = 0;
        for (int i = 0; i < x; i++) {
            dp[i] = 0;
        }
        solve(x, n);
        if (dp[x] == null || dp[x] == 0) {
            return -1;
        } else {
            return dp[x];
        }
    }
}

class Solution {

    private static final int MAX = Integer.MAX_VALUE;

    public int solution(int x, int y, int n) {
        int answer = 0;
        int [] dp = new int [y + 1];
        for (int i = x + 1; i < y + 1; i++) {
            int a = MAX;
            int b = MAX;
            int c = MAX;
            int d;
            if (isDivided(i, 2) && aboveX(x, i/2)) {
                a = dp[i/2];
            }
            if (isDivided(i, 3) && aboveX(x, i/3)) {
                b = dp[i/3];
            }
            if (aboveX(x, i-n)) {
                c = dp[i - n ];
            }
            d = Math.min(a, b);
            d = Math.min(d, c);

            dp[i] = ( d < MAX) ? d + 1 : MAX;
        }
        answer = (dp[y] < MAX) ? dp[y] : -1;

        return answer;
    }
    private static boolean aboveX(int x, int num) {
        return (num >= x);
    }

    private static boolean isDivided(int num, int divide) {
        return (num / divide > 0 && num % divide == 0);
    }
}