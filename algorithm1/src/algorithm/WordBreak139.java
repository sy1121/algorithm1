package algorithm;

import java.util.HashMap;
import java.util.Set;

public class WordBreak139 {
	//AC  10ms  dfs+»º´æ
    public boolean wordBreak(String s, Set<String> wordDict) {  
        return dfs(s,wordDict,new HashMap<String,Boolean>(),"");
    }
    
    public boolean dfs(String s, Set<String> wordDict,HashMap<String,Boolean> map,String pre){
    	if(s==null||s.length()==0) return true;
    	if(map.containsKey(s)){
    		return map.get(s);
    	}
    	for(String str:wordDict){
        	if(!s.startsWith(str))
        		continue;
        	else{
        	   String tpre=pre+str;
               map.put(tpre,true);
        	   if(!dfs(s.substring(str.length()),wordDict,map,tpre))
        		   continue;
        	   else{
        		   return true;
        	   }
        	}
        }
    	map.put(s, false);
        return false;
    }
}
