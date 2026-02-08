import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    public static TreeNode construct(Integer [] arr){

        if(arr==null || arr[0]==null || arr.length==0) return null;

        TreeNode root = new TreeNode(arr[0]);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;

        while(i<arr.length){
            TreeNode curr = queue.poll();

            if(i<arr.length && arr[i]!=null){
                curr.left = new TreeNode(arr[i]);
                queue.add(curr.left);
            }

            i++;

            if(i<arr.length && arr[i]!=null){
                curr.right = new TreeNode(arr[i]);
                queue.add(curr.right);
            }

            i++;
        }

        return root;

    }

    public static void levelOrder(TreeNode root) {
        //List<List<Integer>> ans = new ArrayList<>();
        if (root==null){
            System.out.println("");
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);

        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode p = queue.poll();
                if(p.left!=null) queue.add(p.left);
                if(p.right!=null) queue.add(p.right);

                list.add(p.val);
            }

            System.out.println(list);
        }

        //return ans;
    }

    public static void zigZagTraversal(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean dir = true;

        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int n = queue.size();
            for(int i = 0; i<n;i++){
                TreeNode p = queue.poll();                
                
                if(p.left!=null)queue.add(p.left);
                if(p.right!=null)queue.add(p.right);
            
                list.add(p.val);
            }

            if(dir) System.out.println(list);
            else{
                Collections.reverse(list);
                System.out.println(list);
            } //or just define arraylist of n size and insert from back (takes n time for defining too)
            dir=!dir;
        }
        
    }

    public static boolean rootToNode(TreeNode root, int val, List<Integer> list){
       if(root == null){
        return false;
       }
       list.add(root.val);

       if(root.val==val) return true;

       if(rootToNode(root.left, val, list) || rootToNode(root.right, val, list)){
        return true;
       }

       list.remove(list.size()-1);
       return false;

        
    }

    public static void inOrder(TreeNode root){
        if(root==null) return;

        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = construct(new Integer[]{1,2,3,4,5,null,null,null,null,6,7});
        List<Integer> list = new ArrayList<>();
        //levelOrder(root);
        // zigZagTraversal(root);
        // inOrder(root);
        // System.out.println();
        // rootToNode(root, 7, list);
        // System.out.println(list);

        char c = 'a'-1;
        for(int i = 0; i<26; i++){
            c+=1;
            if(c>'i'){
                System.out.print(" " +c+ " ");
            }else{
                System.out.print(c+ " ");
            }
            
        }
        System.out.println();
        for(int i=1;i<=26;i++){
            System.out.print(i+" ");
        }

    }

    
}
