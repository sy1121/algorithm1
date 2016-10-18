package jianzhioffer;

public class T11 {
   public double power(double base,int exponent){
	    if(equal(base,0.0)&&exponent<0){
	    	return 0.0;
	    }
	    double result=0.0;
	    if(exponent<0) result=1.0/powerWithUnsignedExponent(base,-exponent);
	    else result=powerWithUnsignedExponent(base,exponent);
	    return result;
   }
   
   
   private double powerWithUnsignedExponent(double base,int exponent){
	   if(exponent==0) return 1;
	   if(exponent==1) return base;
	   double result=powerWithUnsignedExponent(base,exponent>>1);
	   result*=result;
	   if((exponent&0x01)==1) result*=base;
	   return result;
   }
   private boolean equal(double num1,double num2){
	   if((num1-num2>-0.0000001)&&(num1-num2<0.00000001)) return true;
	   else return false;
   }
   
   public static void main(String[] args){
	   T11 t=new T11();
	   double r=t.power(-2, -3);
	   System.out.println(r);
   }
}
