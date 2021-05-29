public class Heap {
    int[] tree;
    int last = 1; //lastIndex & node count
    //root = 1

    Heap(int size){
        tree = new int[size];
    }

    //맨 마지막에 삽입 후 부모와 비교하며 승격
    void add(int value){
        int i=last;
        for(;i!=1;){
            if(value<tree[i/2]){ //최대힙,최소힙 부등호 교체
                tree[i]=tree[i/2];
                i=i/2;
            }else
                break;
        }
        tree[i]=value;
        last++;
    }

    //루트를 제외하고 맨마지막 노드를 루트에 배치하고 최상위에서부터 비교하며 하락
    int pop(){
        int i, j;
        int root = tree[1];
        int candiate = tree[--last];
        //i: 부모, j: 자식 중 하나
        for(i=1,j=2; j<=last;){
            //자식이 둘일 경우 더 큰 자식 선택
            if(j<last)
                if(tree[j]>tree[j+1]) //최소힙일 경우 작은 자식
                    j=j+1;

            //후보가 자식보다 클 경우(최대힙 조건 만족) 종료
            if(candiate<=tree[j]) //최소힙일 경우 작은 자식
                break;

            //자식 노드의 승격
            tree[i]=tree[j];
            //다음 단계로 하락
            i=j;
            j*=2;
        }
        //최종 위치 교체
        tree[i] = candiate;
        return root;
    }
}
