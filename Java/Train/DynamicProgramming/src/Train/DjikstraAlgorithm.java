package Train;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class DjikstraAlgorithm {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
			int n = sc.nextInt();
			int[][] graph = new int[n][n];
			for(int i = 0; i < n; i++)for(int j = 0; j < n; j++) {
				int d= sc.nextInt();
				graph[i][j]=i!=j && d==0?Integer.MAX_VALUE:d;
						
			}
			
			int src = sc.nextInt();
			int goal=sc.nextInt();
			
			printShortesPath(graph, src,goal, n);
		}
		sc.close();
	}

	private static void printShortesPath(int[][] graph, int src,int goal, int n) {

		Set<Integer> s=new HashSet<Integer>();
		int[] predecessor=new int[n];
		int[] val=new int[n];
		Arrays.fill(val, Integer.MAX_VALUE);
		val[src]=0;
		int curr=src;
		while(s.size() !=n) {
//			System.out.println("curr:: "+curr+" s:: "+s.toString());
//			printArr(val);
			s.add(curr);
			int min=Integer.MAX_VALUE;
			int next=curr;
			for(int i=0;i<n;i++) {
				
				if(!s.contains(i)) {
					int dist=val[curr]+graph[curr][i];
					if(dist+1<0)dist=Integer.MAX_VALUE;
//					System.out.println("dist:: "+dist+" val[curr]:: "+val[curr]+" graph[curr][i]::: "+graph[curr][i]);
//					val[i]=Math.min(val[i], dist);
					if(dist<val[i]) {
						val[i]=dist;
						predecessor[i]=curr;
					}
					if(val[i]<=min) {
						min=val[i];
						next=i;
					}
				}
				
			}
			curr=next;
		}
//		for(int i=0;i<n;i++) {
//			if(val[i]+1<0)val[i]=-1;
//			if(i !=src)System.out.print(val[i]+" ");
//		}
//		
//		System.out.println();
		
		
//		System.out.println(minDistance);
		Stack<Integer> path=new Stack<Integer>();
		path.push(goal);
		System.out.println(val[goal]);
		while(goal !=src) {
			path.push(predecessor[goal]);
			goal=predecessor[goal];
		}
		
		while(!path.isEmpty())System.out.print(path.pop()+" ");
		System.out.println();
	
	}
	private static void dijkstra(int[][] graph, int src,int goal, int n) {
		Set<Integer> s=new HashSet<Integer>();
		Stack<Integer> st=new Stack<Integer>(); 
		int[] val=new int[n];
		Arrays.fill(val, Integer.MAX_VALUE);
		val[src]=0;
		int curr=src;
		while(s.size() !=n) {
//			System.out.println("curr:: "+curr+" s:: "+s.toString());
//			printArr(val);
			s.add(curr);
			int min=Integer.MAX_VALUE;
			int next=curr;
			for(int i=0;i<n;i++) {
				
				if(!s.contains(i)) {
					int dist=graph[src][curr]+graph[curr][i];
					if(dist+1<0)dist=Integer.MAX_VALUE;
					val[i]=Math.min(val[i], dist);
					if(val[i]<=min) {
						min=val[i];
						next=i;
					}
				}
				
			}
			curr=next;
		}
		
		for(int i=0;i<n;i++) {
			if(val[i]+1<0)val[i]=-1;
			if(i !=src)System.out.print(val[i]+" ");
		}
	}
	
	static void printArr(int[] dp) {
		System.out.print("[ ");
		for(int i=0;i<dp.length;i++) {
			
			System.out.print(" "+dp[i]);
		}
		System.out.println("]");
	}
}
