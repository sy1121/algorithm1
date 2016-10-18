package algorithm;

public class Calculate {
	public static void main(String[] args){
    int i1=0,i2=0,i3=0,i4=0;
    for(int i=0;i<20;i++){
    	for(int j=0;j<20;j++){
    		for(int k=0;k<20;k++){
    			for(int m=0;m<20;m++){
    				if(83*i+186*j+408*k+419*m==6249&&(i+j+k+m==20))
    					System.out.println("i="+i+",j="+j+",k="+k+",m="+m);
    			}
    		}
    	}
    }
	}
}
