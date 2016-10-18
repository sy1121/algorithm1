package jianzhioffer;
/**
 * 数组仅出现一次的数字
 * @author sy
 *
 */
public class T40 {
     public int[] singleNumber(int[] nums) {
        int xandy=0;
        for(int i=0;i<nums.length;i++){
        	xandy^=nums[i];
        }
        int dif=xandy-(xandy&(xandy-1));
        int x=0,y=0;
        for(int i=0;i<nums.length;i++){
           if((nums[i]&dif)==0){
        	   x^=nums[i];
           }else y^=nums[i];
        }
        int[] r={x,y};
        return r;
    }
    public static void main(String[] args){
    	T40 t=new T40();
    	int[] nums=new int[]{2,4,3,6,3,2,5,5};
    	int[] r=t.singleNumber(nums);
    	for(int i=0;i<r.length;i++){
    		System.out.print(r[i]+" ");
    	}
    }
}
