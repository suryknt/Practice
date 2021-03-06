package challange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.StringTokenizer;

public class Kvowels {
	public static void main(String[] args) {
		FastReader fr=new FastReader();
		int t=fr.nextInt();
		while(t-->0) {
			int n=fr.nextInt();
			int k=fr.nextInt();
			char[] s=fr.nextLine().toLowerCase().toCharArray();
			int[][] dp=new int[5][n];
			int[] visited=new int[256];
			Arrays.fill(visited, -1);
			Set<Character> vowels=new HashSet<Character>();
			vowels.addAll(Arrays.asList('a','e','i','o','u'));
			int curr_length=0;
			int max_length=0;
			int vowel_count=0;
			Deque<Integer> v=new LinkedList<Integer>();
//			if(vowels.contains(s[0])) {
//				visited[s[0]]=0;
//				vowel_count++;
//				v.push(0);
//				
//			}
			
			for(int i=0;i<n;i++) {
				if(vowels.contains(s[i])) {
					if(visited[s[i]]==-1 || i-curr_length>visited[s[i]]) {
						if(vowel_count<k) {
							vowel_count++;
							curr_length++;
							visited[s[i]]=i;
							v.push(i);
						}else {
							v.push(i);
							int e=v.pollLast();
							if(!v.isEmpty())
							while(s[e]==s[v.peekLast()] || vowelCount(v,s)>k)e=v.pollLast();
							
							curr_length=i-e;
							visited[s[i]]=i;
						}
					}
					else {
						curr_length++;
						v.push(i);
					}
				}
				else curr_length++;
//				System.out.println("i::: "+i+" s[i]:: "+s[i]+" curr_length:: "+curr_length);
				if(curr_length>max_length) {
					max_length=vowel_count==k?curr_length:-1;
				}
			}
			System.out.println(max_length);
		}
	}
	
	private static int vowelCount(Deque<Integer> v,char[] ca) {
		Set<Character> s=new HashSet<Character>();
		v.forEach((a)->s.add(ca[a]));
		return s.size();
	}

	static class FastReader{
		BufferedReader br;
		StringTokenizer st;
		
		public FastReader() {
			br=new BufferedReader(new InputStreamReader(System.in));
		}
		public String next() {
			while(st==null || !st.hasMoreElements()) {
				try {
					st=new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		int nextInt() {
			return Integer.parseInt(next());
		}
		long nextLong() {
			return Long.parseLong(next());
		}
		String nextLine() {
			String ret="";
			try {
				ret=br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ret;
		}
		
		
	}
}
