function solution(progresses, speeds) {
    var answer = [];
    
    const days = new Array(progresses.length).fill(0);
    for (let d=0; d<days.length; d++){
        days[d] = Math.floor((100-progresses[d]+speeds[d]-1)/speeds[d]);
    }
    while (days.length>0){
        const top = days.shift();
        let cnt = 1;
        while (days.length>0 && days[0]<=top){
            days.shift();
            cnt++;
        }
        answer.push(cnt);
    }
    
    return answer;
}