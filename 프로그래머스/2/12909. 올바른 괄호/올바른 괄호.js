function solution(s){
    var answer = true;

    const charArr = [];
    for (let i=0; i<s.length; i++){
        charArr.push(s[i]);
    }
    
    const queue = [];
    if (s[0]===')'||s[s.length-1]==='(') return false;
    for (let i=0; i<s.length; i++){
        if (s[i]===')'){
            if (queue.length===0) return false;
            else queue.shift();
        } else queue.push('(');
    }
    if (queue.length>0) return false;

    return true;
}