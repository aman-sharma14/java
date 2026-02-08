public class Sort {

    //-----------------------------------------QUICK SORT--------------------------------------------
    /*
     * Time Complexity:
     * - Best Case: O(n log n)
     * - Average Case: O(n log n)
     * - Worst Case: O(n^2) (when array is already sorted)
     *
     * Space Complexity:
     * - O(log n) (due to recursion stack)
     */
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

    //-----------------------------------------BUBBLE SORT-------------------------------------------
    /*
     * Time Complexity:
     * - Best Case: O(n) (When array is already sorted, swap flag breaks early)
     * - Average Case: O(n^2)
     * - Worst Case: O(n^2) (When array is reverse sorted)
     *
     * Space Complexity:
     * - O(1) (In-place sorting)
     */
    public static void bubbleSort(int [] arr){
        for(int i=0; i<arr.length-1;i++){
            boolean swap = false;
            for(int j=0; j<arr.length-i-1;j++){
                if(arr[j] > arr[j+1]){
                    int t = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = t;
                    swap = true;
                }
            }

            if(!swap) break;
        }
    }

    //-----------------------------------------MERGE SORT-----------------------------------------------
    /*
     * Time Complexity:
     * - Best Case: O(n log n)
     * - Average Case: O(n log n)
     * - Worst Case: O(n log n)
     *
     * Space Complexity:
     * - O(n) (requires temporary array)
     */
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

        // Fixed the loop condition here to ensure it copies correctly for all segments
        for (int j = l; j <= h; j++) {
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


    //-----------------------------------------INSERTION SORT-------------------------------------------
    /*
     * Time Complexity:
     * - Best Case: O(n) (when array is already sorted)
     * - Average Case: O(n^2)
     * - Worst Case: O(n^2)
     *
     * Space Complexity:
     * - O(1)
     */
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

    //-----------------------------------------SELECTION SORT-------------------------------------------
    /*
     * Time Complexity:
     * - Best Case: O(n^2)
     * - Average Case: O(n^2)
     * - Worst Case: O(n^2)
     *
     * Space Complexity:
     * - O(1)
     */
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

    //-----------------------------------------HEAP SORT------------------------------------------------
    /*
     * Time Complexity:
     * - Best Case: O(n log n)
     * - Average Case: O(n log n)
     * - Worst Case: O(n log n)
     *
     * Space Complexity:
     * - O(1)
     */
    static void heapSort(int arr[]) {
        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    // To heapify a subtree rooted with node i which is an index in arr[]. n is size of heap
    static void heapify(int arr[], int n, int i) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }


    public static void main(String[] args) {
        int [] arr = {9,3,1,4};
        
        heapSort(arr);
        // mergeSort(arr,0,arr.length-1);

        System.out.println("Sorted Array: ");
        for(int i : arr){
            System.out.print(i + " ");
        }
    }
}