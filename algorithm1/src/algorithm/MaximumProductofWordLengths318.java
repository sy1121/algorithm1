package algorithm;

import java.util.Arrays;

public class MaximumProductofWordLengths318 {
	//212ms
	 public int maxProduct(String[] words) {
	     int len=words.length;
	     if(len<2) return 0;
		 sortByLen(words);
		 int max=0;
	     for(int i=0;i<len;i++){
	    	  if(words[i].length()*words[i].length()<=max) break;
	    	  for(int j=i+1;j<len;j++){
	    		  if(words[i].length()*words[j].length()<=max) break;
	    		  if(!hasShareLetter(words[i],words[j])){
	    			  max=Math.max(words[i].length()*words[j].length(),max); 
	    		  }
	    	  }
	     }
	     return max;
	    }
	 
	 //insert sort
	 private void sortByLen(String[] words){
		 int len=words.length;
		 for(int i=1;i<len;i++){
			 String curWord=words[i];
			 int position=i;
			for(int j=i-1;j>=0;j--){
				if(words[j].length()<curWord.length()) {
					words[j+1]=words[j];
					position--;
				}else break;
			}
            words[position]=curWord;
		 }
	 }
	 
	 private boolean hasShareLetter(String s1,String s2){
		 boolean[] alp=new boolean[26];
		 Arrays.fill(alp, false);
		 char[] c1=s1.toCharArray();
		 char[] c2=s2.toCharArray();
		 for(int i=0;i<s1.length();i++){
			 alp[c1[i]-'a']=true;
		 }
		 
		 for(int i=0;i<s2.length();i++){
			 if(alp[c2[i]-'a']) return true;
		 }
		 return false;
	 }
	 public static void main(String[] args){
		 MaximumProductofWordLengths318 m=new MaximumProductofWordLengths318();
		 String[] words={"abcw","baz","foo","bar","xtfn","abcdef"};
		 int r=m.maxProduct(words);
		 System.out.println("r="+r);
	 }
}
