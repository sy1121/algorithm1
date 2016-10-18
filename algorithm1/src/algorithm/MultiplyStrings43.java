package algorithm;

public class MultiplyStrings43 {
	
	//AC 36ms  比较差的算法
    public String multiply(String num1, String num2) {
         int num1Length=num1.length();
         int num2Length=num2.length();
         String[] unitResults=new String[num2Length];
         for(int i=num2Length-1;i>=0;i--){
        	 unitResults[i]=mult(num1,num2.charAt(i));
         }
           String r=sum(unitResults);
           r=trim0(r);
           if(r.equals("")) return "0";
           
           else
    	    return r;
    }
    
    public String trim0(String s){
    	int size=s.length();
    	int index=0;
    	for(int i=0;i<size;i++){
    		if(s.charAt(i)=='0')
    			index++;
    		else
    		    break;
    	}
    	return s.substring(index);
    }
    
    public String mult(String num,char mult){
    	int mul=mult-'0';
    	if(mul==0) return "0";
    	StringBuffer r=new StringBuffer("");
    	char[] nums=num.toCharArray();
    	int inc=0;
    	for(int i=nums.length-1;i>=0;i--){
    		int temp=(nums[i]-'0')*mul+inc;
    		r.append(temp%10);
    	    inc=temp/10;
    	}
    	if(inc>0)
    	r.append(inc);
    	return r.reverse().toString();
    }
    
    public String sum(String[] units){
    	int size=units.length;
    	String result="0";
    	StringBuffer suffix=new StringBuffer("");
    	for(int i=size-1;i>=0;i--){
    		if(i!=size-1)
    		suffix.append("0");
    	    result=addString(result,units[i]+suffix.toString());
    	}
    	return result;
    }
    
    public String addString(String s1,String s2){
    	int len1=s1.length();
    	int len2=s2.length();
    	int i=len1-1,j=len2-1;
    	int sign=0;
    	StringBuffer r=new StringBuffer("");
    	while(i>=0||j>=0||sign>0){
    	  int temp=0;
    	  if(i>=0)
    	  temp+=s1.charAt(i--)-'0';
    	  if(j>=0)
    	  temp+=s2.charAt(j--)-'0';
    	  if(sign>0)
    	  temp+=sign;
    	  r.append(temp%10);
    	  sign=temp/10;
    	}
    	return r.reverse().toString();
    }
    
    public static void main(String[] args){
    	MultiplyStrings43 m=new MultiplyStrings43();
    	String r=m.multiply("0", "100");
    	System.out.println("r="+r);
    }
}
