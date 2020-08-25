package leetcode.tree;

import java.util.Arrays;
import java.util.stream.IntStream;

public class PreInOrderBinaryTree {

	static void printInorder(TreeNode node) 
    { 
        if (node == null) 
        	return; 
        printInorder(node.left); 
        System.out.print(node.val + " "); 
        printInorder(node.right); 
    } 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] preorder = { 3, 9, 20, 15, 7 };

		int[] inorder = { 9, 3, 15, 20, 7 };

		TreeNode root = buildTree(preorder, inorder);
		
		printInorder(root);
		
	}

	private static int j = 0;

	public static TreeNode buildTree(int[] preorder, int[] inorder) {

		return findRoot(preorder, inorder, 0, inorder.length - 1);

	}

	private static TreeNode findRoot(int[] preorder, int[] inorder, int start, int end) {
		// TODO Auto-generated method stub

		if (start > end)
			return null;
       
		TreeNode root = new TreeNode(preorder[j++]);

		if (start == end)
			return root;

		int len = inorder.length, data = root.val;

		int index = IntStream.range(0, len).filter(i -> data == inorder[i]).findFirst().orElse(-1);

		root.left = findRoot(preorder, inorder, start, index-1);

		root.right = findRoot(preorder, inorder, index + 1, end);

		return root;
	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}