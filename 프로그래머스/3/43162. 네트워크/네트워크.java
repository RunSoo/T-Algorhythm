import java.util.*;
class Solution {
    static class UnionFind {
        int[] parent, rank;
        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i=0; i<n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }
        
        int find(int x) {
            if (parent[x]!=x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        
        void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            
            if (rank[rootA]>rank[rootB]) parent[rootB] = rootA;
            else if (rank[rootA]<rank[rootB]) parent[rootA] = rootB;
            else {
                rank[rootA]++;
                parent[rootB] = rootA;
            }
        }
    }
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        UnionFind uf = new UnionFind(n);
        
        for (int r=0; r<n; r++){
            for (int c=0; c<n; c++) {
                if (computers[r][c]==1) uf.union(r, c);
            }
        }
        
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<n; i++) {
            set.add(uf.find(i));
        }
        
        return set.size();
    }
}