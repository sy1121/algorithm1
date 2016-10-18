package algorithm;

public class BitwiseANDofNumbersRange201 {
	
	//AC  7ms  计算m,n之间的数的与的结果
   public int rangeBitwiseAnd(int m, int n) {
        int count=n-m;  //计算中间有多少个数-1，为后面计算用多少位来表示准备
        int r=0;   //计算移动的位数
        if(count==0)  return m; //两个数相同直接返回
        while(count>0){    //开始移位，共移动表示这么多数需要的位数
        	m=m>>1;        
        	n=n>>1;
        	count=count>>1;
        	r++;
        }
        int temp=m&n;   //此时，把m，n相与
        while(r>0){     //再移回这么多位
        	temp=temp<<1;
        	r--;
        }
        return temp;
    }
   
   public static void main(String[] args){
	   BitwiseANDofNumbersRange201 b=new BitwiseANDofNumbersRange201();
	   int r=b.rangeBitwiseAnd(3, 4);
	   System.out.println("r="+r);
   }
}
