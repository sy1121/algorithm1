package algorithm;

import java.util.HashMap;
import java.util.HashSet;
//AC 48ms 25%
class TrieNode {
    // Initialize your data structure here.
     boolean isTail;
     HashMap<Character,TrieNode> sonNodes;  
    public TrieNode() {
        sonNodes=new HashMap<Character,TrieNode>();
        isTail=false;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    
    public void insert(String word) {
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

    // Returns if the word is in the trie.
    public boolean search(String word) {
    	 HashMap<Character,TrieNode> curSons=root.sonNodes;
        for(int i=0;i<word.length()-1;i++){
        	if(curSons!=null&&curSons.containsKey(word.charAt(i))){
        		curSons=curSons.get(word.charAt(i)).sonNodes;
        	}else{
        		return false;
        	}
        }
        TrieNode tailNode=curSons.get(word.charAt(word.length()-1));
        if(tailNode!=null&&tailNode.isTail)  return true;
        else
        	return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
    	 HashMap<Character,TrieNode> curSons=root.sonNodes;
         for(int i=0;i<prefix.length();i++){
         	if(curSons!=null&&curSons.containsKey(prefix.charAt(i))){
         		curSons=curSons.get(prefix.charAt(i)).sonNodes;
         	}else{
         		return false;
         	}
         }
         return true;
    }
    
    
    public static void main(String[] args){
    	Trie trie=new Trie();
    	/*trie.insert("something");
    	trie.insert("adv");
    	trie.insert("hjkd");
    	boolean r=trie.search("ad5");
    	boolean r2=trie.search("adv");
    	boolean r3=trie.startsWith("a");*/
    	trie.insert("abc");
    	boolean r=trie.search("abc");
    	boolean r2=trie.search("ab");
    	trie.insert("ab");
    	boolean r3=trie.search("ab");
    	trie.insert("ab");
    	boolean r4=trie.search("ab");
    	System.out.println("result="+r);
    	System.out.println("result2="+r2);
    	System.out.println("result3="+r3);
    	System.out.println("result4="+r4);
    }
}
