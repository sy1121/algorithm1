package algorithm;

public class ClimbingStairs70 {
	
	//AC  0ms
  public int climbStairs(int n) {
	    if(n<2) return 1;
	    else if(n==3)  return 2;
	    else{
        int[] nums=new int[n];
        nums[0]=1;
        nums[1]=2;
        for(int i=2;i<n;i++){
        	nums[i]=nums[i-1]+nums[i-2];
        }
        return nums[n-1];
	    }
    }
  
  public static void main(String[] args){
	  ClimbingStairs70 c=new ClimbingStairs70();
	  int r=c.climbStairs(100);
	  System.out.println("r="+r);
  }
}
