package algorithm;

import java.util.Stack;

public class InsertionSortList147 {
	 public static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
	 
	 //AC 39ms
/*	 public ListNode insertionSortList(ListNode head) {
		 Stack<ListNode> s=new Stack<ListNode>();  //先把各个节点保存到栈里， 然后从后向前排序
		    ListNode rnode=null;     //记录结果 
	        while(head!=null){
	        	s.push(new ListNode(head.val));
	        	head=head.next;
	        }
	        while(!s.isEmpty()){  
	          ListNode lnode=s.pop(); //每次出一个节点  
	        //  lnode.next=null;
	          if(rnode==null){   //如果是处理的第一个节点（尾节点）
	        	  rnode=new ListNode(lnode.val); 
	          }else{
	        	ListNode tnode=rnode,preNode=null;
	            while(tnode!=null){   //去找到插入的位置
	        	  if(lnode.val<tnode.val){
	        		  lnode.next=tnode;
	        		  if(preNode!=null)  
	        		  preNode.next=lnode;
	        		  else{     //比当前一排序链表的第一个元素还要小 
	        			 rnode=lnode;
	        		  }
	        		  break;
	        	  }else{
	        		  preNode=tnode;
	        		  tnode=tnode.next;
	        	  }
	           }
	            
	            if(tnode==null) preNode.next=lnode;  //比当前已排序节点的值都大，插到结果链表的最尾部
	          }
	        }
	        return rnode;
	    }*/
	 //这是别人的比较清晰的解法，学习学习
	 // 从前向后排
	 public ListNode insertionSortList(ListNode head) {
		    if (head == null || head.next == null)
		    {
		        return head;
		    }
           //用两个指针指向当前已排序链表  
		    ListNode sortedHead = head, sortedTail = head;
		    head = head.next; //从第二个元素开始处理
		    sortedHead.next = null;

		    while (head != null)  
		    {
		        ListNode temp = head; 
		        head = head.next;  //将head指针移向下一个待处理的元素
		        temp.next = null; //获得当前处理的元素

		        // new val is less than the head, just insert in the front
		        if (temp.val <= sortedHead.val)
		        {
		            temp.next = sortedHead;
		            sortedTail = sortedHead.next == null ? sortedHead : sortedTail;
		            sortedHead = temp;
		        }
		        // new val is greater than the tail, just insert at the back
		        else if (temp.val >= sortedTail.val)
		        {
		            sortedTail.next = temp;
		            sortedTail = sortedTail.next;
		        }
		        // new val is somewhere in the middle, we will have to find its proper
		        // location.
		        else
		        {
		            ListNode current = sortedHead;
		            while (current.next != null && current.next.val < temp.val)
		            {
		                current = current.next;
		            }

		            temp.next = current.next;
		            current.next = temp;
		        }
		    }

		    return sortedHead;
		}
	 
	 public static void main(String[] args){
		 InsertionSortList147 i=new InsertionSortList147();
		 ListNode head=new ListNode(10);
		 ListNode node2=new ListNode(4);
		 ListNode node3=new ListNode(2);
		 ListNode node4=new ListNode(7);
		 ListNode node5=new ListNode(3);
		 ListNode node6=new ListNode(4);
		 ListNode node7=new ListNode(9);
		 head.next=node2;
		 node2.next=node3;
		 node3.next=node4;
		 node4.next=node5;
		 node5.next=node6;
		 node6.next=node7;
		 ListNode lnode=i.insertionSortList(head);
		 while(lnode!=null){
			 System.out.println(lnode.val+",");
			 lnode=lnode.next;
		 }
	 }
}
