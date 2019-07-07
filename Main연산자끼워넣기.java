	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.util.StringTokenizer;
	
	public class Main연산자끼워넣기 {
		public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int N = Integer.parseInt(br.readLine());
			int[] number = new int[N];
			int[] oper = new int[4];
			StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < N; i++) {
				number[i]=Integer.parseInt(st1.nextToken());
			}
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < oper.length; i++) {
				oper[i]=Integer.parseInt(st2.nextToken());
			}
			min=Integer.MAX_VALUE;
			max=Integer.MIN_VALUE;
			power(new char[N-1], oper, number, 0);
			System.out.println(max);
			System.out.println(min);
		}
		static int min;
		static int max;
		
		static void power(char[] op, int[] oper, int[] num, int idx) {
			if(idx == op.length) {
				int result = cal(op, num);
				min=Math.min(min, result);
				max=Math.max(max, result);
				return;
			}
			
			if(oper[0]!=0) {
				op[idx] = '+';
				oper[0]--;
				power(op, oper, num, idx+1);
				oper[0]++;
			}
			if(oper[1]!=0) {
				op[idx] = '-';
				oper[1]--;
				power(op, oper, num, idx+1);
				oper[1]++;
			}
			if(oper[2]!=0) {
				op[idx] = '*';
				oper[2]--;
				power(op, oper, num, idx+1);
				oper[2]++;
			}
			if(oper[3]!=0) {
				op[idx] = '/';
				oper[3]--;
				power(op, oper, num, idx+1);
				oper[3]++;
			}
			
		}
		
		
		static int cal(char[] op, int[] num) {
			int result = num[0];
			for(int i = 0; i < op.length; i++) {
				switch(op[i]) {
				case '+':
					result+=num[i+1];
					break;
				case '-':
					result-=num[i+1];
					break;
				case '*':
					result*=num[i+1];
					break;
				case '/':
					result/=num[i+1];
					break;
				}
			}
			return result;
		}
	}
