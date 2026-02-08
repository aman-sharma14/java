import java.util.ArrayList;
import java.util.List;

public class arrays {
    static boolean checkSort(int [] arr){

        for(int i=1; i<arr.length;i++){
            if(arr[i]<arr[i-1]){
                return false;
            }
        }
        return true;
    }

    static ArrayList union(int [] a, int [] b){
        ArrayList<Integer> union = new ArrayList<>();

        int i = 0;
        int j = 0;

        while(i<a.length && j<b.length){
            int n;
            if(a[i]<=b[j]){
                n = a[i];
                i++;
            }
            else{
                n = b[j];
                j++;
            }

            if(!union.isEmpty() && union.get(union.size()-1)==n){
                    continue;
            }
            union.add(n);
        }

        while(i<a.length){
            union.add(a[i]);
            i++;
        }
        while(j<b.length){
            union.add(b[j]);
            j++;
        }

        return union;
    }

    static ArrayList intersection(int []a , int [] b){
        ArrayList<Integer> intersection = new ArrayList<>();

        int i=0, j=0;

        while(i<a.length && j<b.length){
            if(a[i]==b[j]){
                intersection.add(a[i]);
                i++;
                j++;
            }
            else if(a[i]<b[j]){
                i++;
            }
            else{
                j++;
            }
        }
        return intersection;
    }

    static ArrayList unique(int []a , int [] b){
        ArrayList<Integer> unique = new ArrayList<>();
        int i=0, j=0;
        while(i<a.length && j<b.length){
            if(a[i]==b[j]){
                if(unique.isEmpty() || unique.get(unique.size()-1)!=a[i]){
                    unique.add(a[i]);
                }
               
                i++;
                j++;
            }
            else if(a[i]<b[j]){
                i++;
            }
            else{
                j++;
            }
        }

        return unique;
    }

    static ArrayList longestSubArray(int[] a, int k){
        ArrayList<Integer> ans = new ArrayList<>();

        int i=0, j=0, sum = 0, maxl = 0;

        // 2 3 3 8 6 4 2 1 1 5 9 1
        //
        
        while(i<=j){
            
            sum+=a[j];

            while(sum<k){

            }

            
        }


        return ans;
    }
    public static void main(String[] args) {
        int [] arr = {1,2,2,2,3,4,4,4,4,7,8,9};
        int [] arr1 = {1,2,2,4,4,5,6};

        ArrayList<Integer> union = unique(arr, arr1);

        for(int n: union){
            System.out.println(n);
        }
    }
}
