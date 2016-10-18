package algorithm;

public class CountPrimes204 {
	
	//这是最笨的方法 时间复杂度为O(n)
/*	  public int countPrimes(int n) {
		  if(n<1) return 0; 
	      int heCount=0; 
		  for(int i=2;i<=n;i++){
	    	   if(isHe(i)) heCount++;
	       }
	    	   
		  return n-1-heCount;
	    }
	  
	  public boolean isHe(int num){
		  if(num==2||num==3||num==5) return false;
		  boolean flag=false;
		  for(int i=2;i*i<num;i++){
			  if(num%i==0) {
				  flag=true;
				  break;
			  }
		  }
		  return flag;
	  }*/
	  
	  //这是较好的方法
	  public int countPrimes(int n){
		  boolean[] isPrime=new boolean[n];  //标记每一个数是不是质数
		  for(int i=2;i<n;i++){
			  isPrime[i]=true;         //初始化为是
		  }
		  
		  for(int i=2;i*i<n;i++){     //因为只要计算2到sqrt（n）之间的数就可以确定n是不是质数，所以这里只要考虑这个范围类的n的因子,就可以标记完所有的合数
			  if(!isPrime[i]) continue;  //如果
			  for(int j=i*i;j<n;j+=i){    //从i*i开始标记 每次加i直到大于n   
				  isPrime[j]=false;       //标记为非质数
			  }
		  }
		  int count=0;
		  for(int i=2;i<n;i++){       //计算剩余的质数的个数
			  if(isPrime[i]) count++;
		  }
		  
		  return count;
	  }
	  
	  public static void main(String[] args){
		  CountPrimes204 c=new CountPrimes204();
		  int r=c.countPrimes(10000000);
		  System.out.println("r="+r);
	  }
}
