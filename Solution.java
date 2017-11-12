import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static void expectedAmount(long[] a,int n) throws Throwable {
        // Complete this function
        ArrayList<long[]> subsets = new ArrayList<>();
        int k;
        long sum = 0;
        if(a.length > 1){
            BST bst = new BST(sum);
            permute(a,0,subsets);
            k = subsets.size();
            for(int j = 0;j < k;j++){
                //System.out.println("Valar Morghulis");
                bst = new BST(sum);
                long b[] = subsets.get(j);
                sum = 0;
                for(int l = 0;l < b.length;l++)
                    bst.insert(b[l]);
                sum = bst.inorder(sum);
                //System.out.println("Valar Morghulis");
            }
            //bst.inorder();
            //bst.finalize();
            bst.finalizeBst(bst);
            System.out.println(asFraction(sum, k));
        }
        else{
            sum += a[0];
            System.out.println(sum);
        }
    }

    static long gcm(long a, long b) {
    return b == 0 ? a : gcm(b, a % b); // Not bad for one line of code :)
    }

    static String asFraction(long a, long b) {
    long gcm = gcm(a, b);
    return (a / gcm) + "/" + (b / gcm);
    }

    static void permute(long[] a, int k,ArrayList<long[]> sets) {
        if (k == a.length) {   
            long[] b = new long[a.length];
            for (int i = 0; i < a.length; i++) {
                b[i] = a[i];
            }
            sets.add(b);
        }
        else{
            for (int i = k; i < a.length; i++) {
                long temp = a[k];
                a[k] = a[i];
                a[i] = temp;
                permute(a, k + 1,sets);
                temp = a[k];
                a[k] = a[i];
                a[i] = temp;
            }
        }
    }

    public static void main(String[] args) throws Throwable {
        Scanner in = new Scanner(System.in);
        Solution s = new Solution();
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            long[] a = new long[n];
            for(int a_i = 0; a_i < n; a_i++){
                a[a_i] = in.nextLong();
            }
            expectedAmount(a,n);
        }
        in.close();
    }
}

class BstNode{
    BstNode left,right;
    long data;
    public BstNode(){
        left = null;
        right = null;
        data = 0;
    }
    public BstNode(long n){
    left = null;
    right = null;
    data = n;
    }
    public void setLeft(BstNode n){
        left = n;
    }
    public void setRight(BstNode n){
        right = n;
    }
    public BstNode getLeft(){
        return left;
    }
    public BstNode getRight(){
        return right;
    }
    public void setData(long d){
        data = d;
    }
    public long getData(){
        return data;
    }
}
class BST{
    public BstNode root;
    long sum,sum3;
    public static long sum1 = 0;
    private static long sum2;
    public BST(){

    }
    public BST(long sum){
        root = null;
        this.sum = sum;
    }
    public boolean isEmpty(){
        return root == null;
    }
    public void insert(long data){
        root = insert(root,data);
    }
    public  BstNode insert(BstNode node, long data){
        //System.out.println("Valar Morghulis");
        if(node == null)
            node = new BstNode(data);
        else{
            if (data <= node.getData())
                node.left = insert(node.left, data);
            else
                node.right = insert(node.right, data);
        }
        return node;
    }

    public long inorder(long sum){
        sum = inorder(root,sum);
        //System.out.println(" Valar Morghulis ");
        return sum1;
    }
    private long inorder(BstNode r,long sum){
        if (r != null){
            inorder(r.getLeft(),sum);
            if(r.getLeft() == null && r.getRight() == null){
                //System.out.println(sum1 + " Valar Morghulis ");
                sum += r.getData();
                //System.out.println(sum);
                sum1 += sum;
                //System.out.println(sum1 + " Valar Dohaeris ");
            }
            //System.out.print(r.getData() +" ");
            inorder(r.getRight(),sum);
        }
        return sum;
    }
    public void finalizeBst(BST bst){
        try{
            sum1 = 0;
        bst.finalize();
    }
    catch(Throwable a){}
    }
}
