class Solution {
    static class Person {
        int score;
        int[] answers;
        Person(int num) {
            this.score = 0;
            if (num==1) answers = new int[]{1, 2, 3, 4, 5};
            else if (num==2) answers = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
            else if (num==3) answers = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        }
        void mark(int idx, int answer){
            if (this.answers[idx % this.answers.length]==answer) this.score+=1;
        }
    }
    
    public int[] solution(int[] answers) {

        Person p1 = new Person(1);
        Person p2 = new Person(2);
        Person p3 = new Person(3);
        
        for (int i=0; i<answers.length; i++){
            p1.mark(i, answers[i]);
            p2.mark(i, answers[i]);
            p3.mark(i, answers[i]);
        }
        
        int maxScore = Math.max(p1.score, (Math.max(p2.score, p3.score)));
        
        int len = 0;
        if (p1.score==maxScore) len++;
        if (p2.score==maxScore) len++;
        if (p3.score==maxScore) len++;
        
        int[] answer = new int[len];
        int idx = 0;
        if (p1.score==maxScore) answer[idx++]=1;
        if (p2.score==maxScore) answer[idx++]=2;
        if (p3.score==maxScore) answer[idx++]=3;
        
        return answer;
    }
}