import java.util.*;
class Solution {
    static String[] bestResult;
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        
        String[] result = new String[tickets.length+1];
        bestResult = new String[tickets.length+1];
        boolean[] visited = new boolean[tickets.length];
        for (int i=0; i<tickets.length; i++) {
            if (tickets[i][0].equals("ICN")){
                visited[i] = true;
                result[0] = "ICN";
                result[1] = tickets[i][1];
                dfs(tickets, visited, result, 2);
                visited[i] = false;
            }
        }
        
        return bestResult;
    }
    static void dfs(String[][] tickets, boolean[] visited, String[] result, int idx) {
        // System.out.println(Arrays.toString(result));
        if (idx==tickets.length+1) {
            compareTickets(result);
            return;
        }
        for (int i=0; i<tickets.length; i++) {
            if (tickets[i][0].equals(result[idx-1]) && !visited[i]) {
                visited[i] = true;
                result[idx] = tickets[i][1];
                dfs(tickets, visited, result, idx+1);
                visited[i] = false;
            }
        }
    }
    static void compareTickets(String[] result) {
        // System.out.println(Arrays.toString(result));
        if (bestResult[0]==null) {
            for (int i=0; i<result.length; i++) {
                bestResult[i] = result[i];
            }
            return;
        }
        for (int i=0; i<result.length; i++) {
            if (!bestResult[i].equals(result[i])) {
                if (bestResult[i].compareTo(result[i])>0) {
                    for (int j=0; j<result.length; j++) {
                        bestResult[j] = result[j];
                    }
                    return;
                } else return;
            }
        }
    }
}