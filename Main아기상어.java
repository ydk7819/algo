import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main아기상어 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		Shark shark = new Shark();
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					shark.y = i;
					shark.x = j;
					map[i][j]= 0;
				}
			}
		}
		
		shark.size = 2;
		shark.stack = 2;
		int time = 0;
		
		while(true) {
			boolean[][] visited = new boolean[N][N];
			visited[shark.y][shark.x] = true;
			Queue<int[]> queue = new LinkedList<>();
			queue.add(new int[] {shark.y, shark.x, 0});
			List<Fish> fishes = new ArrayList<>();
			
			while(!queue.isEmpty()) {
				int[] n =  queue.poll();
				for(int i = 0; i < 4; i++) {
					int yi = n[0]+dy[i];
					int xi = n[1]+dx[i];
					int move = n[2] + 1;
					
					if(yi >= N || xi >= N || yi < 0 || xi < 0 || visited[yi][xi])continue;
					if(map[yi][xi] <= shark.size) {
						if(map[yi][xi] > 0 && map[yi][xi] < shark.size) {							
							fishes.add(new Fish(yi, xi, move));
							continue;
						}
						visited[yi][xi] = true;
						queue.add(new int[] {yi,xi,move});
					}
				}
				
			}
			
			if(fishes.isEmpty()) {
				break;
			}
			
			
			Fish fish = fishes.get(0);
			
			for(int i = 1; i < fishes.size(); i++) {
				if(fish.dis > fishes.get(i).dis) {
					fish = fishes.get(i);
				}	
				else if(fish.dis == fishes.get(i).dis) {
					if(fish.y > fishes.get(i).y) {
						fish = fishes.get(i);
						continue;
					}else if(fish.y == fishes.get(i).y) {
						if(fish.x > fishes.get(i).x) {
							fish = fishes.get(i);
						}
					}
				}
			}
			
			time += fish.dis;
			shark.y = fish.y;
			shark.x = fish.x;
			map[shark.y][shark.x] = 0;
			shark.stack--;
			if(shark.stack==0) {
				shark.size++;
				shark.stack = shark.size;
			}
		
			
		}
		
		System.out.println(time);
		
		
		
		
		
	}
	
	static int N;
	static int[][] map;
	
	static int[] dy = { -1, 0, 0, 1 };
	static int[] dx = { 0, -1, 1, 0 };
	
}

class Fish {
	int y;
	int x;
	int dis;
	Fish(int y, int x, int dis){
		this.y = y;
		this.x = x;
		this.dis = dis;
	}
	

	
	
}

class Shark{
	int y;
	int x;
	int size;
	int stack;

}
