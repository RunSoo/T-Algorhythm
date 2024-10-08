import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer i1, Integer i2){
                return i1-i2;
            }
        });
        
        for (int scov : scoville){
            pq.offer(scov);
        }
        
        while (!pq.isEmpty() && pq.peek()<K){
            answer++;
            Integer top = pq.poll();
            if (!pq.isEmpty()) {
                Integer second = pq.poll();
                pq.offer(top+second*2);
            } else {
                return -1;
            }
        }
        
        return answer;
    }
}