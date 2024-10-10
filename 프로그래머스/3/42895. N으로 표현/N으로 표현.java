import java.util.*;
class Solution {
    public int solution(int N, int number) {
        int answer = 0;
        
        List<Integer>[] canMake = new ArrayList[9];
        for (int i=1; i<9; i++) {
            canMake[i] = new ArrayList<>();
            String five = "";
            for (int j=0; j<i; j++){
                five+=N;
            }
            canMake[i].add(Integer.parseInt(five));
        }
        
        for (int i=2; i<9; i++){
            for (int j=1; j<i; j++) {
                for (Integer num1 : canMake[j]) {
                    for (Integer num2 : canMake[i-j]) {
                        canMake[i].add(num1 + num2);
                        canMake[i].add(num1 - num2);
                        canMake[i].add(num1 * num2);
                        if (num2!=0) canMake[i].add(num1/num2);
                    }
                }
            }
        }
        
        for (int i=1; i<9; i++) {
            if (canMake[i].contains(number)) return i;
        }
        
        return -1;
    }
}