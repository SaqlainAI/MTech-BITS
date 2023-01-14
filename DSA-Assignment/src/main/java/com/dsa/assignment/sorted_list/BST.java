package main.java.com.dsa.assignment.sorted_list;



public class BST {


    /* Class containing left
        and right child of current node
        * and key value*/
    class Node {
        int key;
        Node left, right;

        public Node(int item)
        {
            key = item;
            left = right = null;
        }
    }

    // Root of BST
    Node root;

    // Constructor
    public BST() { root = null; }

    BST(int value) { root = new Node(value); }

    // This method mainly calls addElementRec()
    public void addElement(int key) { root = addElementRec(root, key); }

    /* A recursive function to
    addElement a new key in BST */
    Node addElementRec(Node root, int key)
    {

		/* If the tree is empty,
		return a new node */
        if (root == null) {
            root = new Node(key);
            return root;
        }

        /* Otherwise, recur down the tree */
        else if (key < root.key)
            root.left = addElementRec(root.left, key);
        else if (key > root.key)
            root.right = addElementRec(root.right, key);

        /* return the (unchanged) node pointer */
        return root;
    }

    public boolean isDuplicate(int key)  {
        Node temp = search(root, key);
        if (temp!= null)
            return true;
        else
            return false;
    }

    public boolean find(int data) {
        return search(root, data)!= null;
    }
    public Node search(Node root, int key)
    {
        // Base Cases: root is null or key is present at root
        if (root==null || root.key==key)
            return root;

        // Key is greater than root's key
        if (root.key < key)
            return search(root.right, key);

        // Key is smaller than root's key
        return search(root.left, key);
    }

    public void deleteKey(int key) { root = deleteRec(root, key); }

    /* A recursive function to
      delete an existing key in BST
     */
    Node deleteRec(Node root, int key)
    {
        /* Base Case: If the tree is empty */
        if (root == null)
            return root;

        /* Otherwise, recur down the tree */
        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);

            // if key is same as root's
            // key, then This is the
            // node to be deleted
        else {
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // node with two children: Get the inorder
            // successor (smallest in the right subtree)
            root.key = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    int minValue(Node root)
    {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }


        // This method mainly calls InorderRec()
    public void print() { printRec(root); }

    // A utility function to
    // do print traversal of BST
    void printRec(Node root)
    {
        if (root != null) {
            printRec(root.left);
            System.out.println(root.key);
            printRec(root.right);
        }
    }

    // Driver Code
    public static void main(String[] args)
    {
        BST tree = new BST();

		/* Let us create following BST
			50
		/	 \
		30	 70
		/ \ / \
	20 40 60 80 */
        tree.addElement(50);
        tree.addElement(30);
        tree.addElement(20);
        tree.addElement(40);
        tree.addElement(70);
        tree.addElement(60);
        tree.addElement(80);

        // print print traversal of the BST
        tree.print();
    }
}
// This code is contributed by Ankur Narain Verma
