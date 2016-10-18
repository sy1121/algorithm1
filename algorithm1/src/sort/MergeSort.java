package sort;

public class MergeSort {
       public void MergeSort(int[] a,int left,int right){
    	   if(left<right){
    		   int middle=(left+right)/2;
    		   MergeSort(a,left,middle);
    		   MergeSort(a,middle+1,right);
    		   Merge(a,left,middle+1,right);
    	   }
       }
       
       public void Merge(int[]a,int left,int middle ,int right){
    	   int[] temp=new int[right-left+1];
    	   int i=left,j=middle,k=0;
    	   while(i!=middle&&j!=right+1){
    		   if(a[i]<a[j])
    			   temp[k++]=a[i++];
    		   else temp[k++]=a[j++];
    	   }
    	  while(i!=middle){
    		  temp[k++]=a[i++];
    	  }
    	  while(j!=right+1){
    		  temp[k++]=a[j++];
    	  }
    	  for(int h=0;h<temp.length;h++){
    		  a[left++]=temp[h];
    	  }
    	 
       }
       
       public static void main(String [] args){
    	   MergeSort ms=new MergeSort();
    	   int[] a={8,1,1,12,20,3,5,2,3,1,5,35,3};
    	   ms.MergeSort(a, 0, a.length-1);
    	   for(int i=0;i<a.length;i++){
    		   System.out.print(a[i]+"");
    		   System.out.println("");
    	   }
       }
}
