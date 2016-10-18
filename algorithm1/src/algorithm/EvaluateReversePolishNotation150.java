package algorithm;

import java.util.Stack;

public class EvaluateReversePolishNotation150 {
	//要考虑负数
	//AC 15ms
    public int evalRPN(String[] tokens) {
         int len=tokens.length;
         Stack<Integer> s=new Stack<Integer>();
         int first,second;
         for(int i=0;i<len;i++){
        	 String temp=tokens[i];
        	 if(isSign(temp)){
        	  	second=s.pop();
        	  	first=s.pop();
        	  	s.push(cal(first,second,temp));
        	 }else{
        		 s.push(toNum(temp));
        	 }
         }
         return s.peek();
    }
    
    public boolean isSign(String s){
    	return s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/");
    }
    
    public int toNum(String s){
    	int startIndex=0,r=0,sign=0;
         if(!Character.isDigit(s.charAt(0))) {
        	 startIndex=1;
        	 if(s.charAt(0)=='-') sign=1;  //判断正负号
        	 else sign=0;
         }
    	 for(int i=startIndex;i<s.length();i++){
    		 r=r*10+(s.charAt(i)-'0');
    	 }
         if(sign==0)
    	     return r;
         else
             return -r;
    }
    
    public int cal(int first,int second,String sign){
    	int result=0;
    	switch(sign){
    	case "+":result=first+second;break;
    	case "-":result=first-second;break;
    	case "*":result=first*second;break;
    	case "/":result=first/second;break;
    	default:break;
    	}
    	 return result;
    }
    
    public static void main(String [] args){
    	EvaluateReversePolishNotation150 e=new EvaluateReversePolishNotation150();
    	String[] tokens={"+2", "-1", "+", "-3", "*"};
    	int r=e.evalRPN(tokens);
        System.out.println("result="+r);
    }
}
