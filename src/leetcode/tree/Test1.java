package leetcode.tree;

/**
 * 二叉树的最大深度
 *
 * @author toonew on 2018/7/20
 */
public class Test1 {

    public static void main(String[] args) {

        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode20 = new TreeNode(20);
        TreeNode treeNode15 = new TreeNode(15);
        TreeNode treeNode7 = new TreeNode(7);

        treeNode3.left = treeNode9;
        treeNode3.right = treeNode20;
        treeNode20.left = treeNode15;
        treeNode20.right = treeNode7;

        Test1 test1 = new Test1();
        System.out.println(test1.maxDepth(treeNode3));
    }

    private int maxDepth(TreeNode root) {
        int max = 1;
        if (root != null) {

            max++;
            int maxLeft = maxDepth(root.left);
            int maxRight = maxDepth(root.left);

            max += maxLeft > maxRight ? maxLeft : maxRight;
        }
        return max;
    }

}
