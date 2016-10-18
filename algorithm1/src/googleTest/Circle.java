package googleTest;

import java.util.Scanner;

public class Circle {
	public static void main(String args[]){
		Scanner cin = new Scanner(System.in);
		while (cin.hasNext()){
			int n = cin.nextInt();
			System.out.println(cal(n));
		}
	}
	private static long cal(int n)
	{
	    //(n^4 - 6n^3 + 23n^2 - 18n + 24) / 24
	   /* long r = (long) Math.pow(n, 4);
	    r = (long) (r - 6*Math.pow(n,3));
	    r = (long) (r + 23*Math.pow(n,2));
	    r = r - 18*n;
	    r = r + 24;
	    r = r/24;
	    return r;*/
		return 1+n*(n-1)/2 + n*(n-1)*(n-2)*(n-3)/24 -n;
	}
}
