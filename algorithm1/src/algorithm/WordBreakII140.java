package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreakII140{
/*	 public List<String> wordBreak(String s, Set<String> wordDict) {
	        Iterator<String> it=wordDict.iterator();
	        List<String> rlist=new ArrayList<String>();
	        int minlength=Integer.MAX_VALUE,maxlength=0;
	        long start=System.currentTimeMillis();
	        while(it.hasNext()){
	        	String curString=it.next();
	        	if(curString.length()<minlength) minlength=curString.length();
	        	if(curString.length()>maxlength) maxlength=curString.length();
	        }
	        long end=System.currentTimeMillis();
	        System.out.println("计算长度时间:"+(end-start)+"ms");
	        long start1=System.currentTimeMillis();
	         backtrace(0,rlist,s,wordDict,new ArrayList<String>(),minlength,maxlength);
	         long end1=System.currentTimeMillis();
	         System.out.println("回溯算法执行时间："+(end1-start1)+"ms");
	         return rlist;
	    }
	 
	 public void backtrace(int position,List<String> list,String s,Set<String> wordDict,List<String> sb,int minlength,int maxlength){
		    if(position==s.length()){
		        StringBuilder r=new StringBuilder("");
		       for(int i=0;i<sb.size()-1;i++){
		    	   r.append(sb.get(i)+" ");
		       }
		       r.append(sb.get(sb.size()-1));
		       list.add(r.toString());
		       return ;
		    }
		    for(int i=position+minlength-1;i<position+maxlength&&i<s.length();i++){
		    	  String temp=s.substring(position,i+1);
		    	  if(wordDict.contains(temp)){
		    		   sb.add(temp);
		    	       backtrace(i+1,list,s,wordDict,sb,minlength,maxlength);
		    	       sb.remove(sb.size()-1);
		    	  }
		    }
		    return ;
	 }*/
	
/*    public List<String> wordBreak(String s, Set<String> dict) {
        return dfs(s, dict, new HashMap<String, List<String>>());
    }*/

/*    public List<String> dfs(String s, Set<String> dict, Map<String, List<String>> memo){
        if(memo.containsKey(s)) {
            return memo.get(s);
        }
        List<String> res = new ArrayList<>();
        if(s == null || s.length() == 0) {
            return res;
        }
        int n = s.length();

        for(String w : dict) {
            if(!s.startsWith(w)) {
                continue;
            }
            int end = w.length();
            if(end == n) {
                res.add(w);
            } else {
                List<String> sublist = dfs(s.substring(end), dict, memo);
                for(String item : sublist) {
                    item = w + " " + item;
                    res.add(item);
                }
            }
        }

        memo.put(s, res);
        return res;
    }*/
	
	//网上的解法 dfs+动态规划  AC 19ms   注意dfs和回溯的区别  带参数和不带惨数两种写法
    public List<String> wordBreak(String s, Set<String> wordDict) {
    	return dfs(s,wordDict,new HashMap<String,List<String>>());
    }
	 
    public List<String> dfs(String s,Set<String> wordDict,HashMap<String,List<String>> map){
             if(map.containsKey(s)) return map.get(s);
             List<String> list=new ArrayList<String>();
             if(s==null||s.isEmpty()) return list;
             int len=s.length();
             for(String word:wordDict){
            	 if(!s.startsWith(word)) continue;
            	 else{
            		if(word.length()==len) {
            			list.add(word); 
            		}else{
            			List<String> t=dfs(s.substring(word.length()),wordDict,map);
            			for(String str:t){
            				list.add(word+" "+str);
            			}
            		}
            	 }
             }
             map.put(s, list);
         	return 	list;
    }
	 public static void main(String[] args){
		 WordBreakII140 w=new WordBreakII140();
		 Set<String> wordDict=new HashSet<String>();
		 wordDict.add("a");
		 wordDict.add("aa");
		 //wordDict.add("aaaa");
		 wordDict.add("aaa");
	/*	 wordDict.add("aaaaa");
		 wordDict.add("aaaaaaa");
		 wordDict.add("aaaaaaaa");
		 wordDict.add("aaaaaaaaa");
		 wordDict.add("aaaaaa");
		 wordDict.add("aaaaaaaaaa");*/
		 List<String> r=w.wordBreak("aaa", wordDict);
		 System.out.println("r="+r);
		 System.out.println("size="+r.size());
	 }
}
