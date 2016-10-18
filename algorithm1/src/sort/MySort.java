package sort;

public class MySort {
		/*    public static void insertSort(int[] A){
		    int size=A.length;
		    for(int i=1;i<size;i++){
		    for(int j=i;j>0&&A[j]<A[j-1];j--)
		    swap(A,j,j-1);
		    }
		    }*/
		    
		    private static void swap(int[] A,int i,int j){
		    int temp=0;
		    temp=A[j];
		    A[j]=A[i];
		        A[i]=temp;
		    }
		  /**  
		     * ��������<br/>  
		     * <ul>  
		     * <li>�ӵ�һ��Ԫ�ؿ�ʼ����Ԫ�ؿ�����Ϊ�Ѿ�������</li>  
		     * <li>ȡ����һ��Ԫ�أ����Ѿ������Ԫ�������дӺ���ǰɨ��</li>  
		     * <li>����Ԫ�أ������򣩴�����Ԫ�أ�����Ԫ���Ƶ���һλ��</li>  
		     * <li>�ظ�����3��ֱ���ҵ��������Ԫ��С�ڻ��ߵ�����Ԫ�ص�λ��</li>  
		     * <li>����Ԫ�ز��뵽��λ����</li>  
		     * <li>�ظ�����2</li>  
		     * </ul>  
		     *   
		     * @param numbers  
		     */  
		    public static void insertSort(int[] numbers) {   
		        int size = numbers.length, temp, j;   
		        for(int i=1; i<size; i++) {   
		            temp = numbers[i];   
		            for(j = i; j > 0 && temp < numbers[j-1]; j--)   
		                numbers[j] = numbers[j-1];   
		            numbers[j] = temp;   
		        }   
		    }
		    
		    /**
		     * ð������
		     * �����һ����ǰ�ң������Ԫ�ر�ǰһ��Ԫ��С���򽻻���ÿһ��ѭ���ҵ���С���Ǹ�Ԫ�أ���һ���ҵ�������С�ķ���
		     * ��һ�����ڶ����ҵ����ǵڶ�С�ķ��ڵڶ���
		     * @param numbers
		     */
		    public static void bubbleSort(int[] numbers){
		    int size=numbers.length;
		    for(int i=0;i<size-1;i++){
		    for(int j=size-1;j>i;j--){
		    if(numbers[j]<numbers[j-1])
		    swap(numbers,j,j-1);
		    }
		    }
		    }
		    
		    /**
		     * ѡ������
		     * @param numbers
		     */
		    public static void selectSort(int[] numbers){
		    int size=numbers.length,temp,min,lowIndex;
		    for(int i=0;i<size-1;i++){
		    lowIndex=i;
		    for(int j=i;j<size;j++){
		    if(numbers[lowIndex]>numbers[j])
		    lowIndex=j;
		    }
		         //������Сֵ�͵�ǰֵ
		    swap(numbers,i,lowIndex);
		    }
		    }
		   //shell����
		    /**
		     * shell����
		     * �Ѵ������б�ɾ������� �������ò������������  �Ƚ��������O(n2)���Ӷ�Ҫ��
		     * �������һ����16��������������ȷ�Ϊ���飨0,8����1,9��...Ϊһ�飬ÿһ���ò��������ź� �������8
		     * ���Ű���ݷ�Ϊ4�飨0,4,8��12��...Ϊһ�飬���Ų������� �����4
		     * ...
		     * ����Ǽ��Ϊ1����ͨ��������
		     * @param numbers
		     */
		    public static void shellSort(int[] numbers){
		    int size=numbers.length;
		    for(int i=size/2;i>=2;i/=2){
		    for(int j=0;j<i;j++){
		            inssort(numbers,j,i);
		    }
		    inssort(numbers,0,1);
		    }
		    }
		    
