package algorithm;

public class PartitionList86 {
	//AC 1ms
    public ListNode partition(ListNode head, int x) {
        ListNode  bbNode=new ListNode(0);
        ListNode thead=head,bNode=bbNode,preNode=null;
        while(thead!=null){
            if(thead.val<x) {
                preNode=thead;
                thead=thead.next;
            }
            else{
                bNode.next=thead;
                thead=thead.next;
                if(preNode!=null)
                preNode.next=thead;
                else
                head=thead;
                bNode=bNode.next;
                bNode.next=null;
            }
        }
        if(preNode!=null){
          preNode.next=bbNode.next;
            return head;
        }else 
        	return bbNode.next;
    }
    
    public static void main(String[] args){
    	PartitionList86 p=new PartitionList86();
    	ListNode node1=new ListNode(2);
    	ListNode node2=new ListNode(1);
    	ListNode node3=new ListNode(3);
/*    	ListNode node4=new ListNode(4);
    	ListNode node5=new ListNode(4);
    	ListNode node6=new ListNode(3);
    	ListNode node7=new ListNode(2);
    	ListNode node8=new ListNode(1);*/
    	node1.next=node2;
    	node2.next=node3;
/*    	node3.next=node4;
    	node4.next=node5;
    	node5.next=node6;
    	node6.next=node7;
    	node7.next=node8;*/
    	ListNode l=p.partition(node1, 2);
    	while(l!=null){
    	System.out.print(l.val+",");
    	  l=l.next;
    	}
    	}
}
