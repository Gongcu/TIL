public class QuickSort {
    public static void main(String[] args){
        int[] arr = {5,4,3,2,1};
        quickSort(arr,0,4);
        print(arr);
    }

    //피봇을 기준으로 좌측은 작은 값, 우측은 큰 값이 되게 배치
    static void quickSort(int[] arr, int left, int right){
        if(left < right){
            int i = left;
            int j= right;
            int pivot = arr[(left+right)/2];

            while(i<j){
                while(pivot<arr[j]){j--;}
                while(i<j && pivot>arr[i]){i++;}

                swap(arr, i, j);
            }

            quickSort(arr, left, i-1);
            quickSort(arr, i+1, right);
        }
    }

    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    static void print(int[] arr){
        for(int item : arr)
            System.out.print(item+" ");
    }
}
