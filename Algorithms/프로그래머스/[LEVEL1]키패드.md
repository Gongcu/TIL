# 카카오 겨울 인턴십 2020 - 키패드 누르기

[문제](https://programmers.co.kr/learn/courses/30/lessons/67256)


```java
import java.util.*;
class Solution {
    int[] leftHandLocation = {3,0};
    int[] rightHandLocation = {3,2};
    
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int[][] phone = new int [4][3]; //4x3
        int count =1;
        
        //전화기 입력 숫자 설정
        for(int i=0; i<phone.length-1; i++)
            for(int j=0; j<phone[i].length; j++)
                phone[i][j]=count++;
        phone[3][0]=-1;phone[3][1]=0;phone[3][2]=-2;
        
        //번호 마다 정답 갱신 + 손가락 위치 변경
        for(int i=0; i<numbers.length; i++){
            switch(numbers[i]){
                case 1,4,7:
                    answer+="L";
                    changeLocation(numbers[i]);
                    break;
                case 3,6,9:
                    answer+="R";
                    changeLocation(numbers[i]);
                    break;
                default:
                    answer+=compare(numbers[i],hand);
                    break;
            }
            
        }
        
        return answer;
    }
    
    String compare(int number, String hand){
        int[] numberLocation={-1,1};
        int leftDistance = 0, rightDistance=0;
        switch(number){
            case 2:
                numberLocation[0]=0;
                break;
            case 5:
                numberLocation[0]=1;
                break;
            case 8:
                numberLocation[0]=2;
                break;
            case 0:
                numberLocation[0]=3;
                break;
        }
        leftDistance=
            Math.abs(numberLocation[0]-leftHandLocation[0])+
            Math.abs(numberLocation[1]-leftHandLocation[1]);
            
        rightDistance=
            Math.abs(numberLocation[0]-rightHandLocation[0])+
            Math.abs(numberLocation[1]-rightHandLocation[1]);
        
        //거리 비교해서 가까운 쪽 갱신
        if(leftDistance<rightDistance){
            leftHandLocation[0]=numberLocation[0];
            leftHandLocation[1]=numberLocation[1];
            return "L";
        }else if(leftDistance>rightDistance){
            rightHandLocation[0]=numberLocation[0];
            rightHandLocation[1]=numberLocation[1];
            return "R";
        }else{//거리가 같으면 ㅇ손잡이에 따라 설정
            if(hand.equals("left")){
                leftHandLocation[0]=numberLocation[0];
                leftHandLocation[1]=numberLocation[1];
                return "L";
            }else{
                rightHandLocation[0]=numberLocation[0];
                rightHandLocation[1]=numberLocation[1];
                return "R";
            }
        }
            
        
    }
    
    void changeLocation(int number){
        if(number % 3 == 1){
            leftHandLocation[0]=number/3;
            leftHandLocation[1]=0;
        }else if(number % 3 == 0){
            rightHandLocation[0]=number/3-1;
            rightHandLocation[1]=2;
        }
    }
}
```
