package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LongestPalindromicSubstring5 {
	//���ַ�����ʱ �����������
   /*public String longestPalindrome(String s) {
         HashMap<Character,List<Integer>>  map=new HashMap<Character,List<Integer>>();
         int len=s.length();
         if(len<2) return s;
         for(int i=len-1;i>=0;i--){
        	 if(map.containsKey(s.charAt(i))){
        		 map.get(s.charAt(i)).add(i);
        	 }else{
        		 List list=new ArrayList<Integer>();
        		 list.add(i);
        		 map.put(s.charAt(i), list);
        	 }
         }
         int result=0;
         int[] xy=new int[2];
         for(int i=0;i<len;i++){
        	 if(len-i<=result) break;
        	List list=map.get(s.charAt(i));
        	for(int j=0;j<list.size();j++){
        		int tail=(int)list.get(j);
        		int head=i;
        		boolean flag=true;
        		if(tail-head+1<result+1) break;
        		int temphead=head,temptail=tail;
        	    while(temphead<temptail){
        	    	if(s.charAt(temphead)==s.charAt(temptail)){
        	    		temphead++;temptail--;
        	    	}else{
        	    		flag=false;
        	    		break;
        	    	}
        	    }
        	    if(flag){
        	   result=tail-head+1; 
        	    xy[0]=head;
        	    xy[1]=tail;
        	    }
        	}
         }
         return s.substring(xy[0], xy[1]+1);
    }*/
   //���˵ķ���
/*	public String longestPalindrome(String s) {
	    if(s==null){
	        return "";
	    }
	   char[] arr = s.toCharArray();
	      int max = 0;
	      int maxi = 0;
	      int maxj = 0;

	      for(int i = 0; i< arr.length;){
	          int i1 = getFarestSameElementIndex(arr,i);
	          int dist = getDistance(arr,i,i1);
	          int index1 = i-dist;
	          int index2 = i1 + dist;
	          int l = index2 - index1;
	          if(l>max){
	                  max = l;
	              maxi = index1;
	              maxj = index2;
	          }
	          i = i1+1;  //����һ����ͬԪ��
	      }

	      return s.substring(maxi, maxj+1);
	}
    //index1����ߺ�index2���ұ߹��ɻ��ĵĳ���
	private int getDistance(char[] arr,int index1,int index2){
	    int i1 = index1-1;
	    int i2 = index2+1;
	    int dist = 0;
	    while(i1>=0&&i2<arr.length){
	        if(arr[i1]==arr[i2]){
	            dist++;
	        }else{
	            break;
	        }
	        i1--;i2++;
	    }
	    return dist;
	}
    //array[index]�ұ���������ͬԪ�ص��������
	private int getFarestSameElementIndex(char[] arr, int index){
	    for(int i = index+1;i<arr.length;i++){
	        if(arr[i]!=arr[index]){
	            return i-1;
	        }
	    }
	    return arr.length-1;
	}*/
	
	//AC 48ms
	
	 public String longestPalindrome(String s) {
		    if(s.isEmpty()) return s;
	        int len=s.length(),left,right;
	        char[] schar=s.toCharArray();
	        String r=s.charAt(0)+"";
	        for(int i=0;i<len;i++){
	        	left=i-1;
	        	right=i+1;
	        	while(left>=0&&schar[i]==schar[left]) left--;
	        	while(right<len&&schar[i]==schar[right]) right++;
	        	while(left>=0&&right<len&&schar[left]==schar[right]){
	        		left--;right++;
	        	}
	        	if(right-left-1>r.length()){
	        		r=s.substring(left+1,right);
	        	}
	        }
	        return r;
	    }
	
   public static void main(String[] args){
	   LongestPalindromicSubstring5 l=new LongestPalindromicSubstring5();
	   String s=l.longestPalindrome("dabdba");
	   System.out.println("result="+s);
   }
}
