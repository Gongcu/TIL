# Product Defects

### 문제 설명
품질 관리사는 생산 라인에서 생산이 끝난 표본을 검수한다. 각 샘플은 결함(1)이 있거나 결함이 없다(0). 이 샘플들을 2차원 정사각형 배열에 나열 했을 때, 결함이 존재하는 상품들로 구성되는 가장 큰 정사각형의 크기를 결정하라.
![phoneKey](....//images/product_defect.png)


### 아이디어
- DP를 활용한다.
- DP[i][j] = min(DP[i][j-1],DP[i-1][j],DP[i-1][j-1])+1

```python
def LargestArea(samples):
    DP = [[0]*(len(samples)) for _ in range(len(samples))]
    max = 0

    for i in range(len(samples)):
        for j in range(len(samples)):
            DP[i][j] = samples[i][j]

            if i>0 and j>0 and samples[i][j]==1:
                DP[i][j] = min(DP[i][j-1],DP[i-1][j],DP[i-1][j-1])+1
            
            if max < DP[i][j]:
                max = DP[i][j]

    return max
```