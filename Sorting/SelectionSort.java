public class SelectionSort {
    public static void main(String[] args){
        int[] arr = {5,4,3,2,1};
        selectionSort(arr);
        print(arr);
    }

    //i의 주기마다 최소값을 찾아 좌측에 배치
    static void selectionSort(int[] arr){
        for(int i=0; i<arr.length-1; i++){
            int min = arr[i];
            int index = i;
            for(int j=i+1; j<arr.length; j++){
                if(min > arr[j]){
                    min = arr[j];
                    index = j;
                }
            }
            swap(arr, i, index);
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
