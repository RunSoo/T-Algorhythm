class UnionFind {
    constructor(n){
        this.parent = Array.from({length: n}, (_, i)=>i);
        this.rank = new Array(n).fill(1);
    }
    
    find(x){
        if (this.parent[x]!==x){
            this.parent[x]=this.find(this.parent[x]);
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
                this.rank[rootX]++;
            }
        }
    }
}

function solution(n, computers) {
    const uf = new UnionFind(n);
    for (let r=0; r<computers.length; r++){
        for (let c=0; c<computers[0].length; c++){
            if (computers[r][c]===1){
                uf.union(r, c);
            }
        }
    }
    const set = new Set();
    for (let i=0; i<uf.parent.length; i++){
        set.add(uf.find(uf.parent[i]));
    }
    return set.size;
}