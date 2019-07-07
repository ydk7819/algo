
import java.util.Arrays;
import java.util.Scanner;

public class 벽돌깨기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); //1 ≤ N ≤ 4  공의 개수
			int W = sc.nextInt(); // 2 ≤ W ≤ 12 맵의 열의 개수
			int H = sc.nextInt(); // 2 ≤ H ≤ 15 맵의 행의 개수
			int[][] map = new int[H][W];
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++)
					map[i][j] = sc.nextInt();
			}
			answer = 987654321;
			dfs(map, N);	
			System.out.println("#" + tc + " " + answer);
		}
	}
	static int answer;
	static void dfs(int[][] map, int N) {
		if(N == 0) {
			answer = Math.min(answer, getCnt(map));
			return;
		}
		//공한번 던지고
		for(int i = 0; i < map[0].length; i++) {
			int[][] tmp = new int[map.length][map[0].length];
			deepCopy(map, tmp);
			boooooooooooooooomb(tmp, getBoooooombRow(map, i), i);
			gravity(tmp);
			dfs(tmp, N-1);
		}
	}
	static void deepCopy(int[][] origin, int[][] clone) {
		for(int i = 0; i < origin.length; i++) {
			for(int j = 0; j < origin[i].length; j++)
				clone[i][j] = origin[i][j];
		}
	}
	static void boooooooooooooooomb(int[][] map, int r, int c) {
		if( r < 0 || c < 0 || r >= map.length || c >= map[r].length)
			return;
		int range = map[r][c];
		map[r][c] = 0;
		for(int i = 0; i < range; i++) {
			boooooooooooooooomb(map, r, c + i); //오른쪽
			boooooooooooooooomb(map, r, c - i); //왼쪽
			boooooooooooooooomb(map, r + i, c); //아래쪽
			boooooooooooooooomb(map, r - i, c); //위쪽
		}
	}
	static int getBoooooombRow(int[][] map, int col) {
		for(int i = 0; i < map.length; i++) {
			if( map[i][col] != 0 )
				return i;
		}
		return -1;
	}
	static void gravity(int[][] map) {
		for(int i = map.length - 1; i >= 0; i-- ) {
			for(int j = 0; j < map[i].length; j++) {
				if( map[i][j] == 0 ) {
					for(int k = i - 1; k >= 0; k-- ) {
						if( map[k][j] != 0 ) {
							map[i][j] = map[k][j];
							map[k][j] = 0;
							break;
						}
					}
				}
			}
		}
	}
	static int getCnt(int[][] map) {
		int cnt = 0;
		for(int i = 0; i < map.length; i++) {
//			System.out.println(Arrays.toString(map[i])); //디버깅용
			for(int j = 0; j < map[i].length; j++) {
				if( map[i][j] != 0 )
					cnt++;
			}
		}
		return cnt;
	}
}


















