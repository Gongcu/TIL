public class MergeSort {
    static int[] temp = new int[10];
    public static void main(String[] args){
        int[] arr = {5,4,3,2,1};
        mergeSort(arr,0,4);
        print(arr);
    }

    
    static void mergeSort(int[] arr, int left, int right){
        if(left < right){
            int mid = (left+right)/2;
            mergeSort(arr,left,mid);
            mergeSort(arr,mid+1,right);

            merge(arr, left, mid, right);
        }
    }

    static void merge(int[] arr, int left, int mid, int right){
        int i=left;
        int j=mid+1;
        int k=left;

        while(i<=mid && j<=right){
            if(arr[i]<arr[j])
                temp[k++]=arr[i++];
            else
                temp[k++]=arr[j++];
        }

        if(i>mid){
            for(int x=j; x<=right; x++)
                temp[k++]=arr[x];
        }else{
            for(int x=i; x<=mid; x++)
                temp[k++]=arr[x];
        }

        for(int x=left; x<=right; x++)
            arr[x]=temp[x];

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
