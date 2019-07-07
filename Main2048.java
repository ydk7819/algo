import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2048 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		
		int[][] block = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			for(int j = 0; j < N; j++) {
				block[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		ans = 0;
		power(block, 0);
		System.out.println(ans);
		
	}
	static int ans;
	
	static void power(int[][] block, int cnt) {
		
		if(cnt == 5) {
			int max = 0;
			for(int i = 0; i < block.length; i++) {
				for(int j = 0; j < block.length; j++) {
					max = Math.max(max, block[i][j]);
				}
			}
			ans = Math.max(max, ans);
			
		
			
			return;
		}
		int[][] copy = new int[block.length][block.length];
		
		copyMap(block, copy);
		move(copy, 0);
		power(copy, cnt+1);
		
		copyMap(block, copy);
		move(copy, 1);
		power(copy, cnt+1);
		
		copyMap(block, copy);
		move(copy, 2);
		power(copy, cnt+1);
		
		copyMap(block, copy);
		move(copy, 3);
		power(copy, cnt+1);
		
		
		
	}
	
	static void copyMap(int[][] block, int[][] copy) {
		for(int i = 0; i< block.length; i++) {
			for(int j = 0; j < block.length; j++) {
				copy[i][j] = block[i][j];
			}
		}
	}
	
	// 상 0 하 1 좌 2 우 3
	
	static void move(int[][] block, int dir) {
		if(dir == 0) {
			
			for(int j = 0; j < block.length; j++) {
				for(int i = 0; i < block.length-1; i++) {
					if(block[i][j]!=0) {
						for(int k = i+1; k < block.length; k++) {
							if(block[k][j]!=0) {
								if(block[i][j] == block[k][j]) {
									block[i][j] *= 2;
									block[k][j] = 0;
									break;
 								}else {
 									break;
 								}
							}
						}
					}
				}
				gravityUp(block, j);
				
			}
		}else if(dir == 1) {
			for(int j = 0; j < block.length; j++) {
				for(int i = block.length-1; i > 0; i--) {
					if(block[i][j]!=0) {
						for(int k = i-1; k >= 0; k--) {
							if(block[k][j]!=0) {
								if(block[i][j] == block[k][j]) {
									block[i][j] *= 2;
									block[k][j] = 0;
									break;
 								}else {
 									break;
 								}
							}
						}
					}
				}
				gravityDown(block, j);
			}	
		}else if(dir == 2) {
			for(int i = 0; i < block.length; i++) {
				for(int j = 0; j < block.length-1; j++) {
					if(block[i][j]!=0) {
						for(int k = j+1; k < block.length; k++) {
							if(block[i][k]!=0) {
								if(block[i][j] == block[i][k]) {
									block[i][j] *= 2;
									block[i][k] = 0;
									break;
								}else
									break;
							}
						}
					}
				}
				gravityLeft(block, i);
			}
		}else if(dir == 3) {
			for(int i = 0; i < block.length; i++) {
				for(int j = block.length-1; j > 0; j--) {
					if(block[i][j]!=0) {
						for(int k = j-1; k >= 0; k--) {
							if(block[i][k]!=0) {
								if(block[i][j] == block[i][k]) {
									block[i][j] *= 2;
									block[i][k] = 0;
									break;
								}else
									break;
							}
						}
					}
				}
				gravityRight(block, i);
			}	
		}
	}
	
	static void gravityUp(int[][] block, int x) {
		for(int i = 0; i < block.length-1; i++) {
			if(block[i][x] == 0) {
				for(int j = i+1; j < block.length; j++) {
					if(block[j][x] != 0) {
						int tmp = block[i][x];
						block[i][x] = block[j][x];
						block[j][x] = tmp;
						break;
					}
				}
			}
		}
	}
	static void gravityDown(int[][] block, int x) {
		for(int i = block.length-1; i > 0; i--) {
			if(block[i][x] == 0) {
				for(int j = i-1; j >= 0; j--) {
					if(block[j][x] != 0) {
						int tmp = block[i][x];
						block[i][x] = block[j][x];
						block[j][x] = tmp;
						break;
					}
				}
			}
		}
	}
	static void gravityLeft(int[][] block, int y) {
		for(int i = 0; i < block.length-1; i++) {
			if(block[y][i] == 0) {
				for(int j = i+1; j < block.length; j++) {
					if(block[y][j] != 0) {
						int tmp = block[y][i];
						block[y][i] = block[y][j];
						block[y][j] = tmp;
						break;
					}
				}
			}
		}
	}
	static void gravityRight(int[][] block, int y) {
		for(int i = block.length-1; i > 0; i--) {
			if(block[y][i] == 0) {
				for(int j = i-1; j >= 0; j--) {
					if(block[y][j] != 0) {
						int tmp = block[y][i];
						block[y][i] = block[y][j];
						block[y][j] = tmp;
						break;
					}
				}
			}
		}
	}

	
}
