package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class CourseSchedule207 {
	//���ַ�����ʱ��
/*	 public boolean canFinish(int numCourses, int[][] prerequisites) {
	        int size=prerequisites.length;
	        if(size==0) return false;
	        HashMap<Integer,List<Integer>> map=new HashMap<Integer,List<Integer>>();
	        //��ʼ��map
	        for(int i=0;i<size;i++){
	        	int[] temp=prerequisites[i];
	            List<Integer> tlist=map.get(temp[0]);
	            if(tlist==null||tlist.size()==0){
	                List<Integer> newList=new ArrayList<Integer>();
	                newList.add(temp[1]);
	                map.put(temp[0],newList);
	            }else{
	            	tlist.add(temp[1]);
	            	map.put(temp[0], tlist);
	            }
	        }
	        //����0��n-1�ҵ�û�����޿γ̵Ŀγ̣��������޿γ��б���
	        List<Integer>  courses=new ArrayList<Integer>();
	        for(int i=0;i<numCourses;i++){
	          	if(!map.containsKey(i)){
	          		courses.add(i);
	          	}
	        }
	        //����ÿ��ÿ���γ̵����޿γ��б������Щ�γ̶������޿γ���ѵ�ǰ�γ̼��뵽���޿γ��б���
	        int count=1; //ÿ�ֱ���map��������޿γ���  �˴���ʼ��Ϊ1��Ϊ������ѭ��
	        while(count!=0){
	        	count=0;
	        	List<Integer> list=new ArrayList<Integer>();
	        Iterator it=map.entrySet().iterator();
	        while(it.hasNext()){
	        boolean flag=true;
	           Map.Entry entry=(Map.Entry<Integer, List<Integer>>)it.next();
	           Integer key=(Integer)entry.getKey();
	           List<Integer> value=(List<Integer>) entry.getValue();
	           for(int i=0;i<value.size();i++){
	        	   if(!courses.contains(value.get(i))){
	        		    flag=false; break;
	        	   }
	           }
	           if(flag) {
    			   courses.add(key);
    			   list.add(key);
    			   count++;
    		   }
	         }
	       for(Integer i:list)
	         map.remove(i);
	        }
	        if(courses.size()==numCourses) return true;
	        else return false;
	    }*/
	 
	//AC  15ms  dfs+����ķ�ʽ      ������ȱ���
	  public boolean canFinish(int numCourses, int[][] prerequisites) {
		    if(prerequisites.length==0) return true;
		    int size=prerequisites.length;
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
		        boolean r= finish(list,i,map,new HashSet<Integer>());
		        if(!r) return false;
		    }
		    return  true;
	  }
	  
	  public boolean finish(List<ArrayList<Integer>> list,int i,HashMap<Integer,Boolean> map,HashSet<Integer> set){
		     if(!set.add(i)) return false; 
		     if(map.containsKey(i)) return map.get(i);
		     boolean result=true;
		     List<Integer> pres=list.get(i);
		     if(pres==null||pres.size()==0){
		    	  map.put(i,true);
				     return true; 
		     }
		     for(int j=0;j<pres.size();j++){
		    	 result=result&&finish(list,pres.get(j),map,set);
		    	 set.remove(pres.get(j));
		     }
		     map.put(i,result);
		     return result;  
	  }
	  
	 public static void main(String[] args){
		 CourseSchedule207 c=new CourseSchedule207();
		 int[][] pre={{0,1},{0,2},{1,2}};
		 boolean r=c.canFinish(3, pre);
		 System.out.println("r="+r);
	 }
}
