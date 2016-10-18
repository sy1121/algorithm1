package algorithm;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class BasicCalculatorII227 {
	// ac 74ms   
	/**
	 * 思路：两个栈分别记录数字和符号 ，依次扫描字符串的每一位，遇到数字处理后压入操作数栈，遇到符号，如果当前符号栈空，就直接压入栈中，如果不空，则要看
	 * 当前符号和当前栈顶的符号的优先级；若当前符号的优先级小于等于栈顶的符号的优先级，则弹出栈顶符号，再从数字栈中弹出两个数字，计算结果压入到数字栈中；
	 * 重复这个过程，指导符号栈为空或者符号战栈顶元素优先级比当前符号小，再将当前字符压入符号栈；
	 * 扫描完字符串后，再处理两个栈（和上面相同的方式）直到符号栈为空，就可计算出结果
	 * @param s
	 * @return
	 */
	   public int calculate(String s) {
	       int length=s.length();
	       Stack<Character> sstack=new Stack<Character>();
	       Stack<Integer> nstack=new Stack<Integer>();
	       for(int i=0;i<length;i++){
	    	   if(Character.isDigit(s.charAt(i))){
	    		  int sum=s.charAt(i)-'0';
	    		  while(i+1<length&&Character.isDigit(s.charAt(i+1))){
	    			  sum=sum*10+s.charAt(i+1)-'0';
	    			  i++;
	    		  }
	    		  nstack.push(sum);
	    	   }else {
	    		   if(s.charAt(i)==' ') continue;
	    		   else if(s.charAt(i)=='+'||s.charAt(i)=='-'){
	    			   if(sstack.isEmpty())
	    			   sstack.push(s.charAt(i));
	    			   else{
	    				   while(!sstack.isEmpty()){
	    				   char currentSign=sstack.pop();
	    				   int firstOpr=nstack.pop();
	    				   int secondOpr=nstack.pop();
	    				   nstack.push(suan(secondOpr,firstOpr,currentSign));
	    				   }
	    				   sstack.push(s.charAt(i));
	    			   }
	    		   }else{
	    			   if(sstack.isEmpty())
		    			   sstack.push(s.charAt(i));
	    			   else {
	    				   char preSign=sstack.peek();
	    				   if(preSign=='*'||preSign=='/'){
	    					   char currentSign=sstack.pop();
		    				   int firstOpr=nstack.pop();
		    				   int secondOpr=nstack.pop();
		    				   nstack.push(suan(secondOpr,firstOpr,currentSign));
	    				   } 
	    				   sstack.push(s.charAt(i));
	    			   }
	    		   }
	    	   }
	       }

	       while(!sstack.isEmpty()){
	    	   char currentSign=sstack.pop();
			   int firstOpr=nstack.pop();
			   int secondOpr=nstack.pop();
			   nstack.push(suan(secondOpr,firstOpr,currentSign));
	       }
	        return nstack.pop();
	      
	    }
	   
	   public int suan(int num1,int num2,char sign){
			 int result=0;
			 switch(sign){
			 case '+':
				 result= num1+num2;break;
			 case '-':
				 result= num1-num2;break;
			 case '*':
				 result=num1*num2;break;
			 case '/':
				 result=num1/num2;break;
			 }
			 return result;
		 }
  	public static void main(String[] args){
		 BasicCalculatorII227 b=new BasicCalculatorII227();
		 int r=b.calculate(" 3+5 / 2 ");
		 System.out.println("r="+r);
	 }
}
