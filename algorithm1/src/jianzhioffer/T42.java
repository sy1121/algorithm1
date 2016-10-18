package jianzhioffer;
/**
 * 字符串翻转 vs 左旋转字符串
 * @author sy
 *
 */
public class T42 {
    public String reverse(String str){
    	String[] ss=str.split(" ");
    	int left=0,right=ss.length-1;
    	while(left<right){
    	     String temp=ss[left];
    	     ss[left]=ss[right];
    	     ss[right]=temp;
    	     left++;
    	     right--;
    	}
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<ss.length;i++){
        	sb.append(ss[i]+" ");
        }
        return sb.toString().trim();
    }
    
    public static void main(String[] args){
    	T42 t=new T42();
        String s="I'm a Student.";
    	String r=t.reverse(s);
    	System.out.println(r);
    }
}
