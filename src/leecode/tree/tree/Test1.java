package leecode.tree.tree;

import leecode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树前序遍历
 *
 * @author toonew on 2018/7/20
 */
public class Test1 {

    public static void main(String[] args) {

        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);

        treeNode1.right = treeNode2;
        treeNode2.left = treeNode3;

        Test1 test1 = new Test1();
        System.out.println(test1.preorderTraversal(treeNode1));

    }

    private List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preHelper(root, list);
        return list;
    }

    private static void preHelper(TreeNode root, List<Integer> pre) {
        if (root == null) {
            return;
        }
        pre.add(root.val);
        preHelper(root.left, pre);
        preHelper(root.right, pre);
    }
}