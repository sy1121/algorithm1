package jianzhioffer;

public class T9 {
    public long Fibonacci(int n){
    	 if(n<=2) return 1;
         int one=1,two=1,fib=0;
         for(int i=2;i<n;i++){
        	 fib=one+two;
        	 one=two;
        	 two=fib;
         }
         return fib;
    }
    
    public static void main(String[] args){
    	T9 t=new T9();
        long r=t.Fibonacci(5);
        System.out.println(r);
        for(int i=1;i<20;i++){
        	System.out.print(t.Fibonacci(i)+" ");
        }
    }
}
