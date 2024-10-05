function solution(N, number) {
    const setArr = Array.from({length: 9}, ()=>new Set());
    for (let i=1; i<9; i++){
        setArr[i].add(Number(String(N).repeat(i)));
        if (i>1){
            for (let j=1; j<i; j++){
                for (let x of setArr[j]){
                    for (let y of setArr[i-j]){
                        setArr[i].add(x+y);
                        setArr[i].add(x-y);
                        setArr[i].add(x*y);
                        if (y!==0) setArr[i].add(x/y);
                    }
                }
            }
        }
    }
    for (let i=1; i<9; i++){
        if (setArr[i].has(number)) return i;
    }
    return -1;
}