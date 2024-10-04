let maxCnt = 0;

function solution(k, dungeons) {
    var answer = -1;
    
    const visited = new Array(dungeons.length).fill(false);
    visit(dungeons, visited, k, 0);
    
    return maxCnt;
}

function visit(dungeons, visited, k, cnt){
    maxCnt = Math.max(maxCnt, cnt);
    for (let i=0; i<dungeons.length; i++){
        if (!visited[i] && dungeons[i][0]<=k){
            visited[i]=true;
            visit(dungeons, visited, k-dungeons[i][1], cnt+1);
            visited[i]=false;
        }
    }
}