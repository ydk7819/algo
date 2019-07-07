import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main뱀 {
	static class Node{
		int t;
		String d;
		public Node(int t, String d) {
			this.t= t;
			this.d = d;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		int K = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < K; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
			map[Integer.parseInt(st1.nextToken())-1][Integer.parseInt(st1.nextToken())-1]=1;
		}
		
		int L = Integer.parseInt(br.readLine());
		Queue<Node> dir = new LinkedList<>();
		
		for(int i = 0; i < L; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			int t = Integer.parseInt(st2.nextToken());
			String d = st2.nextToken();
			dir.add(new Node(t, d));
		}
		
		Queue<int[]> snake = new LinkedList<>();
		snake.add(new int[] {0,0});
		int direction = 0;
		int time = 0;
		while(true) {
			
			if(!dir.isEmpty() && time == dir.peek().t) {
				direction = rotate(dir.peek().d, direction);
				dir.poll();
			}
			time++;
			
			for(int i = 1; i < snake.size(); i++) {
				snake.add(snake.poll());
			}
			int[] now = snake.poll();
			snake.add(now);
			int y = now[0] + dy[direction];
			int x = now[1] + dx[direction];
			
			if(y >= N || x >= N || y < 0 || x < 0)break;
			if(map[y][x] == 2) break;
			
			if(map[y][x] == 1) {
				snake.add(new int[] {y,x});
				map[y][x] = 2;
			}else if(map[y][x] == 0) {
				snake.add(new int[] {y,x});
				map[y][x] = 2;
				int[] s = snake.poll();
				map[s[0]][s[1]] = 0;
				
			}
			
		}
		System.out.println(time);
	
	}
	// 오른쪽 0 아래 1 왼쪽 2 위 3
	static int[] dy = {0, 1, 0, -1};
	static int[] dx = {1, 0, -1, 0};
	static int[][] map;
	
	
	
	
	static int rotate(String dir, int direction) {
		if( dir.equals("D")) {
			direction = (direction+1)%4;
		}else {
			if(direction == 0) {
				direction = 3;
			}else {
				direction--;
			}
		}
		return direction;
	}
	
	
	
}
