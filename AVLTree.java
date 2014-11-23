
class AVLNode
{
	protected int height;
	protected int data;
	protected AVLNode left, right;
	
	public AVLNode()
	{
		height = 0;
		data = 0;
		left = right = null;
	}
	
	public AVLNode(int value)
	{
		data = value;
		height = 0;
		left = right = null;
	}
	
}

class AVLTreeTest
{
	protected AVLNode root;
	
	public AVLTreeTest()
	{
		root = null;
	}
	
	public boolean isEmpty()
	{
		return root == null;
	}
	
	public void makeEmpty()
	{
		root = null;
	}
	
	public int height(AVLNode node)
	{
		return node == null ? -1 : node.height;
	}
	
	public int max(int lhs, int rhs)
	{
		return lhs > rhs ? lhs : rhs;
	}
	
	
	public void insert(int value)
	{
		root = insert(value, root);
		System.out.println(value + " is inserted.");
	}

	public AVLNode insert(int value, AVLNode node)
	{
		if(node == null)
			node = new AVLNode(value);
		else if( value < node.data)
		{
			node.left = insert(value, node.left);
		}
		else if( value > node.data)
		{	
			node.right = insert(value, node.right);
		}
		else
			;
		//node.height = max(height(node.left), height(node.right)) + 1;
		return balance(node);
			
	}
	
	public void remove(int value)
	{
		root = remove(value, root);
		System.out.println(value + " is removed.");
	}

	public AVLNode remove(int value, AVLNode node)
	{
		if(node == null)
			return node;
		else if(value < node.data)
		{
			node.left = remove(value, node.left);
		}
		else if(value > node.data)
		{
			node.right = remove(value, node.right);
		}
		//else if(node.left == null && node.right == null)
		//{
			//node.data = findMin(node.right).data;
			
		//}
		else
			node = (node.left != null) ? node.left : node.right;
		return balance(node);
	}
	
	public static final int allowed_imbalance = 1;
	
	public AVLNode balance(AVLNode node)
	{
		if(node == null)
			return node;
		
		if(height(node.left) - height(node.right) > allowed_imbalance)
			if(height(node.left.left) >= height(node.left.right))
				node = rotateWithLeftChild(node);
			else
				node = doubleWithLeftChild(node);

		if(height(node.right) - height(node.left) > allowed_imbalance)
			if(height(node.right.right) >= height(node.right.left))
				node = rotateWithRightChild(node);
			else
				node = doubleWithRightChild(node);
		node.height = max(height(node.left), height(node.right)) + 1;
		return node;
		
	}
	private AVLNode rotateWithLeftChild(AVLNode k2)
	{
		AVLNode k1 = k2.left;
		k2.left = k1.right;
		k1.right = k2;
		k2.height = max(height(k2.left), height(k2.right)) + 1;
		k1.height = max(height(k1.left) ,k1.height ) + 1;
		return k1;
	}
	
	/*
	 *      node1
	 *     /
	 *    node2
	 *    /  
	 *     
	 *     After Rotation
	 *     node2
	 *     /    \
	 *         node1  
	 */                
	 
	private AVLNode rotateWithRightChild(AVLNode k2)
	{
		AVLNode k1 = k2.right;
		k2.right = k1.left;
		k1.left = k2;
		k2.height = max(height(k2.left), height(k2.right)) + 1;
		k1.height = max(height(k1.right) , k2.height) + 1;
		return k1;
	}
	
	private AVLNode doubleWithLeftChild(AVLNode node3)
	{
		node3.left = rotateWithRightChild(node3.left);
		return rotateWithLeftChild(node3);
	}
	
	private AVLNode doubleWithRightChild(AVLNode k1)
	{
		k1.right = rotateWithLeftChild(k1.right);
		return rotateWithRightChild(k1);
	}
	public int countNodes()
	{
		System.out.println("No of Nodes: " + countNodes(root));
		return countNodes(root);
	}
	
	public int countNodes(AVLNode node)
	{
		if(node == null)
			return 0;
		else
		{
			int l = 1;
			l += countNodes(node.left);
			l += countNodes(node.right);
			return l;
		}
	}
	
	public boolean search(int value)
	{
		return search(root, value);
	}
	
	public boolean search(AVLNode node, int value)
	{
		boolean found = false;
		while( (node != null) && !found)
		{
			int nodeValue = node.data;
			if(value < nodeValue)
				node = node.left;
			else if( value > nodeValue)
				node = node.right;
			else
			{
				found = true;
				break;
			}
			found = search(node, value);
	
		}
		return found;
	}	
	
	public void inorder()
	{
		inorder(root);
	}
	public void inorder(AVLNode node)
	{
		if(node != null)
		{
			inorder(node.left);
			System.out.print(node.data + " ");
			inorder(node.right);
		}
	}
	
	public void preorder()
	{
		preorder(root);
	}
	public void preorder(AVLNode node)
	{
		if(node != null)
		{
			System.out.print(node.data + " ");
			preorder(node.left);
			preorder(node.right);
		}
	}
	
	public void postorder()
	{
		postorder(root);
	}
	public void postorder(AVLNode node)
	{
		if(node != null)
		{
			postorder(node.left);
			postorder(node.right);
			System.out.print(node.data + " ");
			
		}
	}
	
	
}
public class AVLTree {

	
	public static void main(String argv[])
	{
		AVLTreeTest avl = new AVLTreeTest();
		avl.insert(30);
		avl.insert(10);
		avl.insert(20);
		avl.insert(15);

		avl.insert(25);
		avl.insert(34);
		avl.insert(32);
		avl.insert(31);

		avl.insert(35);

		avl.insert(37);

		System.out.println(" ");
		avl.inorder();
		System.out.println(" ");
		avl.preorder();
		System.out.println(" ");
		avl.postorder();
		System.out.println(" ");
		
		System.out.println("AVL tree is empty or not? " + avl.isEmpty());
		avl.countNodes();
		
		System.out.println("Search result: " + avl.search(35));
		System.out.println("Search result: " + avl.search(50));
		//avl.height(30);
		//System.out.println(avl.height(37));
		
		avl.remove(15);
		System.out.println(" ");
		avl.inorder();
		System.out.println(" ");
		avl.preorder();
		System.out.println(" ");
		avl.postorder();
		System.out.println(" ");
		
	
	}
}
