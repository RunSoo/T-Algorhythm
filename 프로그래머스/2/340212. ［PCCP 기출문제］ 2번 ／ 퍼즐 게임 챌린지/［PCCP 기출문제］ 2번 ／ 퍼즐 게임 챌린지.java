import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        
        int maxLev = 1;
        for (int i=0; i<diffs.length; i++){
            maxLev = Math.max(maxLev, diffs[i]);
        }
        
        int start = 1; 
        int end = maxLev; 
        
        while (start <= end) {
            int mid = (start + end) / 2;
            long time = getTotTime(diffs, times, mid);
            if (time <= limit) {
                answer = mid; 
                end = mid - 1;  
            } else {
                start = mid + 1;
            }
        }
        
        return answer;
    }
    
    
    public int getPuzTime(int diff, int time_cur, int time_prev, int level) {
        if (diff>level) return (diff-level)*(time_cur+time_prev)+time_cur;
        else return time_cur;
    }
    
    public long getTotTime(int[] diffs, int[] times, int level){
        long time = 0;
        time+=getPuzTime(diffs[0], times[0], 0, level);
        for (int i=1; i<diffs.length; i++){
            time+=getPuzTime(diffs[i], times[i], times[i-1], level);
        }
        return time;
    }
}