package algorithm;

public class AdditiveNumber306 {
	//AC 2ms
	/*
	 * i,j分别表示第一个数、第二个数的的结尾索引
	 * 第一个和第二个数确定，后面的数都确定了，因此只要一次计算出每一个数，于num对应位置的字符比较是否匹配
	 * 这两个数的位数不确定，因此用两重循环遍历可能的值
	 */
	 public boolean isAdditiveNumber(String num) {
	     int length=num.length();   
		 for(int i=0;i<length/2;i++){   //依次遍历i，j
			 int rlength=(length-i)/2+i;
			 for(int j=i+1;j<=rlength;j++){
				 if(isMatch(num,i,j)) return true;  //检查该(i,j)是否满足AdditiveNumber的定义
			 }
		 }
		 
		 return false;
	    }
	 
	 //两个字符串数字相加，结果返回字符串
	 public String stringAdd(String first,String second){
		   int i=first.length()-1,j=second.length()-1;
		   StringBuffer r=new StringBuffer("");
		   int sum,sign=0;
		   while(i>=0||j>=0){
			   sum=0; 
			   if(i>=0){
			    	sum+=first.charAt(i)-'0';
			    	i--;
			    }
			   if(j>=0){
				   sum+=second.charAt(j)-'0';
				   j--;
			   }
			   sum+=sign;
			    r.append(sum%10);
			    sign=sum/10;
		   }
		   if(sign!=0){
			   r.append(sign);
		   }
		   return r.reverse().toString();
	 }
	 
	 //检查i,j组合是否符合可加定义  依次少扫描num字符串 ，如果前两个数之和不等于后面一个数就返回false，如果一直相等，且加到最后num字符刚好用完，返回true;
	 public boolean isMatch(String num,int i,int j){
		  int headIndex=0;
		  String first,second,third;
		  first=num.substring(0,i+1);
		  second=num.substring(i+1,j+1);
		  String temp=stringAdd(first,second);
		  headIndex=j+1;
		  while(headIndex+temp.length()<=num.length()){
			  third=num.substring(headIndex,headIndex+temp.length());
			   if(third.equals(temp)){ 
				   if(headIndex+temp.length()==num.length()) return true;
				   first=second;
				   second=third;
				   headIndex=headIndex+temp.length();
				   temp=stringAdd(first,second);
				   continue;
			   }
			   else  
				   return false;
		  }
		  return false;
	 }
	 
	 public static void main(String[] args){
		 AdditiveNumber306 ad=new AdditiveNumber306();
		 boolean r=ad.isAdditiveNumber("199100199");
		 System.out.println("rsult="+r);
	 }
}
