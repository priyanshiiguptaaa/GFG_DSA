/* Geek is learning data structures, and he recently learned about the top-down and bottom-up dynamic programming approaches. Geek is having trouble telling them apart from one another.

When given an integer n, where n is based on a 0-based index, find the nth Fibonacci number.

Every ith number in the series equals the sum of the (i-1)th and (i-2)th numbers, where the first and second numbers are specified as 0 and 1, respectively.

For the given issue, code both top-down and bottom-up approaches.

Note : As the answer might be large, return the final answer modulo 109 + 7 */

class Solution {
    static final int MOD = 1000000007;

    static int topDown(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) dp[i] = -1;
        return helper(n, dp);
    }

    static int helper(int n, int[] dp) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (dp[n] != -1) return dp[n];

        dp[n] = (helper(n - 1, dp) + helper(n - 2, dp)) % MOD;
        return dp[n];
    }

    static int bottomUp(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }
        return dp[n];
    }
}
