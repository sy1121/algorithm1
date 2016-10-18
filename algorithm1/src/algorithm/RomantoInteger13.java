package algorithm;

public class RomantoInteger13 {
	//AC 8ms
    public int romanToInt(String s) {
        char[] cs=s.toCharArray();
        int result=0;
        for(int i=0;i<cs.length;i++){
        	if(i==cs.length-1||chartoint(cs[i])>=chartoint(cs[i+1])){
        		result+=chartoint(cs[i]);
        	}else{
        		result+=chartoint(cs[i+1])-chartoint(cs[i]);
        		i++;
        	}
        }
        return result;
    }
    
    public int chartoint(char c){
    	int r;
    	switch(c){
    	case 'I':r=1;break;
    	case 'V':r=5;break;
    	case 'X':r=10;break;
    	case 'L':r=50;break;
    	case 'C':r=100;break;
    	case 'D':r=500;break;
    	case 'M':r=1000;break;
    	default:r=0;break;
    	}
    	return r;
    }
    
    public static void main(String[] args){
    	RomantoInteger13 r=new RomantoInteger13();
    	int result=r.romanToInt("L");
    	System.out.println("result="+result);
    }
}
