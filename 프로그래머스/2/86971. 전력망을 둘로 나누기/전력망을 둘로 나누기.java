import java.util.*;
class Solution {
    static class UnionFind {
        public int[] parent;
        public int[] rank;
        
        UnionFind(int n){
            parent = new int[n];
            rank = new int[n];
            
            for (int i=0; i<n; i++){
                parent[i] = i;
                rank[i] = 1;
            }
        }
        
        public int find(int x){
            if (parent[x]!=x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        
        public void union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            
            if (rootX!=rootY){
                if (rank[rootX]>rank[rootY]) parent[rootY] = rootX;
                else if (rank[rootY]>rank[rootX]) parent[rootX] = rootY;
                else {
                    rank[rootX]++;
                    parent[rootY] = rootX;
                }
            }
        }
    }
    public int solution(int n, int[][] wires) {
        int answer = -1;
        
        int minDiff = Integer.MAX_VALUE;
        for (int i=0; i<wires.length; i++){
            UnionFind uf = new UnionFind(n);
            for (int j=0; j<wires.length; j++){
                if (j!=i){
                    uf.union(wires[j][0]-1, wires[j][1]-1);
                }
            }
            int cnt1 = 0; int cnt2 = 0;
            for (int j=0; j<n; j++){
                if (uf.find(j)==uf.find(wires[i][0]-1)) cnt1++;
                else cnt2++;
            }
            minDiff = Math.min(minDiff, Math.abs(cnt1-cnt2));
        }
        
        return minDiff;
    }
}