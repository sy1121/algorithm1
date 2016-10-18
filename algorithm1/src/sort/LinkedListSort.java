package sort;

import java.util.Random;

public class LinkedListSort {
     //quickSort
	 public void quickSort(Node p,Node q){
	    if(p!=q){
	    	Node pivot=findPos(p,q);
	    	quickSort(p,pivot);
	        quickSort(pivot.next,q);
	    }
	 }
	 
	 private Node findPos(Node left,Node right){
		  Node p=left;
		  Node q=left.next;
		  int key=left.val;
		  while(q!=right){
			  if(key>q.val){
				  p=p.next;
				  swap(p,q);
			  }
			  q=q.next;
		  }
		  swap(left,p);
		  return p;
	 }
	 
	 private void swap(Node p,Node q){
		  int temp=p.val;
		  p.val=q.val;
		  q.val=temp;
	 }
	 
	 //归并排序
	 public Node mergeSort(Node head){
		 if(head==null||head.next==null) return head;
		 Node slow=head,fast=head.next;
		 while(fast!=null&&fast.next!=null){
			 slow=slow.next;
			 fast=fast.next.next;
		 }
		 Node rHead=mergeSort(slow.next);
		 slow.next=null; 
		 Node lHead=mergeSort(head);
		 return merge(lHead,rHead);
	 }
	 
	 private Node merge(Node left,Node right){
		 Node dummy=new Node(0);
		 Node temp=dummy;
		 while(left!=null&&right!=null){
			 if(left.val<right.val) {
				 temp.next=left;
				 left=left.next;
			 }else{
				 temp.next=right;
				 right=right.next;
			 }
				 temp=temp.next;
		 }
		 temp.next=left==null?right:left;
		 return dummy.next;
	 }
	 
	 
	 
	 public static void main(String[] args){
/*		 Node node1=new Node(7);
		 Node node2=new Node(6);
		 Node node3=new Node(4);
		 Node node4=new Node(5);
		 Node node5=new Node(4);
		 Node node6=new Node(2);
		 Node node7=new Node(12);
		 node1.next=node2;
		 node2.next=node3;
		 node3.next=node4;
		 node4.next=node5;
		 node5.next=node6;
		 node6.next=node7;*/
		 Node[] nodes=new Node[7];
		 Random random=new Random();
		 for(int i=6;i>=0;i--){ 
			 nodes[i]=new Node(random.nextInt());
			 if(i==6) nodes[i].next=null;
			 else nodes[i].next=nodes[i+1];
		 }
		 LinkedListSort s=new LinkedListSort();
		 //s.quickSort(nodes[0], null);
		 Node cur=s.mergeSort(nodes[0]);
		 while(cur!=null) {
			 System.out.println(cur.val);
			 cur=cur.next;
		 }
	 }
	 
}
