package algorithm;

public class LargestNumber179 {
	
	//AC 170ms  注意{0,0}
   public String largestNumber(int[] nums) {
         //冒泡排序
	    int len=nums.length;
	    for(int i=0;i<len-1;i++){
	    	for(int j=len-1;j>i;j--){
	    		if(compare(nums[j],nums[j-1])==-1)
	    			swap(nums,j,j-1);
	    	}
	    }
	    StringBuilder  s=new StringBuilder("");
	    for(int i=0;i<len;i++){
	    	s.append(nums[i]);
	    }
	    while(s.charAt(0)=='0'&&s.length()>1){
	    	s.deleteCharAt(0);
	    }
	    return s.toString();
    }
   
   public void swap(int[] nums,int i,int j){
	   int temp=nums[i];
	   nums[i]=nums[j];
	   nums[j]=temp;
   }
   public int compare(Integer num1,Integer num2){
       String str1=num1.toString(),str2=num2.toString();
       String s1=str1+str2,s2=str2+str1;  //比较两数哪个在前，比较两种连接方式构成的字符串 哪个大
       for(int i=0;i<s1.length();i++){
    	   if(s1.charAt(i)<s2.charAt(i)) return 1;
    	   else if(s1.charAt(i)>s2.charAt(i)) return -1;
       }
       return 0;
   }
   
   public static void main(String[] args){
	   LargestNumber179  l=new LargestNumber179();
	   int[] nums={824,938,1399,5607,6973,5703,9609,4398,8247};
	   String r=l.largestNumber(nums);
	   System.out.println("result="+r);
   }
}
