package algorithm;

public class CountPrimes204 {
	
	//������ķ��� ʱ�临�Ӷ�ΪO(n)
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
	  
	  //���ǽϺõķ���
	  public int countPrimes(int n){
		  boolean[] isPrime=new boolean[n];  //���ÿһ�����ǲ�������
		  for(int i=2;i<n;i++){
			  isPrime[i]=true;         //��ʼ��Ϊ��
		  }
		  
		  for(int i=2;i*i<n;i++){     //��ΪֻҪ����2��sqrt��n��֮������Ϳ���ȷ��n�ǲ�����������������ֻҪ���������Χ���n������,�Ϳ��Ա�������еĺ���
			  if(!isPrime[i]) continue;  //���
			  for(int j=i*i;j<n;j+=i){    //��i*i��ʼ��� ÿ�μ�iֱ������n   
				  isPrime[j]=false;       //���Ϊ������
			  }
		  }
		  int count=0;
		  for(int i=2;i<n;i++){       //����ʣ��������ĸ���
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
