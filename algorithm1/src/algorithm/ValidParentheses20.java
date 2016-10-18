package algorithm;

import java.util.Stack;

public class ValidParentheses20 {
	 public boolean isValid(String s) {
	        Stack<Character> sign=new Stack<Character>();
	        for(int i=0;i<s.length();i++){
	        	if(s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{'){
	        	    sign.push(s.charAt(i));
	        	}else {
	        		if(sign.isEmpty()||!match(sign.peek(),s.charAt(i))){
	        			return false;
	        		}else sign.pop();
	        	}
	        }
	        if(sign.isEmpty())
	        return true;
	        else return false;
	    }
	 
	 private boolean match(char source,char target){
		 if(source=='(') return target==')';
		 else if(source=='[') return target==']';
		 else if(source=='{') return target=='}';
		 else return false;
	 }
	 
	 public static void main(String[] args){
		 ValidParentheses20 v=new ValidParentheses20();
		 boolean r=v.isValid("()[]{}");
		 System.out.println("r="+r);
	 }
	 
	 
}
