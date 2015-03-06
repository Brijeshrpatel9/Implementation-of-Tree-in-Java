/**
 * Represents a node in the Binary Search Tree.
 */
class Node {
  //The value present in the node.
  public int value;

  //The reference to the left subtree.
  public Node left;

  //The reference to the right subtree.
  public Node right;

  public Node(int value) {
    this.value = value;
  }

}

/**
 * Represents the Binary Search Tree.
 */
class BinarySearchTreeTest {

  //Refrence for the root of the tree.
  public Node root;

  public BinarySearchTreeTest insert(int value) {
    Node node = new Node(value);

    if (root == null) {
      root = node;
      return this;
    }

    insertRec(root, node);
    return this;
  }

  private void insertRec(Node latestRoot, Node node) {

    if (latestRoot.value > node.value) {

      if (latestRoot.left == null) {
        latestRoot.left = node;
        return;
      } else {
        insertRec(latestRoot.left, node);
      }
    } else {
      if (latestRoot.right == null) {
        latestRoot.right = node;
        return;
      } else {
        insertRec(latestRoot.right, node);
      }
    }
  }

  /**
   * Returns the minimum value in the Binary Search Tree.
   */
  public int findMinimum() {
    if (root == null) {
      return 0;
    }
    Node currNode = root;
    while (currNode.left != null) {
      currNode = currNode.left;
    }
    return currNode.value;
  }

  /**
   * Returns the maximum value in the Binary Search Tree
   */
  public int findMaximum() {
    if (root == null) {
      return 0;
    }

    Node currNode = root;
    while (currNode.right != null) {
      currNode = currNode.right;
    }
    return currNode.value;
  }
  
  
  
  
  public void delete(int value)
  {
      if (root == null)
          System.out.println("Tree Empty");
      else if (search(value) == false)
          System.out.println("Sorry "+ value +" is not present");
      else
      {
          root = delete(root, value);
          System.out.println( value + " deleted from the tree");
      }
  }
  private Node delete(Node root, int value)
  {
      Node temp, t, n;
      if (root.value == value)
      {
          Node lt, rt;
          lt = root.left;
          rt = root.right;
          if (lt == null && rt == null)
              return null;
          else if (lt == null)
          {
              temp = rt;
              return temp;
          }
          else if (rt == null)
          {
              temp = lt;
              return temp;
          }
          else
          {
              t = rt;
              temp = rt;
              while (temp.left != null)
                  temp = temp.left;
              temp.left = lt;
              return t;
          }
      }
      if (value < root.value)
      {
          n = delete(root.left, value);
          root.left =n;
      }
      else
      {
          n = delete(root.right, value);
          root.right = n;             
      }
      return root;
  }
  /* Functions to count number of nodes */
  public int countNodes()
  {
      return countNodes(root);
  }
  /* Function to count number of nodes recursively */
  private int countNodes(Node root)
  {
      if (root == null)
          return 0;
      else
      {
          int count = 1;
          count += countNodes(root.left);
          count += countNodes(root.right);
          return count;
      }
  }
  /* Functions to search for an element */
  public boolean search(int val)
  {
      return search(root, val);
  }
  /* Function to search for an element recursively */
  private boolean search(Node r, int val)
  {
      boolean found = false;
      while ((r != null) && !found)
      {
          int rval = r.value;
          if (val < rval)
              r = r.left;
          else if (val > rval)
              r = r.right;
          else
          {
              found = true;
              break;
          }
          found = search(r, val);
      }
      return found;
  }
  
  
  
  
  
  /**
   * Printing the contents of the tree in an inorder way.
   */
  public void printInorder() {
    printInOrderRec(root);
    System.out.println("");
  }

  /**
   * Helper method to recursively print the contents in an inorder way
   */
  private void printInOrderRec(Node currRoot) {
    if (currRoot == null) {
      return;
    }
    printInOrderRec(currRoot.left);
    System.out.print(currRoot.value + ", ");
    printInOrderRec(currRoot.right);
  }

  /**
   * Printing the contents of the tree in a Preorder way.
   */
  public void printPreorder() {
    printPreOrderRec(root);
    System.out.println("");
  }

  /**
   * Helper method to recursively print the contents in a Preorder way
   */
  private void printPreOrderRec(Node currRoot) {
    if (currRoot == null) {
      return;
    }
    System.out.print(currRoot.value + ", ");
    printPreOrderRec(currRoot.left);
    printPreOrderRec(currRoot.right);
  }

  /**
   * Printing the contents of the tree in a Postorder way.
   */
  public void printPostorder() {
    printPostOrderRec(root);
    System.out.println("");
  }

  /**
   * Helper method to recursively print the contents in a Postorder way
   */
  private void printPostOrderRec(Node currRoot) {
    if (currRoot == null) {
      return;
    }
    printPostOrderRec(currRoot.left);
    printPostOrderRec(currRoot.right);
    System.out.print(currRoot.value + ", ");

  }
}

public class BinarySearchTree {

  public static void main(String[] args) {
    BinarySearchTreeTest bst = new BinarySearchTreeTest();
    bst .insert(40)
        .insert(25)
        .insert(78)
        .insert(10)
        .insert(3)
        .insert(17)
        .insert(32)
        .insert(30)
        .insert(38)
        .insert(78)
        .insert(50)
        .insert(93);
    System.out.println("Inorder traversal");
    bst.printInorder();

    System.out.println("Preorder Traversal");
    bst.printPreorder();

    System.out.println("Postorder Traversal");
    bst.printPostorder();

    System.out.println();
    
    System.out.println("The minimum value in the BST: " + bst.findMinimum());
    System.out.println("The maximum value in the BST: " + bst.findMaximum());
    
    System.out.println();
    
    System.out.println("Search: True or False?" + bst.search(10));
    
    System.out.println();
    
    System.out.println("No of Nodes: " + bst.countNodes());
    
    System.out.println();
    
    System.out.println("Delete: ");
    bst.delete(50);
    
    System.out.println();
    
    System.out.println("Inorder traversal");
    bst.printInorder();
    

  }
}
