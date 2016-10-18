package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PalindromePairs336 {
	
	//超时了  虽然也用了缓存 但没有利用回文数的特点 缓存的对象不对 
	 /*public List<List<Integer>> palindromePairs(String[] words) {
	        int size=words.length;
	        List<List<Integer>> rlist=new ArrayList<List<Integer>>();
	        if(size<2)  return rlist;
	        HashMap<String,Boolean> cache=new HashMap<String,Boolean>();
	        for(int i=1;i<size;i++){
	        	for(int j=0;j<i;j++){
	        	if(isPal(words[j],words[i],cache)){
	        	    List<Integer> list=new ArrayList<Integer>();
	        	    list.add(j); 
	        	    list.add(i);
	        	    rlist.add(list);
	        	}
	        	if(isPal(words[i],words[j],cache)){
	        	    List<Integer> list=new ArrayList<Integer>();
	        	    list.add(i); 
	        	    list.add(j);
	        	    rlist.add(list);
	        	}
	        	}
	        }
	        return  rlist;
	    }
	 
	 public boolean isPal(String s1,String s2,HashMap<String,Boolean> cache){
		   StringBuilder temp=new StringBuilder(s1);
		   temp.append(s2);
		   if(cache.containsKey(temp.toString())) return cache.get(temp.toString());
		   int left=0,right=temp.length()-1;
		   while(left<right){
			    if(temp.charAt(left++)!=temp.charAt(right--)){
			        cache.put(temp.toString(), false);
			        return false;
			    }
			     
		   }
		   cache.put(temp.toString(), true);
		   return true;
	 }*/
	 
	public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (words.length < 2) return res;
        HashMap<String, List<Integer>> prefixMap = buildPrefixMap(words);
        HashMap<String, List<Integer>> postfixMap = buildPostfixMap(words);

        for (int i = 0; i < words.length; ++i){
            if (postfixMap.containsKey(words[i])){
                for (int j : postfixMap.get(words[i])){
                    if (i != j ){
                        List<Integer> tmp = new ArrayList<Integer>();
                        tmp.add(i);
                        tmp.add(j);
                        res.add(tmp);
                    }
                }
            }
            if (prefixMap.containsKey(words[i])){
                for (int j : prefixMap.get(words[i])){
                    if (i != j){
                        List<Integer> tmp = new ArrayList<Integer>();
                        tmp.add(j);
                        tmp.add(i);
                        res.add(tmp);
                    }
                }
            }
        }
        return res;
    }

    private HashMap<String, List<Integer>> buildPrefixMap(String[] words){
        HashMap<String, List<Integer>> map = new HashMap<String, List<Integer>>();

        for (int j = 0; j < words.length; ++j){
            String s = words[j];

            for (int i = s.length() - 1; i >= 0; --i){

                if (isPalindrome(s.substring(i))){
                    String cur = reverseString(s.substring(0, i));
                    if (map.containsKey(cur)) map.get(cur).add(j);
                    else {
                        map.put(cur, new ArrayList<Integer>());
                        map.get(cur).add(j);
                    }
                }
            }
        }
        return map;
    }

    private HashMap<String, List<Integer>> buildPostfixMap(String[] words){
        HashMap<String, List<Integer>> map = new HashMap<String, List<Integer>>();
        for (int j = 0; j < words.length; ++j){
            String s = words[j];
            for (int i = 0; i <= s.length(); ++i){
                if (isPalindrome(s.substring(0, i))){
                    String cur = reverseString(s.substring(i));
                    if (map.containsKey(cur)) map.get(cur).add(j);
                    else {
                        map.put(cur, new ArrayList<Integer>());
                        map.get(cur).add(j);
                    }
                }
            }
        }
        return map;
    }

    private String reverseString(String s){
        if (s.equals("")) return "";
        char[] array = s.toCharArray();
        int i = 0;
        int j = array.length - 1;
        while (i < j){
            char swap = array[i];
            array[i] = array[j];
            array[j] = swap;
            i++;
            j--;
        }
        return String.valueOf(array);
    }

    private boolean isPalindrome(String s){
        if (s.equals("")) return true;
        int i = 0;
        int j = s.length() - 1;
        while (i < j){
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
	 public static void main(String[] args){
		 PalindromePairs336 p=new PalindromePairs336();
		 String[] words={"abcd", "dcba", "lls", "s", "sssll"};
		 List<List<Integer>> rlist=p.palindromePairs(words);
		 System.out.print("[");
		 for(int i=0;i<rlist.size();i++){
			 System.out.print("[");
			for(int j=0;j<2;j++){
			     System.out.print(rlist.get(i).get(j)+" ");	
			}
			System.out.print("]");
		 }
		 System.out.println("]");
	 }
}
