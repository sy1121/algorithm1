package jianzhioffer;

import java.util.Arrays;
/**
 * 字符串的排列
 * @author sy
 *
 */
public class T28 {
   public void permutation(String str){
	   if(str==null||str.length()==0) return ;
	   char[] s=str.toCharArray();
	   print(s,0);
   }
   
   private void print(char[] c,int index){
	   if(index>=c.length){
		   printstr(c);
	   }else{
	     for(int i=index;i<c.length;i++){
		    swap(c,index,i);
		    print(c,index+1);
		    swap(c,i,index);
	     }
	   }
   }
   
   private void swap(char[] temp,int begin,int end){
	    char t=temp[begin];
	    temp[begin]=temp[end];
	    temp[end]=t;
   }
   
   private void printstr(char[] temp){
	   for(int i=0;i<temp.length;i++){
		   System.out.print(temp[i]+" ");
	   }
	   System.out.println();
   }
   
   public static void main(String[] args){
	   T28 t=new T28();
	   t.permutation("abc");
   }
}
