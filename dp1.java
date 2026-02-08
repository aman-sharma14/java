import java.util.Arrays;

public class dp1 {

    //---------------------------General Knapsack----------------------------

    public static int knapsackRecursive(int [] wt, int [] val, int weight, int n){
        if(n==0 || weight == 0){
            return 0;
        }

        if(wt[n-1]<=weight){
            return Math.max(val[n-1]+knapsackRecursive(wt, val, weight-wt[n-1], n-1),knapsackRecursive(wt, val, weight, n-1));
        }
        else{
            return knapsackRecursive(wt, val, weight, n-1);
        }
    }

    public static int knapsackMemoize(int [] wt, int [] val, int weight, int n, int [][] dp){
        if(n==0 || weight == 0){
            return 0;
        }

        if(dp[n][weight]!=-1) return dp[n][weight];

        if(wt[n-1]<=weight){
            return dp[n][weight] = Math.max(val[n-1]+knapsackMemoize(wt, val, weight-wt[n-1], n-1,dp),knapsackMemoize(wt, val, weight, n-1,dp));
        }
        else{
            return dp[n][weight] = knapsackMemoize(wt, val, weight, n-1,dp);
        }
    }

    public static int knapsackTab(int [] wt, int [] val, int n, int weight){
        int [][] dp = new int [n+1][weight+1];

        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=weight;j++){
                if(wt[i-1]<=j){
                    dp[i][j] = Math.max(val[i-1]+dp[i-1][j-wt[i-1]],dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][weight];
    }
    public static void main(String[] args) {
        int [][] dp = new int [5][7];
        for(int i = 0; i<5;i++){
            Arrays.fill(dp[i],-1);
        }
        System.out.println(knapsackTab(new int[]{2,3,5,4}, new int[]{1,5,7,9}, 4,6));
    }
}
