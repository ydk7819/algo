import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 무선충전 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			int M = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());

			int[] move1 = new int[M];
			int[] move2 = new int[M];
			StringTokenizer st1 = new StringTokenizer(br.readLine().trim(), " ");
			StringTokenizer st2 = new StringTokenizer(br.readLine().trim(), " ");

			for (int i = 0; i < M; i++) {
				move1[i] = Integer.parseInt(st1.nextToken());
			}

			for (int i = 0; i < M; i++) {
				move2[i] = Integer.parseInt(st2.nextToken());
			}

			List<Node> ap = new ArrayList<>();
			for (int i = 0; i < A; i++) {
				StringTokenizer st3 = new StringTokenizer(br.readLine().trim(), " ");
				ap.add(new Node(Integer.parseInt(st3.nextToken()), Integer.parseInt(st3.nextToken()),
						Integer.parseInt(st3.nextToken()), Integer.parseInt(st3.nextToken())));

			}

			Collections.sort(ap);

			int sum = 0;
			Person p1 = new Person(1, 1);
			Person p2 = new Person(10, 10);

			for (int i = 0; i <= M; i++) {
				List<Node> visited1 = new ArrayList<>();
				List<Node> visited2 = new ArrayList<>();
				
				for (int k = 0; k < A; k++) {
					
					if (ap.get(k).c >= getDist(p1.x, p1.y, ap.get(k).x, ap.get(k).y)) {
						visited1.add(ap.get(k));
						

					}

					if (ap.get(k).c >= getDist(p2.x, p2.y, ap.get(k).x, ap.get(k).y)) {
						visited2.add(ap.get(k));
					}

				}
				if(visited1.size() != 0 && visited2.size() == 0) {
					sum+=visited1.get(0).p;
				}
				if(visited1.size() == 0 && visited2.size() != 0) {
					sum+=visited2.get(0).p;
				}
				if(visited1.size() != 0 && visited2.size() != 0) {
					int max = 0;
					for(int f = 0; f < visited1.size(); f++) {
						for(int g = 0; g < visited2.size(); g++) {
							int tmp = visited1.get(f).p + visited2.get(g).p;
							if(visited1.get(f)==visited2.get(g))
								tmp/=2;
							max = Math.max(max, tmp);
						}
					}
					sum += max;
					
				}
				if(i == M) {
					break;
				}
				
				move(move1[i], p1);
				move(move2[i], p2);

			

			}

			System.out.println("#"+tc+" "+sum);
		}
	}

	static void move(int m, Person p) {
		switch (m) {
		case 0:
			break;
		case 1:
			p.y--;
			break;
		case 2:
			p.x++;
			break;
		case 3:
			p.y++;
			break;
		case 4:
			p.x--;
			break;
		}
	}

	static int getDist(int x, int y, int ax, int ay) {
		return Math.abs(x - ax) + Math.abs(y - ay);
	}

	static class Person {
		int x;
		int y;

		public Person(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	static class Node implements Comparable<Node> {
		int x;
		int y;
		int c;
		int p;

		public Node(int x, int y, int c, int p) {
			this.y = y;
			this.x = x;
			this.c = c;
			this.p = p;
		}

		@Override
		public int compareTo(Node o) {
			return o.p-p;
		}

	}
}
