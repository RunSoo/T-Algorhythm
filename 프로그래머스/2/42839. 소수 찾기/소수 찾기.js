const set = new Set();

function solution(numbers) {
    const visited = new Array(numbers.length).fill(false);
    for (let i=0; i<numbers.length; i++){
        visited[i]=true;
        makeNumber(Number(numbers[i]), visited, 0, numbers);
        visited[i]=false;
    }
    console.log(set);
    let cnt=0;
    for (let i of set){
        if (isPrime(i)) cnt++;
    }
    
    return cnt;
}

function isPrime(num){
    if (num===1 || num===0) return false;
    if (num===2) return true;
    for (let i=2; i<=Math.sqrt(num); i++){
        if (num%i===0) return false;
    }
    return true;
}

function makeNumber(curNum, visited, idx, numbers){
    if (!set.has(curNum)){
        set.add(curNum);
    }
    if (idx===numbers.length){
        return;
    }
    if (visited.every(el=>el===true)){
        return;
    }
    
    for (let i=0; i<numbers.length; i++){
        if (!visited[i]){
            visited[i]=true;
            makeNumber(Number(curNum+""+numbers[i]), visited, idx+1, numbers);
            visited[i]=false;
        }
    }
}