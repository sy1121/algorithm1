package algorithm;

public class BitwiseANDofNumbersRange201 {
	
	//AC  7ms  ����m,n֮���������Ľ��
   public int rangeBitwiseAnd(int m, int n) {
        int count=n-m;  //�����м��ж��ٸ���-1��Ϊ��������ö���λ����ʾ׼��
        int r=0;   //�����ƶ���λ��
        if(count==0)  return m; //��������ֱͬ�ӷ���
        while(count>0){    //��ʼ��λ�����ƶ���ʾ��ô������Ҫ��λ��
        	m=m>>1;        
        	n=n>>1;
        	count=count>>1;
        	r++;
        }
        int temp=m&n;   //��ʱ����m��n����
        while(r>0){     //���ƻ���ô��λ
        	temp=temp<<1;
        	r--;
        }
        return temp;
    }
   
   public static void main(String[] args){
	   BitwiseANDofNumbersRange201 b=new BitwiseANDofNumbersRange201();
	   int r=b.rangeBitwiseAnd(3, 4);
	   System.out.println("r="+r);
   }
}
