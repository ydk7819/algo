import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main사다리조작 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st1.nextToken());
		M = Integer.parseInt(st1.nextToken());
		H = Integer.parseInt(st1.nextToken());

		boolean[][] map = new boolean[H + 2][N + 2];
		for (int i = 0; i < M; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			int y = Integer.parseInt(st2.nextToken());
			int x = Integer.parseInt(st2.nextToken());
			map[y][x] = true;
		}

		ans = 4;

		dfs(1, 1, 0, map);

		if (ans > 3) {
			ans = -1;
		}
		System.out.println(ans);

	}

	static int ans;
	static int N;
	static int M;
	static int H;
	
	static void dfs(int y, int x, int cnt, boolean[][] map) {
		if(x == N+1) {
			y++;
			x=1;
		}
		
		// 종료조건 cnt가 3이거나 이미 마지막에 도착했을 때
		if(cnt == 3 || (x==N && y==H)) {
			if(chk(map)) {
				ans = Math.min(ans, cnt);
			}
			return;
		}
		
		dfs(y, x+1, cnt, map);
		
		// 가로선이 이미 존재할 때
		if(x == N ||  map[y][x] || (x!=1 && map[y][x-1]) || map[y][x+1]) return;
		
		map[y][x] = true;
		dfs(y, x+1, cnt+1, map);
		map[y][x] = false;
	}
	
	static boolean chk(boolean[][] map) {
		for(int i = 1; i <= N; i++) {
			int start = i;
			int end = i;
			for(int j = 1; j <= H; j++) {
				if(map[j][end]) {
					end++;
					continue;
				}
				if(end == 1) continue;
				if(!map[j][end]) {
					if(map[j][end-1]) {
						end--;
						continue;
					}
				}
			}
			if(start != end)return false;
		}
		return true;
	}
	
	



}
