package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MinimumHeightTrees310 {
/*	 HashMap<Integer,TreeNode> map1=new HashMap<Integer,TreeNode>();
	 static class  TreeNode{
		  int val;
		  List<Integer> neighbors;
		  public TreeNode(int v){
			  val=v;
			  neighbors=new ArrayList<Integer>();
		  }
	 }
	 public List<Integer> findMinHeightTrees(int n, int[][] edges) {
	     for(int i=0;i<n;i++){
	    	 map1.put(i, new TreeNode(i));
	     }
		 for(int i=0;i<edges.length;i++){
	           map1.get(edges[i][0]).neighbors.add(edges[i][1]);
	           map1.get(edges[i][1]).neighbors.add(edges[i][0]);
	         }
		 List<Integer> rlist=new ArrayList<Integer>();
		 int min=Integer.MAX_VALUE,t=0;
		 for(int i=0;i<n;i++){
			 t=getDeep(map1.get(i),-1);
			 if(t<min) {
				 rlist.clear();
				 rlist.add(i);
				 min=t;
			 }else if(t==min){
				 rlist.add(i);
			 }
		 }
		 return rlist;
	    }
	 
	 public int  getDeep(TreeNode root,int parentNode){
		int max=0;
		for(int i=0;i<root.neighbors.size();i++){
			if(root.neighbors.get(i)==parentNode) continue;
			 max=Math.max(max,getDeep(map1.get(root.neighbors.get(i)),root.val));
		}
		return max+1;
	 }*/
	
     public List<Integer> findMinHeightTrees(int n, int[][] edges) {
         int[] du=new int[n];
         List<Integer> num=new ArrayList<Integer>();
         List<List<Integer>> neib=new ArrayList<List<Integer>>();
         for(int i=0;i<n;i++){
        	 List<Integer> list=new ArrayList<Integer>();
        	 neib.add(list);
         }
         int xlen=edges.length;
         if(xlen==0&&n==1) {
        	 num.add(0);
        	 return num;
         }
         for(int i=0;i<n;i++) num.add((Integer)i);
         int size=n;
         for(int i=0;i<xlen;i++){
        		du[edges[i][0]]++;
        		du[edges[i][1]]++;
        		neib.get(edges[i][0]).add(edges[i][1]);
        		neib.get(edges[i][1]).add(edges[i][0]);
         }
         
         while(num.size()>2){
         //找到度为1的节点
         List<Integer> du1List=new ArrayList<Integer>();
         for(int i=0;i<n;i++){
        	 if(du[i]==1) {
        		 du[i]=0;
        		 num.remove((Integer)i);
        		 du1List.add(i);
        	 }
         }
         //将度为1的节点相邻节点度减1
         for(int i=0;i<du1List.size();i++){
        	 for(int j=0;j<neib.get(du1List.get(i)).size();j++){
			 if(du[neib.get(du1List.get(i)).get(j)]!=0){
				 du[neib.get(du1List.get(i)).get(j)]--;
			  }
        	}
         }
         du1List.clear();
         }
         return  num;
    }
	 public static void main(String[] args){
		 MinimumHeightTrees310 m=new MinimumHeightTrees310();
		 int[][] edges={{0, 1}, {1, 2}, {1, 3}};
		 List<Integer> r=m.findMinHeightTrees(4, edges);
		 for(int i=0;i<r.size();i++){
		   System.out.print(r.get(i)+",");
		 }
	 }
}
