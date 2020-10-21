# 중복 문자열의 수 쿼리

[문제](https://programmers.co.kr/learn/courses/30/lessons/59041)

## 쿼리 요약: 중복된 이름을 갖는 동물의 이름과 수를 구하라.

```
SELECT NAME, COUNT(NAME) AS COUNT
FROM ANIMAL_INS
GROUP BY NAME
HAVING COUNT(NAME)>1
ORDER BY NAME ASC
```

## 핵심
- GROUP BY: 테이블을 특정 필드로 묶음 
- HAVING: GROUPY BY로 묶은 데이터에 __집계함수__ 사용(일반적인 조건문은 불가)
  - WHERE절에선 집계함수 사용불가
