public class HeapSort {
    public static void main(String[] args){
        int[] arr = {5,4,3,2,1};
        heapSort(arr,5);
        print(arr);
    }

    //i의 주기마다 최소값을 찾아 좌측에 배치
    static void heapSort(int[] arr, int size){
        //힙 조정
        for(int i=size/2-1; i>=0; i--)
            adjust(arr,i,size);
        
        //최대값 이동 후, 정렬된 값 빼고 다시 최대 조정 i=size-1 ==> adjust size = size-1;
        for(int i=size-1; i>=0; i--){
            swap(arr,0,i);
            adjust(arr, 0, i); 
        }
    }

    static void adjust(int[] arr, int root, int size){
        int parent = root;
        int left = root*2+1;
        int right = root*2+2;

        if(left < size && arr[left]>arr[parent])
            parent = left;
        
        if(right < size && arr[right]>arr[parent])
            parent = right;

        if(parent!=root){
            swap(arr, root, parent);
            adjust(arr, parent, size);
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
