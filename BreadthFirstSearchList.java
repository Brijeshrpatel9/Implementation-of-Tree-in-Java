import java.io.*;
import java.util.*;

class LBFS
{
	int vertex;
	LBFS[] head;
	LBFS next;
	LBFS first;
	int size;
	int[] visited;
	int[] Queue;
	int front, rear;
	
	public LBFS(int MAX)
	{
		size = MAX;
		int v1;
		head = new LBFS[size];
		Queue = new int[size];
		visited = new int[10];
		
		for(v1= 0; v1 < size ; v1++)
			head[v1] = null;
		for(v1 = 0; v1 < size; v1++)
			Queue[v1] = 0;
			front = rear = -1;
		for(v1 = 0; v1 < size; v1++)
			visited[v1] = 0;
		
	}
	
	public void create(int v1, int v2) throws NullPointerException
	{
		LBFS New = new LBFS(10);
		if( New == null)
			System.out.println("Insufficient Memory.");
		New.vertex = v2;
		New.next = null;
		first = head[v1];
		if(first == null)
		{
			head[v1] = New;
		}
		else
		{
			while(first.next != null)
				first = first.next;
			first.next = New;
		}
		
		New = new LBFS(10);
		if( New == null)
			System.out.println("Insufficient Memory.");
		New.vertex = v1;
		New.next = null;
		first = head[v2];
		if(first == null)
		{
			head[v2] = New;
		}
		else
		{
			while(first.next != null)
				first = first.next;
			first.next = New;
		}
		
	}
	
	public void display()
	{
		LBFS temp;
		System.out.println("\nThe graph is: ");
		for(int i = 0; i < size -1 ; i++)
		{
			temp = head[i];
			System.out.println("");
			System.out.print(i + "--");
			while(temp != null)
			{
				System.out.print(" " + temp.vertex);
				temp = temp.next;
			}
		}
		System.out.println("");
	}
	
	public void BFS(int v1) throws NullPointerException, ArrayIndexOutOfBoundsException
	{
		int i;
		LBFS first;
		front = rear = -1;
		Queue[++rear] = v1;
		while(front != rear)
		{
			i = Queue[++front];
			if(visited[i] == 0)
			{
				System.out.println(i);
				visited[i] = 1;
			}
			first = head[i];
			while( first != null)
			{
				if(visited[first.vertex] == 0)
				{
					Queue[++rear] = first.vertex;
				}
				first = first.next;
			}
		}
	}
}


public class BreadthFirstSearchList {

	public static void main(String argv[]) throws NullPointerException, IOException
	{
		LBFS lbfs = new LBFS(10);
		
		
/* Example 1
 *     1
 *   /   \
 * 0      2
 *   \  /
 *     3
 * 
 * 		lbfs.create(0, 1);
		lbfs.create(1, 3);
		lbfs.create(0, 2);
		lbfs.create(2, 3);
*/		
	
		lbfs.create(0, 1);
		lbfs.create(0, 4);
		lbfs.create(0, 2);
		lbfs.create(1, 3);
		lbfs.create(3, 4);
		lbfs.create(1, 4);
		
		
		//lbfs.create(2, 7);
		lbfs.create(2, 6);
		lbfs.create(2, 5);
		
		
		lbfs.create(5, 6);
		
		lbfs.display();
		System.out.println();
		System.out.println("The Breadth First Search of the graph is: ");
		lbfs.BFS(0);
		
	}
}
