import java.util.Queue;
import java.util.LinkedList;

public class DFS_BFS {
	
	public static void main(String argv[])
	{
		new DFS_BFS();
	}
	
	int N;
	boolean[][] G;
	
	public DFS_BFS()
	{
		setupGraph();
		
		System.out.println();
		System.out.println("------------------------------");
		System.out.println();
		
		DFS();
		
		System.out.println();
		System.out.println("------------------------------");
		System.out.println();
		
		BFS();
		
		System.out.println();
		System.out.println("------------------------------");
		System.out.println("You are done!");
		
	}
	
	
	public void setupGraph()
	{
	
		N= 8;
		G = new boolean[N][N];
		
		G[0][1]=G[1][0]=true;   // notice that for each edge G[i][j] == G[j][i]
		G[0][2]=G[2][0]=true;	// this means that the graph is undirected
		G[0][3]=G[3][0]=true;
		G[1][4]=G[4][1]=true;
		G[3][4]=G[4][3]=true;
		G[5][6]=G[6][5]=true;
		G[5][7]=G[7][5]=true;
		G[6][7]=G[7][6]=true;
	}
	
	public void DFS()
	{
		boolean[] V = new boolean[N];
		
		int numComponents = 0;
		
		for(int i = 0; i < N; ++i)
			if(!V[i])
			{
				++numComponents;
				System.out.printf("Starting a DFS from component %d for node %d%n",numComponents,i);
				
				DFS(i,V);
			}
		System.out.println();
		System.out.printf("Finished with DFS found components %d%n", numComponents);
	}
	public void DFS(int at, boolean[] V)
	{
		System.out.printf("At Node %d in DFS%n",at);
		
		V[at] = true;
		
		for(int i = 0; i < N; ++i)
			if(G[at][i] && !V[i])
			{
				System.out.printf("Going to Node %d...",i);
				DFS(i,V);
			}
		System.out.printf("Done processing Node %d%n",at);
	}
	
	public void BFS()
	{
		boolean[] V = new boolean[N];
		
		int numComponents = 0;
		
		for(int i = 0; i<N; ++i)
			if(!V[i])
			{
				++numComponents;
				System.out.printf("Starting a BFS from component %d for node %d%n",numComponents,i);
				
				BFS(i,V);
			}	
		System.out.println();
		System.out.printf("Finished with DFS found components %d%n", numComponents);
	}
	
	public void BFS(int start, boolean[] V)
	{
		Queue<Integer> Q = new LinkedList<Integer>();
		
Q.offer(start);
		V[start] = true;
		
		while(!Q.isEmpty())
		{
			int at = Q.poll();
			System.out.printf("At Node %d in BFS%n",at);
			
			for(int i = 0; i<N; ++i)
			{
				if(G[at][i] && !V[i])
				{
					Q.offer(i);
					V[i] = true;
					System.out.printf("Adding node %d to the queue in the BFS%n", i);
				}
				
			}
			System.out.printf("Done processing node %d%n", at);
		}
		System.out.printf("Finished with the BFS from start node %d%n", start);
	}
}
