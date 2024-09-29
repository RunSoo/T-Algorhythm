import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int maxSum = 0;

	public static boolean rangeOut(int[] place) {
		if (place[0] < 0 || place[0] >= N || place[1] < 0 || place[1] >= M)
			return true;
		return false;
	}

	public static class Type {
		int curDir;
		int[][] dr, dc;
		int dirCnt;

		Type(int[][] dr, int[][] dc, int dirCnt) {
			this.dr = dr;
			this.dc = dc;
			this.dirCnt = dirCnt;
			this.curDir = 0;
		}

		void turn() {
			if (curDir < dirCnt - 1) {
				curDir++;
			} else {
				curDir = 0;
			}
		}
	}

	public static class Type1 extends Type {
		Type1() {
			super(new int[][] { { 0, 0, 0, 0 }, { 0, 1, 2, 3 } }, new int[][] { { 0, 1, 2, 3 }, { 0, 0, 0, 0 } }, 2);
		}
	}

	public static class Type2 extends Type {
		Type2() {
			super(new int[][] { { 0, 0, 1, 1 } }, new int[][] { { 0, 1, 0, 1 } }, 1);
		}

	}

	public static class Type3 extends Type {
		Type3() {
			super(new int[][] { { 0, 1, 2, 2 }, { 0, 0, 0, 1 }, { 0, 0, 1, 2 }, { 0, 1, 1, 1 }, { 0, 0, -1, -2 },
					{ 0, 0, 0, 1 }, { 0, 0, 1, 2 }, { 0, 0, 0, -1 } },
					new int[][] { { 0, 0, 0, 1 }, { 0, 1, 2, 0 }, { 0, 1, 1, 1 }, { 0, 0, 1, 2 }, { 0, 1, 1, 1 },
							{ 0, 1, 2, 2 }, { 0, 1, 0, 0 }, { 0, 1, 2, 2 } },
					8);
		}
	}

	public static class Type4 extends Type {
		Type4() {
			super(new int[][] { { 0, 1, 1, 2 }, { 0, 0, -1, -1 }, { 0, -1, -1, -2 }, { 0, 0, 1, 1 } },
					new int[][] { { 0, 0, 1, 1 }, { 0, 1, 1, 2 }, { 0, 0, 1, 1 }, { 0, 1, 1, 2 } }, 4);
		}
	}

	public static class Type5 extends Type {
		Type5() {
			super(new int[][] { { 0, 0, 0, 1 }, { 0, -1, 0, 1 }, { 0, 1, 2, 1 }, { 0, 1, 1, 1 } },
					new int[][] { { 0, 1, 2, 1 }, { 0, 1, 1, 1 }, { 0, 0, 0, 1 }, { 0, -1, 0, 1 } }, 4);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] paper = new int[N][M];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				paper[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		// 입력 받기 끝

		Type[] typeArr = new Type[] { new Type1(), new Type2(), new Type3(), new Type4(), new Type5() };

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				for (int t = 0; t < 5; t++) {
					Type tetro = typeArr[t];
					for (int i = 0; i < tetro.dirCnt; i++) {
						int sum = 0;
						int[][] curArr = new int[4][2];
						for (int j = 0; j < 4; j++) {
							curArr[j][0] = r + tetro.dr[i][j];
							curArr[j][1] = c + tetro.dc[i][j];
							if (rangeOut(curArr[j]))
								break;
							sum += paper[curArr[j][0]][curArr[j][1]];
						}
						maxSum = Math.max(sum, maxSum);
						tetro.turn();
					}
				}

			}
		}

		System.out.println(maxSum);
	}
}