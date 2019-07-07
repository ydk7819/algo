import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 색종이붙이기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[10][10];
		list = new ArrayList<int[]>();
		total = 0;
		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					list.add(new int[] { i, j });
					total++;
				}
			}
		}

		visited = new boolean[10][10];
		ans = Integer.MAX_VALUE;
		input(0, 0, 5, 5, 5, 5, 5, 0);
		if(ans == Integer.MAX_VALUE) {
			ans = -1;
		}
		System.out.println(ans);
		
	}

	static int total;
	static boolean[][] visited;
	static int[][] map;
	static List<int[]> list;
	static int ans;

	static void input(int idx, int sum, int one, int two, int three, int four, int five, int cnt) {
		if(sum > ans)return;
			
		if (idx == list.size()) {
			if(cnt == total) {
				ans = Math.min(ans, sum);
			}
			return;
		}
		if (visited[list.get(idx)[0]][list.get(idx)[1]]) {
			input(idx + 1, sum, one, two, three, four, five, cnt);
		}

		int y = list.get(idx)[0];
		int x = list.get(idx)[1];
		int index = chkSize(y, x);
		if (index == 1 && one >= 1) {
			chkMap(y, x, 1, true);
			input(idx+1, sum + 1, one - 1, two, three, four, five, cnt + 1);
			chkMap(y, x, 1, false);
		} else if (index == 2) {
			if (two >= 1) {
				chkMap(y, x, 2, true);
				input(idx+1, sum + 1, one, two - 1, three, four, five, cnt + 4);
				chkMap(y, x, 2, false);
			}
			if (one >= 1) {
				chkMap(y, x, 1, true);
				input(idx+1, sum + 1, one - 1, two, three, four, five, cnt + 1);
				chkMap(y, x, 1, false);
			}
		} else if (index == 3) {
			if (three >= 1) {
				chkMap(y, x, 3, true);
				input(idx+1, sum+1, one, two, three -1 , four, five, cnt+9);
				chkMap(y, x, 3, false);
			}
			if (two >= 1) {
				chkMap(y, x, 2, true);
				input(idx+1, sum + 1, one, two - 1, three, four, five, cnt + 4);
				chkMap(y, x, 2, false);
			}
			if (one >= 1) {
				chkMap(y, x, 1, true);
				input(idx+1, sum + 1, one - 1, two, three, four, five, cnt + 1);
				chkMap(y, x, 1, false);
			}
		} else if (index == 4) {
			if(four >= 1) {
				chkMap(y, x, 4, true);
				input(idx+1, sum+1, one, two, three, four-1, five, cnt+16);
				chkMap(y, x, 4, false);
			}
			if (three >= 1) {
				chkMap(y, x, 3, true);
				input(idx+1, sum+1, one, two, three -1 , four, five, cnt+9);
				chkMap(y, x, 3, false);
			}
			if (two >= 1) {
				chkMap(y, x, 2, true);
				input(idx+1, sum + 1, one, two - 1, three, four, five, cnt + 4);
				chkMap(y, x, 2, false);
			}
			if (one >= 1) {
				chkMap(y, x, 1, true);
				input(idx+1, sum + 1, one - 1, two, three, four, five, cnt + 1);
				chkMap(y, x, 1, false);
			}
		} else if (index == 5) {
			if(five >= 1) {
				chkMap(y, x, 5, true);
				input(idx+1, sum+1, one, two, three, four, five-1, cnt+25);
				chkMap(y, x, 5, false);
			}
			if(four >= 1) {
				chkMap(y, x, 4, true);
				input(idx+1, sum+1, one, two, three, four-1, five, cnt+16);
				chkMap(y, x, 4, false);
			}
			if (three >= 1) {
				chkMap(y, x, 3, true);
				input(idx+1, sum+1, one, two, three -1 , four, five, cnt+9);
				chkMap(y, x, 3, false);
			}
			if (two >= 1) {
				chkMap(y, x, 2, true);
				input(idx+1, sum + 1, one, two - 1, three, four, five, cnt + 4);
				chkMap(y, x, 2, false);
			}
			if (one >= 1) {
				chkMap(y, x, 1, true);
				input(idx+1, sum + 1, one - 1, two, three, four, five, cnt + 1);
				chkMap(y, x, 1, false);
			}
		}

	}

	static int chkSize(int y, int x) {
		if (chkOk(y, x, 2)) {
			if (chkOk(y, x, 3)) {
				if (chkOk(y, x, 4)) {
					if (chkOk(y, x, 5)) {
						return 5;
					}
					return 4;
				}
				return 3;
			}
			return 2;
		}
		return 1;

	}

	static boolean chkOk(int y, int x, int size) {
		if(y+size>=11 || x+size>=11)return false;
		for (int i = y; i < y + size; i++) {
			for (int j = x; j < x + size; j++) {
				if (visited[i][j] || map[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	static void chkMap(int y, int x, int size, boolean val) {
		for (int i = y; i < y + size; i++) {
			for (int j = x; j < x + size; j++) {
				visited[i][j] = val;
			}
		}
	}
}
