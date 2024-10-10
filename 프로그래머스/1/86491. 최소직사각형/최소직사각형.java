import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        for (int i=0; i<sizes.length; i++){
            Arrays.sort(sizes[i]); // {세로, 가로}
        }
        
        int width = 0; int height = 0;
        for (int i=0; i<sizes.length; i++){
            width = Math.max(sizes[i][1], width);
            height = Math.max(sizes[i][0], height);
        }
        
        
        return width * height;
    }
}