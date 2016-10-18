package jianzhioffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 复杂链表的复制
 * @author sy
 *
 */
public class T26 {
	class RandomListNode {
		      int label;
		      RandomListNode next, random;
		      RandomListNode(int x) { this.label = x; }
		 };
		 
	 public RandomListNode copyRandomList(RandomListNode head) {
         if(head==null) return null;
         Map<RandomListNode,RandomListNode> map=new HashMap<RandomListNode,RandomListNode>();
         RandomListNode newhead=new RandomListNode(head.label);
         map.put(head,newhead);
         RandomListNode next=head,newNext=newhead;
         while(next.next!=null){
             newNext.next=new RandomListNode(next.next.label);
             map.put(next.next,newNext.next);
             next=next.next;
             newNext=newNext.next;
         }
         next=head;
         newNext=newhead;
         while(next!=null){
             if(next.random!=null){
                newNext.random=map.get(next.random);
             }
             next=next.next;
             newNext=newNext.next;
         }
         return newhead;
    }
}
