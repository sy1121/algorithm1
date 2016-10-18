package algorithm;

public class ContainerWithMostWater11 {
	//这题没有做出来   关键是没有理清楚这里面的思想 
	//方法是在数组的两边方两个指针，分别往两边移   每次移动两个中较小的一个 知道两个指针相遇
	//这种方法的正确性： 假设当前位置（left，right）可以去到最大值（并且假设此时height[left]<height[right]），那么把right往
	//左移，而left的不动 ，取得的面积都不会比当前的大 （因为当前left是瓶颈）；所以这些计算是多余的  ;所以应该每次移动小的那边
	//AC  5ms
	  public int maxArea(int[] height) {
		  if(height.length<2) return  0;
	        int left=0,right=height.length-1,area=0;
	        while(left<right){
	           int  temparea=(right-left)*(height[left]<height[right]?height[left]:height[right]);
	            if(temparea>area){
	            	area=temparea;
	            }
	            if(height[left]<height[right]) left++;
	            else  right--;
	        }
	        return  area;
	    }
	  
}
