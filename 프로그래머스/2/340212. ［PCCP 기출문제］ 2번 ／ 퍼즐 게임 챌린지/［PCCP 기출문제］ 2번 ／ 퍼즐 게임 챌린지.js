function solution(diffs, times, limit) { // 난이도, 소요시간, 전체 제한시간
    var answer = 0;
    
    let maxLev = 1;
    for (let i=0; i<diffs.length; i++){
        maxLev = Math.max(maxLev, diffs[i]);
    }
    
    const getPuzTime = (idx, level) => {
        if (diffs[idx]>level) return (diffs[idx]-level)*(times[idx]+(idx>0?times[idx-1]:0))+times[idx];
        else return times[idx];
    }
    
    const getTotTime = (level) => {
        let time = 0;
        for (let i=0; i<diffs.length; i++){
            time+=getPuzTime(i, level);
        }
        return time;
    }
    
    let start = 1;
    let end = maxLev;
    
    while (start<=end){
        let mid = Math.floor((start+end)/2);
        const time = getTotTime(mid);
        if (time<=limit){
            end = mid-1;
            answer = mid;
        } else {
            start = mid+1;
        }
    }
    
    return answer;
}