package algorithm;

public class ReverseNodesinkGroup25 {
	//AC 1ms  ���Ը��Ӷ�   �ҵ�����  �����רְ��˳�� 
	//ת��֮�����ڵ�������ǰһ���ͷ�ڵ�Ҫ�ͺ�һ���β�ڵ����� ����ԭ�����о���ǰһ��ĵ�һ���ڵ�ͺ�һ������һ���ڵ�����
	//��ˣ��ڴ���Ĺ����У�����ֻҪ��ÿһ��ĵ�һ���ڵ�����һ���ڵ������������м�ڵ�ֱ��ת����Ϳ�����
	//���ڵ�һ���ڵ㣬Ҫ��ס����λ�ã���ΪҪ����� ������һ������һ���ڵ������� �������ڵ�һ���ڵ�����һ������һ���ڵ�֮����һ����һ��ĵ�һ���ڵ� ���Ҫ����������
	//firstHead��second����¼
	//����ÿһ���ĩ�ڵ㣬����Ҫ������ָ��ָ��ǰһ���ڵ㣬Ȼ���firstHead��ָ��ָ��ǰ�ڵ�
	//������ʣ��Ĳ���һ��Ľڵ�����ƴ���ڽ��������
   public ListNode reverseKGroup(ListNode head, int k) {
            //����ڵ���,����
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
	    	 if(index%k==1){       //ÿ���еĵ�һ���ڵ�
	    		 thead.next=null;
	    		 if(secondHead==null){
	    			 secondHead=thead;
	    		 }else{
	    			 firstHead=secondHead;
	    			 secondHead=thead;
	    		 }
	    	 }else if(index%k==0){   //ÿ���е����һ���ڵ�
	    		 groupIndex++;
	    		 thead.next=preNode;
	    		 if(firstHead!=null){
	    			 tempNode=firstHead;
	    			 tempNode.next=thead;
	    		 }else{             
	    			resultNode=thead; 
	    		 }
	    	 }else{       //�м������ڵ�Ĵ���
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
