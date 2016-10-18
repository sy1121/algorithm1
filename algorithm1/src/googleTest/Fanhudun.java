package googleTest;

import java.util.Scanner;

public class Fanhudun {
	public static void main(String[] args){
		Scanner cin = new Scanner(System.in);
		while (cin.hasNext()){
			int n = cin.nextInt();
			int m=cin.nextInt();
			int k=cin.nextInt();
			int[] a=new int[n];
			int max=0;
			for(int i=0;i<n;i++){
				a[i]=cin.nextInt();
				if(a[i]>max) max=a[i];
			}
		    int min=1,mid=0,result=-1;
		    boolean flag=false;
		   /* while(min+1<max){
		        mid=min+(max-min)/2;
		    	if(canDestroy(a,m,k,mid)){
		    		min=mid;
		    		flag=true;
		    	}else max=mid;
		    }
		    if(flag&&canDestroy(a,m,k,mid))
		    result=max;
		    else result=-1;*/
		    int t=1;
		    while(canDestroy(a,m,k,t++)) ;
		    System.out.println(t-1);
		}
	}
		
		private static boolean canDestroy(int[] a,int m,int k,int t){
			int n=a.length;
			float retain=m;
			for(int i=0;i<n;i++){
				retain=retain-a[i];
				if(retain!=m&&retain>0){
					if(i==0)
					retain=(float) Math.min((float)m, (retain+(t-0.5)));
					else retain=(float) Math.min((float)m, (retain+t));
				}
				else {
					k--;
					retain=m;
				}
			    if(k==0)  return true;
			}
			return false;
		}
}
