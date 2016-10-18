package jianzhioffer;
/**
 * 第n个丑数
 * @author sy
 *
 */
public class T34 {
	 public int nthUglyNumber(int n) {
	        int[] ugly=new int[n];
	        ugly[0]=1;
	        int index2=0,index3=0,index5=0,count=1;
	        while(count<n){
	        	ugly[count]=getNext(ugly,index2,index3,index5);
	        	if(ugly[count]==ugly[index2]*2) index2++;
	        	if(ugly[count]==ugly[index3]*3) index3++;
	        	if(ugly[count]==ugly[index5]*5) index5++;
	        	count++;
	        }
	        return ugly[n-1];
	    }
	 private int getNext(int[] ugly,int index2,int index3,int index5){
		 int result=Integer.MAX_VALUE;
		 if(ugly[index2]*2<result) result=ugly[index2]*2;
		 if(ugly[index3]*3<result) result=ugly[index3]*3;
		 if(ugly[index5]*5<result) result=ugly[index5]*5;
		 return result;
	 }
	 
	 public static void main(String[] args){
		 T34 t=new T34();
		 int result=t.nthUglyNumber(10);
		 System.out.println(result);
	 }
}
