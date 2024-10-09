import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        PriorityQueue<Integer[]> pq = new PriorityQueue<>(new Comparator<Integer[]>(){
            @Override
            public int compare(Integer[] iArr1, Integer[] iArr2){
                return iArr1[1] - iArr2[1];
            }
        });
        
        Arrays.sort(jobs, new Comparator<int[]>(){
           @Override
            public int compare(int[] iArr1, int[] iArr2){
                return iArr1[0] - iArr2[0];
            }
        });
        
        
        int time = 0; // 지난 시간
        int idx = 0; // 넣을 작업
        int sum = 0; // 요청부터 종료까지 합
        int cnt = 0; // 다 처리된 작업의 개수
        
        while (cnt<jobs.length) {
            while (idx<jobs.length && jobs[idx][0]<=time){
                pq.offer(new Integer[]{jobs[idx][0], jobs[idx][1]});
                idx++;
            }
            if (!pq.isEmpty()){
                Integer[] top = pq.poll();
                time+=top[1];
                sum+=(time-top[0]);
                cnt++;
            } else {
                time=jobs[idx][0];   
            }
        }
        
        return sum/jobs.length;
    }
}