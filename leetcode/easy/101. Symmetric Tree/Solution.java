import java.util.*;

/**
 * Definition for a binary tree node.
 */
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

class Solution {
    public boolean isSymmetric(TreeNode root) {
        // return isSymmetricRecursive(root);
        return isSymmetricIterative(root);
    }

    public boolean isSymmetricIterative(TreeNode root) {
        if (root == null)
            return true;
        var stack = new Stack<TreeNode>();
        var mirrorStack = new Stack<TreeNode>();
        stack.push(root.left);
        mirrorStack.push(root.right);
        while (!stack.isEmpty()) {
            var node = stack.pop();
            var mirrorNode = mirrorStack.pop();
            if (node == null && mirrorNode != null || node != null && mirrorNode == null)
                return false;
            if (node == mirrorNode && node == null)
                continue;
            // by now we know that node and mirroNode are not null
            if (node.val != mirrorNode.val)
                return false;
            stack.push(node.left);
            stack.push(node.right);
            mirrorStack.push(mirrorNode.right);
            mirrorStack.push(mirrorNode.left);
        }
        return true;
    }

    public boolean isSymmetricRecursive(TreeNode root) {
        if (root == null)
            return true;
        return recursiveHelper(root.left, root.right);
    }

    public boolean recursiveHelper(TreeNode root, TreeNode mirrorRoot) {
        if (root == null && mirrorRoot != null || root != null && mirrorRoot == null)
            return false;
        if (root == null && mirrorRoot == null)
            return true;
        if (root.val != mirrorRoot.val)
            return false;
        return recursiveHelper(root.left, mirrorRoot.right) && recursiveHelper(root.right, mirrorRoot.left);
    }
}