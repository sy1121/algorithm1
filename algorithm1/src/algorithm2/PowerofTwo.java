package algorithm2;

public class PowerofTwo {
	 public boolean isPowerOfTwo(int n) {
	        return (n&(n-1))==0;
	    }
}
