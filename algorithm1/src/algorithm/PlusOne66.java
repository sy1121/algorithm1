package algorithm;

import java.util.Arrays;

public class PlusOne66 {
	
	//Ac 0ms
	public int[] plusOne(int[] digits) {
        int len=digits.length;
        int i=len-1;
        while(i>=0&&digits[i]==9){
        	digits[i--]=0; 
        }
        if(i<0){
            int[] r=new int[len+1];
            r[0]=1;
            return 	r;
        }else{
            digits[i]=digits[i]+1;
            return  digits;
        }
    }
	
	public static void main(String[] args){
		PlusOne66 p=new PlusOne66();
		int[] r=p.plusOne(new int[]{9,9,9,9});
		for(int i=0;i<r.length;i++){
			System.out.print(r[i]+",");
		}
	}
}
