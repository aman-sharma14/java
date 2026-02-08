public class Sort {

    //-----------------------------------------QUICK SORT--------------------------------------------
    // TC O(n log n) worst case O(n^2) SC O(1)
    static int partition(int [] arr, int low, int high){
        int i = low, j = high;
        int pivot = arr[low];

        while(i < j){
            while(arr[i] <= pivot && i<=high-1){
                i++;
            }

            while (arr[j]> pivot && j >= low+1){
                j--;
            }

            if(i<j){
                int t = arr[i];
                arr[j] = arr[i];
                arr[i] = t;
            }
        }
        int t = arr[low];
        arr[low] = arr[j];
        arr[j] = t;

        return j;
    }

    static int [] quickSort(int [] arr, int low, int high){
        int index;
        if(low<high){
            index = partition(arr, low, high);
            quickSort(arr, low, index-1);
            quickSort(arr, index+1, high);
        }

        return arr;
        
    }

    //-----------------------------------------MERGE SORT-----------------------------------------------
    static void merge(int [] arr, int l, int m, int h){
        int [] op = new int[arr.length];

        int left = l;
        int right = m+1;
        int i=0;

        while(left <= m && right <=h){
            if(arr[left] < arr[right]){
                op[i] = arr[left];
                left++;
            }
            else{
                op[i] = arr[right];
                right++;
            }

            i++;
        }

        while(left<=m){
            op[i] = arr[left];
            i++; left++;
        }
        while(right<=h){
            op[i] = arr[right];
            i++; right++;
        }

        for (int j = l; j <= h - l; j++) {
            arr[j] = op[j-l];
        }

    }

    static void mergeSort(int [] arr,int l, int h){
        if(l<h){
            int mid = (l+h) / 2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid+1, h);
            merge(arr, l, mid, h);
        }
    }
    
    
    public static void insertionSort(int [] arr){
        for(int i=0; i<arr.length; i++){
            int j = i;
            while(j>0 && arr[j-1]>arr[j]){
                int t = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = t;

                j--;
            }
        }
    }

    static void selection(int [] arr){
        int minEl,mi,t;
        for(int i=0;i<arr.length-1;i++){
            minEl = arr[i];
            mi=i;
            for(int j=i;j<arr.length;j++){
                if(minEl>arr[j]){
                    minEl = arr[j];
                    mi=j;
                }

            }
            t = arr[mi];
            arr[mi] = arr[i]; 
            arr[i] = t;
        }
    }

    

    public static void main(String[] args) {
        int [] arr = {9,3,1,4};
        //3914 3194 1394

        mergeSort(arr,0,arr.length-1);
        System.out.println("selection Sort: ");
        for(int i : arr){
            System.out.print(i + " ");
        }
    }
}

// 4 9 3 5 5 2 1 7 8 
