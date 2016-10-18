package algorithm;

public class CountandSay38 {
	//AC 8ms
	 public String countAndSay(int n) {
	         int count=1,len;
	         String curStr="";
	         StringBuilder lastStr=new StringBuilder("1#");
	         while(count!=n){
	        	 curStr=lastStr.toString();
	        	 lastStr=new StringBuilder("");
	        	 len=0;
	        	 for(int i=1;i<curStr.length();i++){
	        		 len++;
	        		 if(curStr.charAt(i)!=curStr.charAt(i-1)){
	        			 lastStr.append(len);
	        			 lastStr.append(curStr.charAt(i-1));
	        			 len=0;
	        		 }
	        	 }
	        	 lastStr.append("#");
	        	 count++;
	         }
	         return lastStr.toString().replace("#", "");
	    }
	 
	 public static void main(String[] args){
		 CountandSay38 c=new CountandSay38();
		 String s=c.countAndSay(10);
		 System.out.println("s="+s);
	 }
}
