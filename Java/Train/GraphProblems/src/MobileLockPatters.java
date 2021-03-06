
public class MobileLockPatters {
	public static void main(String[] args) {
		int[][] jumpMatrix= {
				{0,0,1,0,0,0,3,0,4},
				{0,0,0,0,0,0,0,4,0},
				{1,0,0,0,0,0,4,0,5},
				{0,0,0,0,0,4,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,4,0,0,0,0,0},
				{3,0,4,0,0,0,3,0,7},
				{0,4,0,0,0,0,0,0,0},
				{4,0,5,0,0,0,7,0,0}
		};
		boolean[] visited=new boolean[9];
		int ways=0;
		for(int k=4;k<10;k++) {
			for(int i=0;i<9;i++) {
				int iWays=getandPrintLockPatterns(i,visited,jumpMatrix,k,"Start -->");
				System.out.println("i:: "+i+" iways:: "+iWays);
				ways+=iWays;
			}
		}
		System.out.println("Total ways:: "+ways);
	}

	private static int getandPrintLockPatterns(int start, boolean[] visited, int[][] jumpMatrix,int toTouch,String path) {
		int ways=0;
		visited[start]=true;
		path+=start+" -->";
		if(toTouch==1) {
			path += " end";
			System.out.println(path);
			visited[start]=false;
			return 1;
		}
		
		for(int i=0;i<9;i++) {
			if(!visited[i] && (jumpMatrix[start][i]==0 || visited[jumpMatrix[start][i]]))
			ways+=getandPrintLockPatterns(i, visited, jumpMatrix, toTouch-1,path);	
		}
		visited[start]=false;
		return ways;
	}
}
