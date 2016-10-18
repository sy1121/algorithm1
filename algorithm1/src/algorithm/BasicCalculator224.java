package algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BasicCalculator224 {
	//AC  65ms
	 public int calculate(String s) {
		   s=s+" ";
	       Stack<Character> sign=new Stack<Character>();
	       Stack<Integer> num=new Stack<Integer>();
	       Queue<Integer> validNum=new LinkedList<Integer>();
	       for(int i=0;i<s.length();i++){
	    	  if(Character.isDigit(s.charAt(i))){
	    		  validNum.add(s.charAt(i)-'0');
	    	  }
	    	  else{
	    		  if(!validNum.isEmpty()){
	    		  int vadNum=comNum(validNum);
	    		  num.push(vadNum);
	    		  validNum.clear();
	    		  }
	    		  if(s.charAt(i)==' ')
	    			  continue;
	    		  else if(s.charAt(i)==')'){
	    			  int tempSum=0;
	    			  char si=sign.pop();
	    			  while(si!='('){
	    			  int num1=num.pop();
	    			  tempSum=suan(tempSum,num1,si);
	    			  si=sign.pop();
	    			  }
	    			  int firstNum=num.pop();
	    			  num.push(suan(tempSum,firstNum,'+'));
	    		  }else
	    			  sign.push(s.charAt(i));	  
	    	  }
	    		 
	       }
	       
	       int sum=0;  //������,�Ӻ���ǰ��
	       while(!sign.isEmpty()){
	    	   char tempSign=sign.pop();  //����ǰ��ķ���λ
	    	   int tempNum1=num.pop();    //����
	    	   sum=suan(sum,tempNum1,tempSign); //����
	       }
	          int firstNum=num.pop();
	         return suan(sum,firstNum,'+');//���ϵ�һ����õ����Ľ����
	    }
	 
	 public int suan(int num1,int num2,char sign){
		 int result=0;
		 switch(sign){
		 case '+':
			 result= num1+num2;break;
		 case '-':
			 result= num1-num2;break;
		 }
		 return result;
	 }
	 
	 public int comNum(Queue<Integer> q){
		 int sum=0;
		 while(!q.isEmpty()){
			 int temp=q.poll();
			 sum=sum*10+temp;
		 }
		 return sum;
	 }
	 
	 
	 ///���˵ķ��� AC 26ms
	 
	/* public int calculate(String s) {
	   int len = s.length(), sign = 1, result = 0;
       Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < len; i++) {
		    if (Character.isDigit(s.charAt(i))) {
		        int sum = s.charAt(i) - '0';
		        while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
		            sum = sum * 10 + s.charAt(i + 1) - '0';
		            i++;
		        }
		        result += sum * sign;
		    } else if (s.charAt(i) == '+')
		        sign = 1;
		    else if (s.charAt(i) == '-')
		        sign = -1;
		    else if (s.charAt(i) == '(') {
		        stack.push(result);
		        stack.push(sign);
		        result = 0;
		        sign = 1;
		    } else if (s.charAt(i) == ')') {
		        result = result * stack.pop() + stack.pop();
		    }
		
		}
		
		return result;
			 }*/
	 
	 
			 public static void main(String[] args){
				 BasicCalculator224 b=new BasicCalculator224();
				 int r=b.calculate("1 + 1");
				 System.out.println("r="+r);
			 }
		}
