package algorithm;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings205 {
	
	//AC 28ms
/*	public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map=new HashMap<Character,Character>();
        if(s.length()!=t.length()) return false;
        for(int i=0;i<s.length();i++){
        	 if(!map.containsKey(s.charAt(i))){
        		 if(map.containsValue(t.charAt(i))) return false;
        		 else map.put(s.charAt(i),t.charAt(i));
        	 }else{
        		if(!map.get(s.charAt(i)).equals(t.charAt(i)))
        			     return false;
        	 }
        }
        return true;
    }*/
	//别人的方法  注意map.put返回值
	public boolean isIsomorphic(String s, String t) {
	    Map map = new HashMap();
	    Map map2 = new HashMap();
	    if (s.length() != t.length()) return false;
	    for (Integer i = 0; i < s.length(); i++) {
	        if (map.put(s.charAt(i), i) != map2.put(t.charAt(i), i)) 
	        	return false;
	    }
	    return true;
	  }
	
	public static void main(String[] args){
		IsomorphicStrings205 i=new IsomorphicStrings205();
		boolean r=i.isIsomorphic("caa", "dbd");
		System.out.println("result="+r);
	}
}
