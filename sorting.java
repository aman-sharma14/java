public class sorting {
    public static void print(int [] arr){
        for(int i : arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    public static void selection(int [] arr){
        for(int i = 0; i<arr.length;i++){
            int min = arr[i], idx = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<min){
                    min = arr[j];
                    idx=j;
                }
            }

            arr[idx] = arr[i];
            arr[i] = min;
        }
    }

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

    public static void main(String[] args) {
        int [] arr = {4,7,1,2,8};

        print(arr);
        insertionSort(arr);
        print(arr);
    }
}
