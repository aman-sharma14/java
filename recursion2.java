import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class recursion2 {

    //print string n times
    static void printStr(String s , int n){
        if(n==0) return;

        System.out.println(s);
        printStr(s, n-1);
    }


    //print 1 - n
    static void print1toN(int n){
        if(n==0) return;

        print1toN(n-1);

        System.out.println(n);

        
    }

    //print n-1
    static void printNto1(int n){
        if(n==0) return;

        System.out.println(n);
        printNto1(n-1);
    }

    //sum 1 to n
    static int sum(int n){
        if(n==0) return 0;

        return n+sum(n-1);
    }

    //reverse array
    static void reverse(int [] arr, int n){
        if(n==arr.length/2) return;

        int temp = arr[n];
        arr[n] = arr[arr.length-n-1];
        arr[arr.length-n-1] = temp;

        reverse(arr, n+1);
    }

    //palindrome
    static boolean palindrome(String s, int i){
        if(i==s.length()/2) return true;

        if(s.charAt(i) != s.charAt(s.length()-i-1)){
            return false;
        } 

        return palindrome(s, i+1);
    }
    
    //fibonacci
    static int fibonacci(int n){
        if(n<2) return n;
        
        return  fibonacci(n-1)+fibonacci(n-2);
    }

    //subsets
    static void subset(int i, int [] arr, List<Integer> temp){
        if(i==arr.length){
            for(int j=0; j<temp.size();j++){
                System.out.print(temp.get(j)+" ");
            }
            System.out.println();
            return;
        }

        temp.add(arr[i]);
        subset(i+1, arr, temp);
        temp.remove(temp.size()-1);
        subset(i+1, arr, temp);


    }

    //subsets with sum k
    static void subsetSumK(int i, int [] arr, List<Integer> list, int sum, int k){
        if(i==arr.length){
            if(sum==k){
                for(int j=0; j<list.size();j++){
                    System.out.print(list.get(j)+" ");
                }
                System.out.println();
                
            }
            return;
        }

        list.add(arr[i]);
        sum+=arr[i];
        subsetSumK(i+1, arr, list, sum, k);
        list.remove(list.size()-1);
        sum-=arr[i];
        subsetSumK(i+1, arr, list, sum, k);
    }

    //any subset with sum k (only one)
    static boolean anySubsetSumK(int i, int [] arr, List<Integer> list, int sum, int k){
        if(i==arr.length){
            if(sum==k){
                for(int j=0; j<list.size();j++){
                    System.out.print(list.get(j)+" ");
                }
                System.out.println();
                return true;
                
            }
            return false;
        }

        list.add(arr[i]);
        sum+=arr[i];
        if(anySubsetSumK(i+1, arr, list, sum, k)) return true;
        list.remove(list.size()-1);
        sum-=arr[i];
        if(anySubsetSumK(i+1, arr, list, sum, k)) return true;
        return false;
    }

    // count subsequences with sum k
    static int countSubsetWithSumK(int i, int [] arr, int sum, int k){
        if(i==arr.length){
            if(sum==k){
                return 1;
                
            }
            return 0;
        }

        
        sum+=arr[i];
        int l = countSubsetWithSumK(i+1, arr, sum, k);
        
        sum-=arr[i];
        int r = countSubsetWithSumK(i+1, arr,  sum, k);

        return l+r;
    }

    static void subsetSum(int i, int [] arr, int sum, List<Integer> list){
        if(i==arr.length){
            System.out.println(sum);
            return;
        }

        list.add(arr[i]);
        //sum+=arr[i];
        subsetSum(i+1, arr, sum+arr[i], list);
        list.remove(list.size()-1);
        //sum-=arr[i];
        subsetSum(i+1, arr, sum, list);
        
    }

    public static void permutation(int [] arr, int [] map, List<Integer> list){
        if(list.size()==arr.length){
            for(int x : list){
                System.out.print(x+" ");
            }
            System.out.println();
            return;
        }

        
        for(int i=0; i<arr.length;i++){
            if(map[i]==0) {
                map[i] = 1;
                list.add(arr[i]);
                permutation(arr, map, list);
                list.remove(list.size()-1);
                map[i] = 0;
            }
        }
        

    }
    public static void swap(int [] arr, int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
    public static void permutation2(int i, int [] arr) {
        if(i==arr.length){
            for(int j = 0; j<arr.length;j++){
                System.out.print(arr[j]+" ");
            }
            System.out.println();
            return;
        }

        for(int j=i;j<arr.length;j++){
            swap(arr,i,j);
            permutation2(i+1, arr);
            swap(arr, i, j);
        }
    }
    
    public static void letterpermute(int i, StringBuilder s){
        
        if(i == s.length()){
            System.out.println(s);
            return;
        }
        
        if(s.charAt(i) >= '0' && s.charAt(i) <='9'){
            letterpermute(i+1, s);
        }
        else{
            s.setCharAt(i, Character.toLowerCase(s.charAt(i)));
            letterpermute(i+1, s);
            s.setCharAt(i, Character.toUpperCase(s.charAt(i)));
            letterpermute(i+1, s);
        }

        
    }

    public static boolean palindromeb(String s){
        for(int i = 0; i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length()-i-1)) return false;
        }
        return true;
    }

    //palindrome partitioning
    public static void palindromePartition(int i, String s, List<String> list){
        if(i==s.length()){
            System.out.println(list);
            return;
        }

        for(int j = i; j<s.length();j++){
            if(palindromeb(s.substring(i, j+1))){
                list.add(s.substring(i, j+1));
                palindromePartition(j+1, s, list);
                list.remove(list.size()-1);
            }
        }
    }


    public static void generateParentheses(int o, int c, StringBuilder s){
        if(o==0 && c==0){
            System.out.println(s);
            return;
        }

        if(o==c){
            s.append("(");
            generateParentheses(o-1, c, s);
            return;
        }
        
        if(o>0){
            int n = s.length();
            s.append("(");
            generateParentheses(o-1, c, s);
            s.setLength(n);
            s.append(")");
            generateParentheses(o, c-1, s);
        }
        else{
            s.append(")");
            generateParentheses(o, c-1, s);

        }

    }

    public static void phone(int i, String [] arr, String s, int n){
        if(s.length()==n){
            System.out.println(s);
            return;
        }

        for(int j = 0; j<arr[i].length();j++){
            phone(i+1,arr,s+arr[i].charAt(j),n);
        }
    }

    public static void binaryStrings(int n, String s){
        if(s.length()==n){
            System.out.println(s);
            return;
        }

        binaryStrings(n, s+"1");
        if(s.length()==0 || s.charAt(s.length()-1)=='1'){
            binaryStrings(n, s+"0");
        }
    }



    public static void main(String[] args) {
        // printStr("Hi", 5);
        // print1toN(5);
        // printNto1(5);

        // int [] arr = {1,2,3,4,5};
        // reverse(arr,0);

        // for(int i : arr){
        //     System.out.println(i);
        // }

        // String s = "abccba";
        // String s1 = "wjdjwei";

        // System.out.println(palindrome(s, 0));
        // System.out.println(palindrome(s1, 0));

        // System.out.println(fibonacci(4));

        // int [] arr = {3,1,2,6,4,5,9,8,0};
        // //int [] arr1 = {3,2,5};
        // List<Integer> list = new ArrayList<>();
        // // subsetSumK(0, arr, list, 0, 9);
        // System.out.println(countSubsetWithSumK(0, arr, 0, 8));
        // subsetSumK(0, arr, list, 0, 8);

        //int [] arr = {1,2,3};

        //subsetSum(0, arr, 0, new ArrayList<>());
        // permutation(arr, new int[arr.length], new ArrayList<Integer> ());
        //permutation2(0, arr);

        // String s = "a1b2";

        // letterpermute(0, new StringBuilder(s));

        //List<Integer> list = new ArrayList<>(Arrays.asList(2,3));

        // generateParentheses(3,3,new StringBuilder());
        // System.out.println(list);

        //palindromePartition(0, "abcaa", new ArrayList<>());

        //phone(0, new String[]{"abc","def"}, "", 2);

        binaryStrings(1, "");
    }
}
