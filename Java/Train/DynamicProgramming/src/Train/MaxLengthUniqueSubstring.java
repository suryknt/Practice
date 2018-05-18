package Train;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MaxLengthUniqueSubstring {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		sc.nextLine();
		while(t-->0) {
			String s=sc.nextLine();
			int[] dp=new int[s.length()];
			
//			Map<Character,Integer> visited =new HashMap<Character,Integer>();
			int[] visited=new int[256];
			Arrays.fill(visited	, -1);
			int curr_length=1;
			int max_length=1;
			visited[s.charAt(0)]=0;
			
			for(int i=1;i<s.length();i++) {
				char c=s.charAt(i);
				if(visited[c]==-1 || i-curr_length>visited[c]) curr_length++;
				else {
					if(curr_length>max_length)curr_length=max_length;
					curr_length=i-visited[c];
				}
				visited[c]=i;
				max_length=Math.max(max_length, curr_length);
				
			}
			System.out.println(max_length);
			
		}
	}
}
