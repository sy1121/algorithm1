package algorithm;

public class ReverseNodesinkGroup25 {
	//AC 1ms  线性复杂度   找到规律  处理好专职的顺序 
	//转置之后，相邻的两组中前一组的头节点要和后一组的尾节点相连 ，在原链表中就是前一组的第一个节点和后一组的最后一个节点相连
	//因此，在处理的过程中，我们只要对每一组的第一个节点和最后一个节点做处理，其他中间节点直接转方向就可以了
	//对于第一个节点，要记住它的位置，因为要后面把 它于下一组的最后一个节点连起来 ，又由于第一个节点与下一组的最后一个节点之间有一个下一组的第一个节点 因此要用两各变量
	//firstHead和second来记录
	//对于每一组的末节点，首先要把它的指针指向前一个节点，然后把firstHead的指针指向当前节点
	//最后把上剩余的不足一组的节点链表拼接在结果链表上
   public ListNode reverseKGroup(ListNode head, int k) {
            //计算节点数,组数
	      int nodeCount=0,groupCount=0,index=0,groupIndex=0;
	      ListNode thead=head;
	      while(thead!=null){
	    	  thead=thead.next;
	    	  nodeCount++;
	      }
	      groupCount=nodeCount/k;
	      if(groupCount<1||k==1) return head; 
	      ListNode firstHead=null,secondHead=null,preNode=null,nextNode=thead,tempNode=null,resultNode=null;
	      thead=head;
	      while(thead!=null&&groupIndex<groupCount){
	    	  index++;
	    	  nextNode=thead.next;
	    	 if(index%k==1){       //每组中的第一个节点
	    		 thead.next=null;
	    		 if(secondHead==null){
	    			 secondHead=thead;
	    		 }else{
	    			 firstHead=secondHead;
	    			 secondHead=thead;
	    		 }
	    	 }else if(index%k==0){   //每组中的最后一个节点
	    		 groupIndex++;
	    		 thead.next=preNode;
	    		 if(firstHead!=null){
	    			 tempNode=firstHead;
	    			 tempNode.next=thead;
	    		 }else{             
	    			resultNode=thead; 
	    		 }
	    	 }else{       //中间非特殊节点的处理
	    		 thead.next=preNode;
	    	 }
	    	 preNode=thead;
	    	 thead=nextNode;
	      }
	      if(secondHead!=null)
	         secondHead.next=nextNode;
	      return resultNode;
    }
   
   public static void main(String[] args){
	   ReverseNodesinkGroup25 r=new ReverseNodesinkGroup25();
	   ListNode head=new ListNode(1);
	   ListNode node1=new ListNode(2);
	   ListNode node2=new ListNode(3);
	   ListNode node3=new ListNode(4);
	   ListNode node4=new ListNode(5);
	   head.next=node1;
	   node1.next=node2;
	   node2.next=node3;
	   node3.next=node4;
	   ListNode rNode=r.reverseKGroup(head, 1);
	   while(rNode!=null){
		   System.out.print(rNode.val+" ");
		   rNode=rNode.next;
	   }
	   
   }
}
