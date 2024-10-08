import java.util.*;

class Solution {
    static class Process {
        int idx, priority;
        Process(int idx, int priority){
            this.idx = idx;
            this.priority = priority;
        }
    }
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Map<Integer, Integer> hasPriority = new HashMap<>();
        Queue<Process> queue = new LinkedList<>();
        for (int i=0; i<priorities.length; i++){
            queue.offer(new Process(i, priorities[i]));
            hasPriority.put(priorities[i], hasPriority.getOrDefault(priorities[i], 0)+1);
        }
        
        Integer[] keys = hasPriority.keySet().toArray(new Integer[hasPriority.size()]);
        Arrays.sort(keys);
        
        int rank=0;
        
        while (!queue.isEmpty()){
            Process process = queue.poll();
            
            boolean hasBigger = false;
            for (int i=keys.length-1; i>=0; i--){
                if (keys[i]>process.priority){
                    if (hasPriority.containsKey(keys[i])) {
                        hasBigger = true;
                        break;
                    }
                } else break;
            }
            if (hasBigger){
                queue.offer(process);
            } else {
                rank++;
                if (process.idx==location){
                    return rank;
                }
                if (hasPriority.get(process.priority)>1){
                    hasPriority.put(process.priority, hasPriority.get(process.priority)-1);
                } else hasPriority.remove(process.priority);
            }
        }
        
        return answer;
    }
}