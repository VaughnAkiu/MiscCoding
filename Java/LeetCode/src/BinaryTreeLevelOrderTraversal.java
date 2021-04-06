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
    //print all nodes level by level, starting from root each time

    //print array
    public static void printNode(int[] node)
    {
        for(int i = 0; i < node.length; i++)
        {
            System.out.println(node[i]);
        }
    }

    //find the height of the tree
    public static int height(TreeNode root)
    {

        if (root == null)
        {
            return 0;
        }
        else
        {
            //compute height of each subtree
            //use recursion to recurse through all nodes of tree
            int lHeight = height(root.left);
            int rHeight = height(root.right);

            //use the larger of the left or right side heights
            if (lHeight > rHeight)
            {
                return (lHeight + 1);
            }
            else
            {
                return (rHeight + 1);
            }
        }
    }




    public static void main(String[] args)
    {
        printNode(node);
    }
}
