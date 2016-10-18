package jianzhioffer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 把数组排成最小的数
 * @author sy
 *
 */
public class T33 {
	 public String largestNumber(int[] nums) {
		 
		 Integer[] n=new Integer[nums.length];
		 for(int i=0;i<nums.length;i++){
			n[i]=Integer.valueOf(nums[i]);
		 }
	     Arrays.sort(n, new myCompare()); 
	     StringBuilder sb=new StringBuilder();
	     for(int i=0;i<n.length;i++) sb.append(n[i].toString());
	     return deleteHead(sb.toString());
	 }
	 
	 class myCompare implements Comparator{

		@Override
		public int compare(Object o1, Object o2) {
			// TODO Auto-generated method stub
			String z=o1.toString()+o2.toString();
			String f=o2.toString()+o1.toString();
			return -z.compareTo(f);
		}
		 
	 }
	 
	 private String deleteHead(String s){
		 int i=0; 
		 for(;i<s.length()-1;i++){
			 if(s.charAt(i)!='0') break;
		 }
		 return s.substring(i);
	 }
	 
	 public static void main(String[] args){
		 T33 t=new T33();
		 int[] nums={3,32,321};
		 String r=t.largestNumber(nums);
		 System.out.println(r);
	 }
}
