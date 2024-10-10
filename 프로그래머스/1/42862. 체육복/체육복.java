class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        int[] result = new int[n];
        for (int i=0; i<n; i++){
            result[i] = 1;
        }
        for (int l : lost){
            result[l-1] -=1;
        }
        for (int r : reserve) {
            result[r-1] += 1;
        }
        
        for (int i=0; i<n; i++){
            if (result[i]==0){
                if (i-1>=0 && result[i-1]>1){
                    result[i-1]--;
                    result[i]++;
                } else if (i+1<n && result[i+1]>1){
                    result[i+1]--;
                    result[i]++;
                }
            }
        }
        
        for (int i=0; i<n; i++){
            if (result[i]!=0) answer++;
        }
        
        return answer;
    }
}