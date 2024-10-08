import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int on_bridge = 0;
        Queue<Integer> queue = new LinkedList<>();
        
        int time = 1;
        queue.offer(truck_weights[0]);
        on_bridge+=truck_weights[0];
        int idx = 1;
        
        while (idx<truck_weights.length){
            time++;
            if (queue.size()==bridge_length) on_bridge-=queue.poll();
            if (weight>=on_bridge+truck_weights[idx]){
                queue.offer(truck_weights[idx]);
                on_bridge+=truck_weights[idx];
                idx++;
            } else {
                queue.offer(0);
            }
        }
        int cnt = 0;
        while (queue.size()<bridge_length){
            time++;
            queue.offer(0);
        }
        while(!queue.isEmpty()){
            time++;
            int top = queue.poll();
            if (top==0) cnt++;
            else cnt = 0;
        }
        
        
        return time-cnt;
    }
}