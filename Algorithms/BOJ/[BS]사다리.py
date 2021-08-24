import sys
import math
from decimal import Decimal

x,y,c = map(float,sys.stdin.readline().split())
x= Decimal(x)
y= Decimal(y)
c= Decimal(c)

left = Decimal(c)
right = Decimal(min(x,y))

length = Decimal(0)

while right-left>0.000001 :
    length = Decimal((left +right)/Decimal(2))
    x_ = c*length/Decimal(math.sqrt(math.pow(x,2)-math.pow(length,2)))
    y_ = c*length/Decimal(math.sqrt(math.pow(y,2)-math.pow(length,2)))

    length_ = x_+y_

    if length>length_:
        left = length
    else:
        right = length

result = "{:.3f}".format(length)
print(result)
