public class recursion {
    static int fibo(int n){
        if(n==1 || n==2){
            return n-1;
        }

        return fibo(n-1) + fibo (n-2);
    }

    static boolean isSorted(int [] arr, int i, int size){
        
        if(size <= 1 ){
            return true;
        }

        if(arr[i] > arr[i+1]){
            return false;
        }else{
            boolean ans  = isSorted(arr, i+1, size-1);
            return ans;
        }

        
    }

    static int sum(int [] arr,int i){
        if(i==arr.length){
            return 0;
        }

        return arr[i] + sum(arr, i+1);
    }

    static int search(int [] arr, int i,int key){
        if(i==arr.length){
            return -1;
        }
        
        if(arr[i] == key){
            return i;
        }
        else{
            int ans = search(arr,i+1,key);
            return ans;
        }
    }

    static boolean binarySearch(int [] arr, int l, int r, int key){
        if (l>r){
            return false;
        }
        int mid = (l+r)/2;
        
        if(key == arr[mid]){
            return true;
        }
        else if(key < arr[mid]){
            return binarySearch(arr, l, mid-1, key);
        }
        else{
            return binarySearch(arr, mid+1, r, key);
        }
    }

    static String reverse(String s, int n){
        if(n==0){
            return s.charAt(0)+"";
        }

        return s.charAt(n) + reverse(s, n-1);
    }
    static void swap(StringBuilder sb, int i, int j){
        char x = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, x);
    }
    static String effReverse(String s, int n, StringBuilder sb){
        if(n>s.length()/2){
            return sb.toString();
        }
        swap(sb, n, s.length()-n-1);
        return effReverse(s, n+1,sb);
    }

    static boolean palindrome(String s, int i){
        if(i>s.length()/2){
            return true;
        }

        if(s.charAt(i)==s.charAt(s.length()-i-1)){
            return palindrome(s, i+1);
        }
        else{
            return false;
        }
    }

    static int pow(int i, int j){
        if(j==0){
            return 1;
        }

        return i * pow(i,j-1);
    }

    static int effpow(int i, int j){
        if(j==0){
            return 1;
        }

        int ans = pow(i, j/2);
        if(j%2==0){
            
            return ans*ans;
        }
        else{
            return i * ans * ans ;
        }
    }

    static void swapN(int [] arr, int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
    static void bubbleSort(int [] arr, int n){
        if(n<=1){
            return;
        }

        for(int i=1; i<n;i++){
            if(arr[i-1]>arr[i]){
                swapN(arr,i,i-1);
            }
        }

        bubbleSort(arr, n-1);
    }

    static void subseq(int i, int [] arr, int n, int s){
        if(s>n){
            return;
        }

        
    }

    static void printPerms(int [] arr, int [] ds, int [] map){
        if(ds.length == arr.length){
            return;
        }

        for(int i=0; i<map.length;i++){
            if(map[i]==0){
                
            }
        }
    }
    public static void main(String[] args) {
        int [] arr = {3,2,5,1,7,6};
        // int n = arr.length;
        // System.out.println(isSorted(arr, 0, n));
        // System.out.println(binarySearch(arr, 0, n-1,9));

        // String s = "ababa";
        //StringBuilder sb = new StringBuilder("");

        //System.out.println(effReverse(s, 0, new StringBuilder(s)));
        bubbleSort(arr, arr.length);
        
        for(int i=0; i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }
}
