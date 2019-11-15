import java.util.*;
public class GraphImplementation implements Graph {
	private int vertices;
	private int matrix[][];
	//creates the graph
	public GraphImplementation(int vertices)
	{
		this.vertices = vertices;
		matrix = new int[vertices][vertices];
	}
	//creates edges in the adjacency matrix
	public void addEdge(int v1, int v2) throws Exception {
		if(v1 >= vertices || v1 < 0 || v2 >= vertices || v2 < 0)
			throw new Exception("Cannot be negative");
		matrix[v1][v2] = 1;
	}
	//this sorts vertices
	public List<Integer> topologicalSort()
	{
		List<Integer> list = new ArrayList<Integer>();
		int [] sum = new int[vertices];
		for (int i=0; i < vertices; i++)
		{
			for (int j=0; j < vertices; j++)
				sum[i]+=matrix[j][i];
		}
		for (int i=0; i < vertices; i++)
		{
			int next=findZero(sum);
			if (next == -1)
			{
				return list;
			}
			list.add(next);
			System.out.println(next);
			sum[next]=-1;
			for (int j=0; j<vertices; j++)
				sum[j]-=matrix[next][j];
		}
		System.out.println();
		return list;
	}
	public List<Integer> neighbors(int vertex) throws Exception{
		if(vertex >= vertices || vertex < 0){
			throw new Exception();
		}
		List<Integer> neighbors = new ArrayList<>();
		for(int i=0; i<vertices; i++){
			if(matrix[vertex][i] > 0){
				neighbors.add(i);
			}
		}
		return neighbors;
	}
	//this returns the index of the first element equal to zero in a given array
	private int findZero(int [] sum)
	{
		for (int i=0; i<sum.length; i++)
		{
			if (sum[i]==0)
				return i;
		}
		return -1;
	}
}