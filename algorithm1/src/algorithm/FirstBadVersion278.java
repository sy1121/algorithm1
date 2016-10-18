package algorithm;

public class FirstBadVersion278 {
	//AC  19ms
    public int firstBadVersion(int n) {
        int left=1,right=n,mid=(left+right)/2;
        while(left!=mid&&right!=mid){
            if(isBadVersion(mid))
                right=mid;   
           else
                left=mid;
             mid=left+(right-left)/2;
        }
        if(isBadVersion(left))  return left;
        else return right;
   }
    
    public boolean isBadVersion(int n){
    	if(n<1702766718) return false;
    	else return true;
    }
    
    public static void main(String[] args){
    	FirstBadVersion278 f=new FirstBadVersion278();
    	int result=f.firstBadVersion(2126753390);
    	System.out.println("result="+result);
    }
}
