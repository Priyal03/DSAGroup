package leetcode.tree;

public class PopulatingRightPointer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public Node connect(Node root) {

		if (root == null)
			return root;

		if (root.left != null) {
			root.left.next = root.right;
		}
		
		if (root.right != null) {

			Node next = null;

			if (root.next != null)//if root's next is null i.e. its the current right most node.
				next = root.next.left;

			root.right.next = next;
		}

		connect(root.left);
		connect(root.right);
		return root;
	}
}

class Node {
	public int val;
	public Node left;
	public Node right;
	public Node next;

	public Node() {
	}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, Node _left, Node _right, Node _next) {
		val = _val;
		left = _left;
		right = _right;
		next = _next;
	}
};