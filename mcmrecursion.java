class Solution {
    static int mcm(int arr[] , int i , int j){
        if(i == j){
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for(int k = i; k <= j-1;k++){
            int cost1 = mcm(arr , i , k);
            int cost2 = mcm(arr , k + 1, j);
            int cost3 = arr[i - 1] * arr[k] * arr[j];
            int finalcost =cost1 + cost2 + cost3;
            ans = Math.min(ans , finalcost);
        }
        return ans;
    }
    static int matrixMultiplication(int arr[]) {
        // code here
        int n = arr.length;
        int x=mcm(arr , 1 , n - 1);
        return x;
    }
}
