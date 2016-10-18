package algorithm;

import java.util.HashSet;

public class HappyNumber202 {
	
	//AC 5ms
   public boolean isHappy(int n) {
        int cur=n;
        boolean flag=true;
        HashSet<Integer> map=new HashSet<Integer>();
        while(cur!=1){
        	map.add(cur);
        	int sum=0;
             while(cur>0){
            	 int re=cur%10;
            	 sum+=re*re;
            	 cur=cur/10;
             }
             cur=sum;
             if(map.contains(cur)){
            	 flag=false;
            	 break;
             }
        }
        return flag;
    }
   
   //别人的解法  计算到只有一位时就可以判断了  如果只有1位是不是1，就一定有循化
//   public boolean isHappy(int n) {
//       n = square(n);
//       while (n>9){    
//           n = square(n);
//       }
//
//       if (n==1){return true;}
//       return false;
//
//   }
//
//   public int square(int n){
//       int sum=0;
//       while(n>0){
//           sum = sum+(n%10)*(n%10);
//           n = n/10;
//       }
//       return sum; 
//   }
   
   public static void main(String[] args){
	   HappyNumber202 h=new HappyNumber202();
	   boolean r=true;
	   int i;
	   for(i=2;i<20;i++){
	    r=h.isHappy(i);
	    System.out.println(i+"="+r);
	   }
   }
   
}
