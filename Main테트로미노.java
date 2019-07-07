import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main테트로미노 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st1.nextToken());
		M = Integer.parseInt(st1.nextToken());
		
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st2.nextToken());
			}
		}
		ans = 0;
		visited = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				dfs(i, j, 0, 0);
				nodfs(i, j);
			}
		}
		System.out.println(ans);
	}
	static int ans;
	static int[][] map;
	static int N;
	static int M;
	static int[] dx = { 0, 0, -1, 1};
	static int[] dy = { 1, -1, 0, 0};
	static boolean[][] visited;
	static void dfs(int y, int x, int idx, int sum) {
		if(idx == 4) {
			ans = Math.max(ans, sum);
			return;
		}
		sum+=map[y][x];
		visited[y][x] = true;
		for(int i = 0; i < 4; i++) {
			int yi = y + dy[i];
			int xi = x + dx[i];
			
			if(yi < 0 || xi < 0 || yi >= N || xi >= M)continue;
			
			if(!visited[yi][xi]) {
				dfs(yi, xi, idx+1, sum);
			}
		}
		visited[y][x] = false;
	}

	static void nodfs(int y, int x) {
		
		if(x + 1 < M && y-1 >= 0 && x-1 >= 0) {
			ans = Math.max(ans, map[y-1][x] + map[y][x-1] + map[y][x+1] + map[y][x]);
		}
		if(y+1 < N && x + 1 < M && y-1 >= 0) {
			ans = Math.max(ans, map[y-1][x] + map[y][x+1] + map[y+1][x] + map[y][x]);
		}
		if(y-1 >= 0 && y+1 < N && x-1 >= 0) {
			ans = Math.max(ans, map[y-1][x] + map[y+1][x] + map[y][x-1] + map[y][x]);
		}
		if(x-1 >= 0 && x+1 < M && y+1 < N) {
			ans = Math.max(ans, map[y][x-1] + map[y][x+1] + map[y+1][x] + map[y][x]);
		}
		
		
	}
}
