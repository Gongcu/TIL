# 디스크 컨트롤러

[문제](https://programmers.co.kr/learn/courses/30/lessons/42627)

## 아이디어
- 요청 도착 + 작업 시간이 빠른 순서로 진행해야 한다.
- List로 요청이 빠른 순서대로 정렬하여 진행하며
- 이번 턴에 수행 가능한 작업을 추출해 우선순위 큐에 저장하여 작업시간이 가장 빠른것을 우선으로 수행

```java
import java.util.*;
class Solution {
    int time = 0;


    class Job{
        int requestTime;
        int workTime;
        
        public Job(int r, int w){
            requestTime = r;
            workTime = w;
        }  
    }
    public int solution(int[][] jobs) {
        PriorityQueue<Job> pq = new PriorityQueue((new Comparator<Job>() {
    		@Override
    		public int compare(Job j1, Job j2) {
    			return j1.workTime - j2.workTime;
    		}
    	}));
        
        LinkedList<Job> list = new LinkedList();
        
        for(int[] job : jobs) {
    		list.add(new Job(job[0], job[1]));
    	}
    	
        //1. 요청 빠른 순
    	Collections.sort(list, new Comparator<Job>() {
			@Override
			public int compare(Job j1, Job j2) {
				return j1.requestTime - j2.requestTime;
			}
    	});
        
        int totalSpendTime = 0;
    	int count = 0; //처리된 작업 수
    	int time = list.peek().requestTime;

    	while(count < jobs.length) {
            
            //대기열에서 이번 턴에 수행 가능한 작업 추출
    		while(!list.isEmpty() && list.peek().requestTime <= time) {
    			pq.add(list.pollFirst());
    		}
    		
        
    		if(!pq.isEmpty()) {
    			Job job = pq.poll();
    			time += job.workTime;
    			totalSpendTime += time - job.requestTime;
    			cnt++;
    		} else {
    			time++;
    		}
    	}
    	
    	return totalSpendTime / count;
    }
}
```
