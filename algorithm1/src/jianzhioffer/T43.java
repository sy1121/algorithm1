package jianzhioffer;
/**
 * 筛子的点数
 * @author sy
 *
 */
public class T43 {
   public void printProbability(int n){
	   if(n<1) return ;
	   int[][] p=new int[2][n*6+1];
	   for(int i=1;i<n*6+1;i++){
		   p[0][i]=0;
		   p[1][i]=0;
	   }
	   int flag=0;
	   for(int i=1;i<=6;i++){
		   p[flag][i]=1;
	   }
	   for(int i=2;i<=n;i++){
		   for(int j=1;j<i;j++) p[1-flag][j]=0;
		   for(int k=i;k<=6*n;k++){
			  p[1-flag][k]=0;
			  for(int m=1;m<=k&&m<=6;m++){
				  p[1-flag][k]+=p[flag][k-m];
			  }
		   }
		   flag=1-flag;
	   }
	   
	   double total=Math.pow((double)6,(double)n);
	   for(int i=n;i<=6*n;i++){
		   double r=p[flag][i]/total;
		   System.out.println(r);
	   }
   }
   
   public static void main(String[] args){
	   T43 t=new T43();
	   t.printProbability(3);
	   
   }
}
