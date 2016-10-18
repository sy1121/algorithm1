package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII210 {
	//���ֽⷨ��ʱ��
/*	 public int[] findOrder(int numCourses, int[][] prerequisites) {
	        int[] result=new int[numCourses];
	        int size=prerequisites.length,index=0;
	        if(size==0)  return new int[0];
	        List<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
	        HashSet<Integer> hashset=new  HashSet<Integer>();
		    for(int i=0;i<numCourses;i++){
		    	list.add(new ArrayList<Integer>());
		    }
		    for(int i=0;i<size;i++){
	        	int[] temp=prerequisites[i];
	        	list.get(temp[0]).add(temp[1]);
	            hashset.add(temp[1]);
		    }
		    
		    List<Integer>  roots=new ArrayList<Integer>();
		    for(int i=0;i<numCourses;i++){
		    	if(!hashset.contains(i)) roots.add(i);
		    }
		    HashMap<Integer,List<Integer>> map=new HashMap<Integer,List<Integer>>();
		    HashSet<Integer> resultset=new HashSet<Integer>();
		    for(int i=0;i<roots.size();i++){
		    	List<Integer> tlist=find(roots.get(i),list,map,new HashSet<Integer>());
		    	if(tlist==null) return new int[0];
		    	for(int j=0;j<tlist.size();j++){
		    		if(resultset.add(tlist.get(j)))
		    		result[index++]=tlist.get(j);
		    	}
		    }
		    return result;
	    }
	 
	 public List<Integer> find(int i,List<ArrayList<Integer>> list,HashMap<Integer,List<Integer>> map,HashSet<Integer> set){
		   if(!set.add(i))  return null;
		    if(map.containsKey(i)) return map.get(i);
		    List<Integer> curlist=new ArrayList<Integer>();
		    List<Integer> tlist=list.get(i);
		    if(tlist==null||tlist.size()==0){
		    	curlist.add(i);
		    }else{
		    	 for(Integer elem:tlist){
		    		 List<Integer> t=find(elem,list,map,set);
		    		 if(t==null) return null;
		    		 set.remove(elem);
		    		 for(int j=0;j<t.size();j++){
		    			 if(!curlist.contains(t.get(j))) curlist.add(t.get(j));
		    		 }
		    	 }
		    	 curlist.add(i); 
		    }
			map.put(i, curlist);
	    	return curlist;
	 }*/
	//ѧϰ���˵Ľⷨ  �ӳ���Ϊ0�Ľڵ㣨Ҳ����û�����޿γ̵Ŀγ̣����ǣ�����ǰ����һ����Ҳ�뵽�ˣ����ǲ��ܺܺõı���Լ����뷨  
	/*public int[] findOrder(int numCourses, int[][] prerequisites) {
	    int[] ret = new int[numCourses];
	    int[][] matrix = new int[numCourses][numCourses]; // i -> j
	    int[] indegree = new int[numCourses];

	    for (int i=0; i<prerequisites.length; i++) {
	        int ready = prerequisites[i][0];
	        int pre = prerequisites[i][1];
	        if (matrix[pre][ready] == 0)
	            indegree[ready]++; //duplicate case
	        matrix[pre][ready] = 1;
	    }

	    int count = 0;
	    Queue<Integer> queue = new LinkedList();   //���� ��������һ������̫����
	    for (int i=0; i<indegree.length; i++) {
	        if (indegree[i] == 0) queue.offer(i);
	    }
	    while (!queue.isEmpty()) {
	        int course = queue.poll();
	        count++;
	        ret[count-1]= course;   ////THISLINE
	        for (int i=0; i<numCourses; i++) {
	            if (matrix[course][i] != 0){ 
	                if (--indegree[i] == 0)     //�������㷨�Ĺؼ�㣬�����Ӽ���ĳ��ȼ�һ ������ȥ��һ���ڽӽڵ�
	                    queue.offer(i);      //�����ȱ�Ϊ0���������޿γ��Ѿ������� �������
	            }
	        }
	    }
	    return count == numCourses ? ret : new int[0];  ////THISLINE
	}*/
	
	
	/*public int[] findOrder(int numCourses, int[][] prerequisites) {
	    int[] res=new int[numCourses];
	    int size=prerequisites.length;
	    if(size==0){
	       for(int i=0;i<numCourses;i++)
			  res[i]=i;
	       return res;
		}
	    List<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>(numCourses);
	    for(int i=0;i<numCourses;i++){
	    	list.add(new ArrayList<Integer>());
	    }
	    for(int i=0;i<size;i++){
        	int[] temp=prerequisites[i];
        	list.get(temp[0]).add(temp[1]);
	    }
	    HashMap<Integer,Boolean> map=new HashMap<Integer,Boolean>();
	    for(int i=0;i<numCourses;i++){
	        boolean r= finish(list,i,map,new HashSet<Integer>(),res);
	        if(!r) return new int[0];
	    }
	    return  res;
	}
	
	  public boolean finish(List<ArrayList<Integer>> list,int i,HashMap<Integer,Boolean> map,HashSet<Integer> set,int[] r){
		     if(!set.add(i)) return false; 
		     if(map.containsKey(i)) return map.get(i);
		     boolean result=true;
		     List<Integer> pres=list.get(i);
		     if(pres==null||pres.size()==0){
		    	  map.put(i,true);
				     return true; 
		     }
		     for(int j=0;j<pres.size();j++){
		    	 result=result&&finish(list,pres.get(j),map,set,r);
		    	 set.remove(pres.get(j));
		     }
		     map.put(i,result);
		     r[map.size()-1]=i;
		     return result;  
	  }*/
	//Ac 34ms
	   public int[] findOrder(int numCourses, int[][] prerequisites) {
		   int [] result=new int[numCourses];
		   int index=0;
		   int xlen=prerequisites.length;
		 //  if(xlen==0) return result;
		   int[] out=new int[numCourses];
		   List<List<Integer>> in=new ArrayList<List<Integer>>();
		   for(int i=0;i<numCourses;i++){
			   List<Integer> list=new ArrayList<Integer>();
			   in.add(list);
		   }
		   for(int i=0;i<xlen;i++){
			   out[prerequisites[i][0]]++;
			   in.get(prerequisites[i][1]).add(prerequisites[i][0]);
		   }
		   while(true){
		   List<Integer> zero=new ArrayList<Integer>();
		   for(int i=0;i<numCourses;i++){
			   if(out[i]==0){
				   result[index++]=i;
				   out[i]=-1;
				   zero.add((Integer)i);
			   }
		   }
		   for(int i=0;i<zero.size();i++){
			   for(int j=0;j<in.get(zero.get(i)).size();j++){
				   out[in.get(zero.get(i)).get(j)]--;   
			   }
		   }
		   if(zero.isEmpty()) break;
		   else
		     zero.clear();
		   }
		   
		    if(index==numCourses) return result;
		    else return new int[0];
	   }
	 public static void main(String[] args){
		 CourseScheduleII210 c=new CourseScheduleII210();
		 int[][] pre={{0,1},{1,0}};
		 int[] r=c.findOrder(2, pre);
		 for(int i=0;i<r.length;i++){
		 System.out.print(r[i]+" ");
		 }
	 }
}
