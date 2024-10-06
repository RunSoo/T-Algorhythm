import java.io.*;
import java.util.*;

public class Main {
	public static class Tree implements Comparable<Tree> {
		int r, c, age;

		public Tree(int r, int c, int age) {
			super();
			this.r = r;
			this.c = c;
			this.age = age;
		}

		@Override
		public int compareTo(Tree o) {
			return this.age - o.age;
		}

		@Override
		public String toString() {
			return r + ", " + c + ", " + age;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 땅의 크기
		int M = Integer.parseInt(st.nextToken()); // 나무의 개수
		int K = Integer.parseInt(st.nextToken()); // K년
		int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };

		Deque<Tree> trees = new LinkedList<>();

		int[][] map = new int[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				map[r][c] = 5;
			}
		}

		// 영양분 추가
		int[][] nutrients = new int[N][N];
		for (int r = 0; r < N; r++) {
			String[] str = br.readLine().split(" ");
			for (int c = 0; c < N; c++) {
				nutrients[r][c] = Integer.parseInt(str[c]);
			}
		}

		ArrayList<Tree> treeList = new ArrayList<>();

		// 나무
		for (int i = 0; i < M; i++) {
			String[] str = br.readLine().split(" ");
			int r = Integer.parseInt(str[0]);
			int c = Integer.parseInt(str[1]);
			int age = Integer.parseInt(str[2]);
			treeList.add(new Tree(r - 1, c - 1, age));
		}

		Collections.sort(treeList);

		for (Tree tree : treeList) {
			trees.offer(tree);
		}

		int years = 0;
		while (years < K) {
			Queue<Tree> deadTree = new LinkedList<>();
			// 봄
			int treeLen = trees.size();
			for (int i = 0; i < treeLen; i++) {
				Tree cur = trees.poll();
				if (map[cur.r][cur.c] >= cur.age) {
					map[cur.r][cur.c] -= cur.age;
					cur.age++;
					trees.add(cur);
				} else {
					deadTree.add(cur);
				}
			}
			// 여름
			for (Tree tree : deadTree) {
				map[tree.r][tree.c] += tree.age / 2;
			}
			// 가을
			Queue<Tree> tmpTrees = new LinkedList<>();
			for (Tree tree : trees) {
				if (tree.age % 5 == 0) {
					tmpTrees.add(tree);
				}
			}
			while (!tmpTrees.isEmpty()) {
				Tree tree = tmpTrees.poll();
				for (int d = 0; d < 8; d++) {
					int nr = tree.r + dr[d];
					int nc = tree.c + dc[d];
					if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
						trees.addFirst(new Tree(nr, nc, 1));
					}
				}
			}
			// 겨울
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					map[r][c] += nutrients[r][c];
				}
			}

			years++;
		}
		System.out.println(trees.size());
	}
}