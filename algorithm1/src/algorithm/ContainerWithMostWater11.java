package algorithm;

public class ContainerWithMostWater11 {
	//����û��������   �ؼ���û��������������˼�� 
	//����������������߷�����ָ�룬�ֱ���������   ÿ���ƶ������н�С��һ�� ֪������ָ������
	//���ַ�������ȷ�ԣ� ���赱ǰλ�ã�left��right������ȥ�����ֵ�����Ҽ����ʱheight[left]<height[right]������ô��right��
	//���ƣ���left�Ĳ��� ��ȡ�õ����������ȵ�ǰ�Ĵ� ����Ϊ��ǰleft��ƿ������������Щ�����Ƕ����  ;����Ӧ��ÿ���ƶ�С���Ǳ�
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
