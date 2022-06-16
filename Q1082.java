import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q1082 {
   
   static PriorityQueue<Integer> pq = new PriorityQueue<>((o1 , o2) ->{
      return o2 - o1;
   });


   public static void main(String[] args) throws NumberFormatException, IOException {
      
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int N = Integer.parseInt(br.readLine());
      int mina = 100;
      int index = 0;
      int[] arr = new int[N];
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      arr[0] = Integer.parseInt(st.nextToken());
      for(int i = 1 ; i < N ; i++) {
         arr[i] = Integer.parseInt(st.nextToken());
         if(arr[i] <= mina) {
            mina = arr[i]; 
            index = i;
         }
      }
      int M = Integer.parseInt(br.readLine());
      int min0 ,index0;
      if(mina <= arr[0]) {
         min0 = mina;
         index0 = index;
      }
      else {
         min0 = arr[0];
         index0 = 0;
      }
     

      
      int E = 0;
      int count = 0;


      if(mina <= M) {
          M = M - mina;
          count = M/min0;
          E = M%min0;
          for(int i = N-1 ; i >= index ; i--) {
              if(arr[i] <= mina + E) {
                 E-= arr[i] - mina;
                 pq.offer(i);
                 break;
              }
           }
           for(int i = 0 ; i < count ; i++) {
              for(int j = N-1 ; j >= index0 ; j--) {
                 if(arr[j] <= min0+E) {
                    E -= arr[j] - min0;
                    pq.offer(j);
                    break;
                 }
              }
           }
      }


      if(pq.isEmpty()) System.out.print("0");
      while(!pq.isEmpty()) {
         System.out.print(pq.poll());
      }
      

   }

}