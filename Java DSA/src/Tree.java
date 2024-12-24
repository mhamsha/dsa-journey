import java.util.*;

public class Tree {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            this.val = x;
            this.left = null;
            this.right = null;
        }

        // depth first search recursion algorithm
        // pre-order dfs algorithm
        void pre_dfs() {
            System.out.println(this.val);

            if (this.left != null) {
                this.left.pre_dfs();
            }
            if (this.right != null) {
                this.right.pre_dfs();
            }
        }

        // in-order dfs algorithm
        void in_dfs() {
            if (this.left != null)
                this.left.in_dfs();
            System.out.println(this.val);
            if (this.right != null)
                this.right.in_dfs();
        }

        // pre-order dfs algorithm
        void post_dfs() {
            if (this.left != null)
                this.left.post_dfs();
            if (this.right != null)
                this.right.post_dfs();
            System.out.println(this.val);
        }

        // Breadth-first search algorithm
        void bfs() {
            // Initialize a list with the root node to keep track of nodes to visit
            ArrayList<TreeNode> to_visit = new ArrayList<>();
            to_visit.add(this);
            // Continue looping while there are nodes to visit
            while (to_visit.size() != 0) {
                // Remove the first node from the list
                TreeNode current = to_visit.remove(0);
                // Process the current node (in this case, print its value)
                System.out.println(current.val);
                // Add the left child to the list if it exists
                if (current.left != null) {
                    to_visit.add(current.left);
                }
                // Add the right child to the list if it exists
                if (current.right != null) {
                    to_visit.add(current.right);
                }
            }
        }

        // Perform arbitrary task(operations) on all nodes

        // using functional interface method
        // @FunctionalInterface
        // interface dfs {
        // void applyFunc(TreeNode node);
        // }

        // void dfs_apply(dfs fn) {
        // fn.applyFunc(this);
        // if (this.left != null) {
        // this.left.dfs_apply(fn);
        // }
        // if (this.right != null) {
        // this.right.dfs_apply(fn);
        // }
        // }

        // using simple pass the object methos
        // void dfs_apply(PerformSum p){
        // p.process(this);

        // if(this.left != null){
        // this.left.dfs_apply(p);

        // }
        // if(this.right != null){
        // this.right.dfs_apply(p);
        // }
        // }
        // using simpler recursive method to apply some function to the whole tree
        // element
        int dfs_apply() {
            int sum = this.val;
            if (this.left != null) {
                sum += this.left.dfs_apply();
            }
            if (this.right != null) {
                sum += this.right.dfs_apply();
            }
            return sum;
        }

    }

    public static class PerformSum {
        int sum;

        PerformSum() {
            this.sum = 0;
        }

        void process(TreeNode node) {
            this.sum += node.val;
        }

        int getSum() {
            return this.sum;
        }

        void resetSum() {
            this.sum = 0;
        }

    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(13);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);
        t1.left.left = new TreeNode(4);
        t1.left.right = new TreeNode(5);
        t1.right.left = new TreeNode(6);
        t1.right.right = new TreeNode(7);

        // System.out.println(t1.right.right.val);
        // t1.pre_dfs();
        // System.out.println();
        // System.out.println();
        // t1.in_dfs();
        // System.out.println();
        // System.out.println();
        // t1.post_dfs();
        // System.out.println();
        // System.out.println();
        t1.bfs();

        PerformSum p = new PerformSum();
        // t1.dfs_apply(p::process);

        // using pass the object method
        // t1.dfs_apply(p);

        // using recuusive method 
        // System.out.println(t1.dfs_apply());

        
        // System.out.println(p.getSum());
        p.resetSum();

    }

}
