public class BubbleSort {
    public static void main(String[] args){
        int[] arr = {5,4,3,2,1};
        bubbleSort(arr);
        print(arr);
    }

    //인접한 두 원소를 비교하여 가장 큰 값을 맨 뒤로 이동
    static void bubbleSort(int[] arr){
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length-i-1; j++){
                if(arr[j]>arr[j+1])
                    swap(arr,j,j+1);
            }
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
