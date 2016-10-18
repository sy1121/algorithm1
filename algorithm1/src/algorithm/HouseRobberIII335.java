package algorithm;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class HouseRobberIII335 {
	
	//AC 6ms  树的后根遍历
	// 通过后根遍历的方式 从最下层开始依次更新 各个节点能取得的值，基本思想与前面的两题一致
	 public int rob(TreeNode root) {
		 HashMap<TreeNode,Integer> map=new HashMap<TreeNode,Integer>(); //存储一个节点的子节点可以取得的值得和
		 map.put(null, 0);
		 return robHelp(root,map);
	        	 
	    }
	 
	 public int robHelp(TreeNode root,HashMap<TreeNode,Integer> map){
		   if(root==null) return 0;
		   int leftCount=robHelp(root.left,map);
		   int rightCount=robHelp(root.right,map);
		   map.put(root, leftCount+rightCount);
		   int precount=map.get(root.left)+map.get(root.right); //下下层节点内取得的值的和
		   if(precount+root.val>leftCount+rightCount){ //比较当期节点和下下层节点的和与下层节点的大小来确定当前节点的值
			   root.val=precount+root.val;
		   }else{
			   root.val=leftCount+rightCount;
		   }
		   return root.val;
	 }
	 
	 //网上的方法 可以不使用HashMap 
	/* public int rob(TreeNode root) {
		    int[] maxVal = dpRob(root);
		    return Math.max(maxVal[0], maxVal[1]);
		}

		public int[] dpRob(TreeNode root) {  //返回有两个元素的数组 0 表示抢当前节点 1表示不抢当前节点 
		    if (root == null) {
		        return new int[]{0, 0};
		    } else {
		        int[] maxVal = new int[2];//maxVal[0] store the max value without robing current node, maxVal[1] store the max value with robing current node,
		        int[] leftMax = dpRob(root.left);
		        int[] rightMax = dpRob(root.right);
		        //不抢当前节点 则为任意抢还是不抢当前节点的最大值
		        maxVal[0] = Math.max(leftMax[0], leftMax[1]) + Math.max(rightMax[0], rightMax[1]);
		        //抢当前节点 则为当前节点的值加上不抢子节点的和
		        maxVal[1] = leftMax[0] + rightMax[0] + root.val;
		        return maxVal;
		    }
		}*/
}
