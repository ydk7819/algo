import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main시험감독 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] room = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			room[i] = Integer.parseInt(st.nextToken());
		}
		
		StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
		int B = Integer.parseInt(st1.nextToken());
		int C = Integer.parseInt(st1.nextToken());
		
		long sum = N;
		for(int i = 0; i < N; i++ ) {
			room[i] -= B;
			if(room[i] < 0) {
				room[i] = 0;
			}
			
			if(room[i]!=0) {
				sum+=room[i]/C;
				if(room[i]%C!=0) {
					sum++;
				}
			}
			
		}
		System.out.println(sum);
		
		
	}
}
