package algorithm;

import java.util.HashMap;

public class ContainsDuplicateIII220 {
	
	//�����㷨����  ����pos�ĳ��ȿ��ܳ���int�ı�ʾ��Χ 
	//����˼��� nums�е�Ԫ�ذ������ƻ�������ķ�ʽ����pos������ ������Ӧλ��ֵtrue, ÿ�δ�����һ����ʱҪ��ѯ[t-pos[i],t+pos[i]]��Χ����û��Ϊtrue��
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
        	 //���ڼ�������k��Ԫ�� ������֤��ǰԪ��
        	 temp=nums[i]-min;
        	 leftindex=temp-t>=0?temp-t:0;
       	     rightindex=temp+t+1<pos.length?temp+t+1:pos.length ;
       	    for(int j=leftindex;j<rightindex;j++){
       		 if(pos[j]) return true;
       	    }
       	    //�ѵ�ǰԪ�ؼӵ�������
       	    pos[nums[i]-min]=true;
       	    //��˳��ȥ��֮������Ԫ��
       	    pos[nums[i-k]-min]=false;
         }
         return false;
    }*/
     //���ƻ���ڵ���ʽ�����ڴ�СΪk,ÿ�μ����һ��Ԫ�ؾͽ��������һ���һ��   ���ķ��������ȶԴ����е�Ԫ������     
	//���ַ�����ʱ
/*	   public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		   int size=nums.length ;
		   if(size<2)  return false;
		   List<Integer> win=new LinkedList<Integer>();
		   win.add(nums[0]);
		   int index=1;
		   while(index<k){
			   //��鵱ǰԪ��Ӧ�ò��봰���е���һλ
			   int add=findIndex(win,nums[index]);
			   //���ǰ��Ԫ�� �Ƿ���t��Χ��
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
	
	//���Ͽ����ķ��� ����t�Ĵ�С������������� 
	// ��t�ϴ��ʱ������ͨ�ķ���,��������ѭ���ķ��� ,t��С��ʱ�� ����HashSet
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
