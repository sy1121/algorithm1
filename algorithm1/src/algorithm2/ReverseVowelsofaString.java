package algorithm2;

public class ReverseVowelsofaString {
	 public String reverseVowels(String s) {
	        char[] cc=s.toCharArray();
	        int left=0,right=cc.length-1;
	        while(left<right){
	            while(!isVowels(cc[left])&&left<right) left++;
	            while(!isVowels(cc[right])&&left<right) right--;
	            swap(cc,left++,right--);
	        }
	        return String.valueOf(cc);
	    }
	    
	    private boolean isVowels(char c){
	        return c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='A'||c=='E'||c=='I'||c=='O'||c=='U';
	    }
	    
	    private void swap(char[] cc,int a,int b){
	        char temp=cc[a];
	        cc[a]=cc[b];
	        cc[b]=temp;
	    }
	    
	    public static void main(String[] args){
	    	ReverseVowelsofaString r=new ReverseVowelsofaString();
	    	String s=r.reverseVowels("hello");
	    	System.out.println(s);
	    }
}
