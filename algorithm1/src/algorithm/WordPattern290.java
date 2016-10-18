package algorithm;

import java.util.HashMap;

public class WordPattern290 {
	//2ms
	public boolean wordPattern(String pattern, String str) {
        int length=pattern.length();
        char[] c=pattern.toCharArray();
        String[] strs=str.split(" ");
        if(length!=strs.length) return false;
        HashMap<Character,String> map=new HashMap<Character,String>();
        for(int i=0;i<length;i++){
            if(!map.containsKey(c[i])&&!map.containsValue(strs[i])){
                map.put(c[i],strs[i]);
            }else{
                if(map.get(c[i])==null||!map.get(c[i]).equals(strs[i])) return false;
            }
        }
        return true;
    }
	
	public static void main(String[] args){
		WordPattern290 w=new WordPattern290();
		boolean r=w.wordPattern("abba", "dog dop dop dog");
		System.out.println("r="+r);
	}
}
