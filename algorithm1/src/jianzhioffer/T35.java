package jianzhioffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 第一个只出现一次的字符
 * @author sy
 *
 */
public class T35 {
     public char firstNotRepeatChar(String s){
    	 if(s.length()==0) return 'a';
    	 Map<Character,Integer> map=new HashMap<Character,Integer>();
    	 for(int i=0;i<s.length();i++){
    		 if(map.containsKey(s.charAt(i))) map.put(s.charAt(i), map.get(s.charAt(i))+1);
    		 else map.put(s.charAt(i), 1);
    	 }
    	 for(int i=0;i<s.length();i++){
    		 if(map.get(s.charAt(i))==1) return s.charAt(i);
    	 }
    	 return s.charAt(0);
     }
     
     public static void main(String[] args){
    	 T35 t=new T35();
    	 char r=t.firstNotRepeatChar("abaccdef");
    	 System.out.println(r);
     }
}
