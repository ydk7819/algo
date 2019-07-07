import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main통나무옮기기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		char[][] map = new char[N][N];
		List<int[]> tree = new ArrayList<>();
		List<int[]> end = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'B') {
					tree.add(new int[] {i,j});
				}
				if(map[i][j] == 'E') {
					end.add(new int[] {i,j});
				}
			}
		}

		
		// 출력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
		
	}

	static int N;
	
	static void dfs(char[][]map, List<int[]> tree, int cnt, boolean[][] visited) {
		char[][] copy = new char[N][N];
		
		copyMap(map, copy);
		List<int[]> nextTree = new ArrayList<>();
		
		
		copyMap(map, copy);
		nextTree = new ArrayList<>();
		
		
		copyMap(map, copy);
		nextTree = new ArrayList<>();
		
		
	}
	
	static void copyMap(char[][]map, char[][]copy) {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				copy[i][j] = map[i][j];
			}
		}
	}
	
	static boolean moveU(char[][] map, List<int[]> tree, List<int[]> nextTree, boolean[][] visited) {
		for(int i = 0 ; i < tree.size(); i++) {
			int y = tree.get(i)[0];
			int x = tree.get(i)[1];
			if(y-1<0||map[y-1][x]=='1') {
				return false;
			}
			visited[y][x] = true;
			map[y][x] = '0';
		}
		for(int i = 0; i < tree.size(); i++) {
			int y = tree.get(i)[0];
			int x = tree.get(i)[1];
			if(visited[y-1][x]) {
				return false;
			}
			map[y-1][x] = 'B';
			nextTree.add(new int[] {y-1,x});
		}
		return true;
	}
	static boolean moveL(char[][] map, List<int[]> tree, List<int[]> nextTree, boolean[][] visited) {
		for(int i = 0 ; i < tree.size(); i++) {
			int y = tree.get(i)[0];
			int x = tree.get(i)[1];
			if(x-1<0||map[y][x-1]=='1') {
				return false;
			}
			map[y][x] = '0';
		}
		for(int i = 0; i < tree.size(); i++) {
			int y = tree.get(i)[0];
			int x = tree.get(i)[1];
			map[y][x-1] = 'B';
			nextTree.add(new int[] {y,x-1});
		}
		return true;
	}
	static boolean moveD(char[][] map, List<int[]> tree, List<int[]> nextTree) {
		for(int i = 0 ; i < tree.size(); i++) {
			int y = tree.get(i)[0];
			int x = tree.get(i)[1];
			if(y+1>=N||map[y+1][x]=='1') {
				return false;
			}
			map[y][x] = '0';
		}
		for(int i = 0; i < tree.size(); i++) {
			int y = tree.get(i)[0];
			int x = tree.get(i)[1];
			map[y+1][x] = 'B';
			nextTree.add(new int[] {y+1,x});
		}
		return true;
	}
	static boolean moveR(char[][] map, List<int[]> tree, List<int[]> nextTree) {
		for(int i = 0 ; i < tree.size(); i++) {
			int y = tree.get(i)[0];
			int x = tree.get(i)[1];
			if(x+1>=N||map[y][x+1]=='1') {
				return false;
			}
			map[y][x] = '0';
		}
		for(int i = 0; i < tree.size(); i++) {
			int y = tree.get(i)[0];
			int x = tree.get(i)[1];
			map[y][x+1] = 'B';
			nextTree.add(new int[] {y,x+1});
		}
		return true;
	}
	
	

	static boolean checkOk(List<int[]> tree, List<int[]> end) {
		int chk = 0;
		for(int i = 0; i < tree.size(); i++) {
			for(int j = 0; j < end.size(); j++) {
				if(tree.get(i)[0] == end.get(j)[0] && tree.get(i)[1] == end.get(j)[1]) {
					chk++;
				}
			}
		}
		if(chk == 3) {
			return true;
		}else {
			return false;
		}
	}
	static boolean rotate(char[][] map, int y, int x) {
		if(y-1 < 0 || x - 1 < 0 || y + 1 >= N || x + 1 >= N ) {
			return false;
		}
		boolean check = true;
		for(int i = y-1; i < y+1; i++) {
			for(int j = x-1; j < x+1; j++) {
				if(map[i][j] == '1') {
					check = false;
					break;
				}
			}
		}
		if(check) {
			char tmp = map[y-1][x];
			map[y-1][x] = map[y][x-1];
			map[y][x-1] = map[y+1][x];
			map[y+1][x] = map[y][x+1];
			map[y][x+1] = tmp;
		}
		return check;		
	}
}
