import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, new Comparator<int[]>(){
            @Override
            public int compare(int[] iArr1, int[] iArr2) {
                return iArr1[1] - iArr2[1];
            }
        });
        
        int cam = Integer.MIN_VALUE;
        for (int i=0; i<routes.length; i++) {
            if (cam<routes[i][0]){
                cam = routes[i][1];
                answer++;
            }
        }
        
        return answer;
    }
}