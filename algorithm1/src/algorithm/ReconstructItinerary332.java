package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class ReconstructItinerary332 {
	//AC 23ms
	/* static  class   Node {
	      String val;
	      List<Node> next;
	      Node(String x) {
	          val = x;
	          next = new ArrayList<Node>();
	      }
	  }
	public List<String> findItinerary(String[][] tickets) {
		HashMap<String,Node> map=new HashMap<String,Node>();
		 Node cur;
           for(int i=0;i<tickets.length;i++){
        		   if(map.containsKey(tickets[i][0])){
        			    cur=map.get(tickets[i][0]);
        		   }else{
        			   map.put(tickets[i][0], new Node(tickets[i][0]));
        			   cur=map.get(tickets[i][0]);
        		   }
        		   
        		   if(map.containsKey(tickets[i][1]))
     			      insertNextNode(cur,map.get(tickets[i][1]));
     			   else {
     				   map.put(tickets[i][1], new Node(tickets[i][1]));
     				   insertNextNode(cur,map.get(tickets[i][1]));
     			   }
           }
           
          Node curNode=map.get("JFK");
          Stack<Node> s=new Stack<Node>();
          s.push(curNode);
          List<String> list=new ArrayList<String>();
        //  list.add(curNode.val);
          while(!s.isEmpty()){
        	  while(map.containsKey(s.peek().val)&&!s.peek().next.isEmpty()){
        		  s.push(map.get(s.peek().val).next.remove(0));
        	  }
        	  list.add(0,s.pop().val);
          }
          return list;
    }
	
	public void insertNextNode(Node cur,Node n){
		List<Node> next=cur.next;
		int i=0;
        for(;next!=null&&i<next.size();i++){
        	if(next.get(i).val.compareTo(n.val)>0){
        		break;
        	}
        }
        next.add(i, n);
	}*/
	//别人的解法  DFS 用栈
/*	 public List<String> findItinerary(String[][] tickets) {
	        List<String> result = new ArrayList();
	        if(tickets == null || tickets.length == 0){
	            return result;
	        }
	        Map<String, ArrayList<String>> graph = new HashMap();

	        for(int i=0; i<tickets.length; i++){
	            if(!graph.containsKey(tickets[i][0])){
	                ArrayList<String> adj = new ArrayList();
	                adj.add(tickets[i][1]);
	                graph.put(tickets[i][0], adj);
	            }else{
	                ArrayList<String> newadj = graph.get(tickets[i][0]);
	                newadj.add(tickets[i][1]);
	                graph.put(tickets[i][0], newadj);
	            }
	        }
	        for(ArrayList<String> a : graph.values()){
	            Collections.sort(a);
	        }

	        Stack<String> stack = new Stack();
	        stack.push("JFK");

	        while(!stack.isEmpty()){

	            while(graph.containsKey(stack.peek()) && !graph.get(stack.peek()).isEmpty()){
	                stack.push(graph.get(stack.peek()).remove(0));
	            }
	            result.add(0,stack.pop());
	        }
	        return result;
	    }*/
	
	//别人的解法 回溯
	 public List<String> findItinerary(String[][] tickets) {
	        List<String> result = new ArrayList();
	        if(tickets == null || tickets.length == 0){
	            return result;
	        }

	        Map<String, ArrayList<String>> graph = new HashMap();
	        for(int i=0; i<tickets.length; i++){
	            if(!graph.containsKey(tickets[i][0])){
	                ArrayList<String> adj = new ArrayList();
	                adj.add(tickets[i][1]);
	                graph.put(tickets[i][0], adj);
	            }else{
	                ArrayList<String> newadj = graph.get(tickets[i][0]);
	                newadj.add(tickets[i][1]);
	                graph.put(tickets[i][0], newadj);
	            }
	        }

	        for(ArrayList<String> a : graph.values()){
	            Collections.sort(a);
	        }

	        backtracing(result, "JFK", graph);

	        return result;
	    }

	    public void backtracing(List<String> result, String current, Map<String, ArrayList<String>> graph){
	        while(graph.containsKey(current) && !graph.get(current).isEmpty()){
	            String s = graph.get(current).remove(0);
	            backtracing(result, s, graph);
	        }
	        result.add(0,current);
	    }
	 
	public static void main(String[] args){
		ReconstructItinerary332 r=new ReconstructItinerary332();
		String[][] tickets={{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
		List<String> rs=r.findItinerary(tickets);
		for(int i=0;i<rs.size();i++){
			System.out.print(rs.get(i)+"-->");
		}
	}
}
