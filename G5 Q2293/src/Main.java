//NS

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		 
		 int n = Integer.parseInt(st.nextToken());
		 int k = Integer.parseInt(st.nextToken());
		 
		 int[] arr = new int[n+1];
		 int[] dp = new int[k+1];
		 
		 for(int i = 1; i <= n ; i++) {
			 arr[i] = Integer.parseInt(br.readLine());
		 }
		 
		 for(int i = 1;  i <= k ; i++) {
			 dp[i] = 0;
			 for(int j = 1 ; j <= n ; j++) {
				 if(i > arr[j]) {
					 dp[i] += dp[i-arr[j]];
				 }
				 else if(i == arr[j]) {
					 dp[i]++;
					 break;
				 }
				 else break;
			 }
			 System.out.println(dp[i]);
		 }
		 
		 System.out.println(dp[k]);

	}

}
