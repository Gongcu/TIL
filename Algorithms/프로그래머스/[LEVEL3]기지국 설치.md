# 기지국 설치

[문제](https://programmers.co.kr/learn/courses/30/lessons/12979)

## Note
- 문제의 시간복잡도를 고려하여 시간 낭비 없애기
- 시간복잡도를 고려하지 않은 풀이만 직접 풀고, 정답은 차용

### 시간복잡도를 고려한 풀이
```c++
#include <iostream>
#include <vector>
#include <cmath>

using namespace std;


int solution(int n, vector<int> stations, int w)
{
    int answer = 0;
    float range = 2*w+1;
    int leftBound = 1;
    
    for(int i=0; i<stations.size(); i++){
        int rightBound = stations[i]-w;
        answer +=ceil((rightBound-leftBound)/range);
        leftBound = stations[i]+w+1;
    }
    answer += ceil((n+1-leftBound)/range);
    return answer;
}
```

### 시간복잡도를 고려하지 않은 풀이
```c++
int solution(int n, vector<int> stations, int w)
{
    int answer = 0;
    float range = 2*w+1;
    vector<bool> check(n+1,false); //b[0] is not used
    int areaNum = 1;
    int currNum = areaNum;
    bool areaChecker = false;
    map<int,int> areaManager;
    
    for(int i=0; i<check.size(); i++)
        check[i]=false;
    
    //전파 도달 검사
    for(int i=0; i<stations.size(); i++){
        int bound1 = stations[i]-w;
        int bound2 = stations[i]+w;

        if(bound1<1)
            bound1 = 1;
        if(bound2>n)
            bound2 = n;
        for(int j=bound1; j<=bound2; j++){
            check[j]=true;
        }
    }
    
    
    for(int i=1; i<n+1; i++){
        if(check[i]==false){
            if(areaChecker==false)
                areaManager[areaNum++] = 0;
                
            areaChecker=true;
            areaManager[currNum] = areaManager.find(currNum)->second + 1;
        }else{
            areaChecker=false;
            currNum=areaNum;
        }
    }
        
    for(auto it=areaManager.begin(); it!=areaManager.end();it++){
        answer+=ceil(it->second/(range));
    }
    return answer;

```



