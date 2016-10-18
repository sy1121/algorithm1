package algorithm;

public class OddEvenLinkedList328 {
	//AC 1ms
    public ListNode oddEvenList(ListNode head) {
    	if(head==null) return null;
        ListNode evenNode=new ListNode(0);
        ListNode teven=evenNode;
        ListNode rnode=head;
        while(head!=null&&head.next!=null){
            teven.next=head.next;
            head.next=head.next.next;
            teven=teven.next;
            teven.next=null;
            
            if(head.next!=null)
            head=head.next;
        }
        head.next=evenNode.next;
        return rnode;
    }
    
    public static void main(String[] args){
    	OddEvenLinkedList328 o=new OddEvenLinkedList328();
    	ListNode node1=new ListNode(1);
    	ListNode node2=new ListNode(2);
    	ListNode node3=new ListNode(3);
    	ListNode node4=new ListNode(4);
    	ListNode node5=new ListNode(5);
    	ListNode node6=new ListNode(6);
    	ListNode node7=new ListNode(7);
    	ListNode node8=new ListNode(8);
    	node1.next=node2;
    	node2.next=node3;
    	node3.next=node4;
    	node4.next=node5;
    	node5.next=node6;
    	node6.next=node7;
    	node7.next=node8;
    	ListNode rnode=o.oddEvenList(node1);
    	while(rnode!=null){
    		System.out.print(rnode.val+"-->");
    		rnode=rnode.next;
    	}
    }
}
