package jianzhioffer;
/**
 * 二叉搜索树的后续遍历序列
 * @author sy
 *
 */
public class T24 {
    public boolean isPostSequence(int[] sequence){
    	if(sequence.length==0) return false;
        return isValid(sequence,0,sequence.length-1);
    }
    
    private boolean isValid(int[] nums,int left,int right){
    	int head=nums[right];
    	//左子树
    	int index=left;
    	while(index<=right){
    		if(nums[index]>head)
    			break;
    	     index++;
    	}
    	//保存找到的中间节点
    	int rhead=index;
    	//右子树
    	while(index<=right){
    		if(nums[index++]<head) return false;
    	}
    	//递归判断左子树
    	boolean l=true;
    	if(rhead-1>left) l=isValid(nums,left,rhead-1);
    	boolean r=true;
    	if(rhead<right-1) r=isValid(nums,rhead,right-1);
    	return l&&r;
    }
    
    public static void main(String[] args){
    	T24 t=new T24();
    	boolean r=t.isPostSequence(new int[]{7,4,6,5});
    	System.out.println(r);
    }
}
