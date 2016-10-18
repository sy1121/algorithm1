package algorithm;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class BasicCalculatorII227 {
	// ac 74ms   
	/**
	 * ˼·������ջ�ֱ��¼���ֺͷ��� ������ɨ���ַ�����ÿһλ���������ִ����ѹ�������ջ���������ţ������ǰ����ջ�գ���ֱ��ѹ��ջ�У�������գ���Ҫ��
	 * ��ǰ���ź͵�ǰջ���ķ��ŵ����ȼ�������ǰ���ŵ����ȼ�С�ڵ���ջ���ķ��ŵ����ȼ����򵯳�ջ�����ţ��ٴ�����ջ�е����������֣�������ѹ�뵽����ջ�У�
	 * �ظ�������̣�ָ������ջΪ�ջ��߷���սջ��Ԫ�����ȼ��ȵ�ǰ����С���ٽ���ǰ�ַ�ѹ�����ջ��
	 * ɨ�����ַ������ٴ�������ջ����������ͬ�ķ�ʽ��ֱ������ջΪ�գ��Ϳɼ�������
	 * @param s
	 * @return
	 */
	   public int calculate(String s) {
	       int length=s.length();
	       Stack<Character> sstack=new Stack<Character>();
	       Stack<Integer> nstack=new Stack<Integer>();
	       for(int i=0;i<length;i++){
	    	   if(Character.isDigit(s.charAt(i))){
	    		  int sum=s.charAt(i)-'0';
	    		  while(i+1<length&&Character.isDigit(s.charAt(i+1))){
	    			  sum=sum*10+s.charAt(i+1)-'0';
	    			  i++;
	    		  }
	    		  nstack.push(sum);
	    	   }else {
	    		   if(s.charAt(i)==' ') continue;
	    		   else if(s.charAt(i)=='+'||s.charAt(i)=='-'){
	    			   if(sstack.isEmpty())
	    			   sstack.push(s.charAt(i));
	    			   else{
	    				   while(!sstack.isEmpty()){
	    				   char currentSign=sstack.pop();
	    				   int firstOpr=nstack.pop();
	    				   int secondOpr=nstack.pop();
	    				   nstack.push(suan(secondOpr,firstOpr,currentSign));
	    				   }
	    				   sstack.push(s.charAt(i));
	    			   }
	    		   }else{
	    			   if(sstack.isEmpty())
		    			   sstack.push(s.charAt(i));
	    			   else {
	    				   char preSign=sstack.peek();
	    				   if(preSign=='*'||preSign=='/'){
	    					   char currentSign=sstack.pop();
		    				   int firstOpr=nstack.pop();
		    				   int secondOpr=nstack.pop();
		    				   nstack.push(suan(secondOpr,firstOpr,currentSign));
	    				   } 
	    				   sstack.push(s.charAt(i));
	    			   }
	    		   }
	    	   }
	       }

	       while(!sstack.isEmpty()){
	    	   char currentSign=sstack.pop();
			   int firstOpr=nstack.pop();
			   int secondOpr=nstack.pop();
			   nstack.push(suan(secondOpr,firstOpr,currentSign));
	       }
	        return nstack.pop();
	      
	    }
	   
	   public int suan(int num1,int num2,char sign){
			 int result=0;
			 switch(sign){
			 case '+':
				 result= num1+num2;break;
			 case '-':
				 result= num1-num2;break;
			 case '*':
				 result=num1*num2;break;
			 case '/':
				 result=num1/num2;break;
			 }
			 return result;
		 }
  	public static void main(String[] args){
		 BasicCalculatorII227 b=new BasicCalculatorII227();
		 int r=b.calculate(" 3+5 / 2 ");
		 System.out.println("r="+r);
	 }
}
