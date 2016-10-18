package googleTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Kuohao {
	public static void main(String[] args){
	 FileReader fr;
		try {
			fr = new FileReader("C:/Users/sy/Desktop/B-small-attempt0.in");
	        BufferedReader br=new BufferedReader(fr);
	        List<String> answer=new ArrayList<String>();
	        int T=0,A=0,B=0,N=0,K=0;
	        T=Integer.parseInt(br.readLine());
	        for(int i=0;i<T;i++){
	           String param=br.readLine();
	           String[] lm=param.split(" ");
	           A=Integer.parseInt(lm[0]);
	           B=Integer.parseInt(lm[1]);
	           N=Integer.parseInt(lm[2]);
	           K=Integer.parseInt(lm[3]);
	           int[] a=new int[N+1];
	           int[] b=new int[N+1];
	           suan(a,K,A);
	           suan(b,K,B);
	           long r=0;
	           for(int j=1;j<N+1;j++){
	        	   for(int m=1;m<N+1;m++){
	        		   if(j!=m&&a[m]+b[j]==K) r++;
	        	   }
	           }
	           answer.add("Case #"+(i+1)+": "+r%1000000007);
	        }
	        FileOutputStream fos=new FileOutputStream(new File("C:/Users/sy/Desktop/out.txt"));
	        OutputStreamWriter osw=new OutputStreamWriter(fos, "UTF-8");
	        BufferedWriter  bw=new BufferedWriter(osw);
	        for(String arr:answer){
	            bw.write(arr);
	            bw.write(System.getProperty("line.separator"));
	        }
	        bw.close();
	        osw.close();
	        fos.close();
	        
	        br.close();
	        fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void suan(int[] a,int k,int A){
		int size=a.length,i;
		for(i=1;i<size&&i<=k;i++){
			a[i]=quyu(i,A,k);
		}
		while(i<size){
			a[i]=a[i-k];
			i++;
		}
	}
	
	public static int quyu(int i,int A,int k){
		int r=1;
	    while(A>0){
	    	if(A%2==1) r=(r*i)%k;
	    	A/=2;
	    	i=(i*i)%k;
	    }
	    return r;
	}
}
