package jianzhioffer;

import java.util.Stack;

/**
 * 出栈顺序
 * @author sy
 *
 */
public class T22 {
     public boolean isValid(int[] in,int[] out){
    	 boolean result=true;
    	 int index=0;
    	 Stack<Integer> s=new Stack<Integer>();
    	 for(int i=0;i<out.length;i++){
    		 if(s.isEmpty()||s.peek()!=out[i]){
    			 if(index==out.length){
    				 result=false;
    				 break;
    			 }
    			 while(index<out.length){
    				 if(in[index]!=out[i]){
    					 s.push(in[index++]);
    				 }else{
    					 index++;
    					 break;
    				 }
    			 }
    		 }else if(s.peek()==out[i]) s.pop();
    	 }
    	 return result;
     }
     
     public static void main(String[] args){
    	 T22 r=new T22();
    	 int[] in={1,2,3,4,5};
    	 int[] out={4,3,5,1,2};
    	 boolean result=r.isValid(in, out);
    	 System.out.println(result);
     }
}
