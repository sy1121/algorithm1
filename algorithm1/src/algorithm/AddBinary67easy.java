package algorithm;

import java.util.Arrays;

public class AddBinary67easy {
	//AC 4ms
    public String addBinary(String a, String b) {
        int sign=0;
        StringBuffer result=new StringBuffer();
        int alength=a.length(),blength=b.length();
        int temp=0;
        while(alength>0||blength>0){
        	if(alength>0){
        	temp+=(a.charAt(alength-1)-'0');
        	alength--;
        	}
        	if(blength>0){
        		temp+=b.charAt(blength-1)-'0';
        		blength--;
        	}
        	temp+=sign;
        	result.append((char) (temp%2+'0'));
        	sign=temp/2;
        	temp=0;
        }
          if(sign>0) result.append("1");
        return result.reverse().toString();
    }
    
    public static void main(String[] args){
    	AddBinary67easy a=new AddBinary67easy();
    	String r=a.addBinary("1111001", "111000111");
    	System.out.println("result="+r);
    }
}
