package algorithm;

public class PalindromeLinkedList234 {
	//AC 1ms  把前一半的链表转置
    public boolean isPalindrome(ListNode head) {
        if(head==null) return true;
        int nodeCount=0,half=0;
        boolean flag=false;
        ListNode thead=head;
        while(thead!=null){
        	 nodeCount++;
        	 thead=thead.next;
        }
       	half=nodeCount/2;
        if(nodeCount%2!=0) flag=true;
        
        ListNode pre=null,next=null;
        ListNode rhead=head;
        while(half>0){
            next=rhead.next;
            rhead.next=pre;
            pre=rhead;
            rhead=next;
            half--;
        }
         if(flag) rhead=rhead.next;
        while(rhead!=null&&pre!=null){
            if(rhead.val!=pre.val) return false; 
            rhead=rhead.next;pre=pre.next;
        }
        return true;
    }
    public static void main(String[] args){
    	PalindromeLinkedList234 p=new PalindromeLinkedList234();
    	ListNode node1=new ListNode(1);
    	ListNode node2=new ListNode(2);
    	ListNode node3=new ListNode(3);
    	ListNode node4=new ListNode(4);
    	ListNode node5=new ListNode(4);
    	ListNode node6=new ListNode(3);
    	ListNode node7=new ListNode(2);
    	ListNode node8=new ListNode(1);
    	node1.next=node2;
    	node2.next=node3;
    	node3.next=node4;
    	node4.next=node5;
    	node5.next=node6;
    	node6.next=node7;
    	node7.next=node8;
    	boolean r=p.isPalindrome(node1);
    	System.out.println("r="+r);
    }
}
