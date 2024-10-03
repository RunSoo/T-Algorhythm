const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

let minCnt = Number.MAX_VALUE;

function solution(arr) {
  const [N, M, H] = arr[0].split(" ").map(Number);
  if (M === 0) return 0;
  const map = Array.from({ length: H }, () => new Array(N - 1).fill(false));
  for (let i = 0; i < M; i++) {
    const [a, b] = arr[i + 1].split(" ").map(Number);
    map[a - 1][b - 1] = true;
  }

  if (isSelf(map, N)) return 0;

  dfs(map, N, 0, 0);

  return minCnt === Number.MAX_VALUE ? -1 : minCnt;
}

function dfs(map, N, cnt, startR) {
  if (cnt > 3) {
    return;
  }
  if (isSelf(map, N)) {
    minCnt = Math.min(cnt, minCnt);
    return;
  }

  for (let r = startR; r < map.length; r++) {
    for (let c = 0; c < map[0].length; c++) {
      if (canMark(map, r, c)) {
        map[r][c] = true;
        dfs(map, N, cnt + 1, r);
        map[r][c] = false;
      }
    }
  }
}

function canMark(map, r, c) {
  return (
    !map[r][c] &&
    !(c + 1 < map[0].length && map[r][c + 1]) &&
    !(c - 1 >= 0 && map[r][c - 1])
  );
}

function isSelf(map, N) {
  const R = map.length;

  for (let c = 0; c < N; c++) {
    let pos = c;
    for (let r = 0; r < R; r++) {
      if (pos < N - 1 && map[r][pos]) pos++;
      else if (pos > 0 && map[r][pos - 1]) pos--;
    }
    if (pos !== c) return false;
  }
  return true;
}

console.log(solution(input));