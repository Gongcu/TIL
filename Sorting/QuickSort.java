public class QuickSort {
    public static void main(String[] args){
        int[] arr = {5,4,3,2,1};
        quickSort(arr,0,4);
        print(arr);
    }

    //피봇을 기준으로 좌측은 작은 값, 우측은 큰 값이 되게 배치
    public static void quickSort(int[] arr ,int left, int right){
        if(left< right){
             int index = partition(arr, left, right);
             quickSort(arr, left, index);
             quickSort(arr, index+1, right);
         }
     }
     
     
     
     public static int partition(int[] arr, int left, int right){
         int pivot = arr[(left+right)/2];
     
         while(left<=right){
             while(arr[left] < pivot) {left++;}
             while(arr[right] > pivot) {right--;}
     
             if(left <= right)
                 swap(arr,left,right);
                 left++;
                 right--;
         }
             
         return left;
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
