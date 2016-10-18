package googleTest;

import java.util.Scanner;

public class Gu {
	public static void main(String args[])
    {
        Scanner cin = new Scanner(System.in);
        int a;
        while(cin.hasNextInt())
        {
            a = cin.nextInt();
            long[] b=new long[2];
            b=findPosition(a);
            long r=0;
            if(b[0]==1) r=1;
            else if(b[0]==2&&b[1]==1) r=2;
            else if(b[0]==2&&b[1]==2) r=1;
            else {
            	r+=(b[0]-2)*(b[0]-3)/2+1;
            	r+=b[0]==b[1]?b[1]-2:b[1];
            }
            System.out.println(r);
        }
    }
	private static long[] findPosition(int n){
		int left=1,right=n,mid;
		long[] r=new long[2];
		while(left+1<right){
			mid=left+(right-left)/2;
			int temp=(1+mid)*mid/2;
		    if(temp==n) {
		    	r[0]=mid;
		    	r[1]=mid;
		    	return r;
		    }else if(temp<n){
		    	left=mid;
		    }else right=mid;
		}
		r[0]=left+1;
		r[1]=n-(1+left)*left/2;
		return r;
	}
}
