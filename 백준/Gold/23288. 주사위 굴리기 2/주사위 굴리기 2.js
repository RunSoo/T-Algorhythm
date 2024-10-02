const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const dr = [0, 1, 0, -1];
const dc = [1, 0, -1, 0];

class Dice {
  constructor(r, c, dir) {
    this.r = r;
    this.c = c;
    this.top = 1;
    this.north = 2;
    this.east = 3;
    this.west = 4;
    this.south = 5;
    this.bottom = 6;
    this.dir = dir;
  }
  roll(dir) {
    const top = this.top;
    const north = this.north;
    const east = this.east;
    const west = this.west;
    const south = this.south;
    const bottom = this.bottom;
    switch (dir) {
      case 0: // 동쪽으로 구르기
        this.top = west;
        this.east = top;
        this.west = bottom;
        this.bottom = east;
        break;
      case 1: // 남쪽으로 구르기
        this.top = north;
        this.north = bottom;
        this.south = top;
        this.bottom = south;
        break;
      case 2: // 서쪽으로 구르기
        this.top = east;
        this.east = bottom;
        this.west = top;
        this.bottom = west;
        break;
      case 3: // 북쪽으로 구르기
        this.top = south;
        this.north = top;
        this.south = bottom;
        this.bottom = north;
        break;
    }
  }

  changeDir(B) {
    if (this.bottom > B) this.dir = (this.dir + 1) % 4;
    else if (this.bottom < B) this.dir = (this.dir + 3) % 4;
  }

  cantMove() {
    const dir = (this.dir + 2) % 4;
    this.dir = dir;
  }
}

let map;

function solution(arr) {
  const [N, M, K] = input[0].split(" ").map(Number);
  map = Array.from({ length: N }, () => new Array(M).fill(0));
  for (let r = 0; r < N; r++) {
    map[r] = input[r + 1].split(" ").map(Number);
  }
  let dice = new Dice(0, 0, 0); // 시작좌표 0, 0, 동쪽
  let cnt = 0;
  let add = 0;
  while (cnt < K) {
    let nr;
    let nc;
    nr = dice.r + dr[dice.dir];
    nc = dice.c + dc[dice.dir];
    if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
      dice.cantMove();
    }
    dice.r += dr[dice.dir];
    dice.c += dc[dice.dir];
    dice.roll(dice.dir);
    dice.changeDir(map[dice.r][dice.c]);
    cnt++;
    add += bfs(N, M, dice.r, dice.c) * map[dice.r][dice.c];
  }
    
  return add;
}

function bfs(N, M, r, c) {
  const queue = [];
  queue.push([r, c, 1]);
  const visited = Array.from({ length: N }, () => new Array(M).fill(false));
  visited[r][c] = true;
  let depth = 1;
  let cnt = 0;
  while (queue.length > 0) {
    depth = queue[0][2];
    while (queue.length > 0 && queue[0][2] == depth) {
      const top = queue.shift();
      cnt++;
      for (let dir = 0; dir < 4; dir++) {
        const nr = top[0] + dr[dir];
        const nc = top[1] + dc[dir];
        if (
          nr >= 0 &&
          nr < N &&
          nc >= 0 &&
          nc < M &&
          !visited[nr][nc] &&
          map[nr][nc] === map[r][c]
        ) {
          queue.push([nr, nc, depth + 1]);
          visited[nr][nc] = true;
        }
      }
    }
  }
  return cnt;
}

console.log(solution(input));