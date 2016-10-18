package jianzhioffer;

import java.util.LinkedList;
import java.util.List;

/**
 * 约瑟夫问题： 圆圈中最后剩下的数字
 * @author sy
 *
 */
public class T45 {
	//公式
    public int lastRemain(int n,int m){
    	 if(n<1||m<1) return -1;
    	 int last=0;
    	 for(int i=2;i<=n;i++){
    		 last=(last+m)%i;
    	 }
    	 return last;
    }
    //模拟
    public  int lastRemain1(int n,int m){
    	if(n<1||m<1) return -1;
    	List<Integer> list=new LinkedList<Integer>();
        for(int i=0;i<n;i++){
        	 list.add(i);
        }
        int k=0;
        while(list.size()>1){
        	k=k+m;
        	k=(k%list.size())-1;
        	if(k<0){
        		list.remove(list.size()-1);
        		k=0;
        	}else{
        		list.remove(k);
        	}
        }
        return list.get(0);
    }
    
    
    public static void main(String[] args){
    	T45 t=new T45();
    	int r1=t.lastRemain(4000, 997);
    	int r2=t.lastRemain1(4000, 997);
    	System.out.println(r1);
    	System.out.println(r2);
    	
    }
}
