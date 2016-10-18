package algorithm;

import java.util.HashMap;

public class ContainsDuplicateIII220 {
	
	//这种算法不行  数组pos的长度可能超过int的表示范围 
	//基本思想把 nums中的元素按照类似基数排序的方式存入pos数组中 ，将相应位置值true, 每次存入下一个数时要查询[t-pos[i],t+pos[i]]范围内有没有为true的
   /*public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
         int size=nums.length ;
         if(size<2)  return false;
         int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE,index=0;
         while(index<size){
        	 if(nums[index]>max) max=nums[index];
        	 if(nums[index]<min) min=nums[index];
        	 index++;
         }
         boolean[] pos=new boolean[max-min+1];
         index=0;
         int temp,leftindex,rightindex;
         while(index<k){
        	  temp=nums[index++]-min;
        	  leftindex=temp-t>=0?temp-t:0;
        	  rightindex=temp+t+1<pos.length?temp+t+1:pos.length ;
        	 for(int i=leftindex;i<rightindex;i++){
        		 if(pos[i]) return true;
        	 }
        	 pos[temp]=true;
         }
         for(int i=k;i<size;i++){
        	 //现在集合里有k个元素 ，先验证当前元素
        	 temp=nums[i]-min;
        	 leftindex=temp-t>=0?temp-t:0;
       	     rightindex=temp+t+1<pos.length?temp+t+1:pos.length ;
       	    for(int j=leftindex;j<rightindex;j++){
       		 if(pos[j]) return true;
       	    }
       	    //把当前元素加到集合中
       	    pos[nums[i]-min]=true;
       	    //按顺序去掉之间加入的元素
       	    pos[nums[i-k]-min]=false;
         }
         return false;
    }*/
     //类似活动窗口的形式，窗口大小为k,每次检查完一个元素就将窗口向右滑动一格   检查的方法就是先对窗口中的元素排序     
	//这种方法超时
/*	   public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		   int size=nums.length ;
		   if(size<2)  return false;
		   List<Integer> win=new LinkedList<Integer>();
		   win.add(nums[0]);
		   int index=1;
		   while(index<k){
			   //检查当前元素应该插入窗口中的哪一位
			   int add=findIndex(win,nums[index]);
			   //检查前后元素 是否在t范围内
			   if((add<win.size()&&win.get(add)-nums[index]<=t)||(add>0&&nums[index]-win.get(add-1)<=t)) return true; 
			    win.add(add, nums[index]);
			    index++;
		   }
		   for(int i=k;i<size;i++){
			   int add=findIndex(win,nums[i]);
			   if((add<win.size()&&win.get(add)-nums[index]<=t)||(add>0&&nums[index]-win.get(add-1)<=t)) return true;  
			   win.add(add, nums[index]);
			   win.remove((Integer)nums[i-k]);
		   }
		   return false;
	   }
	   
	   public int findIndex(List<Integer> win,int value){
		  
		   for(int i=0;i<win.size();i++){
			   if(value<win.get(i)) return  i;
		   }
		   return win.size();
	   }*/
	
	//网上看到的方法 根据t的大小分两种情况计算 
	// 当t较大的时候用普通的方法,就是两重循环的方法 ,t较小的时候 就用HashSet
	// AC 12ms 
	 public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		 int size=nums.length ;
		   if(size<2)  return false;
		 if(t<10){
			 HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
			 for(int i=0;i<size;i++){
				 int cur=nums[i];
				 for(int j=cur-t;j<cur+t+1;j++){
					 if(map.containsKey(j)&&(i-map.get(j)<=k&&i-map.get(j)>=-k)) return true;
				 }
				 map.put(cur, i);
			 }
			 return false;
		 }else{
			 for(int i=0;i<size-k;i++){
				 for(int j=i+1;j<=i+k;j++){
					 if(nums[j]-nums[i]<=t&&nums[j]-nums[i]>=-t) return true;
				 }
			 }
			 return false;
		 }
	 }
   public static void main(String[]  args){
	   ContainsDuplicateIII220  c=new ContainsDuplicateIII220();
	   int[] nums={1,2};
	   boolean r=c.containsNearbyAlmostDuplicate(nums, 0, 1);
	   System.out.println("r="+r);
   }
   
   
}
