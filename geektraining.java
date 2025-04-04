/*Geek is going for a training program for n days. He can perform any of
these activities: Running, Fighting, and Learning Practice. Each activity has some point 
on each day. As Geek wants to improve all his skills, he can't do the same activity on two 
consecutive days. Given a 2D array arr[][] of size n where arr[i][0], arr[i][1], and arr[i][2] 
represent the merit points for Running, Fighting, and Learning on the i-th day, determine the 
maximum total merit points Geek can achieve .*/

class Solution {
    public int maximumPoints(int arr[][]) {
        // code here
        int n = arr.length; 
        int m = arr[0].length;
        int max = Integer.MAX_VALUE;
        int dp[][] = new int[n][3];
        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];
        for(int i = 1 ; i < n ; i++){
            dp[i][0] = arr[i][0] + Math.max(dp[i - 1][1] , dp[i - 1][2]);
            dp[i][1] = arr[i][1] + Math.max(dp[i - 1][0] , dp[i - 1][2]);
            dp[i][2] = arr[i][2] + Math.max(dp[i - 1][1] , dp[i - 1][0]);
        }
        return Math.max(dp[n - 1][0] , Math.max(dp[n - 1][1] , dp[n - 1][2]));
    }
}
