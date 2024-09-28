import java.io.*;
import java.util.*;

public class Main {
	static int[] dr = { 0, 0, 0, -1, 1 }; // 동 서 북 남
	static int[] dc = { 0, 1, -1, 0, 0 };

	public static class Dice {
		int top, north, west, east, south, bottom;
		int x, y;

		Dice(int x, int y) {
			this.x = x;
			this.y = y;
			this.top = 0; // 윗면
			this.north = 0; // 북쪽
			this.west = 0; // 동쪽
			this.east = 0; // 서쪽
			this.south = 0; // 남쪽
			this.bottom = 0; // 아래
		}

		void roll1() {
			int top = this.top;
			int west = this.west;
			int east = this.east;
			int bottom = this.bottom;
			this.top = east;
			this.west = top;
			this.east = bottom;
			this.bottom = west;
		}

		void roll2() {
			int top = this.top;
			int west = this.west;
			int east = this.east;
			int bottom = this.bottom;
			this.top = west;
			this.west = bottom;
			this.east = top;
			this.bottom = east;
		}

		void roll3() {
			int top = this.top;
			int north = this.north;
			int south = this.south;
			int bottom = this.bottom;
			this.top = south;
			this.north = top;
			this.south = bottom;
			this.bottom = north;
		}

		void roll4() {
			int top = this.top;
			int north = this.north;
			int south = this.south;
			int bottom = this.bottom;
			this.top = north;
			this.north = bottom;
			this.south = top;
			this.bottom = south;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 세로
		int M = Integer.parseInt(st.nextToken()); // 가로
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken()); // 명령의 개수

		int[][] map = new int[N][M];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		int[] instruction = new int[K];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			instruction[i] = Integer.parseInt(st.nextToken());
		}

		Dice dice = new Dice(x, y);
		
		if (map[x][y]!=0) {
			dice.bottom = map[x][y];
			map[x][y]=0;
		}

		for (int i = 0; i < K; i++) {
			int dir = instruction[i];
			int nx = dice.x + dr[dir];
			int ny = dice.y + dc[dir];
			if (nx < 0 || nx >= N || ny < 0 || ny >= M)
				continue;
			dice.x += dr[dir];
			dice.y += dc[dir];
			switch (dir) {
			case 1:
				dice.roll1();
				break;
			case 2:
				dice.roll2();
				break;
			case 3:
				dice.roll3();
				break;
			case 4:
				dice.roll4();
				break;
			}
			if (map[dice.x][dice.y] == 0) {
				map[dice.x][dice.y] = dice.bottom;
			} else {
				dice.bottom = map[dice.x][dice.y];
				map[dice.x][dice.y] = 0;
			}
			System.out.println(dice.top);
		}
	}
}