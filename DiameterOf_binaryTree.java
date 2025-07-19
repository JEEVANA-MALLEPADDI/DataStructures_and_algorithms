// Given a binary tree, the diameter (also known as the width) is defined as the number of edges on the longest path between two leaf nodes in the tree. This path may or may not pass through the root. Your task is to find the diameter of the tree.
// link :  https://www.geeksforgeeks.org/batch/dsa-self-paced-july/track/DSASP-Tree/problem/diameter-of-binary-tree
// Examples:

// Input: root[] = [1, 2, 3]
//       1
//      /  \
//     2    3
// Output: 2
// Explanation: The longest path has 2 edges (node 2 -> node 1 -> node 3).

// Input: root[] = [5, 8, 6, 3, 7, 9]
//                5
//             /    \
//            /      \
//           8         6
//          /  \       /
//         3    7     9
// Output: 4
// Explanation: The longest path has 4 edges (node 3 -> node 8 -> node 5 -> node 6 -> node 9).

//naive sollution---- O(n^2)
class Solution {
    public int diameter(Node root) {
        if (root == null) return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int diameterThroughRoot = leftHeight + rightHeight + 2;

        int leftDiameter = diameter(root.left);
        int rightDiameter = diameter(root.right);

        return Math.max(diameterThroughRoot, Math.max(leftDiameter, rightDiameter));
    }

    private int height(Node node) {
        if (node == null) return -1; // for edge-based height
        return 1 + Math.max(height(node.left), height(node.right));
    }
}


//efficient sollution--- O(n)
  
class Solution {
    int maxDiameter = 0;

    int diameter(Node root) {
        height(root);
        return maxDiameter;
    }

    int height(Node node) {
        if (node == null) return -1;

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        // diameter through current node
        int dia = leftHeight + rightHeight + 2;

        maxDiameter = Math.max(maxDiameter, dia);

        return Math.max(leftHeight, rightHeight) + 1;
    }
}

