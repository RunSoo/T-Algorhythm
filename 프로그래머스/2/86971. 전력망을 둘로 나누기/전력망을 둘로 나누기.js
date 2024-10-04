class UnionFind {
    constructor(n){
        this.parent = Array.from({length: n}, (_, i)=>i);
        this.rank = new Array(n).fill(1);
    }
    
    find(x){
        if (this.parent[x]!==x){
            this.parent[x] = this.find(this.parent[x]);
        }
        return this.parent[x];
    }
    
    union(x, y){
        let rootX = this.find(x);
        let rootY = this.find(y);
        
        if (rootX!==rootY){
            if (this.rank[rootX]>this.rank[rootY]){
                this.parent[rootY] = rootX;
            } else if (this.rank[rootX]<this.rank[rootY]){
                this.parent[rootX] = rootY;
            } else {
                this.parent[rootY] = rootX;
                this.rank[rootX]+=1;
            }
        }
    }
}

function solution(n, wires) {
    let minDiff = Number.MAX_VALUE;
    for (let i=0; i<wires.length; i++){
        const uf = new UnionFind(n);
        for (let j=0; j<wires.length; j++){
            if (j!==i){
                uf.union(wires[j][0], wires[j][1]);
            }
        }
        let team1 = 0; let team2 = 0;
        for (let j=1; j<=n; j++){
            if (uf.find(wires[i][0])===uf.find(j)) team1++;
            if (uf.find(wires[i][1])===uf.find(j)) team2++;
        }
        minDiff = Math.min(minDiff, Math.abs(team1-team2));
    }
    return minDiff;
}