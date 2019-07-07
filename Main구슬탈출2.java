import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main구슬탈출2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[N][M];
		int[] R = new int[2];
		int[] B = new int[2];
		int[] O = new int[2];
		
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'B') {
					B[0] = i;
					B[1] = j;
				}else if(map[i][j] == 'R') {
					R[0] = i;
					R[1] = j;
				}else if(map[i][j] == 'O') {
					O[0] = i;
					O[1] = j;
				}
			}
		}
		
		ans = 11;
		power(map, new int[2], 0);
		if(ans == 11) {
			ans = -1;
		}
	
		System.out.println(ans);

		
	}
	static int N;
	static int M;
	static int ans;
	
	static void power(char[][] map, int[] result, int cnt) {
		
		if(result[1] == 1) {
			return;
		}
		
		if(cnt > ans) {
			return;
		}
		
		if(cnt > 10) {
			return;
		}


		if(result[0] == 1) {
			ans = Math.min(cnt, ans);
			return;
		}
		
		
		char[][] copy = new char[N][M];
		
		for(int k = 0;k < 4; k++) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					copy[i][j] = map[i][j];
				}
			}
			power(copy, gravity(copy, k), cnt+1);
		}

	}
	
	static int[] gravity(char[][] map, int d) {
		int[] result = new int[2];
		switch(d) {
		case 0:
			for(int j = 0; j < M; j++) {
				for(int i = 0; i < N-1; i++) {
					if(map[i][j]=='.') {
						for(int k = i+1; k < N; k++ ) {
							if(map[k][j]=='R' || map[k][j]=='B') {
								char temp = map[i][j];
								map[i][j] = map[k][j];
								map[k][j] = temp;
								break;
							}
							if(map[k][j]!='.')break;
						}
					}
					if(map[i][j]=='O') {
						for(int k = i+1; k < N; k++ ) {
							if(map[k][j]=='#')break;
							if(map[k][j]=='R') {
								result[0]++;
								map[k][j] = '.';
							}
							else if(map[k][j]=='B') {
								result[1]++;
								map[k][j] = '.';
							}
						}
					}
				}
			}
			break;
		case 1:
			for(int j = 0; j < M; j++) {
				for(int i = N-1; i > 0; i--) {
					if(map[i][j]=='.') {
						for(int k = i-1; k >= 0; k--) {
							if(map[k][j]=='R' || map[k][j]=='B') {
								char temp = map[i][j];
								map[i][j] = map[k][j];
								map[k][j] = temp;
								break;
							}
							if(map[k][j]!='.')break;
						}
					}
					if(map[i][j]=='O') {
						for(int k = i-1; k >= 0; k--) {
							if(map[k][j]=='#')break;
							if(map[k][j]=='R') {
								result[0]++;
								map[k][j] = '.';
							}else if(map[k][j]=='B'){
								result[1]++;
								map[k][j] = '.';
							}
						}
					}
				}
			}
			break;
		case 2:
			for(int i = 0; i < N; i++) {
				for(int j = 0 ; j < M-1; j++) {
					if(map[i][j]=='.') {
						for(int k = j+1; k < M; k++) {
							if(map[i][k]=='R' || map[i][k]=='B') {
								char temp = map[i][j];
								map[i][j] = map[i][k];
								map[i][k] = temp;
								break;
							}
							if(map[i][k]!='.')break;
						}
					}
					if(map[i][j]=='O') {
						for(int k = j+1; k < M; k++) {
							if(map[i][k]=='#')break;
							if(map[i][k]=='R') {
								result[0]++;
								map[i][k]='.';
							}else if(map[i][k]=='B') {
								result[1]++;
								map[i][k]='.';
							}
						}
					}
				}
			}
			break;
		case 3:
			for(int i = 0; i < N; i++) {
				for(int j = M-1; j > 0; j--) {
					if(map[i][j]=='.') {
						for(int k = j-1; k >= 0; k--) {
							if(map[i][k]=='R' || map[i][k]=='B') {
								char temp = map[i][j];
								map[i][j] = map[i][k];
								map[i][k] = temp;
								break;
							}
							if(map[i][k]!='.')break;
						}
					}
					if(map[i][j]=='O') {
						for(int k = j-1; k >= 0; k--) {
							if(map[i][k]=='#')break;
							if(map[i][k]=='R') {
								result[0]++;
								map[i][k]='.';
							}else if(map[i][k]=='B') {
								result[1]++;
								map[i][k]='.';
							}
						}
					}
				}
			}
		}

		return result;
	}
	
	

}




