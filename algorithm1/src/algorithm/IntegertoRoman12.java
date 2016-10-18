package algorithm;

public class IntegertoRoman12 {
	//AC 15ms
	 public String intToRoman(int num) {
	         String[][] p=
	         {{"","I","II","III","IV","V","VI","VII","VIII","IX"},
	            {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
	            {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
	            {"","M","MM","MMM"}};
	         StringBuilder s=new StringBuilder("");
	         int index=0;
	         while(num>0){
	                int temp=num%10;
	                s.insert(0,p[index++][temp]);
	                num=num/10;
	        }
	        return  s.toString();
	         
	    }
	 
	 public static void main(String[] args){
		 IntegertoRoman12 i=new IntegertoRoman12();
		 String r=i.intToRoman(1000);
		 System.out.println("result="+r);
	 }
}
