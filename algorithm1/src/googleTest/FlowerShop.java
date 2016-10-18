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

public class FlowerShop {
	public static void main(String[] args){
		 FileReader fr;
		try {
			fr = new FileReader("C:/Users/sy/Desktop/C-small-attempt0.in");
	        BufferedReader br=new BufferedReader(fr);
	        List<String> answer=new ArrayList<String>();
	        int t=0,n=0;
	        t=Integer.parseInt(br.readLine());
	        for(int i=0;i<t;i++){
	           n=Integer.parseInt(br.readLine());
	           String arg="";
	           int[] nums=new int[n+1];
	        	   arg=br.readLine();
	           String[] argList=arg.split(" ");
	           for(int j=0;j<argList.length;j++){
	        	   nums[j]=Integer.parseInt(argList[j]);
	           }
	            if(n==1)
	           answer.add("Case #"+(i+1)+": "+(nums[1]/nums[0]-1));
	            else {
	            	 answer.add("Case #"+(i+1)+": "+(((-2*nums[0]+nums[1])+Math.sqrt((-2*nums[0]+nums[1])*(-2*nums[0]+nums[1])-4*nums[0]*(nums[0]-nums[1]-nums[2])))/(2*nums[0])));
	            }
	            	
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
}
