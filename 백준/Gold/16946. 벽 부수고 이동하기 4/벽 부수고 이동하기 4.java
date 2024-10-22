import java.io.*;
import java.util.*;

public class Main {
  public static class UnionFind {
    int[] parent, rank;
    int N, M;

    UnionFind(int N, int M) {
      this.N = N;
      this.M = M;
      int size = N * M;
      parent = new int[size];
      rank = new int[size];

      for (int i = 0; i < size; i++) {
        parent[i] = i;
        rank[i] = 1;
      }
    }

    public int convert(int r, int c) {
      return r * this.M + c;
    }

    public int[] convertBack(int num) {
      int r = num / this.M;
      int c = num % this.M;
      return new int[] { r, c };
    }

    public int find(int r, int c) {
      int idx = convert(r, c);
      if (parent[idx] != idx) {
        find(parent[idx] / this.M, parent[idx] % this.M);
      }
      return parent[idx];
    }

    public void union(int r1, int c1, int r2, int c2) {
      int root1 = find(r1, c1);
      int root2 = find(r2, c2);

      if (root1 != root2) {
        if (rank[root1] > rank[root2]) {
          parent[root2] = root1;
        } else if (rank[root1] < rank[root2]) {
          parent[root1] = root2;
        } else {
          parent[root2] = root1;
          rank[root1]++;
        }
      }
    }
  }

  static int N, M;
  static int[][] map;
  static int[][] canGo;
  static boolean[][] visited;

  static int[] dr = { -1, 1, 0, 0 };
  static int[] dc = { 0, 0, -1, 1 };

  static UnionFind uf;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new int[N][M];
    canGo = new int[N][M];

    for (int r = 0; r < N; r++) {
      String[] strArr = br.readLine().split("");
      for (int c = 0; c < M; c++) {
        map[r][c] = Integer.parseInt(strArr[c]);
      }
    }

    visited = new boolean[N][M];
    uf = new UnionFind(N, M);

    for (int r = 0; r < N; r++) {
      for (int c = 0; c < M; c++) {
        if (!visited[r][c] && map[r][c] == 0) {
          visited[r][c] = true;
          dfs(r, c, r, c);
          int parentIdx = uf.find(r, c);
          canGo[uf.convertBack(parentIdx)[0]][uf.convertBack(parentIdx)[1]] = canGo[r][c];
        }
      }
    }

    int[][] result = new int[N][M];
    Set<Integer> set = new HashSet<>();
    for (int r=0; r<N; r++) {
      for (int c=0; c<M; c++) {
        if (map[r][c]==1) {
          result[r][c] = 1;
          for (int d=0; d<4; d++) {
            int nr = r+dr[d];
            int nc = c+dc[d];
            if (nr>=0 && nr<N && nc>=0 && nc<M && map[nr][nc]==0) {
              boolean flag = true;
              for (Integer i : set) {
                if (uf.find(uf.convertBack(i)[0], uf.convertBack(i)[1])==uf.find(nr, nc)) {
                  flag = false;
                  break;
                }
              }
              if (flag) {
                int parentIdx = uf.find(nr, nc);
                result[r][c]=(result[r][c]+canGo[uf.convertBack(parentIdx)[0]][uf.convertBack(parentIdx)[1]])%10;
                set.add(parentIdx);
              }
            }
          }
          set.clear();
        }
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int r=0; r<N; r++) {
      for (int c=0; c<M; c++) {
        sb.append(result[r][c]);
      }
      sb.append("\n");
    }
    System.out.println(sb);
  }

  public static void dfs(int r, int c, int ir, int ic) {
    canGo[ir][ic] += 1;
    for (int d = 0; d < 4; d++) {
      int nr = r+dr[d];
      int nc = c+dc[d];
      if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && map[nr][nc] == 0) {
        uf.union(r, c, nr, nc);
        visited[nr][nc] = true;
        dfs(nr, nc, ir, ic);
      }
    }
  }
}