class Solution {
    public int[] solution(int brown, int yellow) {
        for (int width = brown/2; width>=0; width--){
            if (yellow%(width-2)!=0) continue;
            int height = (yellow/(width-2))+2;
            if (2*width+2*(height-2)==brown) {
                return new int[]{width, height};
            }
        }
        return new int[]{0, 0};
    }
}