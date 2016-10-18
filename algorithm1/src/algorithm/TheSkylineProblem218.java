package algorithm;

import java.util.ArrayList;
import java.util.List;

public class TheSkylineProblem218 {
	//AC   304  
	/*  public List<int[]> getSkyline(int[][] buildings) {
	         List<int[]> rlist=new ArrayList<int[]>();
	         int size=buildings.length;
	         if(size==0)  return rlist;
	         //x，y数组分别表示各建筑的开始和结束的坐标  x_h、y_h为对应的高度
	         int[] x=new int[size];
	         int[] y=new int[size];
	         int[] x_h=new int[size];
	         int[] y_h=new int[size];
	         for(int i=0;i<size;i++){
	        	  x[i]=buildings[i][0];
	        	  x_h[i]=buildings[i][2];
	        	  y[i]=buildings[i][1];
	        	  y_h[i]=buildings[i][2];
	         }
	         //合并开始和结束点的坐标多相同的建筑
	         int index=0;
	         for(int i=0;i<size;i++){
	        	 int partmax=x_h[i];
	        	 while((i+1)<size&&x[i]==x[i+1]&&y[i]==y[i+1]){
	        		  if(partmax<x_h[i+1])  partmax=x_h[i+1]; 
	        		 i++;
	        	 }
	        	 x[index]=x[i];
	        	 x_h[index]=partmax;
	        	 y[index]=y[i];
	        	 y_h[index++]=partmax;
	         }
	         size=index;   //合并后的建筑数
	        //对y和y_h[i]排序   
	         insertSort(y,y_h,size);  //对结束点的坐标进行插入排序 ，y_h也要对应起来
	         int index_x=1,index_y=0;
	         List<Integer> hlist=new ArrayList<Integer>();  //记录当前可见的建筑物的高度 按大小排序
	         rlist.add(new int[]{x[0],x_h[0]});   //初始化 把第一组数据添加进去
	         hlist.add(x_h[0]);   
	         while(index_x<size||index_y<size){    //每次处理当前x,y数组中最小的值
	        	  if(index_x<size&&x[index_x]<=y[index_y]){   //如果x数组中的值更小
	        		  if((hlist.size()==0||x_h[index_x]>hlist.get(0)))  //如果这是一个更高的建筑，则是一个结果
	        			  rlist.add(new int[]{x[index_x],x_h[index_x]});
	        			  addToList(hlist,x_h[index_x]); //把当前高度插入到链表中
	        			  index_x++;
	        	  }else{     //如果y数组中的值更大或是x数组已经处理完
	        		  if(hlist.size()==1)   
	        			  rlist.add(new int[]{y[index_y],0}); 
	        		  else if(hlist.size()>1&&y_h[index_y]==hlist.get(0))
	        			  rlist.add(new int[]{y[index_y],hlist.get(1)});
	        		  removeFromList(hlist,y_h[index_y]);
	        		  index_y++;
	        	  }
	         }
	         //处理结果  去掉无效部分 即高度相同 开始坐标不同
	         List<int[]> result=new ArrayList<int[]>();
	         int i=0;
	         while(i<rlist.size()){
	        	 int temp=rlist.get(i)[1];
	        	 while((i+1)<rlist.size()&&(rlist.get(i)[0]==rlist.get(i+1)[0])){
	        		 if(rlist.get(i+1)[1]==0)
	        			 temp=0;
	        		 else if(temp<rlist.get(i+1)[1])
	        			 temp=rlist.get(i+1)[1];
	        		 i++;
	        	 }
	        	 if(result.isEmpty()||temp!=result.get(result.size()-1)[1])
	             result.add(new int[]{rlist.get(i)[0],temp});
	        	 i++;
	         }
	         return result;
	      //   return rlist;
	    }
	  
	  public void addToList(List<Integer> list,int h){
		  for(int i=0;i<list.size();i++){
		    	 if(h>list.get(i)){
		    		 list.add(i, h);return;
		    	 }
		     }
		  list.add(list.size(), h);
	  }
	  
	  public void removeFromList(List<Integer> list,int h){
		  if(null==list||list.size()==0) return ;
		  for(int i=0;i<list.size();i++){
			  if(list.get(i)==h){
				  list.remove(i);break;
			  }
		  }
	  }
	  
	  public void insertSort(int[] y,int[] y_h,int size){
		  for(int i=1;i<size;i++){
			  int cur=y[i];
			  int cur_h=y_h[i];
			  for(int j=i-1;j>=0;j--){
				 if(cur<y[j]){
					 y[j+1]=y[j];
					 y_h[j+1]=y_h[j];
					 if(j==0){
						y[0]=cur;
						y_h[0]=cur_h;
					 }
				 }else{
					 y[j+1]=cur;
					 y_h[j+1]=cur_h;
					 break;
				 }
			  }
		  }
	  }*/
	  
	//别人的解法  分治解法    这种方法更快    
	public List<int[]> getSkyline(int[][] buildings) {
	    if (buildings.length==0) return new ArrayList<int[]>();
	    return divide(buildings,0,buildings.length-1);
	}

	public List<int[]> divide(int[][] buildings,int i,int j)
	{
	    if(i==j) 
	    {
	        List<int[]> tmp=new ArrayList<>();
	        tmp.add(new int[]{buildings[i][0],buildings[i][2]});
	        tmp.add(new int[]{buildings[i][1],0});
	        return tmp;
	    }
	    List<int[]> left=divide(buildings,i,i+(j-i)/2);
	    List<int[]> right=divide(buildings,i+(j-i)/2+1,j);
	    return merge(left,right);
	}
	public List<int[]> merge(List<int[]> left,List<int[]> right)
	{
	    List<int[]> ans=new ArrayList<>();
	    int l1=0;
	    int l2=0;
	    int curh1=0;
	    int curh2=0;
	    int curlocation=0;
	    int skyline=0;
	    while(l1<left.size()&&l2<right.size())
	    {
	        int[] cur1=left.get(l1);
	        int[] cur2=right.get(l2);

	        if(cur1[0]<cur2[0])
	        {
	            curh1=cur1[1];
	            curlocation=cur1[0];
	            l1++;
	        }
	        else if(cur1[0]>cur2[0])
	        {
	            curh2=cur2[1];
	            curlocation=cur2[0];
	            l2++;
	        }
	        else
	        {
	            curh1=cur1[1];
	            curh2=cur2[1];
	            curlocation=cur1[0];
	            l1++;
	            l2++;
	        }
	        if(skyline!=Math.max(curh1, curh2))
	        {
	            skyline=Math.max(curh1, curh2);
	            ans.add(new int[]{curlocation,skyline});
	        }

	    }
	    for(int i=l1;i<left.size();i++) ans.add(left.get(i));
	    for(int i=l2;i<right.size();i++) ans.add(right.get(i));
	    return ans;
	}
	  public static void main(String[] args){
		  TheSkylineProblem218 s=new TheSkylineProblem218();
		  List<int[]> list=new ArrayList<int[]>();
		  list=s.getSkyline(new int[][]{{0,5,7},{5,10,7},{5,10,12},{10,15,7},{15,20,7},{15,20,12},{20,25,7}});
		  System.out.print("[");
		  for(int i=0;i<list.size();i++){
			  System.out.print("["+list.get(i)[0]+" "+list.get(i)[1]+"]");
		  }
		  System.out.print("]");
	  }
}
