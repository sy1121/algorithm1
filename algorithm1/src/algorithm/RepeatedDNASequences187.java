package algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequences187 {
	//KMP 超时
	/* public List<String> findRepeatedDnaSequences(String s) {
	        List<String> rlist=new ArrayList<String>();
	        for(int i=0;i<s.length()-10;i++){
	           String cur=s.substring(i, i+10);
	           if(kmp(s.substring(i+10),cur)!=-1&&!rlist.contains(cur)) rlist.add(cur);
	        }
	        return rlist;
	    }
	 
	 public void next(char[] P,int[] next){
		int k=0;
		next[0]=0;
		for(int i=1;i<P.length;i++){
		 while(k>0&&P[i]!=P[k])
			 k=next[k-1];
		 if(P[i]==P[k]) k++;
		 next[i]=k;
		}
	 }
	 
	 public int kmp(String s1,String s2){
		 int result=-1,k=0;
		 char[] T=s1.toCharArray(),P=s2.toCharArray();
		 int[] next=new int[P.length];
		 next(P,next);
		 for(int i=0;i<T.length;i++){
			 while(k>0&&T[i]!=P[k])
				 k=next[k-1];
			 if(T[i]==P[k]) k++;
			 if(k==P.length){
				 result=i-k+1;break;
			 }
		 }
		 return result;
	 }*/
	//网上的解法 用hashMap
/*	public List<String> findRepeatedDnaSequences(String s) {
		List<String> rlist=new ArrayList<String>();
		if(s.length()<10) return rlist;
	    HashMap<String,Integer> map=new HashMap<String,Integer>();
	    for(int i=0;i<s.length()-9;i++){
	    	String cur=s.substring(i,i+10);
	    	if(map.containsKey(cur)){
	    		map.put(cur, map.get(cur)+1);
	    	}else{
	    		map.put(cur, 1);
	    	}
	    	if(map.get(cur)==2) rlist.add(cur);
	    }
		return rlist;
	} */
	
	//网上解法 比直接用hashmap快
    private int dnaBaseVal(char base)  {
        if (base == 'A')
            return 0;
        else if (base == 'C')
            return 1;
        else if (base == 'G')
            return 2;
        else if (base == 'T')
            return 3;
        return 0;
    }

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<String>();
        int n = s.length();
        if (n < 10)
            return res;

        Set<Integer> vals = new HashSet<Integer>();
        Set<Integer> resVals = new HashSet<Integer>();

        int val = 0;
        for (int i = 0; i < 10; i++)    {
            val = val << 2;
            val += dnaBaseVal(s.charAt(i));
        }
        vals.add(val);

        int base = 1 << (2 * 9);
        for (int i = 10; i < n; i++)    {
            val -= base * dnaBaseVal(s.charAt(i - 10));
            val = val << 2;
            val += dnaBaseVal(s.charAt(i));
            if (!vals.add(val) && resVals.add(val))  {
                res.add(s.substring(i-9, i+1));
            }
        }
        return res;
    }
	
	 public static void main(String[] args){
		 RepeatedDNASequences187 r=new RepeatedDNASequences187();
		 String s="AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		 
		 List<String> rlist=r.findRepeatedDnaSequences(s);
		 for(int i=0;i<rlist.size();i++){
			 System.out.print(rlist.get(i)+",");
		 }
	 }
}