		    private static void inssort(int[] numbers,int from,int incr){
		    int size=numbers.length;
		    for(int i=incr+from;i<size;i+=incr){
		    for(int j=i;(j>=incr+from)&&numbers[j]<numbers[j-incr];j-=incr)
		    swap(numbers,j,j-incr);
		    }
		    }
		    
		    /**
		     * shell ����
		     * ���ϵ�д��������ÿ�γ���3�ķ���
		     * @param data
		     */
		    public static void shellSort1(int[] data) {  
		        // ���������hֵ  
		        int h = 1;  
		        while (h <= data.length / 3) {  
		            h = h * 3 + 1;  
		        }  
		        while (h > 0) {  
		            for (int i = h; i < data.length; i += h) {  
		                if (data[i] < data[i - h]) {  
		                    int tmp = data[i];  
		                    int j = i - h;  
		                    while (j >= 0 && data[j] > tmp) {  
		                        data[j + h] = data[j];  
		                        j -= h;  
		                    }  
		                    data[j + h] = tmp;  
		                    printNums(data);  
		                }  
		            }  
		            // �������һ��hֵ  
		            h = (h - 1) / 3;  
		        }  
		    }  
		    
		    /**
		     * ��������
		     * partition�����ֵ��������зָ�
		     * quicksork�����ֵ���еݹ����
		     * ��˼�룺ѡ��һ����׼Ԫ��,ͨ��ѡ���һ��Ԫ�ػ������һ��Ԫ��,ͨ��һ��ɨ�裬
		     * ���������зֳ�������,һ���ֱȻ�׼Ԫ��С,һ���ִ��ڵ��ڻ�׼Ԫ��,��ʱ��׼Ԫ������
		     * �ź�������ȷλ��,Ȼ������ͬ��ķ����ݹ�����򻮷ֵ������֡�
		     * @param numbers
		     */
		    public static void quicksort(int n[],int left,int right){
		    int dp;
		    if(left<right){
		    dp=partition(n,left,right);
		    quicksort(n,left,dp-1);
		    quicksort(n,dp+1,right);
		     }			
		    }
		    
		    private static int partition(int n[],int left,int right){
		    int pivot=n[left];
		    while(left<right){
		    while(left<right&&n[right]>=pivot)
		    right--;
		    n[left]=n[right];//������С�ļ�¼�Ƶ��Ͷ�
		        while(left<right&&n[left]<=pivot)
		        left++;
		            n[right]=n[left];//�������ļ�¼�Ƶ��߶�
		    }
		    n[left]=pivot;  //����ֵ��¼���м�λ��
		    return left;
		    }
		    
		    /*
		     * 
		     * �鲢����
		     */
		    public static void mergeSort(int[] n,int left,int right){
		    //�������С��ʱ��ֱ��ʹ�ò�������,Ч����
		    /*if(right-left<8){
		    insertSort(n);  
		    }*/
		        if(left<right){
		        int middle = (left+right)/2;
		        mergeSort(n,left,middle);
		        mergeSort(n,middle+1,right);
		        merge(n,left,middle+1,right);
		        }
		    }
		    
		    private static void merge(int[] n,int left,int middle,int right){
		         int[] temp=new int[right-left+1];
		         int i=left,j=middle,k=0;
		         while(i!=middle&&j!=right+1){
		         if(n[i]<n[j])
		         temp[k++]=n[i++];
		         else
		         temp[k++]=n[j++];
		         }
		          while(i!=middle)
		          temp[k++]=n[i++];
		          while(j!=right+1)
		          temp[k++]=n[j++];
		          for(int h=0;h<temp.length;h++){
		          n[left++]=temp[h];
		          }
		    }
		    
