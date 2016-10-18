package week7;

public class CountofRangeSum {
	//O(n2)时间复杂度 超时
/*public int countRangeSum(int[] nums, int lower, int upper) {
	   int count=0;
	   int[] subSum=new int[nums.length]; //存储第i个元素到当期元素的和(i为subSum的元素下标）
	   for(int i=0;i<nums.length;i++){
	       subSum[i]=0;
		   for(int j=0;j<=i;j++){
	    	   subSum[j]=subSum[j]+nums[i];
	    	   if(subSum[j]>=lower&&subSum[j]<=upper) count++;
	       }
	    }
        return count;
    }*/
	
	//自己想的方法没成功
	/*public int countRangeSum(int[] nums, int lower, int upper) {
        
		return countSum(nums,0,0,nums.length -1,lower,upper);
	}
	public int countSum(int[] nums,int count,int start,int end,int lower,int upper){
		
  	  	 if(start>end) return 0;  //结束条件
  	  	 
	     int middle = (start+end)/2;
	     int l=middle-1,r=middle+1;
	     int sum=nums[middle];
	     if(sum>=lower&&sum<=upper){
	    		count++;
	    	 }
	     while(l>=start||r<=end){
	     if(l>=start)   //向左移动一步
	     sum+=nums[l--];
	     if(sum>=lower&&sum<=upper){
	    		count++;
	    	 }
	     
	     if(r<=end)    //向右移动一步
	     sum+=nums[r++];
	     if(sum>=lower&&sum<=upper){
	    		count++;
	    	 }
	     }
	     int leftsum=countSum(nums,count,start,middle-1,lower,upper);
	     int rightsum=countSum(nums,count,middle+1,end,lower,upper);
	     return count+leftsum+rightsum;
	}*/
	
	/* public int countRangeSum(int[] nums, int lower, int upper) {
	      //构造前i项和数组 
		  long[] sums=new long[nums.length];
		  sums[0]=nums[0];
		  for(int i=1;i<nums.length;i++){
	    	  sums[i]=sums[i-1]+nums[i];
	       }
		  int r=mergeCount(sums,0,sums.length-1,lower,upper);
	       return r;
		}
	
	 public int mergeCount(long[] sums,int left,int right,int lower,int upper){
		 if(left>=right)
			 return 0;
			 int middle=(left+right)/2;
			 int leftCount=mergeCount(sums,left,middle,lower,upper);
			 int rightCount=mergeCount(sums,middle+1,right,lower,upper);
			 int middleCount=merge(sums,left,middle+1,right,lower,upper);
		 return leftCount+rightCount+middleCount;
	 }
	 
	 public int merge(long[] a,int left,int middle,int right,int lower,int upper){
		 //先计算 ,一次遍历左边的子数组中的每一个元素，在右边的子数组中找到符合  lower<=sum[j]-sum[i]<=upper;
		 //也就是lower+sum[i]<=sum[j]<=upper+sum[i],要在右边的子数组中找到这个范围，右边数组此是排好序的
		 //所以可以移动头尾指针找到这个范围
		 int count=0;//
		 int u=0,l=0;
		 for(int q=left;q<middle;q++){
			u=getUpperIndex(a,middle,right,lower+a[q]);
			l=getLowIndex(a,middle,right,upper+a[q]);
			if(u!=-1&&l!=-1){
				count=u-l;
			}
		 }
		  
		// 再排序
		  long[] temp=new long[right-left+1];
	   	   int i=left,j=middle,k=0;
	   	   while(i!=middle&&j!=right+1){
	   		   if(a[i]<a[j])
	   			   temp[k++]=a[i++];
	   		   else temp[k++]=a[j++];
	   	   }
	   	  while(i!=middle){
	   		  temp[k++]=a[i++];
	   	  }
	   	  while(j!=right+1){
	   		  temp[k++]=a[j++];
	   	  }
	   	  for(int h=0;h<temp.length;h++){
	   		  a[left++]=temp[h];
	   	  }  
	   	  
	   	  if(count>0)
	   	  return count;
	   	  else
	   		  return 0;
	 }
	 //二分查找<=key的第一个数的索引
	 public int getLowIndex(long[] sums,int low,int right,long key){
		   if(low>=right) return -1; 
		 int middle=(low+right)/2;
		  if(sums[middle]>=key&&sums[middle-1]<key){
			  return middle;
		  }else if(sums[middle]<key){
			  return getLowIndex(sums,middle,right,key);
		  }else
			  return getLowIndex(sums,low,middle,key);
		  
	 }
	 
	 public int getUpperIndex(long[] sums,int low,int right,long key){
		 if(low>=right) return -1; 
		 int middle=(low+right)/2;
		  if(sums[middle]<=key&&sums[middle+1]>key){
			  return middle;
		  }else if(sums[middle]>key){
			  return getLowIndex(sums,low,middle,key);
		  }else
			  return getLowIndex(sums,middle,right,key);
	 }*/
	
	
	private class TreeNode{
		long val=0;
		int count=1;
		int leftSize=0;
		int rightSize=0;
		TreeNode left=null;
		TreeNode right=null;
	    public TreeNode(long v){
	    	this.val=v;
	    	this.count=1;
	    	this.leftSize=0;
	    	this.rightSize=0;
	    }
	}
	 private TreeNode insert(TreeNode root,long val){
		 if(root==null){
			 return new TreeNode(val);
		 }else if(root.val==val){
			 root.count++;
		 }else if(val<root.val){
			 root.leftSize++;
			 root.left=insert(root.left,val);
		 }else if(val>root.val){
			 root.rightSize++;
			 root.right=insert(root.right,val);
		 }
		 return root;
	 }
	 
	 private int countSmaller(TreeNode root,long val){
		if(root==null){
			return 0;
		}else if(root.val==val){
			return root.leftSize;
		}else if(root.val>val){
			return countSmaller(root.left,val);
		}else{
			return root.leftSize+root.count+countSmaller(root.right,val);
		}
	 }
	 
	 private int countLarger(TreeNode root,long val){
		 if(root==null){
			 return 0;
		 }else if(root.val==val){
			 return root.rightSize;
		 }else if(root.val<val){
			 return countLarger(root.right,val);
		 }else{
			 return countLarger(root.left,val)+root.count+root.rightSize;
		 }
	 }
	 
   private int rangeSize(TreeNode root,long lower,long upper){
	   int total=root.count+root.leftSize+root.rightSize;
	   int smaller=countSmaller(root,lower);
	   int larger=countLarger(root,upper);
	   return total-smaller-larger;
   }
   
   public int countRangeSum(int[] nums,int lower,int upper){
	   if(nums.length==0) return 0;
	   long[] sums=new long[nums.length +1];
	   for(int i=0;i<nums.length;i++){
		   sums[i+1]=sums[i]+nums[i];
	   }
	   TreeNode root=new TreeNode(sums[0]);
	   int output=0;
	   for(int i=1;i<sums.length;i++){
		  output+=rangeSize(root,sums[i]-upper,sums[i]-lower);
		  insert(root,sums[i]);
	   }
	   return output;
   }
	 
   public static void main(String [] args){
	   CountofRangeSum c=new CountofRangeSum();
	   int[] nums={-2,5,-1};
	   int lower=-2,upper=2;
	   int r=c.countRangeSum(nums, lower, upper);
	   System.out.println("result="+r);
   }
}
