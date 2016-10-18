package jianzhioffer;

public class T10 {
    public int NumberOf1(int n){
    	int count=0;
    	while(n>0){
    		count++;
    		n=n&(n-1);
    	}
    	return count;
    }
    
    
    public static void main(String[] args){
    	T10 t=new T10();
    	int r=t.NumberOf1(9);
    	System.out.println(r);
    }
}
