/*Given an array arr[] of size n, where arr[i] denotes the height of ith stone. Geek starts from stone 0 and from stone i, 
he can jump to stones i + 1, i + 2, … i + k. The cost for jumping from stone i to stone j is abs(arr[i] – arr[j]). Find the minimum 
cost for Geek to reach the last stone.*/

class Solution {
    public int minimizeCost(int k, int arr[]) {
        // code here
        int n = arr.length;
        if(n == 0) return 0;
        if(n == 1) return 0;
        
        int dp[] = new int[n];
        Arrays.fill(dp , Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1 ; i < n ; i++){
            for(int j = 1 ; j <= k && i >= j ; j++){
                dp[i] = Math.min(dp[i] , dp[i - j] + Math.abs(arr[i] - arr[i - j]));
            }
        }
        return dp[n - 1];
    }
}
