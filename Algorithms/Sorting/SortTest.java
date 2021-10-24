import Heap;
public class SortTest {
    private static int INF = 10000000;

    static int[] tempArr = new int[10];

    public static void main(String[] args){
        int[] arr = {3,2,5,10,1};

        heapSortVer2(arr,5);
        print(arr);
    }

    //선택 정렬
    //i번째 값과 교체할 최소값 인덱스를 찾아 주기마다 스왑
    static void selectionSort(int[] arr, int size){
        int minIndex = 0;
        for(int i=0; i<size-1; i++){
            minIndex = i;
            //i 기준 이전값은 이미 정렬된 상태이므로 i+1부터 진행
            for(int j=i+1; j<size; j++){
                if(arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
            
        }
    }

    //버블 정렬
    //전체를 순회하며 극단값을 맨 뒤로
    static void bubbleSort(int[] arr, int size){
        for(int i=0; i<size; i++){
            for(int j=0; j<size-1; j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j]= arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }

    //삽입(비교)정렬
    //현재 비교자하는 타겟과 이전 원소들과 비교하며 교체
    //타겟의 자리를 찾는 과정
    static void insertionSort(int[] arr, int size){
        for(int i=1; i<size; i++){
            int target = arr[i];
            int j=i-1;
            

            //타겟이 이전 원소보다 크기 전까지 반복
            for(; j>=0; j--){
                if(arr[j]>target){
                    arr[j+1]=arr[j]; //값을 한 칸씩 뒤로 이동
                }
            }
            //최소 위치에 타겟 설정
            arr[j+1]=target;
        }
    }

    //퀵정렬
    static void quickStort(int[] arr, int left, int right){
        if(left < right){
            int i = left;
            int j = right;
            int pivot = arr[(left+right)/2];

            while(i<j){
                while(arr[j]>pivot) j--;
                while(i<j && arr[i]< pivot) i++;

                swap(arr,i,j);
            }

            //i<j에 의해 i는 pivot의 위치
            quickStort(arr, left, i-1);
            quickStort(arr, i+1, right);
        }
    }

    static void mergeSort(int[] arr, int left, int right){
        if(left<right){
            int mid = (left+right)/2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            merge(arr,left,mid,right);
        }
    }

    static void merge(int[] arr, int left, int mid, int right){
        int i = left;
        int j = mid+1;
        int k = left;


        while(i<=mid && j<=right){
            if(arr[i]>arr[j])
                tempArr[k++]=arr[j++];
            else
                tempArr[k++]=arr[i++];
        }

        if(i>mid){
            for(int x=j;x<=right;x++)
                tempArr[k++] = arr[x];
        }else{
            for(int x=i;x<=mid;x++)
                tempArr[k++] = arr[x];
        }

        for(int x=left; x<=right; x++)
            arr[x]=tempArr[x];
        
    }



    static void heapSortVer1(int[] arr, int size){
        Heap heap = new Heap(size+1);
        for(int i=0; i<size;i++){
            heap.add(arr[i]);
        }
        for(int i=0; i<size;i++){
            arr[i]=heap.pop();
        }
    }

    //https://mygumi.tistory.com/310
    static void adjustToHeap(int[] arr, int root, int size){
        int parent = root;
        int left = 2*root+1;
        int right = 2*root+2;

        //왼쪽 자식이 큰 경우
        if(left < size && arr[parent] < arr[left])
            parent = left;

        //우측 자식이 왼쪽보다 큰 경우(현재 parent==left)
        if(right < size && arr[parent] < arr[right])
            parent = right;
        
        if(root != parent){
            swap(arr, parent, root);
            adjustToHeap(arr, parent, size);
        }
    }

    static void heapSortVer2(int[] arr, int size){
        //히프 구조로 조정(size/2-1: 자식이 있는 노드만 조정)
        for(int i=size/2-1; i>=0; i--)
            adjustToHeap(arr, i, size);
        //정렬-> 현재 가장 큰 값인 root를 마지막으로 보내고
        //맨 가장 큰 값인 맨 마지막 값을 제외하고 다시 힙으로 조정 이를 반복
        for(int i=size-1; i>0; i--){
            swap(arr,0,i);
            adjustToHeap(arr, 0, i);
        }
    }

    static void print(int[] arr){
        for(int i=0; i<arr.length; i++)
            System.out.print(arr[i]+" ");
    }

    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    
}
