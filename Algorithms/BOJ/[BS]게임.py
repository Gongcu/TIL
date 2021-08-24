import sys
import math
# 게임 기록
# X: 게임 수, Y: 이긴 게임, Z: 승률(소수점 없음)
# X와 Y가 주어질 때 게임을 몇판 더 해야 Z가 변할까?
# X가 얼마나 늘어야 되는가?
x,y= map(int,sys.stdin.readline().split())
z = y*100//x

if z >= 99:
    print(-1)
else:
    left,right =1, 1000000000
    result = 1000000000
    while left<=right:
        mid = (left+right)//2
        rate = (y+mid)* 100//(x+mid)

        if rate <= z:
            left = mid +1
        else:
            result = mid
            right = mid -1

    print(result)
