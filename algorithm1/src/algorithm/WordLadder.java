package algorithm;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	/* public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
	     if(beginWord.equals(endWord)) return 1;  //һ�� ���1
	     if(near(beginWord,endWord)) return 2; //��һ���ַ� ֱ�����2
	     int[] result={-1};
	     List<String> curList=new ArrayList<String>();
	     traceback(beginWord,endWord,wordList,result);
	     return (wordList.size()-result[0])+2;
	    }
	 
	 public boolean near(String a,String b){
		 if(a.equals(b)) return false;
		 int count=0;
		 for(int i=0;i<a.length();i++){
			  if(a.charAt(i)!=b.charAt(i))
				  count++;
			 if(count>2) break;
		 }
		 if(count==1) return true;
		 else return false;
	 }
	 
	 public void traceback(String curWord, String endWord,Set<String> wordList,int [] result){
         List<String> cList=new ArrayList<String>(); //�洢��ѡ��String
         int cCount=0; //ÿһ�ֺ�ѡ�ĸ���,��ӦcList�Ĵ�С
		  if(near(curWord,endWord)){
			  if(wordList.size()>result[0])
			  result[0]=wordList.size();
		  }
		  else {
			  cCount=construct_candidates(curWord,wordList,cList);
			  wordList.removeAll(cList);
			  for(int i=0;i<cCount;i++){
				  curWord=cList.get(i);
				//  wordList.remove(curWord);
				  traceback(curWord,endWord,wordList,result);
 
			   } wordList.addAll(cList);
		  }
		 
	 }
	 
	 public int construct_candidates(String curWord,Set<String> wordList,List<String> cList){
		  int count=0;   
		  String temp="";
		  Iterator<String> it=wordList.iterator();
	       while(it.hasNext()){
	    	    temp=(String)it.next();
		    	 if(near(curWord,temp)){//&&!curList.contains(temp)
		    		 count++;
		    		 cList.add(temp);
		    	 }
		     }
		 return count;
	 }*/

