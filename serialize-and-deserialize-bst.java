/** This works but got TLE**/

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public static void main (String[] args) throws java.lang.Exception
	{
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		String serial = serialize(root);
		// System.out.println(serial);
		TreeNode res = deserialize(serial);
		// if (res == null) System.out.println("null");
		// else System.out.println(res.val);
	}
	
	public static String serialize(TreeNode root) {
		LinkedList<TreeNode> s = new LinkedList<TreeNode>();
        if (root != null) s.offer(root); 
        else s.offer(new TreeNode(Integer.MIN_VALUE));
        String res = "";
        while (!s.isEmpty()) {
            TreeNode cur = s.poll();
            // System.out.println(cur.val + ", ");
            if (cur.val == Integer.MIN_VALUE) res += "null,";
            else {
            	res += String.valueOf(cur.val) + ",";
            	if (cur.left == null) s.offer(new TreeNode(Integer.MIN_VALUE));
            	else s.offer(cur.left);
            	// System.out.println(cur.right.val);
            	if (cur.right == null) s.offer(new TreeNode(Integer.MIN_VALUE));
            	else s.offer(cur.right);
            }
        }
        return res;
    }
    
    public static TreeNode deserialize(String data) {
    	LinkedList<TreeNode> list = new LinkedList<TreeNode>();
    	String[] ss = data.split(",");
    	int i = 0;
    	TreeNode cur = null, root = null;
    	if (!ss[i].equals("null")) {
    		// System.out.println(Integer.parseInt(ss[i]));
    		root = new TreeNode(Integer.parseInt(ss[i]));
    		cur = root;
    		list.offer(cur);
    	}
    	while (!list.isEmpty()) {
    		cur = list.poll();
    		// System.out.print(cur.val + ": ");
    		if (ss[++i].equals("null")) {
    			cur.left = null;
    			// System.out.print("null, ");
    		} else {
    			// System.out.print(Integer.parseInt(ss[i]) + ", ");
    			cur.left = new TreeNode(Integer.parseInt(ss[i]));
    			list.offer(cur.left);
    		}
    		if (ss[++i].equals("null")) {
    			cur.right = null;
    			// System.out.println("null, ");
    		} else {
    			// System.out.println(Integer.parseInt(ss[i]));
    			cur.right = new TreeNode(Integer.parseInt(ss[i]));
    			list.offer(cur.right);
    		}
    	}
    	return root;	
    }
}

/** This is the best solution. Very elegant too**/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    public static String splitter = ",";
	public static String nl = "X";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		buildString(sb, root);
		return sb.toString();
	}
	public void buildString(StringBuilder sb, TreeNode root) {
		if (root == null) {
			sb.append(nl).append(splitter);
		} else {
			sb.append(root.val).append(splitter);
			buildString(sb, root.left);	
			buildString(sb, root.right);
		}
	}
	
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> l = Arrays.asList(data.split(splitter));
		Deque<String> d = new LinkedList(l);
		return buildTree(d);
	}
	public TreeNode buildTree(Deque<String> d) {
		String val = d.remove();
		if (val.equals(nl)) {
			return null;
		} else {
			TreeNode root = new TreeNode(Integer.parseInt(val));
			root.left = buildTree(d);
			root.right = buildTree(d);
			return root;
		}
	}
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

