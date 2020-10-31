# 중복 문자열의 수 쿼리

[문제](https://programmers.co.kr/learn/courses/30/lessons/59042)

## 쿼리 요약: 입양된 기록(ANIMAL_OUTS)은 있으나, 보호소로 들어온 기록(ANIMAL_INS)이 없는 동물
입양된 기록(A 테이블) - 보호소 등록 기록(B 테이블)을 구하는 것을 의미

```sql
SELECT O.ANIMAL_ID, O.NAME
FROM ANIMAL_OUTS O LEFT OUTER JOIN ANIMAL_INS I ON I.ANIMAL_ID=O.ANIMAL_ID
WHERE I.ANIMAL_ID IS NULL
```

## 핵심
- LEFT OUTER JOIN: 왼쪽 테이블과 오른쪽 테이블을 조인하는데, 왼쪽은 모두 존재. 오른쪽은 왼쪽의 조인 조건에 맞은 행이 없는 경우 NULL 처리한다.
- 아래는 유저 테이블과 소지한 차량 테이블의 유저 LEFT OUTER JOIN 차량 ON ID=UID의 결과이다. 공채운은 차량이 없고, 강하늘은 차량이 존재한다.


|ID|NAME|UID|CAR|
|:---:|:---:|:---:|:---:|
|1|공채운| | |
|2|강하늘|2|쏘나타|
