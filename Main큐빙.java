import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main큐빙 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<= T; tc++ ) {
			
			up = new char[][]{{'w','w','w'}, {'w','w','w'}, {'w','w','w'}};
			down = new char[][]{{'y','y','y'}, {'y','y','y'}, {'y','y','y'}};
			front = new char[][]{{'r','r','r'}, {'r','r','r'}, {'r','r','r'}};
			back = new char[][]{{'o','o','o'}, {'o','o','o'}, {'o','o','o'}};
			left = new char[][]{{'g','g','g'}, {'g','g','g'}, {'g','g','g'}};
			right = new char[][]{{'b','b','b'}, {'b','b','b'}, {'b','b','b'}};
			
			int n = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			for(int z = 0; z < n; z++) {
				String str = st.nextToken();
				char side = str.charAt(0);
				char dir = str.charAt(1);
				
				
				
				
			}
			clock('F');
			
			for(int i = 0; i < up.length; i++) {
				for(int j = 0; j < up[i].length; j++) {
					System.out.print(up[i][j]);
				}
				System.out.println();
				
			}
			
		
		}
	}
	
	static char[][] up;
	static char[][] down;
	static char[][] front;
	static char[][] back;
	static char[][] left;
	static char[][] right;
	
	static void clock(char side) {
		if(side == 'U') {
			rotateSelf(side);
			
			char tmp1 = back[0][0];
			char tmp2 = back[0][1];
			char tmp3 = back[0][2];
			
			back[0][0] = left[0][0];
			back[0][1] = left[0][1];
			back[0][2] = left[0][2];
			
			left[0][0] = front[0][0];
			left[0][1] = front[0][1];
			left[0][2] = front[0][2];
			
			front[0][0] = right[0][0];
			front[0][1] = right[0][1];
			front[0][2] = right[0][2];
			
			right[0][0] = tmp1;
			right[0][1] = tmp2;
			right[0][2] = tmp3;
			
			
		}else if(side == 'D') {
			
			rotateSelf(side);
			
			char tmp1 = back[2][0];
			char tmp2 = back[2][1];
			char tmp3 = back[2][2];
			
			back[2][0] = left[2][0];
			back[2][1] = left[2][1];
			back[2][2] = left[2][2];
			
			left[2][0] = front[2][0];
			left[2][1] = front[2][1];
			left[2][2] = front[2][2];
			
			front[2][0] = right[2][0];
			front[2][1] = right[2][1];
			front[2][2] = right[2][2];
			
			right[2][0] = tmp1;
			right[2][1] = tmp2;
			right[2][2] = tmp3;
			
		}else if(side == 'F') {
			
			rotateSelf(side);
			
			char tmp1 = up[2][0];
			char tmp2 = up[2][1];
			char tmp3 = up[2][2];
			
			up[2][0] = left[0][2];
			up[2][1] = left[1][2];
			up[2][2] = left[2][2];
			
			left[0][2] = down[2][2];
			left[1][2] = down[2][1];
			left[2][2] = down[2][0];
			
			down[2][2] = right[0][2];
			down[2][1] = right[0][1];
			down[2][0] = right[0][0];
			
			right[0][2] = tmp3;
			right[0][1] = tmp2;
			right[0][0] = tmp1;
			
		}else if(side == 'B') {
			
			rotateSelf(side);
			
			char tmp1 = up[0][0];
			char tmp2 = up[0][1];
			char tmp3 = up[0][2];
			
			up[0][0] = right[0][2];
			up[0][1] = right[1][2];
			up[0][2] = right[2][2];
			
			right[0][2] = down[0][0];
			right[1][2] = down[0][1];
			right[2][2] = down[0][2];
			
			down[0][0] = left[2][0];
			down[0][1] = left[1][0];
			down[0][2] = left[0][0];
			
			left[2][0] = tmp1;
			left[1][0] = tmp2;
			left[0][0] = tmp3;
		
		}else if(side == 'L') {
			
			
			
		}else if(side == 'R') {
			
		}
	}
	
	static void rotateSelf(char side) {
		if(side == 'U') {
			char tmp1 = up[0][0];
			char tmp2 = up[0][1];
			char tmp3 = up[0][2];
			
			up[0][0] = up[2][0];
			up[0][1] = up[1][0];
			up[0][2] = tmp1;
			
			up[2][0] = up[2][2];
			up[1][0] = up[2][1];
			
			up[2][1] = up[1][2];
			up[2][2] = tmp3;
			
		
			up[1][2] = tmp2;
			
		}
	}
	
}