/*	public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
		if (beginWord == null || endWord == null || beginWord.equals(endWord)  
                || beginWord.length() != endWord.length())  
            return 0;  
  
        if (near(beginWord, endWord))  
            return 2;  
		int count=1;
	    String currentStr=beginWord;
	    Queue<String> queue = new LinkedList<String>(); 
	    queue.offer(currentStr);
	    while(!queue.isEmpty()){
	    	currentStr=queue.poll();
	    	count++;
	      for(int i=0;i<currentStr.length();i++){
	    	for(char j='a';j<='z';j++){
	    		 if(currentStr.charAt(i)==j) continue;  
	    	 // String temp=currentStr.substring(0,i)+j+currentStr.substring(i+1, currentStr.length());
	    	  StringBuilder temp=new StringBuilder(currentStr);  
	    	  temp.setCharAt(i, j); 
	    	  
	    	  if(near(temp.toString(),endWord)) return count+1;
	    	  if(wordList.contains(temp.toString())){
	    		  queue.offer(temp.toString());
	    		  wordList.remove(temp.toString());
	    	  }
	    	}
	    }
	      //count--; 
	    }
	    return 0;
	}
	 public boolean near(String a,String b){
		 if(a.equals(b)) return false;
		 int count=0;
		 for(int i=0;i<a.length();i++){
			  if(a.charAt(i)!=b.charAt(i))
				  count++;
			 if(count>2) break;
		 }
		 if(count==1) return true;
		 else return false;
	 }
	*/
	
	//DFS超时
	/*private HashSet<String> wlist=new HashSet<String>();
	private int result=Integer.MAX_VALUE;
	private String eWord="";
	private List<String> rlist=new ArrayList<String>();
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
	     if(beginWord.equals(endWord)) return 1;
	      wlist=(HashSet<String>) wordList;
	      eWord=endWord;
          ladderHelper(beginWord,1);
          return result+1;
          
    }

   private void ladderHelper(String curWord,int count){
	  if(nextWord(curWord,eWord)) {
		if(count<result) result=count;
	  }else{
		  if(count>=result) return ;
		  List<String> candlist=new ArrayList<String>();
          char[] cur=curWord.toCharArray();
          for(int i=0;i<cur.length;i++){
        	  char old=cur[i];
        	  for(int j='a';j<='z';j++){
        		  if(cur[i]==j) continue;
        		  cur[i]=(char)j;
        		  String str=String.valueOf(cur);
        		  if(wlist.contains(str)&&!rlist.contains(str)){
        			  candlist.add(str);
        		  }
        	  }
        	  cur[i]=old;
          }
          for(int i=0;i<candlist.size();i++){
        	  rlist.add(candlist.get(i));
        	  count++;
        	  ladderHelper(candlist.get(i),count);
        	  count--;
        	  rlist.remove(candlist.get(i));
          }
	  }
}

  private boolean nextWord(String w1,String w2){
	  if(w1.length()!=w2.length()) return false;
	  int count=0;
	  for(int i=0;i<w1.length();i++){
		  if(w1.charAt(i)!=w2.charAt(i)){
			 count++;
		  }
	  }
	  if(count==1) return true;
	  else return false;
  }*/

 /*   private void dfs(List<List<String>> rrlist,List<String> rlist,HashSet<String> ewcandlist,HashSet<String> wlist,String curWord){
    	  if(ewcandlist.contains(curWord)){
    		  rrlist.add(new ArrayList<String>(rlist));
    	  }else{
              //构建候选,从wordList找到与当前字符串的距离是1的单词
              List<String> candlist=new ArrayList<String>();
              char[] cur=curWord.toCharArray();
              for(int i=0;i<cur.length;i++){
            	  char old=cur[i];
            	  for(int j='a';j<='z';j++){
            		  if(cur[i]==j) continue;
            		  cur[i]=(char)j;
            		  String str=String.valueOf(cur);
            		  if(wlist.contains(str)&&!rlist.contains(str)){
            			  candlist.add(str);
            		  }
            	  }
            	  cur[i]=old;
              }
              
              for(int i=0;i<candlist.size();i++){
            	  rlist.add(candlist.get(i));
            	  dfs(rrlist,rlist,ewcandlist,wlist,candlist.get(i));
            	  rlist.remove(candlist.get(i));
              }
    	  }
    	
    }
	*/
	//AC 100ms 此题的关键是用26个字符依次替换单词中的各个字符  以及删除wordList中已经使用过的字符   
		 public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
		     if(beginWord.endsWith(endWord)) return 1;
			   wordList.remove(beginWord);
		       Queue<String> q=new LinkedList<String>();
		       q.offer(beginWord);
		       int count=0,lastsum=0,sum=1,level=1;
		       while(!q.isEmpty()){
		    	   while(count<sum){
		    	   String cur=q.poll();
		    	   count++;
		    	   char[] chars=cur.toCharArray();
		    	   for(int i=0;i<chars.length;i++){
		    		   char old=chars[i];
		    		   for(char j='a';j<='z';j++){
		    			   if(old==j) continue;
		    				   chars[i]=j;
		    				   String can=String.valueOf(chars);
		    				   if(can.equals(endWord)) return level+1;
		    				   if(wordList.contains(can)) {
		    					   q.offer(can);
		    					   lastsum++;
		    					   wordList.remove(can);
		    				   }
		    			}
		    		   chars[i]=old;
		    	   }
		         }
		    	   count=0;
		    	   sum=lastsum;
		    	   level++;
		    	   lastsum=0;
		       }
		        
		       return 0;
	  }
	
	 public static void main(String [] args){
		 WordLadder wd=new WordLadder();
		 Set<String> wordList = new HashSet<String>();
		 wordList.add("leet");
		 wordList.add("code");
		 wordList.add("lest");
		 wordList.add("lose");
		 wordList.add("lode");
		 wordList.add("robe");
		 wordList.add("lost");
		 int r= wd.ladderLength("leet", "code", wordList);
/*		 wordList.add("hot");
		 wordList.add("dot");
		 wordList.add("dog");
		 int r= wd.ladderLength("hot", "dog", wordList);*/
	   /* String[] w={"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"};
	   for(int i=0;i<w.length;i++){
		   wordList.add(w[i]);
	   }
		int r= wd.ladderLength("qa", "sq", wordList);*/
		System.out.println("result="+r);
	 }
}
