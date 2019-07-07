import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main연구소3{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer st1 = new StringTokenizer(br.readLine());
	
		N = Integer.parseInt(st1.nextToken());
		M = Integer.parseInt(st1.nextToken());
		int[][] map = new int[N][N];
		virus= new ArrayList<int[]>();
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st2.nextToken());
				if(map[i][j] == 2) {
					virus.add(new int[] {i,j});
				}
			}
		}
		

		ans = Integer.MAX_VALUE;
		inputVirus(0, 0, map, new int[virus.size()]);
		if(ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(ans);			
		}
	
	}
	static int N;
	static int M;
	static int ans;
	static List<int[]> virus;
	static int[] dx = { 1, -1, 0 ,0};
	static int[] dy = { 0, 0, 1, -1};
	
	static void inputVirus(int idx, int cnt, int[][] map, int[] visit) {
		if(cnt == M) {
			int[][] result = new int[N][N];
			int[][] copy = new int[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					result[i][j]=Integer.MAX_VALUE;
					copy[i][j]=map[i][j];
				}
			}
			
			Queue<int[]> queue = new LinkedList<>();
			for(int i = 0; i < visit.length; i++) {
				if(visit[i] == 1) {
					int[] q = virus.get(i);
					queue.add(q);
					result[q[0]][q[1]] = 0;
				}
			}
			
			
			bfs(copy, result, queue);
			
			int chk=0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(copy[i][j] == 0) {
						chk=1;
						break;
					}
				}
			}
			if(chk == 0) {
				int max = 0;
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < N; j++) {
						if(result[i][j] != Integer.MAX_VALUE && map[i][j]!=2) {
							max = Math.max(max, result[i][j]);
						}
					}
				}
				ans = Math.min(max, ans);
				return;
			}else {
				return;
			}
			
		}
		if(idx == virus.size()) {
			return;
		}
		
		//선택함
		visit[idx] = 1;
		inputVirus(idx+1, cnt+1, map, visit);
		//선택안함
		visit[idx] = 0;
		inputVirus(idx+1, cnt, map, visit);
		
	}
	
	
	static void bfs(int[][] map, int[][] check, Queue<int[]> queue) {
		while(!queue.isEmpty()) {
			int[] q = queue.poll();
			map[q[0]][q[1]] = 3;
			
			
			for(int i = 0; i < 4; i++) {
				int yi = q[0] + dy[i];
				int xi = q[1] + dx[i];
				
				if(yi >= N || xi >= N || yi < 0 || xi < 0 || map[yi][xi] == 1)continue;
			
				if( check[yi][xi] > check[q[0]][q[1]]+1 ) {
					
					check[yi][xi] = check[q[0]][q[1]]+1;
					queue.add(new int[] {yi,xi});
				}
			}
		}
	}
}
