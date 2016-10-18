package jianzhioffer;

import java.util.ArrayList;
import java.util.List;

import algorithm.TreeNode;
/**
 * 二叉树和为某一值的路径
 * @author sy
 *
 */
public class T25 {
    public static void findPath(TreeNode root,int target){
        List<List<Integer>> rlist=new ArrayList<List<Integer>>(); 
    	traceback(rlist,new ArrayList<Integer>(),root,target);
    	for(int i=0;i<rlist.size();i++){
    		for(int j=0;j<rlist.get(i).size();j++){
    			System.out.print(rlist.get(i).get(j)+" ");
    		}
    		System.out.println("");
    	}
    }
    
    public static void traceback(List<List<Integer>> rlist,List<Integer> list,TreeNode root,int cur){
        if(cur<0) return ;
    	boolean isLeaf=root.left==null&&root.right==null;
        if(isLeaf&&cur==root.val){
        	list.add(root.val);
        	rlist.add(new ArrayList<Integer>(list));
        	list.remove(list.size()-1);
        }else{
        	list.add(root.val);
        	if(root.left!=null)
        	traceback(rlist,list,root.left,cur-root.val);
        	if(root.right!=null)
        	traceback(rlist,list,root.right,cur-root.val);
        	list.remove(list.size()-1);
        }
    }
    
    public static void main(String[] args){
    	T25 t=new T25();
    	TreeNode root=new TreeNode(3);
    	TreeNode node1=new TreeNode(1);
    	TreeNode node2=new TreeNode(3);
    	TreeNode node3=new TreeNode(4);
    	TreeNode node4=new TreeNode(2);
    	TreeNode node5=new TreeNode(3);
    	TreeNode node6=new TreeNode(7);
    	TreeNode node7=new TreeNode(3);
    	root.left=node1;
    	root.right=node2;
    	node1.left=node3;
    	node1.right=node4;
    	node2.left=node5;
    	node3.right=node6;
    	node4.left=node7;
    	t.findPath(root, 9);
    }
}
