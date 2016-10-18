package jianzhioffer;

import java.util.Stack;
//最小值栈
public class T21 {
	   Stack<Integer> a;
	    Stack<Integer> min;
	    /** initialize your data structure here. */
	    public T21() {
	        a=new Stack();
	        min=new Stack();
	    }
	    
	    public void push(int x) {
	        a.push(x);
	        if(min.size()==0) min.push(x);
	        else{
	           int curMin=min.peek();
	           if(x<=curMin){
	              min.push(x);
	           }
	        }
	       
	    }
	    
	    public void pop() {
	     if(a.size()==0) return ;
	     if(min.peek().equals(a.pop())) min.pop();
	        
	    }
	    
	    public int top() {
	        return a.peek();
	    }
	    
	    public int getMin() {
	        return min.peek();
	    }
	}
