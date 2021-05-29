public class InsertionSort {
    public static void main(String[] args){
        int[] arr = {5,4,3,2,1};
        insertionSort(arr);
        print(arr);
    }

    //타겟을 잡고 하위 값들과 비교에서 작다면 뒤로 미룸
    static void insertionSort(int[] arr){
        for(int i=0; i<arr.length; i++){
            int target = arr[i];
            int j=i-1;
            for(; j>=0; j--){
                if(arr[j] > target)
                    arr[j+1]=arr[j];
                
            }
            arr[j+1] = target;
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
