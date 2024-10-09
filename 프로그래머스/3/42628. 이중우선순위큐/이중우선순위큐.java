import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer i1, Integer i2){
                return i2-i1;
            }
        });
        
        for (int i=0; i<operations.length; i++){
            String[] op = operations[i].split(" ");
            if (op[0].equals("I")){
                pq.offer(Integer.parseInt(op[1]));
                maxPq.offer(Integer.parseInt(op[1]));
            } else if (op[0].equals("D")){
                if (op[1].equals("1")){
                    if (!maxPq.isEmpty()){
                        Integer top = maxPq.poll();
                        pq.remove(top);
                    }
                } else if (op[1].equals("-1")){
                    if (!pq.isEmpty()){
                        Integer top = pq.poll();
                        maxPq.remove(top);
                    }
                }
            }
        }
        int[] answer = new int[2];

        if (pq.isEmpty()){
            answer[0] = 0;
            answer[1] = 0;
        } else {
            answer[0] = maxPq.poll();
            answer[1] = pq.poll();
        }
        
        
        return answer;
    }
}