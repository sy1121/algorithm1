package algorithm;

public class RotateImage48 {
	//AC 0ms
   public void rotate(int[][] matrix) {
        int len=matrix.length;
        int d=len/2,index=0,temp;
        while(index<d){
        	int right=len-1-index;
        	for(int i=index;i<right;i++){
        		temp=matrix[index][i];
        		matrix[index][i]=matrix[len-1-i][index];
        		matrix[len-1-i][index]=matrix[len-1-index][len-1-i];
        		matrix[len-1-index][len-1-i]=matrix[i][len-1-index];
        		matrix[i][len-1-index]=temp;
        	}
        	index++;
        }
    }
   
   public static void main(String[] args){
	   RotateImage48 r=new RotateImage48();
	   int[][] matrix={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
	   r.rotate(matrix);
	  for(int i=0;i<matrix.length;i++){
		  for(int j=0;j<matrix.length;j++){
			  System.out.print(matrix[i][j]+",");
		  }
		  System.out.println("");
	  }
	  
   }
}
