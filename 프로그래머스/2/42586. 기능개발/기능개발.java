import java.util.*;
class Solution {
    static class Work {
        int progress, speed;
        Work(int progress, int speed){
            this.progress = progress;
            this.speed = speed;
        }
        void addProgress(){
            if (this.progress<100) this.progress +=speed;
        }
    }
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Work> queue = new LinkedList<>();
        
        for (int i=0; i<progresses.length; i++){
            queue.offer(new Work(progresses[i], speeds[i]));
        }
        
        List<Integer> resultList = new ArrayList<>();
        
        while (!queue.isEmpty()){
            boolean release = true;
            int len = queue.size();
            int works = 0;
            for (int i=0; i<len; i++){
                Work work = queue.poll();
                work.addProgress();
                if (work.progress>=100 && release){
                    works++;
                } else {
                    release = false;
                    queue.offer(work);
                }
            }
            if (works>0) resultList.add(works);
        }
        
        int[] answer = new int[resultList.size()];
        for (int i=0; i<answer.length; i++){
            answer[i] = resultList.get(i);
        }
        
        return answer;
    }
}