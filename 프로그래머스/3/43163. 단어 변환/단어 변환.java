import java.util.*;

class Solution {
    static class Word {
        int idx;
        String word;
        Word(int idx, String word){
            this.idx = idx;
            this.word = word;
        }
        @Override
        public String toString() {
            return "["+word+", "+idx+"]";
        }
    }
    public int solution(String begin, String target, String[] words) {

        return bfs(begin, target, words);
    }
    
    public int bfs(String begin, String target, String[] words) {
        Queue<Word> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        int cnt = 0;
        for (int i=0; i<words.length; i++) {
            if (diffOne(begin, words[i])){
                queue.offer(new Word(i, words[i]));
                visited[i]=true;
            }
        }
        
        while (!queue.isEmpty()) {
            int len = queue.size();
            cnt++;
            for (int i=0; i<len; i++){
                Word top = queue.poll();
                if (top.word.equals(target)) return cnt;
                for (int j=0; j<words.length; j++) {
                    if (!visited[j] && diffOne(top.word, words[j])) {
                        queue.offer(new Word(j, words[j]));
                        visited[j]=true;
                    }
                }
            }
        }
        return 0;
    }
    
    public boolean diffOne(String str1, String str2){
        int cnt = 0;
        for (int i=0; i<str1.length(); i++){
            if (str1.charAt(i)!=str2.charAt(i)) {
                cnt++;
            }
            if (cnt>1) return false;
        }
        if (cnt==1) return true;
        return false;
    }
}