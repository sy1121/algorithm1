package algorithm;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class WordDictionary {
	class TrieNode {
	    // Initialize your data structure here.
	     boolean isTail;
	     HashMap<Character,TrieNode> sonNodes;  
	    public TrieNode() {
	        sonNodes=new HashMap<Character,TrieNode>();
	        isTail=false;
	    }
	}
	 private TrieNode root;

	    public WordDictionary() {
	        root = new TrieNode();
	    }
	 // Adds a word into the data structure.
    public void addWord(String word) {
    	  HashMap<Character,TrieNode> curSons=root.sonNodes;
          for(int i=0;i<word.length();i++){
            TrieNode tempSon=curSons.get(word.charAt(i));
            if(tempSon==null){
          	  tempSon=new TrieNode();
          	  curSons.put(word.charAt(i), tempSon);
          	  curSons=tempSon.sonNodes;
            }else{
          	 curSons=tempSon.sonNodes;
            }
            
            if(word.length()-1==i){
      		  tempSon.isTail=true;
      	  }
          }
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
    	HashMap<Character,TrieNode> curSons=root.sonNodes;
    	  for(int i=0;i<word.length()-1;i++){
          	if(curSons!=null&&curSons.containsKey(word.charAt(i))){
          		curSons=curSons.get(word.charAt(i)).sonNodes;
          	}else{
          	    if(word.charAt(i)=='.'){
          	    	Iterator it=curSons.entrySet().iterator();
          	    	HashMap<Character,TrieNode> temp=new HashMap<Character,TrieNode>();
          	    	while(it.hasNext()){
          	    		Map.Entry entry = (Map.Entry) it.next();
          	    	   //Object key = entry.getKey();
          	    	   TrieNode val = (TrieNode)entry.getValue();
          	    	   temp.putAll(val.sonNodes);
          	    	}
          	         curSons=temp;
          	    }else
          		return false;
          	}
          }
          TrieNode tailNode=curSons.get(word.charAt(word.length()-1));
          if(tailNode!=null&&tailNode.isTail)  return true;
          else if(word.charAt(word.length()-1)=='.'&&!curSons.isEmpty()){
        	   Iterator it=curSons.entrySet().iterator();
    	    	while(it.hasNext()){
    	    		Map.Entry entry = (Map.Entry) it.next();
    	    	   TrieNode val = (TrieNode)entry.getValue();
    	    	   if(val.isTail) return true;
    	    	}
        	  return false;
          }else
          	return false;
    }
    
    public static void main(String[]  args){
    	WordDictionary dic=new WordDictionary();
    	dic.addWord("ran");
    	dic.addWord("rune");
    	dic.addWord("runner");
    	dic.addWord("runs");
    	dic.addWord("add");
    	dic.addWord("adds");
    	dic.addWord("adder");
    	dic.addWord("addee");
    	boolean r1=dic.search("r.n");
    	boolean r2=dic.search("ru.n.e");
    	boolean r3=dic.search("add");//search("add."),search("adde."),search(".an."),search("...s"),search("....e."),search("......."),search("..n.r")
    //	boolean r=dic.search("r.n");
    	System.out.println("r="+r1);
    	System.out.println("r="+r2);
    	System.out.println("r="+r3);
    }
}
