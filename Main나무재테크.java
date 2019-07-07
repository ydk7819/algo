import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main나무재테크 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st1.nextToken());	// 맵 크기
		int M = Integer.parseInt(st1.nextToken());	// 나무 개수
		int K = Integer.parseInt(st1.nextToken());	// k년
		
		int[][]A = new int[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st2.nextToken());
			}
		}
		PriorityQueue<Tree>[] tree = new PriorityQueue[2];
		tree[0] = new PriorityQueue<>();
		tree[1] = new PriorityQueue<>();
		
		int thisYear = 0;
		int nextYear = 0;
		
		for(int i = 0; i < M; i++) {
			StringTokenizer st3 = new StringTokenizer(br.readLine(), " ");
			tree[thisYear].add(new Tree(Integer.parseInt(st3.nextToken())-1, Integer.parseInt(st3.nextToken())-1, Integer.parseInt(st3.nextToken())));
		}
				
		int[][]map = new int[N][N];
		for(int i = 0; i < N; i++) {
			Arrays.fill(map[i], 5);
		}
		
		

		while(true) {
			if(K == 0) {
				break;
			}
			nextYear = (thisYear+1)%2;
			
			Queue<Tree> live = new LinkedList<>();
			Queue<Tree> die = new LinkedList<>();
			
			spring(map, tree[thisYear], tree[nextYear], live, die);
			summer(map, die);
			fall(tree[nextYear], live);
			winter(map, A);
			
			
			thisYear = nextYear;
			K--;

		}
		
		System.out.println(tree[nextYear].size());
		
		

		
		
	}
	
	static int N;
	static int[] dy = {-1,-1,-1,0,0,1,1,1};
	static int[] dx = {-1,0,1,-1,1,-1,0,1};
	
	static void spring(int[][] map, PriorityQueue<Tree> thisYear, PriorityQueue<Tree> nextYear, Queue<Tree> live, Queue<Tree> die) {
		while(!thisYear.isEmpty()) {
			
			Tree tree = thisYear.poll();
			if(map[tree.y][tree.x] >= tree.age) {
				map[tree.y][tree.x] -= tree.age;
				Tree next = new Tree(tree.y, tree.x, tree.age+1);
				nextYear.add(next);
				live.add(next);
			}else {
				die.add(tree);
			}
		}
		
	}
	
	static void summer(int[][] map, Queue<Tree> die) {
		while(!die.isEmpty()) {
			Tree tree = die.poll();
			map[tree.y][tree.x] += tree.age/2;
		}
	}
	
	static void fall(PriorityQueue<Tree> nextYear, Queue<Tree> live) {
		while(!live.isEmpty()) {
			Tree tree = live.poll();
			if(tree.age%5 == 0) {
				for(int i = 0; i < 8; i++) {
					int yi = dy[i]+tree.y;
					int xi = dx[i]+tree.x;
					
					if(yi >= N || xi >= N || yi < 0 || xi < 0)continue;
				
					nextYear.add(new Tree(yi, xi, 1));
				}
			}
		}
	}
	
	static void winter(int[][] map, int[][] A) {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] += A[i][j];
			}
		}
	}

}


class Tree implements Comparable<Tree>{
	int y;
	int x;
	int age;
	
	Tree(int y, int x, int age){
		this.y = y;
		this.x = x;
		this.age = age;
	}
	
	@Override
	public int compareTo(Tree o) {
		return this.age - o.age;
	}
}
