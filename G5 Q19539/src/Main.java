import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int sum = 0;
		int cnt2 = 0;
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		st = new StringTokenizer(br.readLine() , " ");
		for(int i = 1 ; i < N+1 ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i];
			cnt2 += arr[i]/2;
		}
		
		if(sum%3 != 0) {
			System.out.println("NO");
			return ;
		}
		else {
			if(cnt2 >= sum/3) {
				System.out.println("YES");
				return ;
			}
			else {
				System.out.print("NO");
				return ;
			}
		}
		
		

	}

}
