import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[k+1];
		int[] arr = new int[n+1];
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i = 1; i <= n ; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		
		for(int i = 1 ; i <= n ; i++) {
			arr[i] = pq.poll();
		}
		
		for(int i = 1; i <= k ; i++) {
			dp[i] = 99999;
			for(int j = 1; j <= n ; j++) {
				if(arr[j] < i) {
					if(dp[i-arr[j]] != 99999) {
						dp[i] = min(dp[i] , dp[i-arr[j]] + 1);
					}
				}
				else if(arr[j] == i) {
					dp[i] = 1;
					break;
				}
				else break;
			}
		}
		
		if(dp[k] == 99999) System.out.println(-1);
		else System.out.println(dp[k]);
		
		
	}
	
	static int min(int n1, int n2) {
		if(n1 < n2) return n1;
		else return n2;
	}

}
