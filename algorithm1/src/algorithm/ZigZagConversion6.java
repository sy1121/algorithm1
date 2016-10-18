package algorithm;

public class ZigZagConversion6 {
   public String convert(String s, int numRows) {
        int len=s.length();
        char[][] chars=new char[numRows][len];
        int[] index=new int[numRows];
        int count=0,rowIndex=0;
        int dir=1;
        while(count<len){
             chars[rowIndex][index[rowIndex]++]=s.charAt(count++);
             if(dir==1) rowIndex++;
             else rowIndex--;
             if(rowIndex>=numRows) {
            	 rowIndex-=2;
            	 dir=-1;
             }
             if(rowIndex<=-1){
            	 rowIndex+=2; 
            	 dir=1;
             }
        }
        StringBuffer rs=new StringBuffer("");
        for(int i=0;i<numRows;i++){
        	for(int j=0;j<index[i];j++){
        	    rs.append(chars[i][j]);
        	}
        }
        return rs.toString();
    }
   
   public static void main(String[] args){
	   ZigZagConversion6 z=new ZigZagConversion6();
	   String r=z.convert("PAYPALISHIRING",3);
	   System.out.println("r="+r);
   }
}
