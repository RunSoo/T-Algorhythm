import java.util.*;

class Solution {
    static class Stock {
        int idx, price;
        Stock(int idx, int price){
            this.idx = idx;
            this.price = price;
        }
        
        @Override
        public String toString(){
            return "["+idx+", "+price+"]";
        }
    }
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Stack<Stock> stack = new Stack<>();
        for (int i=0; i<answer.length; i++){
            answer[i] = prices.length-1;
        }
        for (int i=0; i<prices.length; i++){
            while (!stack.isEmpty() && stack.peek().price > prices[i]){
                Stock stock = stack.pop();
                answer[stock.idx]=i-stock.idx;
            } 
            stack.push(new Stock(i, prices[i]));
        }
        
        while (!stack.isEmpty()){
            Stock stock = stack.pop();
            answer[stock.idx] = prices.length-1-stock.idx;
        }
        
        
        return answer;
    }
}