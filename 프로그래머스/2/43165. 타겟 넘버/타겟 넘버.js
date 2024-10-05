let cnt = 0;
function solution(numbers, target) {
    dfs(numbers, target, 0, 0);
    return cnt;
}

function dfs(numbers, target, idx, number){
    if (idx===numbers.length){
        if (number===target) {
            cnt++;
        }
        return;
    }
    dfs(numbers, target, idx+1, number+numbers[idx]);
    dfs(numbers, target, idx+1, number-numbers[idx]);
}