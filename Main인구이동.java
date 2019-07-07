import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main인구이동 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st2.nextToken());
			}
		}
		
		chk = false;
		int cnt = 0;
		while(true) {
			
			chk = false;
			visited = new boolean[N][N];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(!visited[i][j]) {
						add = new ArrayList<>();
						sum = 0;
						dfs(map, i, j);
						for(int k = 0; k < add.size(); k++) {
							map[add.get(k)[0]][add.get(k)[1]] = sum/add.size();
						}
					}
				}
			}
			cnt++;
			
			if(!chk) {
				break;
			}
		}
		
		
		System.out.println(cnt-1);
	}
	
	static int[] dy = {0,0,-1,1};
	static int[] dx = {1,-1,0,0};
	static int L;
	static int R;
	static int N;
	static boolean[][] visited;
	static List<int[]> add;
	static int sum;
	
	static boolean chk;
	
	
	static void dfs(int[][] map, int y, int x) {
		visited[y][x] = true;
		add.add(new int[] {y,x});
		sum += map[y][x];
		for(int i = 0; i < 4; i++) {
			int yi = dy[i]+y;
			int xi = dx[i]+x;
			
			if(yi < 0 || yi >= N || xi < 0 || xi >= N || visited[yi][xi])continue;
			
			if(Math.abs(map[yi][xi] - map[y][x]) >= L && Math.abs(map[yi][xi] - map[y][x]) <= R) {
				chk = true;
				dfs(map, yi, xi);
			}
			
		}
		
	}
}
