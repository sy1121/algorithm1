package algorithm;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class HouseRobberIII335 {
	
	//AC 6ms  ���ĺ������
	// ͨ����������ķ�ʽ �����²㿪ʼ���θ��� �����ڵ���ȡ�õ�ֵ������˼����ǰ�������һ��
	 public int rob(TreeNode root) {
		 HashMap<TreeNode,Integer> map=new HashMap<TreeNode,Integer>(); //�洢һ���ڵ���ӽڵ����ȡ�õ�ֵ�ú�
		 map.put(null, 0);
		 return robHelp(root,map);
	        	 
	    }
	 
	 public int robHelp(TreeNode root,HashMap<TreeNode,Integer> map){
		   if(root==null) return 0;
		   int leftCount=robHelp(root.left,map);
		   int rightCount=robHelp(root.right,map);
		   map.put(root, leftCount+rightCount);
		   int precount=map.get(root.left)+map.get(root.right); //���²�ڵ���ȡ�õ�ֵ�ĺ�
		   if(precount+root.val>leftCount+rightCount){ //�Ƚϵ��ڽڵ�����²�ڵ�ĺ����²�ڵ�Ĵ�С��ȷ����ǰ�ڵ��ֵ
			   root.val=precount+root.val;
		   }else{
			   root.val=leftCount+rightCount;
		   }
		   return root.val;
	 }
	 
	 //���ϵķ��� ���Բ�ʹ��HashMap 
	/* public int rob(TreeNode root) {
		    int[] maxVal = dpRob(root);
		    return Math.max(maxVal[0], maxVal[1]);
		}

		public int[] dpRob(TreeNode root) {  //����������Ԫ�ص����� 0 ��ʾ����ǰ�ڵ� 1��ʾ������ǰ�ڵ� 
		    if (root == null) {
		        return new int[]{0, 0};
		    } else {
		        int[] maxVal = new int[2];//maxVal[0] store the max value without robing current node, maxVal[1] store the max value with robing current node,
		        int[] leftMax = dpRob(root.left);
		        int[] rightMax = dpRob(root.right);
		        //������ǰ�ڵ� ��Ϊ���������ǲ�����ǰ�ڵ�����ֵ
		        maxVal[0] = Math.max(leftMax[0], leftMax[1]) + Math.max(rightMax[0], rightMax[1]);
		        //����ǰ�ڵ� ��Ϊ��ǰ�ڵ��ֵ���ϲ����ӽڵ�ĺ�
		        maxVal[1] = leftMax[0] + rightMax[0] + root.val;
		        return maxVal;
		    }
		}*/
}
