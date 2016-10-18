package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph133 {
	 public static class UndirectedGraphNode {
		      int label;
		      List<UndirectedGraphNode> neighbors;
		      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
		  };
		  //AC  4ms  ษ๎หั
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
	    if(node==null) return null;
         HashMap<Integer,UndirectedGraphNode> map=new HashMap<Integer,UndirectedGraphNode>(); 
         return cloneGraph(node,map);
    }
	
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node,HashMap<Integer,UndirectedGraphNode> map) {
		   if(map.containsKey(node.label))  return map.get(node.label);
		   else{
			   UndirectedGraphNode newNode=new UndirectedGraphNode(node.label);
			   map.put(node.label, newNode);
			   for(int i=0;i<node.neighbors.size();i++){
				   newNode.neighbors.add(cloneGraph(node.neighbors.get(i),map));
			   }
			   return newNode;
		   }
		   
	}
}
