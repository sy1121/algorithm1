package googleTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Country_Leader {
     
	public static void main(String[] args){
		 FileReader fr;
		try {
			fr = new FileReader("C:/Users/sy/Desktop/A-large.in");
	        BufferedReader br=new BufferedReader(fr);
	        List<String> answer=new ArrayList<String>();
	        int t=0,n=0;
	        t=Integer.parseInt(br.readLine());
	        for(int i=0;i<t;i++){
	           n=Integer.parseInt(br.readLine());
	           String[] names=new String[n];
	           for(int j=0;j<n;j++){
	        	   names[j]=br.readLine();
	           }
	           answer.add("Case #"+(i+1)+": "+solve(names));
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
	
	private static String solve(String[] names){
	    int len=names.length;
	    int[][] board=new int[len][26];
	    int[] counts=new int[len];
	    for(int i=0;i<len;i++){
	    	for(int j=0;j<names[i].length();j++){
	    		if(names[i].charAt(j)!=' '){
	    			if(board[i][names[i].charAt(j)-'A']==0) counts[i]++;
	    			board[i][names[i].charAt(j)-'A']=1;
	    		}
	    	}
	    }
	    int max=counts[0],index=0;
	    String answer=names[0];
	    for(int i=1;i<len;i++){
	    	if(counts[i]>max){
	    		answer=names[i];
	    		max=counts[i];
	    		index=i;
	    	}else if(counts[i]==max){
	    		if(compare(names[i],names[index])==1){
	    			answer=names[i];
		    		max=counts[i];
		    		index=i;
	    		}
	    	}
	    	
	    }
	    
		return answer;
	}
	
	private static int compare(String ori,String max){
	    int index1=0,index2=0;
	    while(index1<ori.length()&&index2<max.length()){
	    	if(ori.charAt(index1)>max.charAt(index2)) return -1;
	    	else if(ori.charAt(index1)<max.charAt(index2)) return 1;
	    	if(index1<ori.length()&&ori.charAt(index1)==' ')  index1++;
	    	if(index2<max.length()&&max.charAt(index2)==' ')  index2++;
	    	index1++;
	    	index2++;
	    }
	    if(index1<ori.length()) return -1;
	    else if(index2<max.length()) return 1;
		return 0;
	}
    
}  
