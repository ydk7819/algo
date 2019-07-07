import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main치킨배달 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st1.nextToken());
		int M = Integer.parseInt(st1.nextToken());
		
		int[][] map = new int[N][N];
		
		home = new ArrayList<>();
		chicken = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st2.nextToken());
				if(map[i][j]==1) {
					home.add(new int[] {i,j});
				}else if(map[i][j]==2) {
					chicken.add(new int[] {i,j});
				}
			}
		}
		ans = Integer.MAX_VALUE;
		power(new ArrayList<>(), M, 0, 0);
		System.out.println(ans);
			
	}
	static int ans;
	static List<int[]> chicken;
	static List<int[]> home;
	static void power(List<int[]> remain, int M, int idx, int cnt) {
		if(cnt == M) {
			int sum = 0;
			for(int i = 0; i < home.size(); i++) {
				sum+=calMinDistance(home.get(i)[0], home.get(i)[1], remain);
			}
			
			ans = Math.min(ans, sum);
			return;
		}
		
		if(idx == chicken.size()) {
			return;
		}
		
		remain.add(new int[] {chicken.get(idx)[0], chicken.get(idx)[1]});
		power(remain, M, idx+1, cnt+1);
		remain.remove(remain.size()-1);
		power(remain, M, idx+1, cnt);
		
	}
	
	static int calMinDistance(int hy, int hx, List<int[]> chicken) {
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < chicken.size(); i++) {
			min = Math.min(min, getDistance(hy, hx, chicken.get(i)[0], chicken.get(i)[1]));
		}
		return min;
	}
	
	static int getDistance(int hy, int hx, int cy, int cx) {
		return Math.abs(hy-cy)+Math.abs(hx-cx);
	}
}
