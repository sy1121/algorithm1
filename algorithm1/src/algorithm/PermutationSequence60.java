package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationSequence60 {
	
	//AC 2ms
    public String getPermutation(int n, int k) {
        int[] nums=new int[n];
        int tn=n-1,tk=k-1;
		int tann=tan(tn);
        while(tn>0){
        	if(tk>=tann){
        		nums[tn]=tk/tann;
        		tk=tk%tann;
        	}
        	tann=tann/tn;
        	tn--;
        }
        boolean[] visit=new boolean[n+1];
        Arrays.fill(visit,false);
        int curIndex=1,count=0;
        StringBuffer r=new StringBuffer();
        for(int i=n-1;i>=0;i--){
        	if(nums[i]==0){
        		visit[curIndex]=true;
        		r.append(curIndex);
        		while(curIndex<=n&&visit[curIndex])
        		curIndex++;
        	}else{
        		count=0;
        	  for(int j=curIndex+1;j<=n;j++){
        		  if(!visit[j]) count++;
                if(count==nums[i]){
        			 r.append(j);
        			 visit[j]=true;
        			 break;
        		  }
        	  }
        	}
        }
        return r.toString();
    }
    
    public int  tan(int n){
    	if(n==0) return 1;
    	else return  n*tan(n-1);
    }
    
/*    //AC 5ms
    public String getPermutation(int n, int k) {
        int[] nums=new int[n];
        int tn=n-1,tk=k-1;
    	int tann=tan(tn);
        while(tn>0){
        	if(tk>=tann){
        		nums[tn]=tk/tann;
        		tk=tk%tann;
        	}
        	tann=tann/tn;
        	tn--;
        }
        List<Integer> numList=new ArrayList<Integer>();
        for(int i=1;i<n+1;i++){
        	numList.add(i);
        }
        StringBuffer r=new StringBuffer();
        for(int i=n-1;i>=0;i--){
        	 if(numList.size()>nums[i]){
        	  r.append(numList.get(nums[i]));
        	  numList.remove(nums[i]);
        	 }
        }
        return r.toString();
    }
    
    public int  tan(int n){
    	if(n==0) return 1;
    	else return  n*tan(n-1);
    }*/
    
    public static void main(String[] args){
    	PermutationSequence60 p=new PermutationSequence60();
    	String s=p.getPermutation(3,6);
    	System.out.println("rr="+s);
    }
}
