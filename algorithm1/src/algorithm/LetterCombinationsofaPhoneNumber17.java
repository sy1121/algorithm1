package algorithm;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber17 {
	//AC 3ms
	 public List<String> letterCombinations(String digits) {
		 List<String> rlist=new ArrayList<String>();
		 if(digits.isEmpty()) return rlist;
		 traceback(digits,0,rlist,new StringBuilder(""));
		 return rlist;
	    }
	 
	 public void traceback(String digits,int level,List<String> rlist,StringBuilder s){
		   if(level==digits.length()){
			   rlist.add(s.toString());
		   }else{
			   List<Character> clist=constructCandidate(digits.charAt(level)-'0');
			   for(int i=0;i<clist.size();i++){
				   s.append(clist.get(i));
				   traceback(digits,level+1,rlist,s);
				   s.deleteCharAt(s.length()-1);
			   }
		   }
	 }
	 //这里方法太慢了
	 public List<Character> constructCandidate(int i){
		  List<Character> rlist=new ArrayList<Character>();
		  switch(i){
		  case 0: rlist.add(' ');break;
		  case 2: rlist.add('a');rlist.add('b');rlist.add('c');break;
		  case 3: rlist.add('d');rlist.add('e');rlist.add('f');break;
		  case 4: rlist.add('g');rlist.add('h');rlist.add('i');break;
		  case 5: rlist.add('j');rlist.add('k');rlist.add('l');break;
		  case 6: rlist.add('m');rlist.add('n');rlist.add('o');break;
		  case 7: rlist.add('p');rlist.add('q');rlist.add('r');rlist.add('s');break;
		  case 8: rlist.add('t');rlist.add('u');rlist.add('v');break;
		  case 9: rlist.add('w');rlist.add('x');rlist.add('y');rlist.add('z');break;
		  default: break;
		  }
		  return rlist;
	 }
	 
	 //别人的解法
/*	 private void helper(String digits, int index, String result, List<String> results)
	 {
	     if (index >= digits.length())
	     {
	         results.add(result);
	     }
	     else
	     {
	         char digit = digits.charAt(index);
	         int count = digit == '9' || digit == '7' ? 4 : 3;
	         int startIndex = ((digit - '0') - 2) * 3;
	         startIndex = (digit - '0') > 7 ? startIndex + 1 : startIndex;
	         for (int i = 0; i < count; i++)
	         {
	             helper(digits, index + 1, result + (char)((startIndex + i) + 'a'), results);
	         }
	     }
	 }

	 public List<String> letterCombinations(String digits) {
	     List<String> results = new ArrayList<String>();
	     if (digits.isEmpty())
	     {
	         return results;
	     }
	     helper(digits, 0, "", results);
	     return results;
	 }*/
	 public static void main(String[] args){
		 LetterCombinationsofaPhoneNumber17 l=new LetterCombinationsofaPhoneNumber17();
		 List<String> rlist=l.letterCombinations("2");
		 for(int i=0;i<rlist.size();i++){
			 System.out.print(rlist.get(i)+",");
		 }
		 System.out.println("size="+rlist.size());
	 }
}
