package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FractiontoRecurringDecimal166 {
	
	//AC 5ms
	  public String fractionToDecimal(int numerator, int denominator) {
		  long numerator1=0L,denominator1=0L; 
		  numerator1=Math.abs((long)numerator);
		  denominator1=Math.abs((long)denominator);
		  String s="";  //����
		   if(numerator>0&&denominator<0||numerator<0&&denominator>0) s="-";
	      long ipart=0; //�������ֵ�ֵ
	      int dcount=0;  //С�������м�λ
	      boolean flag=false;  //�Ƿ���ѭ��С��
	      StringBuilder dpartString=new StringBuilder("");  //С����λ���ɵ��ַ���
	      List<Long> dpart=new ArrayList<Long>();   //�洢С������ÿһλ��ֵ���б�
	      HashMap<Long,Integer> num=new HashMap<Long,Integer>(); //�ڼ���ѭ��С����ʱ�򣬼�����ֹ��ı���������ȷ��ѭ������һλ��ʼ
	      if(numerator1>denominator1){    //�ȼ�����������  
	    	   ipart=numerator1/denominator1;
	    	   numerator1=numerator1%denominator1;
	       }
		   if(numerator1==0) return s+ipart+"";   //�����������û��С�����֣�ֱ�ӷ���
		   numerator1*=10;          //�õ�������������10 ��������
		   while(numerator1!=0){     //֪��������������Ϊ��
			   if(num.containsKey(numerator1)){   //���������ֹ�˵����һ��ѭ��С��
				   flag=true;     //����ѭ��С����־ ��
				   break;     //�˳�ѭ��
			   }
			   while(numerator1<denominator1){  //�����ǰ�������ȷ�ĸС
				   dpart.add(0L);   //С��������0
				   dcount++;        //С��λ����1
				   num.put(numerator1, dcount);  //�ѵ�ǰ�ı���������hashMap�У�Ϊ����ȷ��ѭ��С��
				   numerator1*=10;    //����������10
			   }
			   long  d=numerator1/denominator1;   //����С�������ϼ�
			   dpart.add(d);    //��whileһ��
			   dcount++;      //С�����ּ�1
			   num.put(numerator1, dcount);
			   numerator1=numerator1%denominator1;
			   numerator1*=10;
		   }
		   
		   //��ʼƴ��С������
		    if(flag){  //�����ѭ��С��
		    	 int repindex=num.get(numerator1)-1; //����С���ִ���һλ��ʼѭ��
		    	for(int i=0;i<dpart.size();i++){ //�������ÿһλ  
		    		if(i==repindex)   // ѭ����ʼλǰ�ӡ�����
			            dpartString.append("("+dpart.get(i));
		    		else
		    			dpartString.append(dpart.get(i));
		    	}
		    	dpartString.append(")");
		    }else{   //����ѭ��С����ֱ�����ÿһλ
		    	for(long i:dpart){
		    		dpartString.append(i);
		    	}
	    	}
		   //ƴ�����������ֺͷ���
		   return s+ipart+"."+dpartString;
		   
	    }
	  
	  public static void main(String[] args){
		  FractiontoRecurringDecimal166 f=new FractiontoRecurringDecimal166();
		  String r=f.fractionToDecimal(-2147483648,1);
		  System.out.println("r="+r);
	  }
}
