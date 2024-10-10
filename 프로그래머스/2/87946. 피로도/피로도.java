class Solution {
    static int maxCnt = 0;
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        
        boolean[] visited = new boolean[dungeons.length];
        
        for (int i=0; i<dungeons.length; i++){
            if (k>=dungeons[i][0]){
                k-=dungeons[i][1];
                visited[i] = true;
                explore(dungeons, visited, 1, k);
                visited[i] = false;
                k+=dungeons[i][1];
            }
        }
        
        return maxCnt;
    }
    
    public void explore(int[][] dungeons, boolean[] visited, int cnt, int k){
        maxCnt = Math.max(cnt, maxCnt);
        
        for (int i=0; i<dungeons.length; i++){
            if (!visited[i]){
                if (k>=dungeons[i][0]){
                    k-=dungeons[i][1];
                    visited[i] = true;
                    explore(dungeons, visited, cnt+1, k);
                    visited[i] = false;
                    k+=dungeons[i][1];
                }
            }
        }
    }
}