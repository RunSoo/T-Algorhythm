function solution(n, lost, reserve) {
    const gym = new Array(n).fill(1);
    for (let i of lost){
        gym[i-1]--;
    }
    for (let i of reserve){
        gym[i-1]++;
    }
    for (let i=0; i<n; i++){
        if (gym[i]==0){
            if (i-1>=0 && gym[i-1]>1){
                gym[i-1]--;
                gym[i]++;
            } else if (i+1<n && gym[i+1]>1){
                gym[i+1]--;
                gym[i]++;
            }
        }
    }
    let cnt= 0;
    for (let i of gym){
        if (i>=1) cnt++;
    }
    return cnt;
}