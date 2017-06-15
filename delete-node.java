import java.io.*;
import java.util.*;
static class TreeNode {
  TreeNode left, right;
  int val;
  public TreeNode(val) {this.val = val;}
}
class Solution {

  public static TreeNode deleteNode(TreeNode root, int key) {
      TreeNode parent = root;
      TreeNode keyNode = findKeyInTree(root, key, parent);
      if (keyNode.right == null && keyNode.left == null) {
          keyNode = null;
      } else if (keyNode.right != null && keyNode.left != null) {
          if (keyNode.val < parent.val) {
              parent.left = keyNode.right;
              
          } else {
              parent.right = keyNode.right;
          }
          keyNode.right.left = keyNode.left;
          keyNode = null;
      } else {
          if (keyNode.right == null) {
              keyNode = keyNode.left;
          } else {
              keyNode = keyNode.right;
          }
      }
      return root;
  }
  
  public static TreeNode findKeyInTree(TreeNode root, int key, TreeNode parent) {
      TreeNode cur = root;
      parent = root;
      if (key == cur.val) {
          return cur;
      } else if (key < cur.val) {
          parent = cur;
          cur = cur.left;
      } else {
          parent = cur;
          cur = cur.right
      }
  }

  public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        TreeNode res = deleteNode(root, 3);
  }

}

/**
        5
       / \
      3    8
     / \  / 
    2    6 
    
        5
       / \
      3   6
     / \   \
    2   4   7
    
    
**/
