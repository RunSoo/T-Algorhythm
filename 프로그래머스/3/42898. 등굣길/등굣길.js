function solution(m, n, puddles) {
    const MOD = 1000000007;

    const map = Array.from({ length: m }, () => new Array(n).fill(0));

    puddles.forEach(([x, y]) => {
        map[x - 1][y - 1] = -1;
    });

    map[0][0] = 1;

    for (let r = 0; r < m; r++) {
        for (let c = 0; c < n; c++) {
            if (map[r][c] === -1) {
                map[r][c] = 0;
                continue;
            }

            if (r > 0) map[r][c] += map[r - 1][c];
            if (c > 0) map[r][c] += map[r][c - 1];
            map[r][c] %= MOD;
        }
    }

    return map[m - 1][n - 1];
}
