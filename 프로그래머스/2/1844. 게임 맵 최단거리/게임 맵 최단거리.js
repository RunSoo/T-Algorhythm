const dr = [-1, 1, 0, 0];
const dc = [0, 0, -1, 1];

function solution(maps) {
    return bfs(maps);
}

function bfs(maps){
    const queue = [];
    queue.push([0, 0, 1]);
    const visited = Array.from({length: maps.length}, ()=>new Array(maps[0].length).fill(false));
    visited[0][0]=true;
    while (queue.length>0){
        const [r, c, dist] = queue.shift();
        if (r===maps.length-1 && c===maps[0].length-1){
            return dist;
        }
        for (let d=0; d<4; d++){
            const nr = r+dr[d];
            const nc = c+dc[d];
            if (nr>=0 && nr<maps.length && nc>=0 && nc<maps[0].length && !visited[nr][nc] && maps[nr][nc]===1){
                visited[nr][nc]=true;
                queue.push([nr, nc, dist+1]);
            }
        }
    }
    return -1;
}