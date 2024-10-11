import java.util.*;

class Solution {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public int solution(int[][] maps) {
        int answer = 0;
        
        return bfs(maps);
    }
    
    public int bfs(int[][] maps) {
        Queue<Integer[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        queue.offer(new Integer[]{0, 0});
        visited[0][0] = true;
        int cnt = 0;
        while(!queue.isEmpty()){
            int len = queue.size();
            cnt++;
            for (int i=0; i<len; i++){
                Integer[] top = queue.poll();
                for (int d=0; d<4; d++){
                    int nr = top[0]+dr[d];
                    int nc = top[1]+dc[d];
                    if (nr>=0 && nr<maps.length && nc>=0 && nc<maps[0].length && !visited[nr][nc] && maps[nr][nc]==1){
                        if (nr==maps.length-1 && nc==maps[0].length-1) {
                            return cnt+1;
                        }
                        queue.offer(new Integer[]{nr, nc});
                        visited[nr][nc]=true;
                    }
                }
                
            }
        }
        return -1;
    }
}