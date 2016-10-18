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
		 Stack<ListNode> s=new Stack<ListNode>();  //�ȰѸ����ڵ㱣�浽ջ� Ȼ��Ӻ���ǰ����
		    ListNode rnode=null;     //��¼��� 
	        while(head!=null){
	        	s.push(new ListNode(head.val));
	        	head=head.next;
	        }
	        while(!s.isEmpty()){  
	          ListNode lnode=s.pop(); //ÿ�γ�һ���ڵ�  
	        //  lnode.next=null;
	          if(rnode==null){   //����Ǵ���ĵ�һ���ڵ㣨β�ڵ㣩
	        	  rnode=new ListNode(lnode.val); 
	          }else{
	        	ListNode tnode=rnode,preNode=null;
	            while(tnode!=null){   //ȥ�ҵ������λ��
	        	  if(lnode.val<tnode.val){
	        		  lnode.next=tnode;
	        		  if(preNode!=null)  
	        		  preNode.next=lnode;
	        		  else{     //�ȵ�ǰһ��������ĵ�һ��Ԫ�ػ�ҪС 
	        			 rnode=lnode;
	        		  }
	        		  break;
	        	  }else{
	        		  preNode=tnode;
	        		  tnode=tnode.next;
	        	  }
	           }
	            
	            if(tnode==null) preNode.next=lnode;  //�ȵ�ǰ������ڵ��ֵ���󣬲嵽����������β��
	          }
	        }
	        return rnode;
	    }*/
	 //���Ǳ��˵ıȽ������Ľⷨ��ѧϰѧϰ
	 // ��ǰ�����
	 public ListNode insertionSortList(ListNode head) {
		    if (head == null || head.next == null)
		    {
		        return head;
		    }
           //������ָ��ָ��ǰ����������  
		    ListNode sortedHead = head, sortedTail = head;
		    head = head.next; //�ӵڶ���Ԫ�ؿ�ʼ����
		    sortedHead.next = null;

		    while (head != null)  
		    {
		        ListNode temp = head; 
		        head = head.next;  //��headָ��������һ���������Ԫ��
		        temp.next = null; //��õ�ǰ�����Ԫ��

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
