import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Deque<Integer> deque = new LinkedList<>();
        Arrays.sort(people);
        for (int p : people) {
            deque.addFirst(p);
        }
        
        while (!deque.isEmpty()){
            Integer heavy = deque.removeFirst();
            if (!deque.isEmpty() && heavy+deque.peekLast()<=limit){
                deque.removeLast();
            }
            answer++;
        }
        
        return answer;
    }
}