package algorithm;

import java.util.HashMap;

public class BullsandCows299 {
	//AC   21ms
	  public String getHint(String secret, String guess) {
	         int size=secret.length();
	         int bulls=0,cows=0;
	         StringBuilder result=new StringBuilder("");
	         HashMap<Character,Integer> str1=new HashMap<Character,Integer>();
	         HashMap<Character,Integer> str2=new HashMap<Character,Integer>();
	         for(int i=0;i<size;i++){
	        	 char char1=secret.charAt(i);
	        	 char char2=guess.charAt(i);
	        	 if(char1==char2)
	        		 bulls++;
	        	 else{
	        		 //处理secret中的字符
	        		if(str2.get(char1)==null){
	        			if(str1.containsKey(char1)){
	        				str1.put(char1, str1.get(char1)+1);
	        			}else{
	        				str1.put(char1, 1);
	        			}
	        		}else{
	        			cows++;
	        			int c=str2.get(char1);
	        			if(c<=1)
	        		    str2.remove(char1);
	        			else
	        				str2.put(char1, str2.get(char1)-1);
	        		}
	        		//处理guess中的字符
	        		if(str1.get(char2)==null){
	        			if(str2.containsKey(char2)){
	        				str2.put(char2, str2.get(char2)+1);
	        			}else{
	        				str2.put(char2, 1);
	        			}
	        		}else{
	        			cows++;
	        			int c=str1.get(char2);
	        			if(c<=1)
	                      str1.remove(char2);
	        			else
	        			str1.put(char2,str1.get(char2)-1);
	        		}
	        	 }
	        		 
	         }
	         
	        result.append(bulls+"A");
	        result.append(cows+"B");
	        return result.toString();
	    }

}
