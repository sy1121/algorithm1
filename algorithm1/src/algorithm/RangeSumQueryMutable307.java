package algorithm;

public class RangeSumQueryMutable307 {
	//AC   7ms  数据结构 树状数组
	int bubsum[];
	int num[];
	int size;
    public RangeSumQueryMutable307(int[] nums) {
    	init(nums);
    }
    
    public void init(int[] nums){
        size=nums.length;
    	bubsum=new int[size+1];
    	num=new int[size];
    	for(int i=0;i<nums.length;i++){
    		bubsum[i+1]=nums[i];
    		num[i]=nums[i];
    	}
    	int i=1;
    	int bar;
    	while(i<size+1){
    	    int lowbit=((i-1)^i)&i;
    	    bar=i+lowbit;
    	    if(bar<=size)
    	    bubsum[bar]+=bubsum[i];
    	    i++;
    	}
    }
    
    public int getSum(int i){
    	if(i<1) return 0;
    	int sum=0,bar,lowbit;
    	while(i>0){
    		sum+=bubsum[i];
    		lowbit=((i-1)^i)&i;
    		i-=lowbit;
    	}
    	return sum;
    }

    void update(int i, int val) {
        int dif=val-num[i];
        int lowbit;
        int temp=i+1;
        while(temp<size+1){
        	bubsum[temp]+=dif;
        	lowbit=((temp-1)^temp)&temp;
        	temp+=lowbit;
        }
        num[i]=val;
    }

    public int sumRange(int i, int j) {
        return getSum(j+1)-getSum(i);
    }
    
    public static void main(String[] args){
    	int[] nums={1,3,2,5,6,3,5,6};
    	RangeSumQueryMutable307 r=new RangeSumQueryMutable307(nums);
    	int sum=r.sumRange(1, 4);
    	System.out.println("sum="+sum);
    	r.update(3, 4);
    	int sum1=r.sumRange(2, 5);
    	System.out.println("sum1="+sum1);
    	
    }
}
