import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		int[] dp = new int[N+1];
		int m = 1;
		
		for(int i = 1; i <= N ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			dp[i] = 1;
		}
		
		for(int i = 2; i <= N ; i++) {
			for(int j = i-1 ; j >= 1 ; j--) {
				if(arr[j] < arr[i]) {
					dp[i] = max(dp[i] , dp[j]+1);
				}
			}
			m = max(dp[i] , m);
		}
		
		System.out.println(N-m);
		
		
		
	}
	
	static int max(int n1, int n2) {
		if(n1>n2) return n1;
		else return n2;
	}

}
