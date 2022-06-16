import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	static Map<String , User> user = new HashMap<>();
	static Map<String , File> file = new HashMap<>();

   public static void main(String[] args) throws IOException {
	   
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	   StringTokenizer st = new StringTokenizer(br.readLine() , " ");
	   StringTokenizer st2;
	   int U = Integer.parseInt(st.nextToken());
	   int F = Integer.parseInt(st.nextToken());
	   String name;
	   for(int i = 0 ; i < U ; i++) {
		   List<String> go = new ArrayList<>(); 
		   st = new StringTokenizer(br.readLine() , " ");
		   name = st.nextToken();
		   if(st.hasMoreTokens()) {
			   st2 = new StringTokenizer(st.nextToken() , ",");
			   while(st2.hasMoreTokens()) {
				   go.add(st2.nextToken());
				   go.add(name);
			   }
			   user.put(name, new User(name , go));
		   }
		   else {
			   go.add(name);
			   user.put(name, new User(name , go));
		   }
	   }
	   
	   String u_name , f_name , g_name;
	   for(int i = 0 ; i < F ; i++) {
		   StringBuilder sb = new StringBuilder();
		   st = new StringTokenizer(br.readLine() , " ");
		   f_name = st.nextToken();
		   sb.append(st.nextToken());
		   u_name = st.nextToken();
		   g_name = st.nextToken();
		   file.put(f_name, new File(f_name , u_name , g_name , sb));
		   sb.delete(0, sb.length());
	   }
	   
	   int Q = Integer.parseInt(br.readLine());
	   File f;
	   String us , fn , qu;
	   for(int i = 1 ; i < Q+1 ; i++) {
		   st = new StringTokenizer(br.readLine(), " ");
		   us = st.nextToken();
		   fn = st.nextToken();
		   qu = st.nextToken();
		   f = file.get(fn);
		   bw.write(process(us , qu , f) + "\n");
	   }
	   
	   bw.flush();
	   bw.close();
	   
   }
   
   static int process(String u , String qu , File fi) {
	   boolean R = false;
	   boolean W = false;
	   boolean X = false;
	   
	   if(fi.n3 == 1) {
		   X = true;
	   }
	   if(fi.n3 == 2) {
		   R = true;
		   W = true;
	   }
	   if(fi.n3 == 3) {
		   R = true;
		   W = true;
		   X = true;
	   }
	   if(fi.n3 == 4) {
		   R = true;
	   }
	   if(fi.n3 == 5) {
		   R = true;
		   X = true;
	   }
	   if(fi.n3 == 6) {
		   R = true;
		   W = true;
	   }
	   if(fi.n3 == 7) {
		   R = true;
		   W = true;
		   X = true;
	   }
	   

	   if(user.get(u).gro.contains(fi.o_group)) {
		   if(fi.n2 == 1) {
			   X = true;
		   }
		   if(fi.n2 == 2) {
			   R = true;
			   W = true;
		   }
		   if(fi.n2 == 3) {
			   R = true;
			   W = true;
			   X = true;
		   }
		   if(fi.n2 == 4) {
			   R = true;
		   }
		   if(fi.n2 == 5) {
			   R = true;
			   X = true;
		   }
		   if(fi.n2 == 6) {
			   R = true;
			   W = true;
		   }
		   if(fi.n2 == 7) {
			   R = true;
			   W = true;
			   X = true;
		   }
	   }
	   
	   if(fi.owner.equals(u)) {
		   if(fi.n1 == 1) {
			   X = true;
		   }
		   if(fi.n1 == 2) {
			   R = true;
			   W = true;
		   }
		   if(fi.n1 == 3) {
			   R = true;
			   W = true;
			   X = true;
		   }
		   if(fi.n1 == 4) {
			   R = true;
		   }
		   if(fi.n1 == 5) {
			   R = true;
			   X = true;
		   }
		   if(fi.n1 == 6) {
			   R = true;
			   W = true;
		   }
		   if(fi.n1 == 7) {
			   R = true;
			   W = true;
			   X = true;
		   }
	   }
	   
	   
	   if(qu.equals("R")) {
		   if(R) return 1;
		   else return 0;
	   }
	   else if(qu.equals("W")) {
		   if(W) return 1;
		   else return 0;
	   }
	   else {
		   if(X) return 1;
		   else return 0;
	   }

   }


}


class File {
	String owner;
	String o_group;
	String name;
	int n1, n2, n3;
	public File(String s1 , String s2 , String s3 , StringBuilder s4) {
		name = s1;
		owner = s2;
		o_group = s3;
		n1 = Integer.parseInt(s4.substring(0, 1));
		n2 = Integer.parseInt(s4.substring(1, 2));
		n3 = Integer.parseInt(s4.substring(2, 3));
	}
}

class User{
	String name;
	List<String> gro = new ArrayList<>();
	public User(String s1 , List<String> li) {
		name = s1;
		gro = li;
	}
	
}

