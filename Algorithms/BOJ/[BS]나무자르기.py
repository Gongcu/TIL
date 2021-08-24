import sys

#절단기로 잘려 남는 나무 길이
def totalLength(trees, height):
    sum = 0
    for i in trees:
        if(height < i):
            sum = sum+i-height
    
    return sum

# 적어도 m미터의 나무를 가져가이 위한 절단기 최대 높이
treeCount, treeLength = map(int,sys.stdin.readline().split())
trees = list(map(int,sys.stdin.readline().split()))

left = 0
right = 1000000000

result = 0

used = []
while left < right:
    mid = round((left+right)/2)

    # 반복문 탈충
    if mid in used:
        break;
    used.append(mid)

    # 잘려서 남은 나무 길이
    length = totalLength(trees,mid)

    if length >= treeLength:
        result = mid
        left = mid
    else:
        right = mid

print(result)


