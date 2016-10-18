package algorithm;

public class AdditiveNumber306 {
	//AC 2ms
	/*
	 * i,j�ֱ��ʾ��һ�������ڶ������ĵĽ�β����
	 * ��һ���͵ڶ�����ȷ�������������ȷ���ˣ����ֻҪһ�μ����ÿһ��������num��Ӧλ�õ��ַ��Ƚ��Ƿ�ƥ��
	 * ����������λ����ȷ�������������ѭ���������ܵ�ֵ
	 */
	 public boolean isAdditiveNumber(String num) {
	     int length=num.length();   
		 for(int i=0;i<length/2;i++){   //���α���i��j
			 int rlength=(length-i)/2+i;
			 for(int j=i+1;j<=rlength;j++){
				 if(isMatch(num,i,j)) return true;  //����(i,j)�Ƿ�����AdditiveNumber�Ķ���
			 }
		 }
		 
		 return false;
	    }
	 
	 //�����ַ���������ӣ���������ַ���
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
	 
	 //���i,j����Ƿ���ϿɼӶ���  ������ɨ��num�ַ��� �����ǰ������֮�Ͳ����ں���һ�����ͷ���false�����һֱ��ȣ��Ҽӵ����num�ַ��պ����꣬����true;
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
