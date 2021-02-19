public class BinaryTreeLevelOrderTraversal
{
    static int node[] = {1, 2, 3, 4, 5, 6};

    public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

      //input is formatted root = [1,2,3,null,null,6,7,etc]
    //output should be formatted [[1],[2,3],[6,7]]
      //first value is always root

    //print array
    public static void printNode(int[] node)
    {
        for(int i = 0; i < node.length; i++)
        {
            System.out.println(node[i]);
        }
    }

    public static void main(String[] args)
    {
        printNode(node);
    }
}
