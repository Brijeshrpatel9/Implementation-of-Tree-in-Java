import java.io.*;
import java.util.*;

class LDFS
{
	int vertex;
	LDFS[] head;
	LDFS next;
	LDFS first;
	int size;
	int[] visited;
	int[] Queue;
	int front, rear;
	
	public LDFS(int MAX)
	{
		size = MAX;
		int v1;
		head = new LDFS[size];
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
		LDFS New = new LDFS(5);
		
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
		
		New = new LDFS(4);
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
		LDFS temp;
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
	
	public void DFS(int v1) throws NullPointerException, ArrayIndexOutOfBoundsException
	{
		int v2;
		LDFS first;
		System.out.println(v1);
		visited[v1] = 1;
		first = head[v1];
		while( first!= null)
			if(visited[first.vertex] != 1)
				DFS(first.vertex);
			else
				first = first.next;
		
	}
}


public class DeapthFirstSearchList {

	public static void main(String argv[]) throws NullPointerException, IOException
	{
		LDFS ldfs = new LDFS(8);
		
		
		ldfs.create(1, 6);
		ldfs.create(1, 5);
		ldfs.create(1, 2);
		ldfs.create(2, 3);
		ldfs.create(2, 7);
		ldfs.create(4, 3);
		ldfs.create(5, 4);
		ldfs.create(7, 4);
		
		ldfs.create(5, 6);
		
		ldfs.display();
		System.out.println("");
		System.out.println("The Deapth First Search of the graph is: ");
		ldfs.DFS(1);
		
	}
}
