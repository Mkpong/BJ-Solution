import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//Q23090 / G1 / ³­¹Î

public class Main {
	
	static PriorityQueue<Integer> min = new PriorityQueue<>((o1 , o2) ->{
		return o2-o1;
	});
	static PriorityQueue<Integer> max = new PriorityQueue<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N  = Integer.parseInt(br.readLine());
		long sumx = 0;
		long sumy = 0;
		
		for(int i = 1 ; i <= N ; i++) {
			int x,y,l = 0;
			int n1 = min.size();
			int n2 = max.size();
			st = new StringTokenizer(br.readLine() , " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			if(i > 2) l = ans();
			sumx += Math.abs(x);
			pull(y);
			position();
			if(i == 1) sumy = 0;
			else if(i == 2) sumy = Math.abs(min.peek() - max.peek());
			else {
				sumy += Math.abs(y-ans());
				sumy += Math.abs(l-ans())*Math.abs(n1-n2);
			}
			System.out.println(ans() + " " + (sumx+sumy));
		}

	}
	
	static void pull(int n) {
		if(min.isEmpty()) {
			min.add(n);
			return;
		}
		if(n <= min.peek()) min.add(n);
		else max.add(n);
	}
	
	static void position() {
		while(true) {
			if(min.size() == max.size() || min.size() == max.size()+1) break;
			if(min.size()<max.size()) {
				min.add(max.poll());
			}
			else if(min.size() > max.size()+1) {
				max.add(min.poll());
			}
		}
	}
	
	static int ans() {
		return min.peek();
	}

}