		    /**
		     * �������������ҵ�K���Ԫ�أ�
		     * ������ȫ���������������ʾ���ڵ�k�����ӽڵ�Ϊ2*k+1,���ӽڵ�Ϊ2*k+2,���ڵ�Ϊ(k-1)/2
		     * �� ��ʼ����������R[1..n]����Ϊ��ʼ�ѣ�

		        �� ÿһ������Ļ����������ǰ������ĶѶ���¼R[1]�͸��������һ����¼������Ȼ���µ����������Ϊ��(����ؽ���)��
		ע�⣺ 
		��ֻ����n-1������ѡ���ϴ��n-1���ؼ��ּ�����ʹ���ļ���������
		����С������������ô������ƣ�ֻ�������������ǵݼ�����ġ��������ֱ��ѡ�������෴��
		���κ�ʱ�̶�������������������������֮ǰ��������������ԭ������β���ɺ���ǰ���������������Ϊֹ��
		     * @param data
		     */
		    public static void heapSort(int[] data) {  
		        for (int i = 0; i < data.length; i++) {  
		            createMaxdHeap(data, data.length - 1 - i);  
		            swap(data, 0, data.length - 1 - i);  
		           // print(data);  
		        }  
		    }  
		  
		    private static void createMaxdHeap(int[] data, int lastIndex) {  //
		        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {   //�ӵ���ڶ��㿪ʼ
		            // ���浱ǰ�����жϵĽڵ�  
		            int k = i;  
		            // ����ǰ�ڵ���ӽڵ����  
		            while (2 * k + 1 <= lastIndex) {  //����Ҷ�ӽڵ�
		                // biggerIndex���Ǽ�¼�ϴ�ڵ��ֵ,�ȸ�ֵΪ��ǰ�жϽڵ�����ӽڵ�  
		                int biggerIndex = 2 * k + 1;  
		                if (biggerIndex < lastIndex) {  
		                    // �����ӽڵ���ڣ������ʱbiggerIndexӦ�õ��� lastIndex  
		                    if (data[biggerIndex] < data[biggerIndex + 1]) {  
		                        // �����ӽڵ�ֵ�����ӽڵ�ֵ����biggerIndex��¼�������ӽڵ��ֵ  
		                        biggerIndex++;  
		                    }  
		                }  
		                if (data[k] < data[biggerIndex]) {  
		                    // ����ǰ�ڵ�ֵ���ӽڵ����ֵС���򽻻�2�ߵ�ֵ��������biggerIndexֵ��ֵ��k  
		                    swap(data, k, biggerIndex);  
		                    k = biggerIndex;  
		                } else {  
		                    break;  
		                }  
		            }  
		        }  
		    } 
		    
		   /**
		    * �������� 
		    * @param n  
		    * @param r   ����
		    * @param k   λ��ؼ��볤�ȣ�
		    */
		   public static void radixSort(int[] n,int r,int k){
		  int size=n.length;
		  int[] temp=new int[size];  
		  int[] cnt=new int[size];   //��¼ÿ��������ĸ���
		  for(int i=0,rtok=1;i<k;i++,rtok*=r){
		  for(int j=0;j<r;j++) cnt[j]=0;//��ʼ������
		  for(int j=0;j<size;j++) cnt[(n[j]/rtok)%r]++; //����ÿ��Ͱ��Ӧ���ж��ٸ���¼
		  for(int j=1;j<r;j++) cnt[j]=cnt[j]+cnt[j-1]; //������ת��������
		  for(int j=size-1;j>=0;j--) temp[--cnt[(n[j]/rtok)%r]]=n[j]; //�Ӻ���ǰ���Ѹ����������ȷ��λ����
		  for(int j=0;j<size;j++) n[j]=temp[j];  
		  }
		   }
		    
		    public static void printNums(int[] numbers){
		    int size=numbers.length;
		    for(int i=0;i<size;i++){
		       System.out.print(numbers[i]+" ");
		    }
		    System.out.println();
		    }
		    public  static void main(String [] args){
		    int[] numbers={8,1,1,20,12,3,5,2,3,1,5,35,5};
		    //int[] numbers={12,1,2,3,4,5,6,7,8,9,10,11};
		    MySort.shellSort(numbers);//(numbers,10,2);
		    MySort.printNums(numbers);
		    }
		    
}
