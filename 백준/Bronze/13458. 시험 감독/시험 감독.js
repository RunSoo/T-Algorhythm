const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

function solution(arr) {
  const N = Number(input[0]);
  const applicant = input[1].split(" ").map(Number);
  const [B, C] = input[2].split(" ").map(Number);
  let sum = 0;
  for (let i = 0; i < N; i++) {
    const add = Math.floor((applicant[i] - B + C - 1) / C) + 1;
    sum += add > 0 ? add : 1;
  }
  return sum;
}

console.log(solution(input));