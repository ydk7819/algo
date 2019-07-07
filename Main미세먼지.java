import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main미세먼지 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st1.nextToken());
		C = Integer.parseInt(st1.nextToken());
		int T = Integer.parseInt(st1.nextToken());
		
		int[][] map = new int[R][C];
		
		List<Integer> cleaner = new ArrayList<>();
		
		for(int i = 0; i < R; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st2.nextToken());
				if(map[i][j]==-1) {
					cleaner.add(i);
				}
			}
		}
		
		while(T > 0) {
			
			int[][] next = new int[R][C];
			
			for(int i = 0; i < R; i++) {
				for(int j = 0; j < C; j++) {
					if (map[i][j]>0) {
						spread(i, j, map, next);
					}
				}
			}
			next[cleaner.get(0)][0] = -1;
			next[cleaner.get(1)][0] = -1;
			
			map = next;
			
			cleanTop(cleaner.get(0), map);
			cleanBottom(cleaner.get(1), map);
			T--;
		}


		System.out.println(check(map));
		
	}
	
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,-1,1};
	static int R;
	static int C;
	
	
	static void spread(int y, int x, int[][] map, int[][] next) {
		int cnt = 0;
		for(int i = 0; i < 4; i++) {
			int yi = y + dy[i];
			int xi = x + dx[i];
			
			if(yi < 0 || xi < 0 || yi >= R || xi >= C || map[yi][xi] == -1)continue;
			
			next[yi][xi] += map[y][x]/5;
			cnt++;
		}
		next[y][x]+=map[y][x] - map[y][x]/5 * cnt;
	}
	
	static void cleanTop(int y, int[][] map) {
		for(int i = y-1; i > 0; i--) {
			map[i][0] = map[i-1][0];
		}
		for(int i = 0; i < C-1; i++) {
			map[0][i] = map[0][i+1];
		}
		for(int i = 0; i < y; i++) {
			map[i][C-1] = map[i+1][C-1];
		}
		for(int i = C-1; i > 1; i--) {
			map[y][i] = map[y][i-1];
		}
		map[y][1] = 0;
	}
	
	static void cleanBottom(int y, int[][] map) {
		for(int i = y+1; i < R-1; i++) {
			map[i][0] = map[i+1][0];
		}
		for(int i = 0; i < C-1; i++) {
			map[R-1][i] = map[R-1][i+1];
		}
		for(int i = R-1; i > y; i--) {
			map[i][C-1] = map[i-1][C-1];
		}
		for(int i = C-1; i > 1; i--) {
			map[y][i] = map[y][i-1];
		}
		map[y][1] = 0;
	}
	
	static int check(int[][] map) {
		int sum = 0;
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] > 0) {
					sum+=map[i][j];
				}
			}
		}
		return sum;
	}
}


