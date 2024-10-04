const set = new Set();
const alp = ['A', 'E', 'I', 'O', 'U'];

function solution(word) {
    for (let i=0; i<alp.length; i++){
        makeLetter(alp[i], 1);
    }
    const allLetters = [];
    for (let str of set){
        allLetters.push(str);
    }
    allLetters.sort((a, b)=>(a+b)-(b+a));
    return allLetters.indexOf(word)+1;
}

function makeLetter(letter, idx){
    
    if (!set.has(letter)){
        set.add(letter);
    }
    if (idx===5){
        return;
    }
    for (let i=0; i<alp.length; i++){
        makeLetter(letter+alp[i], idx+1);
    }
}