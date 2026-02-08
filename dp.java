import java.util.Scanner;

public class dp {
    static int fibo(int n, int [] arr){
        if(n<=2){
            arr[n] = 1;
            return 1;
        }

        if(arr[n]!=0){
            return arr[n];
        }

        arr[n] = fibo(n-1, arr) + fibo(n-2, arr);
        return arr[n];
    }

    static int fiboTab(int n){
        if(n<=1){
            return n;
        }
        int [] arr = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;

        for(int i=2; i<=n;i++){
            arr[i] = arr[i-1] + arr[i-2];
        }

        return arr[n];
    }

    //---------------Frog Jump --------------------
    
    public static int frogRecursive(int [] energies, int i){
        if(i==0){
            return 0;
        }

        int left = frogRecursive(energies, i-1) + Math.abs(energies[i]-energies[i-1]);

        if(i>1){
            int right = frogRecursive(energies, i-2) + Math.abs(energies[i]-energies[i-2]);
            return Math.min(left,right);
        }
        

        return left;
        
    }

    // public static int frogMem(int [] energies, int n, int[]dp){
    //     if(n==0){
    //         dp[n] =  0;
    //         return 0;
    //     }

    //     dp[n]
    // }

    // count sorted vowels
    public static int count(int i, String s, String sb, int n){
        if(sb.length()==n){
            //System.out.println(sb);
            return 1;
        }
        
        int ans = 0;
        for(int j = i; j<s.length();j++){
            ans += count(j, s, sb+s.charAt(j), n);
        }

        return ans;
    }

    public static void main(String[] args) {
        
        //System.out.println(frogRecursive(new int[]{30,10,60,10,60,50}, 5));

        System.out.println(count(0, "aeiou", "", 33));
        
    }
}
