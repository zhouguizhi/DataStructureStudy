package com.zgz.leetCode;
import java.util.LinkedList;
import java.util.Queue;
/**
 * https://leetcode-cn.com/problems/invert-binary-tree/
 * 描述:二叉树翻转如图:
 *   ┌──4──┐
 *   │     │
 * ┌─2─┐ ┌─7─┐
 * │   │ │   │
 * 1   3 6   9
 * 翻转后成为这样的
 *   ┌──4──┐
 *   │     │
 * ┌─7─┐ ┌─2─┐
 * │   │ │   │
 * 9   6 3   1
 *
 * 从上面的图可以看的出规律,翻转是将左右调换,将所有的左右子树都替换
 */
public class _25_翻转二叉树 {
    public static void main(String[] args) {
    }
    //   public TreeNode invertTree(TreeNode root) {
//	   if (root == null) return root;
//
//	   TreeNode tmp = root.left;
//	   root.left = root.right;
//	   root.right = tmp;
//
//       invertTree(root.left);
//       invertTree(root.right);
//
//       return root;
//   }

//	public TreeNode invertTree(TreeNode root) {
//	   if (root == null) return root;
//
//       invertTree(root.left);
//       invertTree(root.right);
//
//	   TreeNode tmp = root.left;
//	   root.left = root.right;
//	   root.right = tmp;
//
//       return root;
//    }

    //	public TreeNode invertTree(TreeNode root) {
//	   if (root == null) return root;
//
//       invertTree(root.left);
//
//	   TreeNode tmp = root.left;
//	   root.left = root.right;
//	   root.right = tmp;
//
//       invertTree(root.left);
//
//       return root;
//    }
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return root;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
