import java.util.*;
class Solution {
    static class UnionFind {
        int[] parent, rank;
        UnionFind(int n){
            parent = new int[n];
            rank = new int[n];
            
            for (int i=0; i<n; i++){
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
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        UnionFind uf = new UnionFind(n);
        
        Arrays.sort(costs, new Comparator<int[]>(){
            @Override
            public int compare(int[] iArr1, int[] iArr2) {
                return iArr1[2]-iArr2[2];
            }
        });

        for (int i=0; i<costs.length; i++){
            if (uf.find(costs[i][0])!=uf.find(costs[i][1])){
                uf.union(costs[i][0], costs[i][1]);
                answer+=costs[i][2];
            }
        }
        
        return answer;
    }
}