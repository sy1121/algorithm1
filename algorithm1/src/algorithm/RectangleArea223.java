package algorithm;

import java.util.ArrayList;
import java.util.List;

public class RectangleArea223 {
	//Wrong Answer  ûץסҪ��  �����ֳ��ֳ�  ������ȷ
/*	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
         int rec1=areaOfRec(A,B,C,D),rec2=areaOfRec(E,F,G,H);
         List<Integer> list;
         if(rec1<rec2){
        	 int t;
        	 t=A;A=E;E=t;
        	 t=B;B=F;F=t;
        	 t=C;C=G;G=t;
        	 t=D;D=H;H=t;
         }
         list=getPoint(A,B,C,D,E,F,G,H);
    	 int cover=0;
         if(list.size()==0)  cover=0;
         else if(list.size()==1){
        	 switch(list.get(0)){
        	 case 1: cover=areaOfRec(E,F,C,D);break;
        	 case 2: cover=areaOfRec(E,H,C,B);break;
        	 case 3: cover=areaOfRec(A,B,G,H);break;
        	 case 4: cover=areaOfRec(A,D,G,F);break;
        	 default:break;
        	 }
         }else if(list.size()==2){
        	 int sign=list.get(0)*10+list.get(1);
        	 switch(sign){
        	 case 12: cover=areaOfRec(E,F,C,H);break;
        	 case 23: cover=areaOfRec(E,B,G,H);break;
        	 case 34: cover=areaOfRec(A,F,G,H);break;
        	 case 41: cover=areaOfRec(E,F,G,D);break;
        	 }
         }else if(list.size()==4){
        	cover=areaOfRec(E,F,G,H);
         }
         return areaOfRec(A,B,C,D)+areaOfRec(E,F,G,H)-cover;
    }
	
	public int areaOfRec(int leftx,int lefty,int rightx,int righty){
		return  Math.abs((righty-lefty)*(rightx-leftx));
	}
	
	public List<Integer> getPoint(int bleftx,int blefty,int brightx,int brighty,int sleftx,int slefty,int srightx,int srighty){
		 List<Integer> list=new ArrayList<Integer>();
		 if(in(bleftx,blefty,brightx,brighty,sleftx,slefty)) list.add(1); 
		 if(in(bleftx,blefty,brightx,brighty,sleftx,srighty)) list.add(2); 
		 if(in(bleftx,blefty,brightx,brighty,srightx,srighty)) list.add(3); 
		 if(in(bleftx,blefty,brightx,brighty,srightx,slefty)) list.add(4);
		 return  list;
	}
	
	public boolean in(int x1,int y1,int x2,int y2,int xx,int yy){
		  return  (xx-x1)*(xx-x2)<=0&&(yy-y1)*(yy-y2)<=0;
	}*/
	// ���˵Ľⷨ 
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
	    int result = (C - A) * (D - B) + (G - E) * (H - F); //Sum of areas of two rectangles
	    if(C <= E || G <= A || H <= B || D <= F) return result; //If no overlap at all.
	    int dx = Math.min(C, G) - Math.max(A, E); //Overlap length along x
	    int dy = Math.min(D, H) - Math.max(B, F); //Overlap length along y
	    return result - dx * dy;
	}
	public static void main(String[] args){
		RectangleArea223 r=new RectangleArea223();
		int result=r.computeArea(-2,-2,2,2,-3,-3,3,-1);
		System.out.println("result="+result);
	}
    
}
